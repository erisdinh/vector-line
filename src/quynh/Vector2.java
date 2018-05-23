////////////////////////////////////////////////////////////////////////////////
// Vector2.java
// =============
// Vector2 class: Define 2D Vector
//
// AUTHOR: Quynh Dinh
// CREATED: 5/2/2018
// UPDATED: 9/2/2018
////////////////////////////////////////////////////////////////////////////////
package quynh;

public class Vector2 {

    public float x;
    public float y;

    // Define 2 constructors
    public Vector2() {
        set(0, 0);
    }

    public Vector2(float x, float y) {
        set(x, y);
    }

    // Define 2 set methods
    public void set(float x, float y) {
        this.x = x;
        this.y = y;

    }

    public void set(Vector2 v) {
        set(v.x, v.y);
    }

    // Print the information about the current vector
    public String toString() {
        return String.format("Vector2(%.1f, %.1f)", this.x, this.y);
    }

    // Define a clone method to copy the current vector
    public Vector2 clone() {
        Vector2 vector = new Vector2(this.x, this.y);
        return vector;
    }

    // Add 2 vectors and return the result to the current vector
    public Vector2 add(Vector2 rhs) {
        this.x += rhs.x;
        this.y += rhs.y;
        return this;
    }

    // Subtract 2 vectors and return the result to the current vector
    public Vector2 subtract(Vector2 rhs) {
        this.x -= rhs.x;
        this.y -= rhs.y;
        return this;
    }

    // Multiply a scalar to the vector
    // And return the result to the current vector
    public Vector2 scale(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }

    // Calculate inner product and to return the result 
    public float dot(Vector2 rhs) {
        return this.x * rhs.x + this.y * rhs.y;
    }

    // Calculate the length of the vector and to return the result 
    public float getLength() {
        float length = (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
        return length;
    }

    // Make the vector with unit length and to return the result
    public Vector2 normalize() {
        float normalizeX = this.x / getLength();
        float normalizeY = this.y / getLength();

        return new Vector2(normalizeX, normalizeY);
    }
}
