package vectors;

import matrix.Matrix;

import java.util.ArrayList;
import java.util.List;

import static matrix.MatrixUtils.multiplyToDouble;

public class Vector<T extends Number> extends Matrix<T> {

    public Vector(List<T> matrix) {
        super(matrix, 1, matrix.size());
    }

    public Vector(T[] matrix) {
        super(matrix, 1, matrix.length);
    }

    public Vector(int size, T value) {
        super(1, size, value);
    }

    public int size(){
        return values.size();
    }
    public static<T extends Number> double length(Vector<T> vec) {
        double temp = 0;
        for(int i = 0; i < vec.size(); i++) {
            temp += Math.pow(vec.values.get(i).doubleValue(), 2);
        }
        return Math.sqrt(temp);
    }

    public static<T extends Number> Vector<T> normalize(Vector<T> vec) {
        List<T> values = new ArrayList<>();
        double length = length(vec);
        if(Double.compare(length,0.0) ==0){
            return new Vector<T>(vec.size(),(T) Integer.valueOf(0));
        }
        for(int i = 0; i < vec.size(); i++) {
            values.add((T) Double.valueOf(vec.values.get(i).doubleValue()/length));
        }
        return new Vector<T>(values);
    }

    public static<T extends Number> Vector<T> divideByScalar(Vector<T> vec, double s) {
        if (Double.compare(s,0) == 0){
            throw new VectorException("zero division error");
        }
        for (int i = 0; i < vec.size(); i++) {
            vec.values.set(i,(T) Double.valueOf(vec.values.get(i).doubleValue()/s));
        }
        return vec;
    }

    public static<T extends Number> T dot(Vector<T> vec1, Vector<T> vec2) throws VectorException {
        Double scalar = 0.0;
        if(vec1.size() == vec2.size()) {
            for (int i = 0; i < vec1.size(); i++) {
                scalar += multiplyToDouble(vec1.values.get(i), vec2.values.get(i));
            }
        } else {
            throw new VectorException("vectors of different sizes");
        }
       return (T) scalar;
    }

    public static<T extends Number> void printVector(Vector<T> vector) {
        for(T i: vector.values) {
            System.out.print(i + " ");
        }
    }
}
