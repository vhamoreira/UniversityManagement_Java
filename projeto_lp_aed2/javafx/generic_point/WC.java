package projeto_lp_aed2.javafx.generic_point;

public class WC extends Point3D {
    String gender;
    private int numero_wc;


    public WC(float x, float y, int z, String name, String gender, int numero_wc) {
        super(x, y, z, name);
        this.gender = gender;
        this.numero_wc = numero_wc;
    }

    public int getNumero_wc() {
        return numero_wc;
    }

    public void setNumero_wc(int numero_wc) {
        this.numero_wc = numero_wc;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
