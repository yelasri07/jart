package geometrical_shapes;

public class Pentagon implements Drawable {
    private final Point center;
    private final int radius;
    private final double rotation;

    public Pentagon(Point center, int radius) {
        this(center, radius, 0.0);
    }

    public Pentagon(Point center, int radius, double rotation) {
        this.center = center;
        this.radius = radius;
        this.rotation = rotation;
    }

    @Override
    public void draw(Displayable d) {
        var color = getColor();
        int n = 5;
        int[] xs = new int[n];
        int[] ys = new int[n];
        double start = -Math.PI / 2.0 + rotation;

        for (int i = 0; i < n; i++) {
            double a = start + i * (2.0 * Math.PI / n);
            xs[i] = center.getX() + (int)Math.round(radius * Math.cos(a));
            ys[i] = center.getY() + (int)Math.round(radius * Math.sin(a));
        }
        for (int i = 0; i < n; i++) {
            int j = (i + 1) % n;
            drawLine(d, xs[i], ys[i], xs[j], ys[j], color);
        }
    }

    private static void drawLine(Displayable d, int x0, int y0, int x1, int y1, java.awt.Color c) {
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
