public class Vertex {
    private int ID;
    private int fromVertex;
    private double key;

    public Vertex(int ID){
        this.ID = ID;
        if(ID == 1){
            key = 0;
        }
        else {
            key = Double.POSITIVE_INFINITY;
        }
    }

    public void setID(int ID){
        this.ID = ID;
    }

    public void setKey(double key){
        this.key = key;
    }

    public void setFromVertex(int key){
        fromVertex = key;
    }

    public int getID(){
        return ID;
    }

    public double getKey(){
        return key;
    }

    public int getFromVertex(){
        return fromVertex;
    }
}
