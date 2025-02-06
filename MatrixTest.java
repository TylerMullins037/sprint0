import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class MatrixTest {
    @Test
    void testIsSquare() {
        Matrix squareMatrix = new Matrix(4,4);
        assertTrue(squareMatrix.isSquare(), "Matrix should be square.");
    }

    @Test
    void testIsNotSquare() {
        Matrix squareMatrix = new Matrix(3,4);
        assertFalse(squareMatrix.isSquare(), "Matrix should not be square.");
    }

    @Test
    void testTranspose() {
        double[][] data = {
            {0,1,2},
            {3,4,5},
            {6,7,8}
        };
        Matrix matrix = new Matrix(data);
        Matrix transpose = matrix.transpose();

        assertEquals(0, transpose.getData()[0][0]);
        assertEquals(3, transpose.getData()[0][1]);
        assertEquals(4, transpose.getData()[1][1]);
        assertEquals(5, transpose.getData()[2][1]);
        assertEquals(6, transpose.getData()[0][2]);


    }

    @Test
    void testDeterminant() {
        double[][] data = {
            {1, 2},
            {3, 4}
        };
        Matrix matrix = new Matrix(data);
        assertEquals(-2, matrix.determinant(), "Determinant should be -2.");

        // Test a 3x3 matrix
        double[][] data3x3 = {
            {1, 2, 3},
            {0, 4, 5},
            {1, 0, 6}
        };
        Matrix matrix3x3 = new Matrix(data3x3);
        assertEquals(22, matrix3x3.determinant(), "Determinant should be 6.");
        
        // Test for a non-square matrix
        double[][] dataNonSquare = {
            {1, 2, 3}
        };
        Matrix nonSquareMatrix = new Matrix(dataNonSquare);
        assertTrue(Double.isNaN(nonSquareMatrix.determinant()), "Determinant of non-square matrix should be NaN.");
    
    }

    @Test
    void testInverse() {
       // Test invertible 2x2 matrix
       double[][] data2x2 = {
        {4, 7},
        {2, 6}
    };
    Matrix matrix2x2 = new Matrix(data2x2);
    Matrix inverse2x2 = matrix2x2.inverse();
    assertNotNull(inverse2x2, "Inverse should not be null.");
    assertEquals(0.6, inverse2x2.getData()[0][0], 0.0001);
    assertEquals(-0.7, inverse2x2.getData()[0][1], 0.0001);
    
    // Test non-invertible matrix (determinant = 0)
    double[][] dataNonInvertible = {
        {1, 2},
        {2, 4}
    };
    Matrix nonInvertibleMatrix = new Matrix(dataNonInvertible);
    assertNull(nonInvertibleMatrix.inverse(), "Inverse of non-invertible matrix should be null.");

    }

    @Test
    public void testSubMatrix() {
        double[][] data = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        Matrix matrix = new Matrix(data);
        Matrix subMatrix = Matrix.subMatrix(matrix, 2, 2);  // Exclude row 2, col 2
        // exclude_row & exclude_col start at 1, so this excludes the middle row and middle column

        Matrix subMatrix2 = Matrix.subMatrix(matrix, 1, 1);  // Exclude row 2, col 2
        // exclude_row & exclude_col start at 1, so this excludes the first row and first column

        // Submatrix should be a 2x2 matrix
        assertEquals(1, subMatrix.getData()[0][0]);
        assertEquals(3, subMatrix.getData()[0][1]);
        assertEquals(7, subMatrix.getData()[1][0]);
        assertEquals(9, subMatrix.getData()[1][1]);

        assertEquals(5, subMatrix2.getData()[0][0]);
        assertEquals(6, subMatrix2.getData()[0][1]);
        assertEquals(8, subMatrix2.getData()[1][0]);
        assertEquals(9, subMatrix2.getData()[1][1]);
    }
}
