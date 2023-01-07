package matrix.floatMatrix;


import matrix.Matrix3;

import java.util.List;

import static matrix.MatrixUtils.toFloatArray;

public class Matrix3f extends Matrix3<Float> {
    public Matrix3f(List<Float> matrix) {
        super(matrix);
    }

    public Matrix3f(float[] matrix) {
        super(toFloatArray(matrix));
    }


    public Matrix3f(int size, Float value) {
        super(value);
    }
}
