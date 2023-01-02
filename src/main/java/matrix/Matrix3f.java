package matrix;


import org.ejml.simple.SimpleMatrix;

import java.util.ArrayList;

public class Matrix3f extends Matrix{


    public Matrix3f(float[] matrix, int rows, int cols) {
        //todo
        super(new ArrayList(),rows,cols);
        if(rows != 3 || cols != 3 || matrix.length != 9){
            throw new MatrixException("");
        }
    }

    public static void main(String[] args) {
        Matrix matrix = new Matrix3f(new float[]{1,2,3,4,5,6,7,8,9},3,3);
        Matrix matrix2 = new Matrix4f(new float[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16},4,4);
        Matrix4f.addition(matrix,matrix2);
//        Matrix matrix3 = new Matrix(new float[]{},1,2);
    }


}
