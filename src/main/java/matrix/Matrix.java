package matrix;

import java.util.*;

public class Matrix<T extends Number> {
    protected final List<T> matrix;
    protected final int rows;
    protected final int cols;


    public Matrix(List<T> matrix, int rows, int cols) {
        this.matrix = matrix;
        this.rows = rows;
        this.cols = cols;
    }

    //https://www.youtube.com/live/9yt4SiA7OiU?feature=share&t=5321
    public Matrix(int rows, int cols, T value) {
        this.rows = rows;
        this.cols = cols;
        matrix = new ArrayList<>();
        fill(value);
    }

    private void fill(T number) {
        for (int i = 0; i < rows * cols; i++) {
            this.matrix.add(number);
        }

    }

    public List<T> getArray(int size) {
        return matrix;
    }

    private static Double sumToDouble(Number... numbers) {
        double doubleSum = 0;

        for (Number number : numbers) {
            doubleSum += number.doubleValue();
        }
        return doubleSum;
    }

    public static <T extends Number, MartixUtils> Matrix<T> addition(Matrix<T> matrix1, Matrix<T> matrix2) {
        checkMatrices(matrix1, matrix2);
        List<T> valuesOfMatrix1 = matrix1.getMatrix();
        List<T> valuesOfMatrix2 = matrix2.getMatrix();
        List<T> newMatrix = new LinkedList<>();
        for (int i = 0; i < valuesOfMatrix1.size(); i++) {
            newMatrix.add((T) sumToDouble(valuesOfMatrix1.get(i), valuesOfMatrix2.get(i)));
//            newMatrix.add((T) Double.valueOf(valuesOfMatrix1.get(i).doubleValue() + valuesOfMatrix2.get(i).doubleValue()));
        }

        return new Matrix<>(newMatrix, matrix1.getRows(), matrix1.getCols());
    }


    public static <T extends Number> Matrix subtraction(Matrix<T> matrix1, Matrix<T> matrix2) {
        checkMatrices(matrix1, matrix2);
        List<T> matrix1F = matrix1.getMatrix();
        List<T> matrix2F = matrix2.getMatrix();
        List<T> newMatrix = new LinkedList<>();

        for (int i = 0; i < matrix1F.size(); i++) {
            newMatrix.add((T) sumToDouble(
                    matrix1F.get(i).doubleValue(), matrix2F.get(i).doubleValue()
            ));
        }

        return new Matrix(newMatrix, matrix1.getRows(), matrix1.getCols());
    }

    public static <T extends Number> Matrix multiplication(Matrix<T> matrix, T c) {
        List<T> matrix1F = matrix.getMatrix();
        List<T> newMatrix = new LinkedList<>();
        for (T t : matrix1F) {
            newMatrix.add((T) Double.valueOf(c.doubleValue() * t.doubleValue()));
        }

        return new Matrix(newMatrix, matrix.getRows(), matrix.getCols());
    }

    public static <T extends Number> Matrix multiplication(Matrix<T> matrix1, Matrix<T> matrix2) {
        if (matrix1 == null || matrix2 == null) {
            throw new MatrixException("Matrix is null");
        }
        if (matrix1.getCols() != matrix2.getRows()) {
            throw new MatrixException("Width of the first matrix isn't equal to the height of the second one");
        }

        List<T> matrix1F = matrix1.getMatrix();
        List<T> matrix2F = matrix2.getMatrix();
        List<T> newMatrix = new LinkedList<>();

//
        for (int i = 0; i < matrix1.getRows() * matrix2.getCols(); i++) {
            double value = 0.0;
            for (int j = 0; j < matrix1.getCols(); j++) {
                value += matrix1F.get(i * matrix1.getCols() + j).doubleValue() * matrix2F.get(j * matrix2.getRows() + i).doubleValue();
            }
            newMatrix.add((T) Double.valueOf(value));
        }

        return new Matrix(newMatrix, matrix1.getRows(), matrix2.getCols());
    }

//    public static <T extends Number> Matrix transposition(Matrix<T> matrix) {
//        List<T> matrix1F = matrix.getMatrix();
//        List<T> newMatrix = new float[matrix.getCols()];
//        for (int row = 0; row < matrix.getRows(); row++) {
//            for (int col = 0; col < matrix.getCols(); col++) {
//                setElement(newMatrix, matrix.getCols(), row, col, matrix.getElement(col, row));
//            }
//        }
//        return new Matrix(matrix.getMatrix(), matrix.getRows(), matrix.getCols());
//    }
//
//    public static Matrix<? extends Number> createIdentityMatrix(int rows, int cols) {
//        float[] newMatrix = new float[rows * cols];
//        for (int i = 0; i < cols; i++) {
//            newMatrix[cols * i + i] = 1;
//        }
//        return new Matrix<Number>(newMatrix, rows, cols);
//    }

    static <T extends Number> void setElement(List<T> matrix, int width, int row, int col, T value) {
        matrix.set(width * row + col, value);
    }

    static void checkMatrices(Matrix matrix1, Matrix matrix2) {
        //переименовать метод и разделить проверки
        if (matrix1 == null || matrix2 == null) {
            throw new MatrixException("Matrix is null");
        }
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getCols() != matrix2.getCols()) {
            throw new MatrixException("length of the matrices aren't equal");
        }
    }

    public static void main(String[] args) {
        int[][] a = new int[][]{{1, 2}, {1, 2, 3}, {1, 2, 3, 4}};
        System.out.println(Arrays.toString(a));
        Matrix.addition(
                new Matrix3f(new float[4],3,3),
                new Matrix4f(new float[3],1,2)
        );

        Matrix<Float> matrix1 = new Matrix<>(2,3,3f);
    }

    public List<T> getMatrix() {
        return matrix;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }
//
//    public float getElement(int row, int col) {
//        return matrix[cols * row + col];
//    }
//
    public Matrix<T> add(Matrix<T> matrix1) {
        return addition(this, matrix1);
    }
//
//    public Matrix subtract(Matrix<? extends Number> matrix1) {
//        return subtraction(this, matrix1);
//    }
//
//    public Matrix multiply(Matrix<? extends Number> matrix1) {
//        return multiplication(this, matrix1);
//    }
//
//    public Matrix multiply(T c) {
//        return multiplication(this, c);
//    }

//    public Matrix transpose() {
//        return transposition(this);
//    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix<?> matrix1 = (Matrix<?>) o;
        return rows == matrix1.rows && cols == matrix1.cols && Objects.equals(matrix, matrix1.matrix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matrix, rows, cols);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
//        for (int row = 0; row < rows; row++) {
//            for (int col = 0; col < cols; col++) {
//                stringBuilder.append(getElement(row, col) + " ");
//            }
//            stringBuilder.append("\n");
//        }
        return stringBuilder.toString();

    }
}
