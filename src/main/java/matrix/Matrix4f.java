package matrix;

import java.util.ArrayList;

public class Matrix4f extends Matrix {
    public Matrix4f(float[] matrix, int rows, int cols) {
        //todo
        super(new ArrayList(),rows,cols);
        if(rows != 4 || cols !=4|| matrix.length != 16){
            throw new MatrixException("");
        }
    }

}
