package geometricalShapes;

import java.awt.Color;

public interface Drawable {
    void draw(Displayable displayable);
    default Color getColor() {
        return new Color(255, 255, 255);
    }
}