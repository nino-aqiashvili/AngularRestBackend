package com.epam.upskill.calculator;

import com.epam.upskill.calculator.models.Result;
import com.epam.upskill.calculator.models.operations.AddOperation;
import com.epam.upskill.calculator.models.operations.DivideOperation;
import com.epam.upskill.calculator.models.operations.MultiplyOperation;
import com.epam.upskill.calculator.models.operations.SubtractOperation;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {

    @Mock
    private Result result;

    @Spy
    @InjectMocks
    private AddOperation addOperation;

    @Spy
    @InjectMocks
    private SubtractOperation subtractOperation;

    @Spy
    @InjectMocks
    private MultiplyOperation multiplyOperation;

    @Spy
    @InjectMocks
    private DivideOperation divideOperation;

    // Add Operation Tests
    @Test
    public void addPositiveNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("5");
        BigDecimal num2 = new BigDecimal("10");
        addOperation.setOperand1(num1);
        addOperation.setOperand2(num2);

        Result result1 = addOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("15"), result1.getResult());
    }

    @Test
    public void addNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("-5");
        BigDecimal num2 = new BigDecimal("-10");
        addOperation.setOperand1(num1);
        addOperation.setOperand2(num2);

        Result result1 = addOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("-15"), result1.getResult());
    }

    @Test
    public void addPositiveAndNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("5");
        BigDecimal num2 = new BigDecimal("-10");
        addOperation.setOperand1(num1);
        addOperation.setOperand2(num2);

        Result result1 = addOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("-5"), result1.getResult());
    }

    // Subtract Operation Tests
    @Test
    public void subtractPositiveNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("5");
        subtractOperation.setOperand1(num1);
        subtractOperation.setOperand2(num2);

        Result result1 = subtractOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("5"), result1.getResult());
    }

    @Test
    public void subtractNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("-10");
        BigDecimal num2 = new BigDecimal("-5");
        subtractOperation.setOperand1(num1);
        subtractOperation.setOperand2(num2);

        Result result1 = subtractOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("-5"), result1.getResult());
    }

    @Test
    public void subtractPositiveAndNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("-5");
        subtractOperation.setOperand1(num1);
        subtractOperation.setOperand2(num2);

        Result result1 = subtractOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("15"), result1.getResult());
    }

    // Multiply Operation Tests
    @Test
    public void multiplyPositiveNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("4");
        BigDecimal num2 = new BigDecimal("5");
        multiplyOperation.setOperand1(num1);
        multiplyOperation.setOperand2(num2);

        Result result1 = multiplyOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("20"), result1.getResult());
    }

    @Test
    public void multiplyNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("-4");
        BigDecimal num2 = new BigDecimal("-5");
        multiplyOperation.setOperand1(num1);
        multiplyOperation.setOperand2(num2);

        Result result1 = multiplyOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("20"), result1.getResult());
    }

    @Test
    public void multiplyPositiveAndNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("4");
        BigDecimal num2 = new BigDecimal("-5");
        multiplyOperation.setOperand1(num1);
        multiplyOperation.setOperand2(num2);

        Result result1 = multiplyOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("-20"), result1.getResult());
    }

    // Divide Operation Tests
    @Test
    public void dividePositiveNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("2");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("5.0000000000"), result1.getResult());
    }

    @Test
    public void divideNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("-10");
        BigDecimal num2 = new BigDecimal("-2");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("5.0000000000"), result1.getResult());
    }

    @Test
    public void dividePositiveAndNegativeNumbersTest() throws Exception {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("-2");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("-5.0000000000"), result1.getResult());
    }

    @Test
    public void divideZeroByPositiveNumberTest() throws Exception {
        BigDecimal num1 = new BigDecimal("0");
        BigDecimal num2 = new BigDecimal("5");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("0.0000000000"), result1.getResult());
    }

    @Test
    public void divideZeroByNegativeNumberTest() throws Exception {
        BigDecimal num1 = new BigDecimal("0");
        BigDecimal num2 = new BigDecimal("-5");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("0.0000000000"), result1.getResult());
    }

    @Test
    public void divideByOneTest() throws Exception {
        BigDecimal num1 = new BigDecimal("12345");
        BigDecimal num2 = new BigDecimal("1");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("12345.0000000000"), result1.getResult());
    }

    @Test
    public void divideResultWithRoundingTest() throws Exception {
        BigDecimal num1 = new BigDecimal("10");
        BigDecimal num2 = new BigDecimal("2");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        // Assuming your implementation handles rounding
        assertFalse(result1.getError());
        assertEquals(new BigDecimal("5.0000000000"), result1.getResult());
    }

    @Test
    public void divideNullOperatorTest() throws Exception {
        BigDecimal num1 = new BigDecimal("12");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(null);

        Result result1 = divideOperation.perform();

        assertTrue(result1.getError());
    }

    @Test
    public void divideZeroOperatorTest() throws Exception {
        BigDecimal num1 = new BigDecimal("12");
        BigDecimal num2 = new BigDecimal("0");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertTrue(result1.getError());
    }
    @Test
    public void divideNegativeOperatorTest() throws Exception {
        BigDecimal num1 = new BigDecimal("12");
        BigDecimal num2 = new BigDecimal("-1");
        divideOperation.setOperand1(num1);
        divideOperation.setOperand2(num2);

        Result result1 = divideOperation.perform();

        assertFalse(result1.getError());
        assertEquals(new BigDecimal("-12.0000000000"), result1.getResult());
    }
}