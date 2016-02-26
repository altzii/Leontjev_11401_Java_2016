package Task003;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Alexander on 24/02/2016.
 */
public class ComplexMatrix2x2Test {
    private static ComplexNumber complexNumber;
    private static ComplexNumber complexNumber1;
    private static ComplexNumber complexNumber2;
    private static ComplexNumber complexNumber3;
    private static ComplexNumber complexNumber4;

    @BeforeClass
    public static void init() {
        complexNumber = mock(ComplexNumber.class);
        when(complexNumber.getA()).thenReturn(1.0);
        when(complexNumber.getB()).thenReturn(2.0);
        when(complexNumber.mult(complexNumber)).thenCallRealMethod();
        when(complexNumber.add(anyObject())).thenCallRealMethod();

        complexNumber1 = mock(ComplexNumber.class);
        when(complexNumber1.getA()).thenReturn(2.0);
        when(complexNumber1.getB()).thenReturn(5.0);
        when(complexNumber1.add(anyObject())).thenCallRealMethod();

        complexNumber2 = mock(ComplexNumber.class);
        when(complexNumber2.getA()).thenReturn(3.0);
        when(complexNumber2.getB()).thenReturn(6.0);
        when(complexNumber2.add(anyObject())).thenCallRealMethod();

        complexNumber3 = mock(ComplexNumber.class);
        when(complexNumber3.getA()).thenReturn(7.0);
        when(complexNumber3.getB()).thenReturn(8.0);
        when(complexNumber3.add(anyObject())).thenCallRealMethod();

        complexNumber4 = mock(ComplexNumber.class);
        when(complexNumber4.getA()).thenReturn(1.0);
        when(complexNumber4.getB()).thenReturn(2.0);
        when(complexNumber4.add(anyObject())).thenCallRealMethod();
    }

    @Test
    public void allElementsShouldHaveParamValue() {
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2(complexNumber);

        Assert.assertTrue(complexMatrix2x2.getElements()[0][0].equals(complexNumber)
                && complexMatrix2x2.getElements()[0][1].equals(complexNumber)
                && complexMatrix2x2.getElements()[1][0].equals(complexNumber)
                && complexMatrix2x2.getElements()[1][1].equals(complexNumber));
    }

    @Test
    public void allElementsShouldHaveZeroValue() {
        ComplexNumber zeroComplexNumber = mock(ComplexNumber.class);
        when(zeroComplexNumber.getA()).thenReturn(0.0);
        when(zeroComplexNumber.getB()).thenReturn(0.0);
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2();

        Assert.assertTrue(complexMatrix2x2.getElements()[0][0].equals(zeroComplexNumber)
                && complexMatrix2x2.getElements()[0][1].equals(zeroComplexNumber)
                && complexMatrix2x2.getElements()[1][0].equals(zeroComplexNumber)
                && complexMatrix2x2.getElements()[1][1].equals(zeroComplexNumber));
    }

    @Test
    public void eachElementShouldHaveTheSameValueToElementInParams() {
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2(complexNumber1, complexNumber2, complexNumber3, complexNumber4);

        Assert.assertTrue(complexMatrix2x2.getElements()[0][0].equals(complexNumber1)
                && complexMatrix2x2.getElements()[0][1].equals(complexNumber2)
                && complexMatrix2x2.getElements()[1][0].equals(complexNumber3)
                && complexMatrix2x2.getElements()[1][1].equals(complexNumber4));
    }

