////////////////////////////////////////////////////////////////////////////////
// Line3D.java
// =============
// Line3D class: Define 3D Line
// 
// AUTHOR: Quynh Dinh
// CREATED: 19/2/2018
// UPDATED: 23/2/2018
////////////////////////////////////////////////////////////////////////////////
package quynh;

public class Line3D {

    private Vector3 point = new Vector3();
    private Vector3 direction = new Vector3();

    // Define 4 constructors
    public Line3D() {
        point.set(0, 0, 0);
        direction.set(0, 0, 0);
    }

    public Line3D(Vector3 point, Vector3 direction) {
        set(point, direction);
    }

    public Line3D(float x1, float y1, float z1, float x2, float y2, float z2) {
        set(x1, y1, z1, x2, y2, z2);
    }

    // Define set methods
    public void set(Vector3 point, Vector3 direction) {
        setPoint(point);
        setDirection(direction);
    }

    public void set(float x1, float y1, float z1, float x2, float y2, float z2) {
        point.set(x1, y1, z1);
        direction.set(x2 - x1, y2 - y1, z2 - z1);
    }

    // Define setter and getter methods for Point
    public void setPoint(Vector3 point) {
        this.point = point;
    }

    public Vector3 getPoint() {
        return this.point;
    }

    // Define setter and getter methods for Direction
    public void setDirection(Vector3 direction) {
        this.direction = direction;
    }

    public Vector3 getDirection() {
        return this.direction;
    }

    // Print the information about the current line
    public String toString() {
        return String.format("Line\n====\n%10s (%.1f, %.1f, %.1f)\n%10s (%.1f, %.1f, %.1f)",
                "Point:", this.point.x, this.point.y, this.point.z,
                "Direction:", this.direction.x, this.direction.y, this.direction.z);
    }

    // Find the intersection point from 2 line segments 
    public Vector3 intersect(Line3D line) {
        
        Vector3 p = this.point;
        Vector3 v = this.direction;
        Vector3 q = line.point;
        Vector3 u = line.direction;

        // Find cross product of 2 direction vectors
        Vector3 a = v.cross(u);

        // If crossVectorA is a zero vector, 2 direction vectors are parallel
        // If 2 direction vectors are parallel, there is no intersection, return NaN point
        if (a.x == 0 && a.y == 0 && a.z == 0) {
            return new Vector3(Float.NaN, Float.NaN, Float.NaN);
        }

        Vector3 qClone = q.clone();
        Vector3 b = (qClone.subtract(p)).cross(u);
        
        float t = 0;
        if (a.x != 0) {
            t = b.x/ a.x;
        } else if (a.y != 0) {
            t = b.y / a.y;
        } else if (a.z != 0) {
            t = b.z / a.z;
        }

        Vector3 vClone = v.clone();
        Vector3 pClone = p.clone();
        Vector3 intersectionPoint = pClone.add(vClone.scale(t));
        
        return intersectionPoint;

    }

    // Determine whether 2 lines are intersected or not
    public boolean isIntersected(Line3D line) {
        Vector3 v = this.direction;
        Vector3 u = line.direction;
        
        Vector3 a = v.cross(u);
        
        // If crossVectorA is a zero vector, 2 direction vectors are parallel
        // else they are intersected
        return !(a.x == 0 && a.y == 0 && a.z == 0);
    }
}
