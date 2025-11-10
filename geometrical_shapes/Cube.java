package geometrical_shapes;

import java.awt.Color;

/**
 * Represents a simple wireframe cube drawn in 2D projection.
 * The cube is composed of two offset squares connected by lines.
 * The color is obtained from Drawable.getColor(), which may change each time draw() is called.
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
    @Override
    public void draw(Displayable d) {
        Color color = getColor();

        int x = origin.getX(), y = origin.getY();
        int s = size, o = offset;

        // Front face vertices (A, B, C, D)
        Point A = new Point(x, y);
        Point B = new Point(x + s, y);
        Point C = new Point(x + s, y + s);
        Point D = new Point(x, y + s);

        // Back face vertices (A', B', C', D')
        Point A2 = new Point(A.getX() + o, A.getY() + o);
        Point B2 = new Point(B.getX() + o, B.getY() + o);
        Point C2 = new Point(C.getX() + o, C.getY() + o);
        Point D2 = new Point(D.getX() + o, D.getY() + o);

        // Helper lambda to draw a colored edge between two points
        java.util.function.BiConsumer<Point, Point> edge = (p, q) -> new Line(p, q, color).draw(d);

        // Front square
        edge.accept(A, B);
        edge.accept(B, C);
        edge.accept(C, D);
        edge.accept(D, A);

        // Back square
        edge.accept(A2, B2);
        edge.accept(B2, C2);
        edge.accept(C2, D2);
        edge.accept(D2, A2);

        // Connect front and back faces
        edge.accept(A, A2);
        edge.accept(B, B2);
        edge.accept(C, C2);
        edge.accept(D, D2);
    }
}
