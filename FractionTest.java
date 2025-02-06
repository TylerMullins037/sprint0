import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FractionTest {

    @Test
    void testAddition() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(1, 3);
        Fraction result = f1.add(f2);
        assertEquals("5/6", result.toString());
    }

    @Test
    void testSubtraction() {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(1, 4);
        Fraction result = f1.subtract(f2);
        assertEquals("1/2", result.toString());
    }

    @Test
    void testMultiplication() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.multiply(f2);
        assertEquals("1/2", result.toString());
    }

    @Test
    void testDivision() {
        Fraction f1 = new Fraction(2, 3);
        Fraction f2 = new Fraction(3, 4);
        Fraction result = f1.divide(f2);
        assertEquals("8/9", result.toString());
    }

    @Test
    void testEquality() {
        Fraction f1 = new Fraction(1, 2);
        Fraction f2 = new Fraction(2, 4);
        assertTrue(f1.equals(f2));
    }

    @Test
    void testGreaterThan() {
        Fraction f1 = new Fraction(3, 4);
        Fraction f2 = new Fraction(1, 2);
        assertTrue(f1.greaterThan(f2));
    }

    @Test
    void testLessThan() {
        Fraction f1 = new Fraction(1, 3);
        Fraction f2 = new Fraction(1, 2);
        assertTrue(f1.lessThan(f2));
    }

    @Test
    void testInvalidFraction() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Fraction(1, 0));
        assertEquals("Fraction is undefined/indeterminate", exception.getMessage());
    }
}