    @Test
    public void eachElementOfAddResultShouldBeCorrect() {
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2(complexNumber1, complexNumber2, complexNumber3, complexNumber4);
        ComplexMatrix2x2 resultComplexMatrix2x2 = complexMatrix2x2.add(complexMatrix2x2);

        ComplexNumber resComplexNumber1 = mock(ComplexNumber.class);
        when(resComplexNumber1.getA()).thenReturn(4.0);
        when(resComplexNumber1.getB()).thenReturn(10.0);
        when(resComplexNumber1.add(anyObject())).thenCallRealMethod();
        ComplexNumber resComplexNumber2 = mock(ComplexNumber.class);
        when(resComplexNumber2.getA()).thenReturn(6.0);
        when(resComplexNumber2.getB()).thenReturn(12.0);
        when(resComplexNumber2.add(anyObject())).thenCallRealMethod();
        ComplexNumber resComplexNumber3 = mock(ComplexNumber.class);
        when(resComplexNumber3.getA()).thenReturn(14.0);
        when(resComplexNumber3.getB()).thenReturn(16.0);
        when(resComplexNumber3.add(anyObject())).thenCallRealMethod();
        ComplexNumber resComplexNumber4 = mock(ComplexNumber.class);
        when(resComplexNumber4.getA()).thenReturn(2.0);
        when(resComplexNumber4.getB()).thenReturn(4.0);
        when(resComplexNumber4.add(anyObject())).thenCallRealMethod();

        Assert.assertTrue(resultComplexMatrix2x2.getElements()[0][0].equals(resComplexNumber1)
                && resultComplexMatrix2x2.getElements()[0][1].equals(resComplexNumber2)
                && resultComplexMatrix2x2.getElements()[1][0].equals(resComplexNumber3)
                && resultComplexMatrix2x2.getElements()[1][1].equals(resComplexNumber4));
    }

    @Test
    public void eachElementOfMultResultShouldBeCorrect() {
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2(complexNumber);
        ComplexMatrix2x2 resultComplexMatrix2x2 = complexMatrix2x2.mult(complexMatrix2x2);

        Assert.assertTrue(resultComplexMatrix2x2.getElements()[0][0].equals(complexNumber.mult(complexNumber).add(complexNumber.mult(complexNumber)))
                && resultComplexMatrix2x2.getElements()[0][1].equals(complexNumber.mult(complexNumber).add(complexNumber.mult(complexNumber)))
                && resultComplexMatrix2x2.getElements()[1][0].equals(complexNumber.mult(complexNumber).add(complexNumber.mult(complexNumber)))
                && resultComplexMatrix2x2.getElements()[1][1].equals(complexNumber.mult(complexNumber).add(complexNumber.mult(complexNumber))));
    }

    @Test
    public void valueOfDetShouldBeCorrect() {
        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2(complexNumber);

        Assert.assertTrue(complexMatrix2x2.det().equals((complexMatrix2x2.getElements()[0][0].mult(complexMatrix2x2.getElements()[1][1])).sub(complexMatrix2x2.getElements()[1][0].mult(complexMatrix2x2.getElements()[0][1]))));
    }

    @Test
    public void multVectorShouldWorkCorrect() {
        ComplexVector2D complexVector2D = mock(ComplexVector2D.class);
        when(complexVector2D.getX()).thenReturn(complexNumber);
        when(complexVector2D.getY()).thenReturn(complexNumber);
        when(complexVector2D.add(anyObject())).thenCallRealMethod();

        ComplexMatrix2x2 complexMatrix2x2 = new ComplexMatrix2x2(complexNumber);
        ComplexVector2D resultComplexVector2D = mock(ComplexVector2D.class);
        ComplexNumber cn1 = complexMatrix2x2.getElements()[0][0].mult(complexVector2D.getX()).add(complexMatrix2x2.getElements()[0][1].mult(complexVector2D.getY()));
        ComplexNumber cn2 = complexMatrix2x2.getElements()[1][0].mult(complexVector2D.getX()).add(complexMatrix2x2.getElements()[1][1].mult(complexVector2D.getY()));

        when(resultComplexVector2D.getX()).thenReturn(cn1);
        when(resultComplexVector2D.getY()).thenReturn(cn2);

        Assert.assertTrue(complexMatrix2x2.multVector(complexVector2D).equals(resultComplexVector2D));
    }
}
