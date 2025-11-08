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
        Color color = this.getColor();
        int xMin = Math.min(this.point1.getX(), this.point2.getX());
        int xMax = Math.max(this.point1.getX(), this.point2.getX());
        int yMin = Math.min(this.point1.getY(), this.point2.getY());
        int yMax = Math.max(this.point1.getY(), this.point2.getX());
    
        Line l1 = new Line(new Point(xMin, yMin), new Point(xMin, yMax));
        Line l2 = new Line(new Point(xMin, yMin), new Point(xMax, yMin));
        Line l3 = new Line(new Point(xMax, yMax), new Point(xMin, yMax));
        Line l4 = new Line(new Point(xMax, yMax), new Point(xMax, yMin));
        drawl(displayable, l1);
        drawl(displayable, l2);
        drawl(displayable, l3);
        drawl(displayable, l4);
    }
    public void drawl(Displayable displayable, Line l) {
        float dx = l.p2.getX() - l.p1.getX();
        float dy = l.p2.getY() - l.p1.getY();

        float steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);

        float Xinc = dx / steps;
        float Yinc = dy / steps;

        float x = l.p1.getX();
        float y = l.p1.getY();

        for (int i = 0; i < steps; i++) {
            displayable.display(Math.round(x), Math.round(y), this.color);
            x += Xinc;
            y += Yinc;
        }
    }
}