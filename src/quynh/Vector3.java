////////////////////////////////////////////////////////////////////////////////
// Vector3.java
// =============
// Vector3 class: Define 3D Vector
//
// AUTHOR: Quynh Dinh
// CREATED: 19/2/2018
// UPDATED: 23/2/2018
////////////////////////////////////////////////////////////////////////////////
package quynh;

public class Vector3 {

    public float x;
    public float y;
    public float z;

    // Define 2 constructors
    public Vector3() {
        set(0, 0, 0);
    }

    public Vector3(float x, float y, float z) {
        set(x, y, z);
    }

    // Define 2 set methods
    public void set(float x, float y, float z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    // Print the information about the current vector
    public String toString() {
        return String.format("Vector3(%.1f, %.1f, %.1f)", this.x, this.y, this.z);
    }

    // Define a clone method to copy the current vector
    public Vector3 clone() {
        Vector3 vector = new Vector3(this.x, this.y, this.z);
        return vector;
    }

    // Add 2 vectors and return the result to the current vector
    public Vector3 add(Vector3 rhs) {
        this.x += rhs.x;
        this.y += rhs.y;
        this.z += rhs.z;
        return this;
    }

    // Subtract 2 vectors and return the result to the current vector
    public Vector3 subtract(Vector3 rhs) {
        this.x -= rhs.x;
        this.y -= rhs.y;
        this.z -= rhs.z;
        return this;
    }

    // Calculate cross product of 2 vectors
    public Vector3 cross(Vector3 rhs) {
        float x = this.y * rhs.z - this.z * rhs.y;
        float y = this.z * rhs.x - this.x * rhs.z;
        float z = this.x * rhs.y - this.y * rhs.x;
        Vector3 crossVector = new Vector3(x, y, z);
        return crossVector;
    }

    // Multiply a scalar to the vector
    // And return the result to the current vector
    public Vector3 scale(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
        return this;
    }
    
    // Calculate inner product and to return the result 
    public float dot(Vector3 rhs) {
        return this.x * rhs.x + this.y * rhs.y + this.z * rhs.z;
    }

    // Calculate the length of the vector and to return the result 
    public float getLength() {
        float length = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2) + Math.pow(z, 2));
        return length;
    }

    // Make the vector with unit length and to return the result
    public Vector3 normalize() {
        float normalizeX = this.x / getLength();
        float normalizeY = this.y / getLength();
        float normalizeZ = this.z / getLength();

        return new Vector3(normalizeX, normalizeY, normalizeZ);
    }
}
