package Task009;

/**
 * Created by Alexander on 23/02/2016.
 */
public class ComplexMatrix2x2 {
    public ComplexNumber[][] getElements() {
        return elements;
    }

    private ComplexNumber elements[][] = new ComplexNumber[2][2];

    public ComplexMatrix2x2(ComplexNumber x) {
        this(x, x, x, x);
    }

    public ComplexMatrix2x2(ComplexNumber x1, ComplexNumber x2, ComplexNumber x3, ComplexNumber x4) {
        elements[0][0] = x1;
        elements[0][1] = x2;
        elements[1][0] = x3;
        elements[1][1] = x4;
    }

    public ComplexMatrix2x2() {
        this(new ComplexNumber());
    }

    public ComplexMatrix2x2 add(ComplexMatrix2x2 m2) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                m.elements[i][j] = this.elements[i][j].add(m2.elements[i][j]);
            }
        }
        return m;
    }

    public ComplexMatrix2x2 mult(ComplexMatrix2x2 m2) {
        ComplexMatrix2x2 m = new ComplexMatrix2x2();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    m.elements[i][j] = m.elements[i][j].add(this.elements[i][k].mult(m2.elements[k][j]));
                }
            }
        }
        return m;
    }

    public ComplexNumber det() {
        return elements[0][0].mult(elements[1][1]).sub(elements[0][1].mult(elements[1][0]));
    }

    public ComplexVector2D multVector(ComplexVector2D cv2) {
        ComplexVector2D cv2d = new ComplexVector2D();
        cv2d.setX(this.elements[0][0].mult(cv2.getX()).add(this.elements[0][1].mult(cv2.getY())));
        cv2d.setY(this.elements[1][0].mult(cv2.getX()).add(this.elements[1][1].mult(cv2.getY())));
        return cv2d;
    }
}

