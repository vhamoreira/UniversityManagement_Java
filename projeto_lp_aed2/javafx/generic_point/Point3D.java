package projeto_lp_aed2.javafx.generic_point;

public class Point3D extends Point {
    int id;
    int z;
    private String name;

    public Point3D(float x, float y, int z, String name) {
        super(x, y);
        this.z = z;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
