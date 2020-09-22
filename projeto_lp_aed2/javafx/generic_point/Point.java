/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projeto_lp_aed2.javafx.generic_point;


public class Point {

    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return this.x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return this.y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float distX(Point p) {
        return Math.abs(p.getX() - this.x);
    }

    public float distY(Point p) {
        return Math.abs(p.getY() - this.y);
    }

    public float dist(Point p) {
        return (float) Math.sqrt(Math.pow(this.distX(p),2) + (Math.pow(this.distY(p),2)));
    }

    public void moveX(float delta) {
        this.x += delta;
    }

    public void moveY(float delta) {
        this.y += delta;
    }

    public void move(float x, float y) {
        this.x += x;
        this.y += y;
    }

    public void printPoint() {
        System.out.println("x->" + this.getX() + " y->" + this.y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public static void main(String[] args) {
        Point p1 = new Point(1.0f, 2.0f);
        Point p2 = new Point(5.0f, 7.0f);

        System.out.println(p1);
        System.out.println(p2);

        System.out.println(p1.distX(p2));
        System.out.println(p1.distX(p1));

        System.out.println(p2.distY(p1));
        System.out.println(p2.distY(p2));

        System.out.println(p1.dist(p2));

        p1.move(p1.distX(p2), p1.distY(p2));
        p1.printPoint();
    }
}

