package geometrical_shapes;

import java.awt.Color;

public class Circle implements Drawable {
    Point center;
    int radius;
    Color color;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = this.getColor();
    }

    public static Circle random(int width, int height) {
        Point center = Point.random(width, height);
        int radius = (int) Math.round(Math.random() * ((width > height ? width : height) / 2 ));
        return new Circle(center, radius);
    }

    // Bresenham algorithm
    public void draw(Displayable displayable) {
        int d = 3 - (2 * this.radius);
        int x = 0;
        int y = this.radius;

        this.setPoints(x, y, displayable);

        while (x <= y) {
            if (d < 0) {
                d = d + (4 * x) + 6;
            } else {
                d = d + 4 * (x - y) + 10;
                y--;
            }

            x++;
            this.setPoints(x, y, displayable);
        }
    }

    private void setPoints(int x, int y, Displayable displayable) {
        int xc = this.center.getX(), yc = this.center.getY();
        displayable.display(xc + x, yc + y, this.color);
        displayable.display(xc - x, yc + y, this.color);
        displayable.display(xc + x, yc - y, this.color);
        displayable.display(xc - x, yc - y, this.color);
        displayable.display(xc + y, yc + x, this.color);
        displayable.display(xc - y, yc + x, this.color);
        displayable.display(xc + y, yc - x, this.color);
        displayable.display(xc - y, yc - x, this.color);
    }
}