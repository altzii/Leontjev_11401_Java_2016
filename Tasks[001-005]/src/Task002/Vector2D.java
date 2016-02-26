package Task002;

/**
 * Created by Alexander on 23/02/2016.
 */
public class Vector2D implements Comparable<Vector2D> {
    private double x;
    private double y;

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public Vector2D() {
        this(0, 0);
    }

    public Vector2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "{" + x + "," + y + "}";
    }

    public Vector2D add(Vector2D v) {
        Vector2D cn = new Vector2D(this.x + v.getX(), this.y + v.getY());
        return cn;
    }

    public void add2(Vector2D v) {
        this.x = this.x + v.getX();
        this.y = this.y + v.getY();
    }

    public Vector2D sub(Vector2D v) {
        Vector2D cn = new Vector2D(this.x - v.getX(), this.y - v.getY());
        return cn;
    }

    public void sub2(Vector2D v) {
        this.x = this.x - v.getX();
        this.y = this.y - v.getY();
    }

    public Vector2D mult(double k) {
        Vector2D cn = new Vector2D(this.x * k, this.y * k);
        return cn;
    }

    public void mult2(double k) {
        this.x = this.x * k;
        this.y = this.y * k;
    }

    public double length() {
        return Math.sqrt(this.x * this.x + this.y * this.y);
    }

    public double scalarProduct(Vector2D v) {
        return this.x * v.getX() + this.y * v.getY();
    }

    public double cos(Vector2D v) {
        return this.scalarProduct(v) / (this.length() * v.length());
    }

    public boolean equals(Vector2D v) {
        return this.x == v.getX() && this.y == v.getY();
    }

    @Override
    public int compareTo(Vector2D v) {
        return (int) Math.signum(this.length() - v.length());
    }
}
