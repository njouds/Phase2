
package dijkstra_phase2;

public class Dijkstra_Phase2 {

    static int minDistance(int distances[], Boolean sptSet[])// used to get the minimum distance vertex
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;
  
        for (int v = 0; v < distances.length; v++){//loop over the verices to check the one with the minimum distance
            if (sptSet[v] == false && distances[v] < min) {//if the vertex is not processed yet and the distance is smaller than minimum  retrun the min index
                min = distances[v];
                min_index = v;
            }
    }
        return min_index;
    }
    
    
    static void dijkstra(int graph[][], int src){
        
         int distances[] = new int[graph.length];//this will hold the result which each index is the distance between the source and that index
         

         
         Boolean sptSet[] = new Boolean[graph.length]; //store if the vertices is processed yet
         
        for (int i = 0; i < distances.length; i++) {//initialize the distances as infinity and the boolean as false 
            distances[i] = Integer.MAX_VALUE;
            sptSet[i]=false;
    }
        
        distances[src] = 0;// distance from the source to itself is 0
        
        for (int i = 0; i < graph.length; i++) {
            
             int u = minDistance(distances, sptSet);// to pick the minimum disance vertex among the unprocessed vertices 
             
             sptSet[u] = true;//mark it as processed 
             
             
            
             for (int  j = 0;  j < distances.length;  j++) {//to update the distance value of the adjacent vertices to the picked vertex
                  if (!sptSet[j] && graph[u][j] != 0 && distances[u] != Integer.MAX_VALUE && distances[u] + graph[u][j] < distances[j])//update the adjacent vertice only if it is not already in sptSet and theres an edge between u and v and the path weight from src to v through u is smaller then the current distance 
                         distances[j] = distances[u] + graph[u][j];//assign the new shortest distance 
                  
                }
  
                
            }
        
        printSolution(distances, distances.length);
        }
        static void printSolution(int dist[], int n)
    {
        System.out.println("Vertex    Distance from Source");
        for (int i = 0; i < dist.length; i++)
            System.out.println("from 0 to "+i + "     \t\t " + dist[i]);
    }
        
        
        
    
    
    
    
    
    public static void main(String[] args) {
//       
       int graph[][]={{0,79,420,949,1343,167,625,1024,863,777,710,905}, //creating a graph
                      {79,0,358,870,1265,88,627,1037,876,790,685,912},
                       {420,358,0,848,1343,446,985,679,518,432,1043,1270},
                       {949,870,848,0,395,782,1064,1304,330,640,1272,950},
                       {1343,1265,1343,395,0,1177,1495,1729,725,1035,1667,1345},
                      {167,88,446,782,1177,0,561,1204,936,957,763,864},
                       {625,627,985,1064,1459,561,0,1649,1488,1402,202,280},
                       {1024,1037,679,1304,1729,1204,1649,0,974,664,1722,1929},
                      {863,876,518,330,725,936,1488,974,0,310,1561,1280},
                      {777,790,432,640,1035,957,1402,664,974,0,1475,1590},
                      {710,685,1043,1272,1667,763,202,1722,1561,1475,0,482},
                       {905,912,1270,950,1345,864,280,1929,1280,1590,482,0}
                       
                       
       };
////        
        dijkstra(graph,0);
        
    }
    
}
