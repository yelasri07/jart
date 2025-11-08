package geometrical_shapes;

import java.awt.Color;

public interface Drawable {
    void draw(Displayable displayable);
    default Color getColor() {
        int a = (int) (Math.round(Math.random() * 255));
        int b = (int) (Math.round(Math.random() * 255));
        int c = (int) (Math.round(Math.random() * 255));
        return new Color(a, b, c);
    }
}