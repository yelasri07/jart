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
    
    int margin = 10; 
    
    int minCenterX = margin;
    int maxCenterX = width - margin;
    int minCenterY = margin;
    int maxCenterY = height - margin;

    int pointX = (int)(Math.random() * (maxCenterX - minCenterX) + minCenterX);
    int pointY = (int)(Math.random() * (maxCenterY - minCenterY) + minCenterY);
    
    int maxRadiusLeft = pointX - margin;
    int maxRadiusRight = (width - margin) - pointX;
    int maxRadiusTop = pointY - margin;
    int maxRadiusBottom = (height - margin) - pointY;
    
    int maxPossibleRadius = Math.min(
        Math.min(maxRadiusLeft, maxRadiusRight),
        Math.min(maxRadiusTop, maxRadiusBottom)
    );
    
    int minRadius = 10;
    if (maxPossibleRadius < minRadius) {
        maxPossibleRadius = minRadius;
    }
    
    float radius = (float)(Math.random() * (maxPossibleRadius - minRadius) + minRadius);
    
    Point center = new Point(pointX, pointY);
    return new Circle(center, radius);
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