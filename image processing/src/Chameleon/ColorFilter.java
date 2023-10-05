package Chameleon;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ColorFilter {
    public static void main(String[] args) {
        try {

            BufferedImage inputImage = ImageIO.read(new File("koala.jpg"));

            BufferedImage redFilterImage = new BufferedImage(
                    inputImage.getWidth(),
                    inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            BufferedImage blueFilterImage = new BufferedImage(
                    inputImage.getWidth(),
                    inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            BufferedImage greenFilterImage = new BufferedImage(
                    inputImage.getWidth(),
                    inputImage.getHeight(),
                    BufferedImage.TYPE_INT_RGB
            );

            for (int y = 0; y < inputImage.getHeight(); y++) {
                for (int x = 0; x < inputImage.getWidth(); x++) {
                    Color pixel = new Color(inputImage.getRGB(x, y));


                    Color redFilterColor = new Color(pixel.getRed(), 0, 0);
                    redFilterImage.setRGB(x, y, redFilterColor.getRGB());


                    Color blueFilterColor = new Color(0, 0, pixel.getBlue());
                    blueFilterImage.setRGB(x, y, blueFilterColor.getRGB());

                    Color greenFilterColor = new Color(0, pixel.getGreen(), 0);
                    greenFilterImage.setRGB(x, y, greenFilterColor.getRGB());
                }
            }

            ImageIO.write(redFilterImage, "jpg", new File("koala_red_filter.jpg"));
            ImageIO.write(blueFilterImage, "jpg", new File("koala_blue_filter.jpg"));
            ImageIO.write(greenFilterImage, "jpg", new File("koala_green_filter.jpg"));

            System.out.println("Filtered images saved successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
