package projeto_lp_aed2.javafx.generic_point;

public class Corredor extends Point3D {
    private int numero_corredor;

    public Corredor(float x, float y, int z, String name, int numero_corredor) {
        super(x, y, z, name);
        this.numero_corredor = numero_corredor;
    }

    public int getNumero_corredor() {
        return numero_corredor;
    }

    public void setNumero_corredor(int numero_corredor) {
        this.numero_corredor = numero_corredor;
    }
}
