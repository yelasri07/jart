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
        // Draw lines between consecutive vertices using Line
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            Line edge = new Line(
                    new Point(xs[i], ys[i]),
                    new Point(xs[j], ys[j]),
                    color);
            edge.draw(d);
        }
    }
}
