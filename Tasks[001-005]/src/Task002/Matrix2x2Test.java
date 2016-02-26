package Task002;

import org.junit.*;

/**
 * Created by Alexander on 23/02/2016.
 */
public class Matrix2x2Test {
    private static final double EPS = 1e-9;
    private static Matrix2x2 matrix1;
    private static Matrix2x2 matrix2;
    private static Matrix2x2 zeroMatrix2x2;

    @BeforeClass
    static public void init() {
        matrix1 = new Matrix2x2(1, 2, 3, 4);
        matrix2 = new Matrix2x2(6, 7, 8, 9);
        zeroMatrix2x2 = new Matrix2x2();
    }

    @Test
    public void allElementsShouldHaveZeroValue() {
        double[][] array = {{0, 0}, {0, 0}};
        Assert.assertArrayEquals(array, zeroMatrix2x2.getElements());
    }

    @Test
    public void allElementsShouldHaveParamValue() {
        double param = 2;
        Matrix2x2 matrix2x2 = new Matrix2x2(param);
        double[][] array = {{param, param}, {param, param}};
        Assert.assertArrayEquals(array, matrix2x2.getElements());
    }

    @Test
    public void eachElementShouldHaveTheSameValueToElementInParamArray() {
        double[][] array = {{1, 2}, {3, 4}};
        Matrix2x2 matrix2x2 = new Matrix2x2(array);
        Assert.assertArrayEquals(array, matrix2x2.getElements());
    }

    @Test
    public void eachElementShouldHaveTheSameValueToElementInParams() {
        double[][] array = {{1, 2}, {3, 4}};
        Assert.assertArrayEquals(array, matrix1.getElements());
    }

    @Test
    public void eachElementOfAddResultShouldBeCorrect() {
        Matrix2x2 addResult = matrix1.add(matrix2);
        double[][] array = {{7, 9}, {11, 13}};
        Assert.assertArrayEquals(array, addResult.getElements());
    }

    @Test
    public void eachElementOfAdd2ResultShouldBeWrittenToFirstMatrix() {
        Matrix2x2 add2Matrix = new Matrix2x2(1, 2, 3, 4);
        add2Matrix.add2(matrix2);
        double[][] array = {{7, 9}, {11, 13}};
        Assert.assertArrayEquals(array, add2Matrix.getElements());
    }

    @Test
    public void eachElementOfSubResultShouldBeCorrect() {
        double[][] array = {{-5, -5}, {-5, -5}};
        Assert.assertArrayEquals(array, matrix1.sub(matrix2).getElements());
    }

    @Test
    public void eachElementOfSub2ResultShouldBeWrittenToFirstMatrix() {
        Matrix2x2 sub2Matrix = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 matrix2 = new Matrix2x2(6, 7, 8, 9);
        sub2Matrix.sub2(matrix2);
        double[][] array = {{-5, -5}, {-5, -5}};
        Assert.assertArrayEquals(array, sub2Matrix.getElements());
    }

    @Test
    public void eachElementOfMultNumberShouldBeCorrect() {
        double[][] multNumberArray = {{3, 6}, {9, 12}};
        Assert.assertArrayEquals(multNumberArray, matrix1.multNumber(3).getElements());
    }

    @Test
    public void eachElementOfMultNumber2ResultShouldBeWrittenToMatrix() {
        double[][] multNumberArray = {{3, 6}, {9, 12}};
        Matrix2x2 multNum2Matrix = new Matrix2x2(1, 2, 3, 4);
        multNum2Matrix.multNumber2(3);
        Assert.assertArrayEquals(multNumberArray, multNum2Matrix.getElements());
    }

    @Test
    public void eachElementOfMultResultShouldBeCorrect() {
        double[][] array = {{22, 25}, {50, 57}};
        Assert.assertArrayEquals(array, matrix1.mult(matrix2).getElements());
    }

    @Test
    public void eachElementOfMult2ResultShouldBeWrittenToFirstMatrix() {
        Matrix2x2 mult2Matrix = new Matrix2x2(1, 2, 3, 4);
        mult2Matrix.mult2(matrix2);
        double[][] array = {{22, 25}, {50, 57}};
        Assert.assertArrayEquals(array, mult2Matrix.getElements());
    }

    @Test
    public void valueOfDetShouldBeCorrect() {
        Assert.assertEquals(matrix1.det(), -2, EPS);
    }

    @Test
    public void transponOfMatrixShouldWorkCorrect() {
        Matrix2x2 matrixToTranspon = new Matrix2x2(1, 2, 3, 4);
        matrixToTranspon.transpon();
        double[][] transponArray = {{1, 3}, {2, 4}};
        Assert.assertArrayEquals(transponArray, matrixToTranspon.getElements());
    }

    @Test
    public void inverseMatrixShouldWorkCorrect() {
        Matrix2x2 matrixToInverse = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 inverseMatrix = matrixToInverse.inverseMatrix();
        double[][] inverseArray = {{-2, 1}, {1.5, -0.5}};
        Assert.assertArrayEquals(inverseArray, inverseMatrix.getElements());
    }

    @Test(expected = ArithmeticException.class)
    public void inverseShouldCatchExceptionIfDetHasZeroValue() {
        zeroMatrix2x2.inverseMatrix();
    }

    @Test
    public void multVectorShouldWorkCorrect() {
        Vector2D vector2D = new Vector2D(5, 6);
        Vector2D resultVector2D = matrix1.multVector(vector2D);
        Assert.assertTrue(resultVector2D.getX() == 17 && resultVector2D.getY() == 39);
    }

    @Test
    public void equivalentDiagonalShouldWorkCorrect() {
        Matrix2x2 matrix = new Matrix2x2(1, 2, 3, 4);
        Matrix2x2 equivalentDiagonal = matrix.equivalentDiagonal();
        double[][] equivalentDiagonalArray = {{1, 0}, {0, -2}};
        Assert.assertArrayEquals(equivalentDiagonalArray, equivalentDiagonal.getElements());
    }
}
