import java.io.*;
import java.net.URISyntaxException;


public class Bimage {
    DJset image = new DJset();
    int imageSize = 5400;
    int element;

    public void SetInit(){
        image.uandf(imageSize);
    }

    public void ReadChar() throws IOException{
        final InputStream stream = this.getClass().getResourceAsStream("/face");
        final InputStreamReader reader = new InputStreamReader(stream);
        final BufferedReader buffered = new BufferedReader(reader);
        String line = buffered.readLine();
        element = 0;
        while(line != null){
            for(int i = 0; i < line.length(); i++){
                char current = line.charAt(i);
                if (current == '+') {
                    image.make_set(element, false);
                    element++;
                } else if (current == ' ') {
                    image.make_set(element, true);
                    element++;
                }
            }
            image.elements[element - 1].newLine = true;
            line = buffered.readLine();
        }
    }

    public void printImage(){
        for(int i = 0; i < imageSize; i++){
            if(image.elements[i].size != 0){
                    System.out.print('+');
            }
            else{
                System.out.print(' ');
            }
            if(image.elements[i].newLine){
                System.out.print('\n');
            }
        }
        System.out.print('\n');
    }

    public void printCharImage(){
        for(int i = 0; i < imageSize; i++){
            if(image.elements[i].size != 0){
                System.out.print(getSymbol(image.find_set(i)));
            }
            else{
                System.out.print(' ');
            }
            if(image.elements[i].newLine){
                System.out.print('\n');
            }
        }
        System.out.print('\n');
    }

    private char getSymbol(int index) {
        int finalRep = image.elements[index].finalRep;
        return (char) (96 + finalRep);
    }

    public void printGreater(int limit){
        for(int i = 0; i < imageSize; i++){
            //if(image.elements[image.elements[i].parent].size > limit){
            if(image.elements[image.find_set(i)].size > limit) {
                System.out.print(getSymbol(image.find_set(i)));
            }
            else{
                System.out.print(' ');
            }

            if(image.elements[i].newLine){
                System.out.print('\n');
            }
        }
        System.out.print('\n');
    }


    public void mergeSets(){
        for(int element = 0; element < 5400; element++) {
            boolean checkLeft = true, checkTopLeft = true, checkTop = true, checkTopRight = true;
            if (image.elements[element].size != 0) {
                if(element < 75){
                    checkTopLeft = checkTop = checkTopRight = false;
                }
                if(element % 75 == 0){
                    checkLeft = checkTopLeft = false;
                }
                if(element % 75 == 74){
                    checkTopRight = false;
                }
                if(checkLeft && image.elements[element - 1].size != 0){
                    image.union_sets(element - 1, element);
                    checkTopLeft = checkTop = false;
                }
                if(checkTopLeft && image.elements[element - 76].size != 0){
                    image.union_sets(element - 76, element);
                    checkTop = false;
                }
                if(checkTop && image.elements[element - 75].size != 0){
                    image.union_sets(element - 75, element);
                    checkTopRight = false;
                }
                if(checkTopRight && image.elements[element - 74].size != 0){
                    image.union_sets(element - 74, element);
                }
            }
        }
    }

    private static void printTitle(String title) {
        System.out.println("");
        System.out.println("");
        System.out.println(title);
        System.out.println("");
    }

    public static void main(String args[]) throws IOException {
        Bimage test = new Bimage();
        test.SetInit();
        test.ReadChar();
        test.mergeSets();
        test.image.final_sets();
        SetList finalSets = new SetList(test.image.finalSet);

        printTitle("1. The input binary image");
        test.printImage();

        printTitle("2. The connected component image where each component is labelled with a unique character");
        test.printCharImage();

        printTitle("3. A list sorted by component size, where each line of the list contains the size and the label of a component");
        for(int i = 0; i < finalSets.finalSets.length; i++){
            //System.out.format("%10d%10d%16s", finalSets.finalSets[i].value, finalSets.finalSets[i].size, test.getSymbol(finalSets.finalSets[i].value) + "\n");
            System.out.format("%10d%16s", finalSets.finalSets[i].size, test.getSymbol(finalSets.finalSets[i].value) + "\n");
        }

        printTitle("4. the connected components whose sizes are greater than 1 will be printed");
        test.printGreater(1);

        printTitle("5. the connected components whose sizes are greater than 11 will be printed");
        test.printGreater(11);
    }
}
