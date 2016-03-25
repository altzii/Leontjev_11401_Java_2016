package Task009;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Alexander on 24/02/2016.
 */
public class ComplexMatrix2x2Test {
    private static ComplexNumber complexNumber;
    private static ComplexNumber complexNumber1;
    private static ComplexNumber complexNumber2;
    private static ComplexNumber complexNumber3;
    private static ComplexNumber complexNumber4;
    static ApplicationContext ac;

    @BeforeClass
    public static void init() {
        ac = new ClassPathXmlApplicationContext("Task009/spring-config-task009.xml");
        complexNumber = (ComplexNumber) ac.getBean("complexNumber");
        complexNumber1 = (ComplexNumber) ac.getBean("complexNumber1");
        complexNumber2 = (ComplexNumber) ac.getBean("complexNumber2");
        complexNumber3 = (ComplexNumber) ac.getBean("complexNumber3");
        complexNumber4 = (ComplexNumber) ac.getBean("complexNumber4");


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
        ComplexNumber zeroComplexNumber = (ComplexNumber) ac.getBean("zeroComplexNumber");
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

        ComplexNumber resComplexNumber1 = (ComplexNumber) ac.getBean("resComplexNumber1");
        ComplexNumber resComplexNumber2 = (ComplexNumber) ac.getBean("resComplexNumber2");
        ComplexNumber resComplexNumber3 = (ComplexNumber) ac.getBean("resComplexNumber3");
        ComplexNumber resComplexNumber4 = (ComplexNumber) ac.getBean("resComplexNumber4");

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
        ComplexVector2D complexVector2D = (ComplexVector2D) ac.getBean("complexVector2D");

        ComplexMatrix2x2 complexMatrix2x2 = (ComplexMatrix2x2) ac.getBean("complexMatrix2x2");
        ComplexVector2D resultComplexVector2D = (ComplexVector2D) ac.getBean("resultComplexVector");

        Assert.assertTrue(complexMatrix2x2.multVector(complexVector2D).equals(resultComplexVector2D));
    }
}
