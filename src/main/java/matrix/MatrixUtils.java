package matrix;

interface MatrixUtils {
    public static Matrix addition(Matrix matrix1, Matrix matrix2) {
        checkMatrices(matrix1,matrix2);
        float[] matrix1F = matrix1.getMatrix();
        float[] matrix2F = matrix2.getMatrix();
        float[] newMatrix = new float[matrix1F.length];

        for (int i = 0; i < newMatrix.length; i++) {
            newMatrix[i] = matrix1F[i] + matrix2F[i];
        }

        return new Matrix(newMatrix,matrix1.getRows(), matrix1.getCols());
    }

    public static Matrix subtraction(Matrix matrix1, Matrix matrix2) {
        checkMatrices(matrix1,matrix2);
        float[] matrix1F = matrix1.getMatrix();
        float[] matrix2F = matrix2.getMatrix();
        float[] newMatrix = new float[matrix1F.length];

        for (int i = 0; i < newMatrix.length; i++) {
            newMatrix[i] = matrix1F[i] - matrix2F[i];
        }
        return new Matrix(newMatrix,matrix1.getRows(), matrix1.getCols());
    }

    public static Matrix multiplication(Matrix matrix, float c){
        float[] matrix1F = matrix.getMatrix();
        float[] newMatrix = new float[matrix1F.length];
        for (int i = 0; i < matrix1F.length; i++) {
            newMatrix[i] *=c*matrix1F[i];
        }
        return new Matrix(newMatrix,matrix.getRows(), matrix.getCols());
    }

    /*static Matrix multiply(Matrix matrix, Vector v){
    }*/
    public static Matrix multiplication(Matrix matrix1, Matrix matrix2){
        if(matrix1 == null || matrix2 == null ){
            throw new MatrixException("Matrix is null");
        }
        if(matrix1.getCols() != matrix2.getRows()){
            throw new MatrixException("Width of the first matrix isn't equal to the height of the second one");
        }

        float[] matrix1F = matrix1.getMatrix();
        float[] matrix2F = matrix2.getMatrix();
        float[] newMatrix = new float[matrix1.getRows()*matrix2.getCols()];
//
       for (int i = 0; i < newMatrix.length ; i++) {
           for (int j = 0; j < matrix1.getCols(); j++) {
               newMatrix[i] += matrix1F[i*matrix1.getCols() + j]*matrix2F[j* matrix2.getRows() + i];
           }
       }

       return new Matrix(newMatrix,matrix1.getRows(),matrix2.getCols());
    }


    public static Matrix transposition(Matrix matrix){
        float[] matrix1F = matrix.getMatrix();
        float[] newMatrix = new float[matrix.getCols()];
        float tmp;
        for (int row = 0; row < matrix.getRows(); row++) {
            for (int col = 0; col < matrix.getCols(); col++)
            {
                setElement(newMatrix,matrix.getCols(),row,col,matrix.getElement(col,row));
            }
        }
        return new Matrix(matrix.getMatrix(),matrix.getRows(),matrix.getCols());
    }

    static void setElement(float[] matrix,int width, int row,int col,float value){
        matrix[width*row + col] = value;
    }




    static void checkMatrices(Matrix matrix1, Matrix matrix2) {
        if(matrix1 == null || matrix2 == null){
            throw new MatrixException("Matrix is null");
        }
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getCols() != matrix2.getCols()) {
            throw new MatrixException("length of the matrices aren't equal");
        }
    }
}
