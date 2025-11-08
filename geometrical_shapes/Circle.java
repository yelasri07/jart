package geometrical_shapes;

import java.awt.Color;

public class Circle implements Drawable {
    public double r;
    public Point center;

    public Circle(Point center, double r) {
        this.r = r;
        this.center = center;
    }

    public static Circle random(int width, int height) {
        // int pointX = (int)(Math.random() * (width - 50) + 20);
        // int pointY = (int)(Math.random() * (height - 50) + 20);
        // float radius = (float)(Math.random() * (Math.min(pointX, pointY) - 50) + 20);
        Point center = new Point(300, 300);
        return new Circle(center, 60);
    }

    public double getR() {
        return this.r;
    }

    public Point getCenter() {
        return this.center;
    }

    public void draw(Displayable displayable) {
        double c = 2.0 * Math.PI * this.r ;
        double inc = 360.0 / c;
        double i = 0.0;
        Color color = this.getColor();
        while (i <= 360.0) {
            double angle = Math.toRadians(i);
            int x = (int)(Math.round(this.center.getX()+ this.r * Math.cos(angle))); 
            int y = (int)(Math.round(this.center.getY()+ this.r * Math.sin(angle))); 

            displayable.display(x, y, color);
            i += inc;
        }
    }
}