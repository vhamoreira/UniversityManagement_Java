package projeto_lp_aed2;

import java.io.Serializable;

public class Grafo implements Serializable {
    private int vertice;                    // The id of vertex in the sub-graph , if -1 , than it has no graph
    private int x;                                  // x coordinate
    private int y;                                  // y coordinate


    public Grafo(int x, int y, int vertice) {
        this.x = x;
        this.y = y;
        this.vertice = vertice;
        GrafoController grafoController = new GrafoController();
        //grafoController.addGrafo(this);
    }


    public void setVertice(int vertice) {
        this.vertice = vertice;
    }
    public int getVertice(){
        return this.vertice;
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }




    /**
     * Calcula a distancia entre dois pontos
     *
     * @param ponto ponto que queremos saber a distancia
     * @return distancia entre um ponto e outro
     */
    public double getDistanceFromOtherLocation(Grafo ponto){
        return Math.sqrt((ponto.getY() - this.y) * (ponto.getY() - this.y) + (ponto.getX() - this.x) * (ponto.getX() - this.x));
    }

    public double getDistanceFromCoordinate(int x , int y){
        return Math.sqrt((y - this.y) * (y - this.y) + (x - this.x) * (x - this.x));
    }
}