package geometrical_shapes;

import java.awt.Color;

public class Triangle implements Drawable {
    Point p1, p2, p3;
    Color color;

    public Triangle(Point p1, Point p2, Point p3) {
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.color = this.getColor();
    }

    public void draw(Displayable displayable) {
        Line l1 = new Line(p1, p2, this.color);
        Line l2 = new Line(p2, p3, this.color);
        Line l3 = new Line(p3, p1, this.color);

        l1.draw(displayable);
        l2.draw(displayable);
        l3.draw(displayable);
    }
}
