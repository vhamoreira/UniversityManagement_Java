package projeto_lp_aed2.javafx.generic_point;

public class SalaCoordenadas extends Point3D {
    private int numero_sala;

    public SalaCoordenadas(float x, float y, int z, String name, int numero_sala) {
        super(x, y, z, name);
        this.numero_sala = numero_sala;
    }

    public int getNumero_sala() {
        return numero_sala;
    }

    public void setNumero_sala(int numero_sala) {
        this.numero_sala = numero_sala;
    }
}
