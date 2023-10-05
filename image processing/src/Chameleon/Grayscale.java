package Chameleon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Grayscale {
    public static void main(String[] args) {
        try {

            BufferedImage inputImage = ImageIO.read(new File("koala.jpg"));

            BufferedImage outputImageLightness = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            BufferedImage outputImageLuminosity = new BufferedImage(inputImage.getWidth(), inputImage.getHeight(), BufferedImage.TYPE_INT_RGB);

            for (int y = 0; y < inputImage.getHeight(); y++) {
                for (int x = 0; x < inputImage.getWidth(); x++) {
                    Color pixel = new Color(inputImage.getRGB(x, y));
                    int grayValue = (Math.max(Math.max(pixel.getRed(), pixel.getGreen()), pixel.getBlue()) + Math.min(Math.min(pixel.getRed(), pixel.getGreen()), pixel.getBlue())) / 2;
                    Color grayColor = new Color(grayValue, grayValue, grayValue);
                    outputImageLightness.setRGB(x, y, grayColor.getRGB());
                }
            }

            for (int y = 0; y < inputImage.getHeight(); y++) {
                for (int x = 0; x < inputImage.getWidth(); x++) {
                    Color pixel = new Color(inputImage.getRGB(x, y));
                    int grayValue = (int) (0.21 * pixel.getRed() + 0.72 * pixel.getGreen() + 0.07 * pixel.getBlue());
                    Color grayColor = new Color(grayValue, grayValue, grayValue);
                    outputImageLuminosity.setRGB(x, y, grayColor.getRGB());
                }
            }

            ImageIO.write(outputImageLightness, "jpg", new File("koala_lightness.jpg"));
            ImageIO.write(outputImageLuminosity, "jpg", new File("koala_luminosity.jpg"));

            System.out.println("Grayscale images saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
