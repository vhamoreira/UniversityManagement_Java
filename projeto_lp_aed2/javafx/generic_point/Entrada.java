package projeto_lp_aed2.javafx.generic_point;

public class Entrada extends Point3D {

    private int numero_entrada;

    public Entrada(float x, float y, int z, String name, int numero_entrada) {
        super(x, y, z, name);
        this.numero_entrada = numero_entrada;
    }

    public int getNumero_entrada() {
        return numero_entrada;
    }

    public void setNumero_entrada(int numero_entrada) {
        this.numero_entrada = numero_entrada;
    }
}
