////////////////////////////////////////////////////////////////////////////////
// Line.java
// =============
// Line class: Define 2D Line
// 
// AUTHOR: Quynh Dinh
// CREATED: 5/2/2018
// UPDATED: 10/2/2018
////////////////////////////////////////////////////////////////////////////////
package quynh;

public class Line {

    private Vector2 point = new Vector2();
    private Vector2 direction = new Vector2();

    
    // Define 4 constructors
    public Line() {
        point.set(0, 0);
        direction.set(0, 0);
    }

    public Line(Vector2 point, Vector2 direction) {
        set(point, direction);
    }

    public Line(float slope, float intercept) {
        set(slope, intercept);
    }

    public Line(float x1, float y1, float x2, float y2) {
        set(x1, y1, x2, y2);
    }

    // Define 3 set methods
    public void set(Vector2 point, Vector2 direction) {
        setPoint(point);
        setDirection(direction);
    }

    public void set(float slope, float intercept) {
        point.set(0, intercept);
        direction.set(1, slope);
    }

    public void set(float x1, float y1, float x2, float y2) {
        point.set(x1, y1);
        direction.set(x2 - x1, y2 - y1);
    }

    // Define setter and getter methods for Point
    public void setPoint(Vector2 point) {
        this.point = point;
    }

    public Vector2 getPoint() {
        return this.point;
    }

    // Define setter and getter methods for Direction
    public void setDirection(Vector2 direction) {
        this.direction = direction;
    }

    public Vector2 getDirection() {
        return this.direction;
    }

    // Print the information about the current line
    public String toString() {
        return String.format("Line\n====\n%10s (%.1f, %.1f)\n%10s (%.1f, %.1f)",
                "Point:", this.point.x, this.point.y,
                "Direction:", this.direction.x, this.direction.y);
    }

    // Find the intersection point from 2 line segments 
    public Vector2 intersect(Line line) {
        float a = this.direction.y;
        float b = - this.direction.x;
        float c = this.direction.y * this.point.x - this.direction.x * this.point.y;

        float d = line.direction.y;
        float e = - line.direction.x;
        float f = line.direction.y * line.point.x - line.direction.x * line.point.y;

        // If 2 lines are intersected, return the intersection
        // If not, return a point with Float.NaN 
        if (isIntersected(line) == false) {
            return new Vector2(Float.NaN, Float.NaN);
        } else {
            float x = (float) ((c * e - b * f) / (a * e - b * d));
            float y = (float) ((a * f - c * d) / (a * e - b * d));

            Vector2 intersectPoint = new Vector2(x, y);

            return intersectPoint;
        }
    }
    
    // Determine whether 2 lines are intersected or not
    public boolean isIntersected(Line line) {
        float determinant = this.direction.y * (- line.direction.x) 
                - (- this.direction.x) * line.direction.y;
        
        // Check if the determinant is 0 or not 
        // the determinant = 0, there is no intersection
        return determinant != 0;
    }
}
