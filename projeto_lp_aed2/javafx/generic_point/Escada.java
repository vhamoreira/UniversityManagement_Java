package projeto_lp_aed2.javafx.generic_point;

public class Escada extends Point3D {

    private int numero_escada;

    public Escada(float x, float y, int z, String name, int numero_escada) {
        super(x, y, z, name);
        this.numero_escada = numero_escada;
    }

    public int getNumero_escada() {
        return numero_escada;
    }

    public void setNumero_escada(int numero_escada) {
        this.numero_escada = numero_escada;
    }
}
