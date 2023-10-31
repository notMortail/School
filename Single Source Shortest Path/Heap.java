public class Heap {
    public Vertex[] heap;
    private int heapSize;

    public void heap(Vertex[] keys, int n) {
        heap = keys;
        for(int i = n-1; i >= 0; i--){
            if(keys[i].getKey() < keys[i/2].getKey()){
                Swap(keys, i, i/2);
            }
        }
        heapSize = n;
    }

    public boolean in_heap(int id){
        for(int i = 0; i < heapSize; i++){
            if(heap[i].getID() == id){
                return true;
            }
        }
        return false;
    }

    public boolean is_empty(){
        if(heapSize == 1){
            return true;
        }
        return false;
    }

    public double min_key(){
        return heap[0].getKey();
    }

    public int min_id(){
        return heap[0].getID();
    }

    public double key(int id){
        for(int i = 0; i < heapSize; i++){
            if(heap[i].getID() == id){
                return heap[i].getKey();
            }
        }
        return -1;
    }

    public void delete_min(){
        for(int i = 0; i < heapSize - 1; i++){
            heap[i] = heap[i+1];
        }
        heap(heap, heapSize - 1);
    }

    public void decrease_key(int id, double new_key){
        for(int i = 0; i < heapSize; i++){
            if(heap[i].getID() == id && heap[i].getKey() > new_key){
                heap[i].setKey(new_key);
                heap[i].setFromVertex(this.min_id());
            }
        }
    }


    private void Swap(Vertex[] array, int firstIndex, int secondIndex){
        Vertex temp;
        temp = array[firstIndex];
        array[firstIndex] = array[secondIndex];
        array[secondIndex] = temp;
    }
}
