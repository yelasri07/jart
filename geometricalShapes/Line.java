package geometricalShapes;

import java.awt.Color;

public class Line implements Drawable {
    Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    // DDA (Digital Differential Analyzer) algorithm
    public void draw(Displayable displayable) {
        float dx = this.p2.getX() - this.p1.getX();
        float dy = this.p2.getY() - this.p1.getY();

        float steps = Math.abs(dx) > Math.abs(dy) ? Math.abs(dx) : Math.abs(dy);

        float Xinc = dx / steps;
        float Yinc = dy / steps;

        float x = this.p1.getX();
        float y = this.p1.getY();

        Color color = this.getColor();

        for (int i = 0; i < steps; i++) {
            displayable.display(Math.round(x), Math.round(y), color);
            x += Xinc;
            y += Yinc;
        }
    }
}
