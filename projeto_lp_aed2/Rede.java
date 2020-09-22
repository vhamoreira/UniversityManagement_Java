/*package projeto_lp_aed2;

import edu.princeton.cs.algs4.*;
import projeto_lp_aed2.javafx.generic_point.SalaCoordenadas;

import javax.swing.*;

public class Rede {
    public static SeparateChainingHashST<String, SalaCoordenadas> salaCoordenadasST = new SeparateChainingHashST<>();

    public static void caminhoMaisCurto(SymbolDigraph grafo, EdgeWeightedDigraph d, String sala_origem, String sala_destino, JTextArea textarea) {
        int sala_origem2 = grafo.indexOf(sala_origem);
        int sala_destino2 = grafo.indexOf(sala_destino);

        DijkstraSP caminho_curto = new DijkstraSP(d, sala_origem2);
        double distancia = 0;

        for (DirectedEdge g : caminho_curto.pathTo(sala_destino2)) {
            textarea.append(grafo.nameOf(g.from()) + "->" + grafo.nameOf(g.to()) + ":" + g.weight() + "\n");
            distancia = distancia + g.weight();
        }
        textarea.append("\nDistancia Total = " + distancia + "m");
    }

    public static void cheapestPath(SymbolDigraph grafo, EdgeWeightedDigraph d, String sala_origem, String sala_destino){
        double distancia = 50000, distanciatotal = 0;
        String ligBarata = null;

        int sala_origem2 = grafo.indexOf(sala_origem);
        int sala_destino2 = grafo.indexOf(sala_destino);

        for(DirectedEdge de : d.adj(grafo.indexOf(sala_origem))){
            System.out.println(grafo.nameOf(de.from()) + "->" + grafo.nameOf(de.to()) + ":" + de.weight());
            DijkstraSP caminhoCurto = new DijkstraSP(grafo.digraph(),de.to());
            distanciatotal = 0;
            distanciatotal = distanciatotal + de.weight();
            for(DirectedEdge g : caminhoCurto.pathTo(sala_destino2)){
                System.out.println(grafo.nameOf(g.from()) + "->" + grafo.nameOf(g.to()) + ":" + g.weight());
                distanciatotal = distanciatotal + g.weight();
            }
            if(distanciatotal<distancia){
                distancia = distanciatotal;
                ligBarata = ("\nLigação: " + grafo.nameOf(de.to()) + "->" + sala_destino + "distancia total: " + distancia);
            }
            System.out.println("\nLigação: " + grafo.nameOf(de.to()) + "->" + sala_destino + "distancia total: " + distanciatotal);
            System.out.println("---------------------");
        }
        System.out.println("######Ligação mais Curta é ###############");
        System.out.println(ligBarata);
    }

}*/
