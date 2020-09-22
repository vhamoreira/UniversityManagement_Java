package projeto_lp_aed2;


import edu.princeton.cs.algs4.*;

import java.io.Serializable;
import java.util.ArrayList;

public class GrafoController implements Serializable {

    private EdgeWeightedDigraph globalGraph;
    private ArrayList<Grafo> grafos;

    public GrafoController() {
        this.grafos = new ArrayList<>();
    }

    public EdgeWeightedDigraph getGlobalGraph() {
        return globalGraph;
    }

    public void setGlobalGraph(EdgeWeightedDigraph globalGraph) {
        this.globalGraph = globalGraph;
    }

    public ArrayList<Grafo> getGrafos() {
        return grafos;
    }

    public void setGrafos(ArrayList<Grafo> grafos) {
        this.grafos = grafos;
    }

    /**
     * cria o grafo global
     *
     * @return
     */
    public void cria_grafo(){
        if (this.grafos.isEmpty())
            System.out.println("grafo nao iniciado\n");
        this.globalGraph = new EdgeWeightedDigraph(this.grafos.size());
        System.out.println("grafo criado com "+this.grafos.size()+" vertices\n");
    }

    /**
     * @param from   vertice entrada
     * @param to     vertice saida
     * @param distancia distancia da conexao
     * @param tempo peso da conexao
     */
    public void createEdge(int from, int to, double distancia, double tempo){
        Connection edge = new Connection(from, to, distancia, tempo);
        if (this.globalGraph != null) {
            this.globalGraph.addEdge(edge);
            System.out.println("An edge from " + from + " to " + to + " w/ " + distancia + " distance weight" + " and " + tempo + " time cost was added to graph");
        } else
            System.out.println("nao foi possivel adicionar ligaçao");
    }

    public double calculateWeight(Grafo from, Grafo to) {
        return from.getDistanceFromOtherLocation(to);
    }

    /**
     * adiciona o grafo ao arraylist de grafos e adiciona o vertice
     *
     * @param grafo adicionar a Grafo
     */
    public void addGrafo(Grafo grafo) {
        if (this.grafos.contains(grafo)) {
            System.out.println("ja existe!");
            return;
        }
        grafo.setVertice(this.grafos.size());
        this.grafos.add(grafo);
        System.out.println("Adicionado com sucesso!");
    }



    /**
     * Prints the shortest path from s to all other vertices
     *
     * @param g the edge weighted graph
     * @param s the source vertex
     */
    public static void printSP(EdgeWeightedDigraph g, int s) {
        DijkstraSP sp = new DijkstraSP(g,s);
        System.out.println("\nDijkstra:");

        // print shortest path
        for (int t = 0; t < g.V(); t++) {
            if (sp.hasPathTo(t)) {
                StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
                for (DirectedEdge e : sp.pathTo(t)) {
                    StdOut.print(e + "   ");
                }
                StdOut.println();
            }
            else {
                StdOut.printf("%d to %d         no path\n", s, t);
            }
        }
    }

    /**
     * Prints the shortest path from s to t vertice
     *
     * @param g the edge weighted graph
     * @param s the source vertex
     * @param t the destination vertex
     */
    public static void printSP_FromAtoB(EdgeWeightedDigraph g, int s, int t) {
        DijkstraSP sp = new DijkstraSP(g,s);
        System.out.println("\nDijkstra:");

        // print shortest path
        if (sp.hasPathTo(t)) {
            StdOut.printf("%d to %d (%.2f)  ", s, t, sp.distTo(t));
            for (DirectedEdge e : sp.pathTo(t)) {
                StdOut.print(e + "   ");
            }
            StdOut.println();
        }
        else {
            StdOut.printf("%d to %d         no path\n", s, t);
        }
    }

    /**
     * Check if graph is connected
     * @param g graph
     */
    public static boolean isConnected(EdgeWeightedDigraph g) {
        int s = 0;
        int flag = 0;
        DijkstraSP sp = new DijkstraSP(g, s);
        for (int t = 0; t < g.V(); t++) {
            if (!sp.hasPathTo(t)) {
                System.out.println("nao conexo em -> " + t);
                flag = 1;
            }
        }
        if (flag == 0) {
            System.out.println("O grafo é Conexo!");
            return true;
        }
        System.out.println("O grafo nao é conexo!");
        return false;
    }


}

