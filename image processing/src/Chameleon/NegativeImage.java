package Chameleon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class NegativeImage {
    public static void main(String[] args) {
        try {
            BufferedImage inputImage = ImageIO.read(new File("koala.jpg"));

            BufferedImage grayscaleImage = new BufferedImage(
                    inputImage.getWidth(),
                    inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            BufferedImage negativeGrayscaleImage = new BufferedImage(
                    inputImage.getWidth(),
                    inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            for (int y = 0; y < inputImage.getHeight(); y++) {
                for (int x = 0; x < inputImage.getWidth(); x++) {
                    Color pixel = new Color(inputImage.getRGB(x, y));
                    int grayValue = (pixel.getRed() + pixel.getGreen() + pixel.getBlue()) / 3;
                    Color grayColor = new Color(grayValue, grayValue, grayValue);
                    grayscaleImage.setRGB(x, y, grayColor.getRGB());
                }
            }

            for (int y = 0; y < grayscaleImage.getHeight(); y++) {
                for (int x = 0; x < grayscaleImage.getWidth(); x++) {
                    Color pixel = new Color(grayscaleImage.getRGB(x, y));
                    Color negativeColor = new Color(255 - pixel.getRed(), 255 - pixel.getGreen(), 255 - pixel.getBlue());
                    negativeGrayscaleImage.setRGB(x, y, negativeColor.getRGB());
                }
            }

            BufferedImage negativeColorImage = new BufferedImage(
                    inputImage.getWidth(),
                    inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            for (int y = 0; y < inputImage.getHeight(); y++) {
                for (int x = 0; x < inputImage.getWidth(); x++) {
                    Color pixel = new Color(inputImage.getRGB(x, y));
                    Color negativeColor = new Color(255 - pixel.getRed(), 255 - pixel.getGreen(), 255 - pixel.getBlue());
                    negativeColorImage.setRGB(x, y, negativeColor.getRGB());
                }
            }

            ImageIO.write(negativeGrayscaleImage, "jpg", new File("negative_grayscale.jpg"));
            ImageIO.write(negativeColorImage, "jpg", new File("negative_color.jpg"));

            System.out.println("Negative images saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
