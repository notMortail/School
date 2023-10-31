import java.io.*;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.databind.*;

import javax.crypto.*;
import javax.crypto.spec.*;
import java.security.*;
import java.security.spec.*;

/**
 * Manages user accounts and handles their points.
 * @author Ryan Lambe
 */
public class AccountManager {

    /**
     * the username of the active user, used to save data.
     */
    private static String activeUser = null;

    /**
     * the password key for the active user to save data
     */
    private static Key secretKey = null;

    /**
     * the active points of the user that could be drawn, includes both user points and built in.
     */
    private static ArrayList<Point> activePoints = new ArrayList<>();

    /**
     * searches for valid user file and attempts to read it, if successful the login is valid.
     * @param username the username to be logged in with.
     * @param password the password of the user to be logged in.
     * @return true if successful, false otherwise.
     */
    public static boolean LogIn(String username, String password){

        activePoints = new ArrayList<>();
        activeUser = null;

        //verify admin login
        if(username.equals("admin") && (!username.equals(password))){
            return false;
        }

        //load built in data
        if(!LoadFileData("Saves\\builtIn.json", "admin", "admin", !username.equals("admin"), true))
            return false;

        //load user data
        if(!username.equals("admin"))
            if(!LoadFileData("Saves\\" + username + ".json", username, password, false, false))
                return false;

        //return
        activeUser = username;
        return true;
    }

