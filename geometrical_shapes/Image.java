package geometrical_shapes;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Image implements Displayable {
    private int width, height;
    private BufferedImage img;

    public Image(int width, int height) {
        this.width = width;
        this.height = height;
        this.img = new BufferedImage(this.width, this.height, BufferedImage.TYPE_INT_RGB);
    }

    public void save(String imageName) {
        try {
            ImageIO.write(this.img, "png", new File(imageName));
        } catch (IOException e) {
            System.err.println(e);
        }
    }
    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void display(int x, int y, Color color) {
        if (x > 0 && x < width && y > 0 && y < height) {
            this.img.setRGB(x, y, color.getRGB());
        }
    }
}
