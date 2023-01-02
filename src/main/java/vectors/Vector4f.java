package vectors;

public class Vector4f {
    final float X;
    final float Y;
    final float Z;
    final float W;

    public Vector4f(float x, float y, float z, float w) {
        X = x;
        Y = y;
        Z = z;
        W = w;
    }

    public Vector4f subtract(Vector4f v4) {
        return new Vector4f(v4.X - X, v4.Y - Y,v4.Z - Z, v4.W-W);
    }

    public Vector4f add(Vector4f v4) {
        return new Vector4f(v4.X + X, v4.Y + Y,v4.Z + Z, v4.W+W);
    }

    public Vector4f multiply(float c) {
        return new Vector4f(X * c, Y * c,Z*c,W*c);
    }

    public Vector4f multiply(Vector4f v4) {
        return new Vector4f(X * v4.X, Y * v4.Y,Z* v4.Z,W* v4.W);
    }
    //todo:except dividing by zero

    public Vector4f divide(float c) {
        return new Vector4f(X / c, Y / c, Z/c,W/c);
    }

    public float getLength() {
        return (float) Math.sqrt(X * X + Y * Y + Z*Z+W*W);
    }
    //todo:except dividing by zero

    public Vector4f normalize() {
        return this.divide(getLength());
    }

    public double dotProduct(Vector4f v4) {
        return v4.X * X + Y * v4.Y + Z*v4.Z + W* v4.W;
    }


}
