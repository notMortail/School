public class SetList {
    public Bpixel[] finalSets;

    public SetList(Bpixel[] finalSets){
        this.finalSets = finalSets;
        this.sortSets();
    }

    public void sortSets(){
        for(int i = 1; i < finalSets.length; i++){
            Bpixel insertion = finalSets[i];
            int j = i - 1;
            while(j > -1 && finalSets[j].size > insertion.size){
                finalSets[j+1] = finalSets[j];
                j--;
            }
            finalSets[j + 1] = insertion;
        }
        for(int i = 0; i < finalSets.length; i++){
            finalSets[i].finalRep = i + 1;
        }
    }
}
