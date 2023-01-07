package matrix.floatMatrix;

import matrix.Matrix4;

import java.util.List;

import static matrix.MatrixUtils.toFloatArray;

public class Matrix4f extends Matrix4<Float> {
    public Matrix4f(List<Float> matrix) {
        super(matrix);
    }

    public Matrix4f(float[] matrix) {
        super(toFloatArray(matrix));
    }

    public Matrix4f(float value) {
        super(value);
    }
}
