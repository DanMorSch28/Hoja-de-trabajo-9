/*
 * UVG
 * Hoja de trabajo 8
 * Daniel Morales 15526
 * Rodrigo Corona 15102
 * Fernando Hernandez 15476
*/	

import java.util.Arrays;

public class FloydWarshall {

    private double[][] graph;

    private boolean negativeCycle;

    public FloydWarshall(int n) {
        this.graph = new double[n][n];
        initGraph();
    }

    private void initGraph() {
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph.length; j++) {
                if (i == j) {
                    graph[i][j] = 0;
                } else {
                    graph[i][j] = Double.POSITIVE_INFINITY;
                }
            }
        }
    }

    public boolean hasNegativeCycle() {
        return this.negativeCycle;
    }

    public void addEdge(int from, int to, double weight) {
        graph[from][to] = weight;
    }
    public double getEdge(int from, int to) 
    {
        try 
        {
            return graph[from][to];
        }
        catch (ArrayIndexOutOfBoundsException index) 
        {
            System.out.println("The vertices does not exists");
        }
        return -1;
    }

    public double[][] floydWarshall() {
        double[][] distances;
        int n = this.graph.length;
        distances = Arrays.copyOf(this.graph, n);

        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }

            if (distances[k][k] < 0.0) {
                this.negativeCycle = true;
            }
        }

        return distances;
    }
    public static void main(String args[]) 
    {
    	int v=4,e=5;
    	FloydWarshall fw = new FloydWarshall(4);
    	fw.addEdge(0, 1, 5);
        fw.addEdge(0, 2, 9);
        fw.addEdge(0, 3, 10);
        fw.addEdge(1, 2, 3);
        fw.addEdge(2, 3, 1);
        System.out.println("The adjacency matrix for the given graph is: ");
        System.out.print("  ");
        for (int i = 0; i < v; i++)
            System.out.print(i + " ");
        System.out.println();

        for (int i = 0; i < v; i++) 
        {
            System.out.print(i + " ");
            for (int j = 0; j < v; j++) 
                System.out.print(fw.getEdge(i, j) + " ");
            System.out.println();
        }
    }
}