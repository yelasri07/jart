package geometrical_shapes;

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

    public void draw(Displayable displayable) {
        displayable.display(this.x, this.y, this.getColor());
    }
}
