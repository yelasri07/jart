package geometricalShapes;

public class Point implements Drawable {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public static Point random(int width, int height) {
        int x = (int) Math.round(Math.random() * width);
        int y = (int) Math.round(Math.random() * height);
        return new Point(x, y);
    }

    public void draw(Displayable displayable) {
        displayable.display(this.x, this.y, this.getColor());
    }
}
