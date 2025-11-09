package geometrical_shapes;

public class Pentagon implements Drawable {
    private final Point center;
    private final int radius;
    private final double rotation;

    /**
     * Represents a regular pentagon shape that can be drawn on a Displayable
     * surface.
     * The color is obtained from Drawable.getColor(), which may produce a random
     * color each time.
     */
    public Pentagon(Point center, int radius) {
        this(center, radius, 0.0);
    }

    /**
     * Creates a new Pentagon centered at the given point with the specified radius
     * and rotation.
     *
     * @param center   The center point of the pentagon.
     * @param radius   The radius (must be greater than zero).
     * @param rotation The rotation angle in radians.
     */

    public Pentagon(Point center, int radius, double rotation) {
        this.center = center;
        this.radius = radius;
        this.rotation = rotation;
    }

    /**
     * Draws the outline of the pentagon by connecting its five vertices.
     * The color used is determined by getColor(), which may change between draws.
     *
     * @param d The Displayable surface on which to draw.
     */
    public void draw(Displayable d) {
        var color = getColor();
        int n = 5;
        int[] xs = new int[n];
        int[] ys = new int[n];
        double start = -Math.PI / 2.0 + rotation;

        // Calculate coordinates of each vertex around the circle
        for (int i = 0; i < n; i++) {
            double a = start + i * (2.0 * Math.PI / n);
            xs[i] = center.getX() + (int) Math.round(radius * Math.cos(a));
            ys[i] = center.getY() + (int) Math.round(radius * Math.sin(a));
        }
        // Draw lines between consecutive vertices
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            drawLine(d, xs[i], ys[i], xs[j], ys[j], color);
        }
    }

    /**
     * Draws a line between two points using Bresenham's line algorithm.
     *
     * @param d  The Displayable surface to draw on.
     * @param x0 Starting x-coordinate.
     * @param y0 Starting y-coordinate.
     * @param x1 Ending x-coordinate.
     * @param y1 Ending y-coordinate.
     * @param c  The color of the line.
     */
    private static void drawLine(Displayable d, int x0, int y0, int x1, int y1, java.awt.Color c) {
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
