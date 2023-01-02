package vectors;

public class Vector3f {
    final float Z;
    final float X;
    final float Y;

    public Vector3f(float x, float y, float z) {
        X = x;
        Y = y;
        Z = z;
    }

    public Vector3f subtract(Vector3f v3) {
        return new Vector3f(v3.X - X, v3.Y - Y,v3.Z - Z);
    }

    public Vector3f add(Vector3f v3) {
        return new Vector3f(v3.X + X, v3.Y + Y,v3.Z + Z);
    }

    public Vector3f multiply(float c) {
        return new Vector3f(X * c, Y * c,Z*c);
    }

    public Vector3f multiply(Vector3f v3) {
        return new Vector3f(X * v3.X, Y * v3.Y,Z* v3.Z);
    }
    //todo:except dividing by zero

    public Vector3f divide(float c) {
        return new Vector3f(X / c, Y / c, Z/c);
    }

    public float getLength() {
        return (float) Math.sqrt(X * X + Y * Y + Z*Z);
    }
    //todo:except dividing by zero

    public Vector3f normalize() {
        return this.divide(getLength());
    }

    public Vector3f crossProduct(Vector3f v3){
        float x = Y* v3.Z - Z* v3.Y;
        float y = -(X* v3.Z - Z* v3.X);
        float z = X* v3.Y - Y* v3.X;
        return new Vector3f(x,y,z);
    }

    public double dotProduct(Vector3f v3) {
        return v3.X * X + Y * v3.Y + Z*v3.Z;
    }


}
