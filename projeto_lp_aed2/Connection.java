package projeto_lp_aed2;

import edu.princeton.cs.algs4.DirectedEdge;

public class Connection extends DirectedEdge {
    private double tempo;


    public Connection(int v, int w, double weight, double tempo) {
        super(v, w, weight);
        this.tempo = tempo;
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(double tempo) {
        this.tempo = tempo;
    }

    public double getDistancia(){
        return super.weight();
    }

    @Override
    public String toString() {
        return super.from() + "-->" + super.to() + "{distancia: " + super.weight() + "} {Tempo : " + this.tempo + "}";
    }
}
