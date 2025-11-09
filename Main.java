import geometrical_shapes.*;

public class Main {
    public static void main(String[] args) {
        Image image = new Image(1000, 1000);

        Line line = Line.random(image.getWidth(), image.getHeight());
        line.draw(image);

        Rectangle rectangle = new Rectangle(new Point(320, 50), new Point(700, 200));
        rectangle.draw(image);
        Triangle triangle = new Triangle(new Point(100, 100), new Point(900, 900), new Point(100, 900));
        triangle.draw(image);

        for (int i = 0; i < 50; i++) {
            Circle circle = Circle.random(image.getWidth(), image.getHeight());
            circle.draw(image);
        }
        //***---------------***//
        //        Bonus        //
        //***---------------***//
        Pentagon p = new Pentagon(new Point(500, 300), 120);
        p.draw(image);
        ////
        Cube c1 = new Cube(new Point(600, 150), 180);
        c1.draw(image);
        ///

        image.save("image.png");
    }
}