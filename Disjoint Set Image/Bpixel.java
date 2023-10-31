public class Bpixel {
    public int parent;
    public int size;
    public int rank;
    public int finalRep;
    public int value;
    public boolean newLine;

    public Bpixel(int index, boolean isEmpty){
        parent = index;
        rank = 0;
        if(isEmpty){
            size = 0;
        }
        else{
            size = 1;
        }
        value = index;
    }
}
