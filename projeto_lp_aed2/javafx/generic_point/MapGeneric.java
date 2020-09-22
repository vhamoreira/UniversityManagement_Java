package projeto_lp_aed2.javafx.generic_point;

import edu.princeton.cs.algs4.EdgeWeightedDigraph;
import projeto_lp_aed2.Connection;

import java.util.ArrayList;

public class MapGeneric <T extends Point3D>{
    private static int idCount = 0;
    ArrayList<T> points = new ArrayList<>();
    private EdgeWeightedDigraph globalGraph;       // global graph with all the sub-graphs


    /**
     * Devolve todos os pontos existentes no ArrayList
     * @return ArrayList de pontos
     */

     public ArrayList<T> getPoints() {
        return points;
    }

    /**
     * Devolve o tamanho (numeros de pontos) do Arraylist
     *
     * @return o numero de pontos existentes
     */
    public int size(){
        return this.points.size();
    }

    /**
     * Adiciona um novo ponto ao Map(ArrayList de pontos)
     *
     * @param point o ponto a adicionar
     */
    public void addPoint(T point){
        //validar se o ponto ja existe no arraylist
        if(!this.points.contains(point)){
            //define o id do ponto com base no valor de id coint
            point.setId(idCount++);
            this.points.add(point);
        }
    }

    /**
     * @param from   vertex tail
     * @param to     vertex head
     * @param distancia distance weight from the connection
     * @param tempo time weight from the connection
     */
    public void createEdge(int from, int to, double distancia, double tempo){
        Connection edge = new Connection(from, to, distancia, tempo);
        if (this.globalGraph != null) {
            // If the global graph exists
            this.globalGraph.addEdge(edge);
            System.out.println("An edge from " + from + " to " + to + " w/ " + distancia + " distance weight" + " and " + tempo + " time cost was added to graph");
        } else
            System.out.println("nao foi possivel adicionar ligaçao");
    }

    /**
     * Devolve todos os pontos de um dado piso
     *
     * @param floor o piso a procurar os pontos
     * @return todos os pontos do piso indicado
     */
    public ArrayList<T> getPointsByFloor(int floor){
        ArrayList<T> pointsByFloor = new ArrayList<>();
        for (T t : this.points){
            if (t.getZ() == floor)
                pointsByFloor.add(t);
        }
        return pointsByFloor;
    }


    /**
     * Devolve todos os pisos distintos existentes (com base nos pontos do map)
     *
     * @return um ArrayList com todos os pisos existentes
     */
    public ArrayList<Integer> getDistinctExistingFloors(){
        ArrayList<Integer> floors = new ArrayList<>();
        for (T t : this.points){
            if (!floors.contains(t.getZ()))
                floors.add(t.getZ());
        }
        return floors;
    }



}
