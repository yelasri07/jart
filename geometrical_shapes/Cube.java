package geometrical_shapes;

public class Cube implements Drawable {
    private final Point origin;
    private final int size;
    private final int offset;

    public Cube(Point origin, int size) {
        this(origin, size, Math.max(1, size / 3));
    }

    public Cube(Point origin, int size, int offset) {
        this.origin = origin;
        this.size = size;
        this.offset = offset;
    }

    @Override
    public void draw(Displayable d) {
        var color = getColor();

        int x = origin.getX(), y = origin.getY();
        int s = size, o = offset;

        int Ax = x,     Ay = y;
        int Bx = x + s, By = y;
        int Cx = x + s, Cy = y + s;
        int Dx = x,     Dy = y + s;

        int A2x = Ax + o, A2y = Ay + o;
        int B2x = Bx + o, B2y = By + o;
        int C2x = Cx + o, C2y = Cy + o;
        int D2x = Dx + o, D2y = Dy + o;

        line(d, Ax, Ay, Bx, By, color);
        line(d, Bx, By, Cx, Cy, color);
        line(d, Cx, Cy, Dx, Dy, color);
        line(d, Dx, Dy, Ax, Ay, color);

        line(d, A2x, A2y, B2x, B2y, color);
        line(d, B2x, B2y, C2x, C2y, color);
        line(d, C2x, C2y, D2x, D2y, color);
        line(d, D2x, D2y, A2x, A2y, color);

        line(d, Ax, Ay, A2x, A2y, color);
        line(d, Bx, By, B2x, B2y, color);
        line(d, Cx, Cy, C2x, C2y, color);
        line(d, Dx, Dy, D2x, D2y, color);
    }

    private static void line(Displayable d, int x0, int y0, int x1, int y1, java.awt.Color c) {
        int dx = Math.abs(x1 - x0), dy = Math.abs(y1 - y0);
        int sx = x0 < x1 ? 1 : -1, sy = y0 < y1 ? 1 : -1;
        int err = dx - dy;
        int x = x0, y = y0;
        while (true) {
            d.display(x, y, c);
            if (x == x1 && y == y1) break;
            int e2 = 2 * err;
            if (e2 > -dy) { err -= dy; x += sx; }
            if (e2 <  dx) { err += dx; y += sy; }
        }
    }
}
