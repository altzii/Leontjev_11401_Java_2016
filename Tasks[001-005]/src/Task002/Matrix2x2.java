package Task002;

/**
 * Created by Alexander on 23/02/2016.
 */
public class Matrix2x2 {
    private double elements[][] = new double[2][2];

    public double[][] getElements() {
        return elements;
    }

    public Matrix2x2() {
    }

    public Matrix2x2(double x) {
        this(x, x, x, x);
    }

    public Matrix2x2(double x1, double x2, double x3, double x4) {
        elements[0][0] = x1;
        elements[0][1] = x2;
        elements[1][0] = x3;
        elements[1][1] = x4;
    }

    public Matrix2x2(double b[][]) {
        this(b[0][0], b[0][1], b[1][0], b[1][1]);
    }

    public Matrix2x2 add(Matrix2x2 m2) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.elements[i][j] = this.elements[i][j] + m2.elements[i][j];
            }
        }
        return m;
    }

    public void add2(Matrix2x2 m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.elements[i][j] = this.elements[i][j] + m2.elements[i][j];
            }
        }
    }

    public Matrix2x2 sub(Matrix2x2 m2) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.elements[i][j] = this.elements[i][j] - m2.elements[i][j];
            }
        }
        return m;
    }

    public void sub2(Matrix2x2 m2) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.elements[i][j] = this.elements[i][j] - m2.elements[i][j];
            }
        }
    }

    public Matrix2x2 multNumber(double k) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.elements[i][j] = this.elements[i][j] * k;
            }
        }
        return m;
    }

    public void multNumber2(double k) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                this.elements[i][j] = this.elements[i][j] * k;
            }
        }
    }

    public Matrix2x2 mult(Matrix2x2 m2) {
        Matrix2x2 m = new Matrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    m.elements[i][j] += this.elements[i][k] * m2.elements[k][j];
                }
            }
        }
        return m;
    }

    public void mult2(Matrix2x2 m2) {
        double a = 0;
        double b = 0;
        double c = 0;
        double d = 0;

        for (int i = 0; i < 2; i++) {
            a += this.elements[0][i] * m2.elements[i][0];
            b += this.elements[0][i] * m2.elements[i][1];
            c += this.elements[1][i] * m2.elements[i][0];
            d += this.elements[1][i] * m2.elements[i][1];
        }

        this.elements[0][0] = a;
        this.elements[0][1] = b;
        this.elements[1][0] = c;
        this.elements[1][1] = d;
    }

    public double det() {
        return elements[0][0] * elements[1][1] - elements[0][1] * elements[1][0];
    }

    public void transpon() {
        double temp;
        temp = this.elements[1][0];
        this.elements[1][0] = this.elements[0][1];
        this.elements[0][1] = temp;
    }

    public Matrix2x2 inverseMatrix() {
        Matrix2x2 m = new Matrix2x2();
        if (this.det() != 0) {
            m.elements[0][0] = this.elements[1][1] / this.det();
            m.elements[0][1] = -this.elements[1][0] / this.det();
            m.elements[1][0] = -this.elements[0][1] / this.det();
            m.elements[1][1] = this.elements[0][0] / this.det();
            m.transpon();
        } else {
            throw new ArithmeticException();
        }
        return m;
    }

    public Vector2D multVector(Vector2D v2) {
        Vector2D v = new Vector2D();
        v.setX(this.elements[0][0] * v2.getX() + this.elements[0][1] * v2.getY());
        v.setY(this.elements[1][0] * v2.getX() + this.elements[1][1] * v2.getY());
        return v;
    }

    public Matrix2x2 equivalentDiagonal() {
        Matrix2x2 m = new Matrix2x2();
        m.elements[0][0] = this.elements[0][0];
        m.elements[0][1] = 0;
        m.elements[1][0] = 0;
        m.elements[1][1] = this.elements[1][1] - this.elements[0][1] * this.elements[1][0] / this.elements[0][0];
        return m;
    }
}