    /**
     * creates new empty user file for the username and password entered.
     * @param username the username of the user account to be created.
     * @param password the username of the user account to be created.
     * @return true if successfully created user file.
     */
    public static boolean SignUp(String username, String password){

        activePoints = new ArrayList<>();
        activeUser = null;

        //check if username available
        File file = new File("Saves\\" + username + ".json");
        if(file.exists() || username.equals("admin") || username.equals("builtIn"))
            return false;

        //create file
        try{
            file.createNewFile();

            //create key
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), new byte[16], 65536, 128);
            secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");
        } catch (Exception e) {
            return false;
        }

        //return
        activeUser = username;
        activePoints = new ArrayList<>();
        return true;
    }

    /**
     * logs out of the current account and saves the user created points.
     */
    public static void LogOut(){

        //check if logged in
        if(activeUser == null)
            return;


        //get file
        File file;
        if(activeUser.equals("admin")){
            file = new File("Saves\\builtIn.json");

            //create builtIn if not created
            try{
                if(!file.exists())
                    file.createNewFile();
            } catch (IOException e) {
                //file exists, so it will be used
            }
        }
        else
            file = new File("Saves\\" + activeUser + ".json");


        //get data to write
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.INDENT_OUTPUT, true);
        byte[] fileData;
        try{
            fileData = mapper.writeValueAsBytes(GetUserData());
        } catch (IOException e) {
            //account doesn't exist
            activeUser = null;
            activePoints = new ArrayList<>();
            secretKey = null;
            return;
        }


        //encrypt file
        try{
            //get cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            //write to file
            FileOutputStream outputStream = new FileOutputStream(file);
            CipherOutputStream cipherOutputStream = new CipherOutputStream(outputStream, cipher);

            cipherOutputStream.write(fileData);

            cipherOutputStream.close();
            outputStream.close();
        }
        catch (Exception e){
            return;
        }

        activeUser = null;
        activePoints = new ArrayList<>();
        secretKey = null;
    }

    /**
     * creates new point that can be saved and accessed by the map.
     * @param x the x coordinate of the point.
     * @param y the y coordinate of the point.
     * @param name the name of the point.
     * @param iconImg the points image.
     */
    public static void CreatePoint(float x, float y, String name, String iconImg){
        activePoints.add(new Point(x, y, name, iconImg, MapFrameUI.getFloor(), MapFrameUI.getBuilding(), false, false));
    }

    /**
     * gets the points to be displayed based on the specified context.
     * @param search the points returned must all contain this search term.
     * @param onlyFavourites if true, all points returned must be favourited.
     * @param floor the points returned must all be on the specified floor.
     * @param building the points returned must all be from the specified building.
     * @param iconTypes the points returned must all have the specified icons.
     * @return an array of points the fit the specified conditions.
     */
    public static Point[] GetPoints(String search, boolean onlyFavourites, int floor, String building, String[] iconTypes){

        ArrayList<Point> out = new ArrayList<>();

        for(int i = 0; i < activePoints.size(); i++){
            if (activePoints.get(i).getName() == null) {
                System.out.printf("Empty");
            }

            //check building
            if(!activePoints.get(i).getBuilding().equals(building))
                continue;

            //check floor
            if(activePoints.get(i).getFloor() != floor)
                continue;

            //check search
            if(!activePoints.get(i).getName().contains(search))
                continue;

            //check favourites
            if(onlyFavourites && (!activePoints.get(i).isFavourite()))
                continue;

            //check icons
            for (int j = 0; j < iconTypes.length; j++){

                if(activePoints.get(i).getIconImg().equals(iconTypes[j])){

                    //add to list
                    out.add(activePoints.get(i));
                    break;
                }
            }
        }

        //return array
        Point[] arr = new Point[out.size()];
        return out.toArray(arr);
    }

    /**
     * gets the point at the specified index position.
     * @param index the location of the point to be retrieved.
     * @return the point at the specified index.
     * @throws IndexOutOfBoundsException if there is no point at the index specified.
     */
    public static Point GetPoint(int index) throws IndexOutOfBoundsException{
        return activePoints.get(index);
    }

    /**
     * marks the favourite value of the point at the specified index as the input value.
     * @param value the value of the favourite for the point.
     * @param index the location of the point.
     * @throws IndexOutOfBoundsException if there is no point at the index specified.
     */
    public static void FavouritePoint(boolean value, int index) throws IndexOutOfBoundsException{
        activePoints.get(index).favourite(value);
    }

    /**
     * removes the point at the specified index.
     * @param index the location of the point to be removed.
     * @throws IndexOutOfBoundsException if there is no point at the index specified.
     */
    public static void RemovePoint(int index) throws IndexOutOfBoundsException{
        activePoints.remove(index);
    }

    /**
     * modifies the values of a point.
     * @param index the location of the point to be modified.
     * @param name the new name of the point to be modified.
     * @param iconImg the new icon of the point to be modified.
     * @throws IndexOutOfBoundsException if there is no point at the index specified.
     */
    public static void ModifyPoint(int index, String name, String iconImg) throws IndexOutOfBoundsException{
        activePoints.get(index).setName(name);
        activePoints.get(index).setIcon(iconImg);
    }

    /**
     * Gets the active user data, excluding the builtIn points
     * @return the users data as UserData class
     */
    private static UserData GetUserData(){
        UserData userData = new UserData();
        userData.username = activeUser;

        ArrayList<Point> userPoints = new ArrayList<>();
        for(int i = 0; i < activePoints.size(); i++){

            if(activePoints.get(i).isBuiltIn() && !activeUser.equals("admin"))
                continue;

            userPoints.add(activePoints.get(i));
        }

        Point[] arr = new Point[userPoints.size()];
        userData.userPoints = userPoints.toArray(arr);
        return userData;
    }

    /**
     * Loads Points from file to active
     * @param filePath path to file to read from
     * @param username the username of the user to verify the validity of the data being read
     * @param password the password of the user to encrypt with, if no encryption set to null
     * @param builtIn whether the points added to active are builtIn or not
     * @param isAdmin whether the user is an admin or not
     * @return true if successful, otherwise false
     */
    private static boolean LoadFileData(String filePath, String username, String password, boolean builtIn, boolean isAdmin){

        //decrypt file
        byte[] fileData;
        try{
            //create key
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            KeySpec spec = new PBEKeySpec(password.toCharArray(), new byte[16], 65536, 128);
            secretKey = new SecretKeySpec(factory.generateSecret(spec).getEncoded(), "AES");

            //get cipher
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            //read file
            File file = new File(filePath);
            if(!file.exists())
                return isAdmin;

            //create streams
            FileInputStream inputStream = new FileInputStream(filePath);
            CipherInputStream cipherInputStream = new CipherInputStream(inputStream, cipher);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

            //read data
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = cipherInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            fileData = outputStream.toByteArray();

            //close streams
            outputStream.close();
            cipherInputStream.close();
            inputStream.close();
        }
        catch (Exception e){
            return false;
        }


        //get data
        UserData userData;
        ObjectMapper mapper = new ObjectMapper();
        try {
            userData = mapper.readValue(fileData, UserData.class);
        }
        catch (Exception e){
            return false;
        }

        if(!isAdmin && !userData.username.equals(username))
            return false;

        //add data to active points
        for(int i = 0; i < userData.userPoints.length; i++){
            userData.userPoints[i].setBuiltIn(builtIn);
            activePoints.add(userData.userPoints[i]);
        }
        return true;
    }
    
    /** Returns the current user logged into the system */
    public static String getUser() {
        return activeUser;
    }
    
    /** Removes the point from the active point array
     * 
     * @param point The point to be removed
     */
    public static void remove(Point point) {
        int index = activePoints.indexOf(point);
        if (index != -1) {
            RemovePoint(index);
        }
    }
}
