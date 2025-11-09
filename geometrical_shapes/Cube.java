package geometrical_shapes;

/**
 * Represents a simple wireframe cube drawn in 2D projection.
 * The cube is composed of two offset squares connected by lines.
 * The color is obtained from Drawable.getColor(), which may change each time
 * draw() is called.
 */
public class Cube implements Drawable {
    private final Point origin;
    private final int size;
    private final int offset;

    /**
     * Creates a cube with a given origin and size.
     * The offset (depth effect) is automatically set to one-third of the size.
     *
     * @param origin The top-left corner of the front square.
     * @param size   The side length of the cube (must be positive).
     */
    public Cube(Point origin, int size) {
        this(origin, size, Math.max(1, size / 3));
    }

    /**
     * Creates a cube with a given origin, size, and projection offset.
     *
     * @param origin The top-left corner of the front face.
     * @param size   The side length of the cube.
     * @param offset The diagonal offset used to position the back face.
     */
    public Cube(Point origin, int size, int offset) {
        this.origin = origin;
        this.size = size;
        this.offset = offset;
    }

    /**
     * Draws a wireframe cube using simple 2D projection.
     * The cube is represented as two squares (front and back) connected by edges.
     *
     * Drawing steps:
     * 1. Compute the 8 vertices (4 for the front square, 4 for the back).
     * 2. Draw the edges of the front and back squares.
     * 3. Connect corresponding vertices between the two squares.
     *
     * @param d The Displayable surface on which the cube is drawn.
     */
    public void draw(Displayable d) {
        var color = getColor();

        int x = origin.getX(), y = origin.getY();
        int s = size, o = offset;

        // Front face (square ABCD)
        int Ax = x, Ay = y;
        int Bx = x + s, By = y;
        int Cx = x + s, Cy = y + s;
        int Dx = x, Dy = y + s;

        // Back face (square A'B'C'D'), offset diagonally
        int A2x = Ax + o, A2y = Ay + o;
        int B2x = Bx + o, B2y = By + o;
        int C2x = Cx + o, C2y = Cy + o;
        int D2x = Dx + o, D2y = Dy + o;

        // Draw front square
        line(d, Ax, Ay, Bx, By, color);
        line(d, Bx, By, Cx, Cy, color);
        line(d, Cx, Cy, Dx, Dy, color);
        line(d, Dx, Dy, Ax, Ay, color);

        // Draw back square
        line(d, A2x, A2y, B2x, B2y, color);
        line(d, B2x, B2y, C2x, C2y, color);
        line(d, C2x, C2y, D2x, D2y, color);
        line(d, D2x, D2y, A2x, A2y, color);
        
        // Connect corresponding vertices between front and back
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
            if (x == x1 && y == y1)
                break;
            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
    }
}
