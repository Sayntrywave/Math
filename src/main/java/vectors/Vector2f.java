package vectors;

import matrix.MatrixException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Vector2f{
    final float X;
    final float Y;

    public Vector2f(float x, float y) {
        X = x;
        Y = y;
    }



    public Vector2f subtract(Vector2f v2) {
        return new Vector2f(v2.X - X, v2.Y - Y);
    }

    public Vector2f add(Vector2f v2) {
        return new Vector2f(v2.X + X, v2.Y + Y);
    }

    public Vector2f multiply(float c) {
        return new Vector2f(X * c, Y * c);
    }

    public Vector2f multiply(Vector2f v2) {
        return new Vector2f(X * v2.X, Y * v2.Y);
    }

    //todo:except dividing by zero
    public Vector2f divide(float c) {
        if(c == 0){
            throw new MatrixException("try to divide by zero",new ArithmeticException());
        }
        return new Vector2f(X / c, Y / c);
    }

    public float getLength() {
        return (float) Math.sqrt(X * X + Y * Y);
    }
    //todo:except dividing by zero

    public Vector2f normalize() {
        return this.divide(getLength());
    }

/*    public double crossProduct(Vector2f v2){
        return X* v2.Y - Y* v2.X;
    }*/

    public double dotProduct(Vector2f v2) {
        return v2.X * X + Y * v2.Y;
    }


    public static void main(String[] args) {
        Vector2f v2 = new Vector2f(1,2);
        List list = new ArrayList(Arrays.asList(9, 2, 3, 4));
        Vector2f v21 = new Vector2f(2 ,3);
        System.out.println(v2.divide(0));

    }
}
