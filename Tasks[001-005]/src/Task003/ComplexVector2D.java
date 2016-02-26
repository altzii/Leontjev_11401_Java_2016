package Task003;

/**
 * Created by Alexander on 24/02/2016.
 */
public class ComplexVector2D {
    private ComplexNumber x;
    private ComplexNumber y;

    public ComplexVector2D(ComplexNumber x, ComplexNumber y) {
        this.x = x;
        this.y = y;
    }

    public ComplexVector2D() {
        this(new ComplexNumber(), new ComplexNumber());
    }

    public ComplexNumber getX() {
        return this.x;
    }

    public ComplexNumber getY() {
        return this.y;
    }

    public void setX(ComplexNumber x) {
        this.x = x;
    }

    public void setY(ComplexNumber y) {
        this.y = y;
    }

    public String toString() {
        return "{" + this.x + " , " + this.y + "}";
    }

    public ComplexVector2D add(ComplexVector2D cn2d) {
        ComplexVector2D n = new ComplexVector2D();
        n.x = this.x.add(cn2d.x);
        n.y = this.y.add(cn2d.y);
        return n;
    }

    public ComplexNumber scalarProduct(ComplexVector2D cv2d) {
        return this.x.mult(cv2d.x).add(this.y.mult(cv2d.y));
    }

    @Override
    public boolean equals(Object cv2d) {
        return this.getX().equals(((ComplexVector2D) cv2d).getX()) && this.getY().equals(((ComplexVector2D) cv2d).getY());
    }
}
