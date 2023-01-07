import matrix.Matrix;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class MatrixTest {
    static LinkedList<Matrix> matrices;
    float[] expectedF;
    @BeforeAll
    public static void createMatrices(){
        matrices = new LinkedList<>();
        float[] a = new float[]{
                30,21,12,
                32,54,51,
                12,32,11
        };
        float[] b = new float[]{
                12,10,94,
                44,32,41,
                13,19,32
        };
        float[] c = new float[]{
                12,10,94,
                44,32,41
        };
        float[] d = new float[]{
                12,10,
                94,44,
                32,41
        };
        float[] e = new float[]{
                10,11,94,
                44,32,41
        };
//
//        matrices.add(new Matrix(a,3,3));
//        matrices.add(new Matrix(b,3,3));
//        matrices.add(new Matrix(c,2,3));
//        matrices.add(new Matrix(d,3,2));
//        matrices.add(new Matrix(e,2,3));
    }
    @Test
    public void shouldAddSquareMatrices(){
        expectedF = new float[]{
                42,	31,	106,
                76,	86,	 92,
                25,	51,	 43,

        };
//        Matrix expectedMatrix = new Matrix(expectedF,3,3);
//        Assertions.assertEquals(expectedMatrix, Matrix.addition(matrices.get(0),matrices.get(1)));
    }

    @Test
    public void shouldAddMatrices(){
        expectedF = new float[]{
                22,	21,	188,
                88,	64,	 82
        };
        /*Matrix expectedMatrix = new Matrix(expectedF,2,3);
        Assertions.assertEquals(expectedMatrix, Matrix.addition(matrices.get(2),matrices.get(4)));*/
    }
}
