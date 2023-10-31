import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        //Initialize the file reader
        BufferedReader testFile = new BufferedReader(new FileReader("/infile.txt"));
        String line = testFile.readLine();

        //Reads the size of the graph and intializes adjacency list and matrix
        int graphSize = Integer.parseInt(line);
        ArrayList<ArrayList<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i <= graphSize; i++){
            ArrayList<int[]> adjVertices = new ArrayList<>();
            adjList.add(adjVertices);
        }
        line = testFile.readLine();

        //Reads all edges from the file and populates the adjacency list
        while(line != null){
            //Partition the string using the spaces as delimiters to isolate the integers
            //int firstBreak = line.indexOf(' ');
            //int secondBreak = line.indexOf(' ', firstBreak + 1);
            //Parse each integer
            int fromVertex = Integer.parseInt(line.substring(0,2).replace(" ", ""));
            int toVertex = Integer.parseInt(line.substring(3, 5).replace(" ", ""));
            int weight = Integer.parseInt(line.substring(5).replace(" ", ""));
            //Store the information into the adjacency list
            int[] adjacencyWeight = {toVertex, weight};
            adjList.get(fromVertex).add(adjacencyWeight);
            line = testFile.readLine();
        }

        //Print the adjacency list
        System.out.println("Adjacency List:");
        for(int i = 1; i <= graphSize; i++){
            for(int j = 0; j < adjList.get(i).size(); j++){
                String edge = String.format("(%d,%d): ", i, adjList.get(i).get(j)[0]);
                String output = String.format("%-9s%d", edge, adjList.get(i).get(j)[1]);
                System.out.println(output);
            }
        }

        //Initialize the unfound vertex heap
        Vertex[] graph = new Vertex[graphSize];
        for(int i = 0; i < graphSize; i++){
            graph[i] = new Vertex(i + 1);
        }
        Heap graphHeap = new Heap();
        graphHeap.heap(graph, graphSize);

        //Build the SSSP tree
        System.out.println("Single Source Shortest Path Edge Tree:");
        int source = graphHeap.min_id();
        double sourceKey = graphHeap.min_key();
        while(!graphHeap.is_empty()) {
            ArrayList<int[]> adjacency = adjList.get(source);
            for (int i = 0; i < adjacency.size(); i++) {
                if(graphHeap.in_heap(adjacency.get(i)[0])) {
                    graphHeap.decrease_key(adjacency.get(i)[0], graphHeap.min_key() + adjacency.get(i)[1]);
                }
            }
            graphHeap.delete_min();
            String edge = String.format("(%d,%d): ", graphHeap.heap[0].getFromVertex(), graphHeap.min_id());
            String output = String.format("%-9s%.0f", edge, (sourceKey + graphHeap.min_key()));
            System.out.println(output);
            source = graphHeap.min_id();
        }
    }
}