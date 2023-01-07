package vectors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static matrix.MatrixUtils.multiplyToDouble;
import static matrix.MatrixUtils.sumToDouble;

public class Vector3<T extends Number> extends FixedSizeVector<T> {
    public Vector3(List<T> matrix) {
        super(matrix, matrix.size());
    }
    public Vector3(T x, T y, T z){
        super(new ArrayList<>(Arrays.asList(x,y,z)),3);
    }
    public Vector3(T value) {
        super(3, value);
    }

    public T getX(){
        return values.get(0);
    }
    public T getY(){
        return values.get(1);
    }
    public T getZ(){
        return values.get(2);
    }

    public static<T extends Number> Vector3<T> cross(Vector3<T> v1, Vector3<T> v2){
        T x = (T) sumToDouble(
                multiplyToDouble(v1.getY(),v2.getZ()),
                -multiplyToDouble(v1.getZ(),v2.getY())
        );
        T y = (T) sumToDouble(
                -multiplyToDouble(v1.getX(),v2.getZ()),
                multiplyToDouble(v1.getZ(),v2.getX())
        );
        T z = (T) sumToDouble(
                multiplyToDouble(v1.getX(),v2.getY()),
                -multiplyToDouble(v1.getY(),v2.getX())
        );
        return new Vector3<>(x,y,z);
    }

    public Vector3<T> cross(Vector3<T> v2){
        return cross(this,v2);
    }


}
