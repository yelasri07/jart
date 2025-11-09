package geometrical_shapes;

import java.awt.Color;

public class Rectangle implements Drawable {
    Point point1, point2;
    Color color ;
    public Rectangle(Point p1, Point p2){
        this.point1 = p1;
        this.point2 = p2;
        this.color = this.getColor();
    }

    public void draw(Displayable displayable) {
        int xMin = Math.min(this.point1.getX(), this.point2.getX());
        int xMax = Math.max(this.point1.getX(), this.point2.getX());
        int yMin = Math.min(this.point1.getY(), this.point2.getY());
        int yMax = Math.max(this.point1.getY(), this.point2.getX());
    
        Line l1 = new Line(new Point(xMin, yMin), new Point(xMin, yMax), this.color);
        Line l2 = new Line(new Point(xMin, yMin), new Point(xMax, yMin), this.color);
        Line l3 = new Line(new Point(xMax, yMax), new Point(xMin, yMax), this.color);
        Line l4 = new Line(new Point(xMax, yMax), new Point(xMax, yMin), this.color);
        l1.draw(displayable);
        l2.draw(displayable);
        l3.draw(displayable);
        l4.draw(displayable);
    }
}