/******************************************************************************
 *  Compilation:  javac DirectedEdge.java
 *  Execution:    java DirectedEdge
 *  Dependencies: StdOut.java
 *
 *  Immutable weighted directed edge.
 *
 ******************************************************************************/

package projeto_lp_aed2;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import edu.princeton.cs.algs4.In;

import java.util.LinkedList;

public class WeightedGraph {
    static class Edge {
        int source;
        int destination;
        int weight;
        int time;

        public Edge(int source, int destination, int weight, int time) {
            this.source = source;
            this.destination = destination;
            this.weight = weight;
            this.time = time;
        }
    }

    static class EdgeWeightedDigraph {
        int vertices;
        LinkedList<Edge>[] adjacencylist;

        EdgeWeightedDigraph(int vertices) {
            this.vertices = vertices;
            adjacencylist = new LinkedList[vertices];
            //initialize adjacency lists for all the vertices
            for (int i = 0; i < vertices; i++) {
                adjacencylist[i] = new LinkedList<>();
            }
        }

        public EdgeWeightedDigraph(In in) {
            this(in.readInt());
            int E = in.readInt();
            if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");
            for (int i = 0; i < E; i++) {
                int v = in.readInt();
                int w = in.readInt();
                int weight = in.readInt();
                int time = in.readInt();
                addEgde(v, w, weight, time);
            }
        }


        public void addEgde(int source, int destination, int weight, int time) {
            Edge edge = new Edge(source, destination, weight, time);
            adjacencylist[source].addFirst(edge); //for directed graph
        }

        public void printGraph() {
            for (int i = 0; i < vertices; i++) {
                LinkedList<Edge> list = adjacencylist[i];
                for (int j = 0; j < list.size(); j++) {
                    System.out.println( i + " is connected to " +
                            list.get(j).destination + " with weight " + Math.addExact(list.get(j).weight,list.get(j).time));
                }
            }
        }
    }
    public static void main(String[] args) {
        In in = new In(".//data//coords.txt");
        EdgeWeightedDigraph g = new EdgeWeightedDigraph(in);

        g.printGraph();
    }
}