public class DJset {
        public Bpixel[] elements;
        public Bpixel[] finalSet;
        private boolean isFinalized = false;

        public void uandf(int n){
            elements = new Bpixel[n];
        }
        public void make_set(int data, boolean isEmpty){
            if (isFinalized) return;
            elements[data] = new Bpixel(data, isEmpty);
        }

        public int find_set(int i){
            if(elements[i].parent == i){
                return i;
            }
            elements[elements[i].parent].parent = find_set(elements[i].parent);
            return elements[elements[i].parent].parent;
        }

        public void union_sets(int i, int j){
            if (isFinalized) return;
            int rootI = find_set(i);
            int rootJ = find_set(j);
            if(rootJ != rootI) {
                if (elements[rootI].rank < elements[rootJ].rank) {
                    elements[rootI].parent = rootJ;
                    elements[rootJ].size = elements[rootJ].size + elements[rootI].size;
                } else {
                    if (elements[rootI].rank == elements[rootJ].rank) {
                        elements[rootI].rank++;
                    }
                    elements[rootJ].parent = rootI;
                    elements[rootI].size = elements[rootJ].size + elements[rootI].size;
                }
            }
        }

        public int final_sets(){
            int size = 0;
            for(int pixel = 0; pixel < 5400; pixel++){
                if(elements[pixel].size != 0 && elements[pixel].parent == pixel){
                    size++;
                    elements[pixel].finalRep = size;
                }
            }
            finalSet = new Bpixel[size];
            int populatorIndex = 0;
            for(int pixels = 0; pixels < 5400; pixels++){
                this.find_set(pixels);
                if(elements[pixels].size != 0 && elements[pixels].parent == pixels){
                    finalSet[populatorIndex] = elements[pixels];
                    populatorIndex++;
                }
            }

            isFinalized = true;

            return size;
        }
}

