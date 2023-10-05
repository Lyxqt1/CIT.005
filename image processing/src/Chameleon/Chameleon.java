package Chameleon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Chameleon {
    public static void main(String[] args) {
        BufferedImage originalImage = null;
        // Need to change directory depends on the project structure
        String image = "src/chameleon.jpg";
        try {
            originalImage = ImageIO.read(new File(image));
            System.out.println("read");
        } catch (IOException e) {
            System.out.println("File not found");
        }
        int width = originalImage.getWidth();
        int height = originalImage.getHeight();
        int halfWidth = width / 2;
        int halfHeight = height / 2;

        // Horizontal Flip
        BufferedImage horizontalFlipImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                horizontalFlipImage.setRGB(x, y, originalImage.getRGB(width - x - 1, y));
            }
        }
        try {
            ImageIO.write(horizontalFlipImage, "jpg", new File("horizontal_flip.jpg"));
        } catch (IOException e) {
            System.out.println("File not found");
        }

        // Vertical Flip
        BufferedImage verticalFlipImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                verticalFlipImage.setRGB(x, y, originalImage.getRGB(x, height - y - 1));
            }
        }
        try {
            ImageIO.write(verticalFlipImage, "jpg", new File("vertical_flip.jpg"));
        } catch (IOException e) {
            System.out.println("File not found");
        }

        // Four-Segment Images
        BufferedImage topLeft = originalImage.getSubimage(0, 0, halfWidth, halfHeight);
        BufferedImage topRight = originalImage.getSubimage(halfWidth, 0, halfWidth, halfHeight);
        BufferedImage bottomLeft = originalImage.getSubimage(0, halfHeight, halfWidth, halfHeight);
        BufferedImage bottomRight = originalImage.getSubimage(halfWidth, halfHeight, halfWidth, halfHeight);

        try {
            ImageIO.write(topLeft, "jpg", new File("top_left.jpg"));
        } catch (IOException e) {
            System.out.println("File not found");
        }

        try {
            ImageIO.write(topRight, "jpg", new File("top_right.jpg"));
        } catch (IOException e) {
            System.out.println("File not found");
        }

        try {
            ImageIO.write(bottomLeft, "jpg", new File("bottom_left.jpg"));
        } catch (IOException e) {
            System.out.println("File not found");
        }

        try {
            ImageIO.write(bottomRight, "jpg", new File("bottom_right.jpg"));
        } catch (IOException e) {
            System.out.println("File not found");
        }

        System.out.println("Image transformations completed.");
    }
}
