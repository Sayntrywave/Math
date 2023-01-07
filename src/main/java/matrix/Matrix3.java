package matrix;


import java.util.List;

public class Matrix3<T extends Number> extends SquareMatrix<T>{


    public Matrix3(List<T> matrix) {
        super(matrix, 3);
    }

    public Matrix3(T[] matrix) {
        super(matrix, 3);
    }

    public Matrix3(T value) {
        super( 3, value);
    }

    public static void main(String[] args) {
        SquareMatrix<Integer> a = new SquareMatrix<>(3,1);
        Matrix<Integer> b = new SquareMatrix<>(3,1);

        b = b.add(b);
        System.out.println(b.toString());

        b = b.mul(3);

        System.out.println(b.toString());

        b = b.add(a);
        System.out.println(b.toString());

        b = b.sub(a);
        System.out.println(b.toString());
        b = new Matrix3<Integer>(
                new Integer[]{
                        1,2,3,
                        4,5,6,
                        7,8,9
                }
        );
        b = b.transpose();

        System.out.println(b.toString());
//        Matrix matrix3 = new Matrix(new float[]{},1,2);
    }


}
