package Chameleon;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class HistogramStretching {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the image path: ");
        String imagePath = scanner.nextLine();

        try {
            // Load the image from the user input
            BufferedImage image = ImageIO.read(new File(imagePath));

            // Compute the histogram
            int[] histogram = computeHistogram(image);

            // Print the histogram values
            for (int i = 0; i < histogram.length; i++) {
                System.out.println("Pixel Value " + i + ": " + histogram[i]);
            }

            // Find the maximum, minimum, and most occurring pixel values
            int maxPixelValue = findMaxPixelValue(histogram);
            int minPixelValue = findMinPixelValue(histogram);
            int mostOccurringPixelValue = findMostOccurringPixelValue(histogram);

            System.out.println("Maximum Pixel Value: " + maxPixelValue);
            System.out.println("Minimum Pixel Value: " + minPixelValue);
            System.out.println("Most Occurring Pixel Value: " + mostOccurringPixelValue);

            // Apply histogram stretching
            BufferedImage stretchedImage = stretchHistogram(image, minPixelValue, maxPixelValue);

            // Save the stretched image to a file (output with the same name as input, with "_stretched" added)
            String outputImagePath = imagePath.replace(".jpg", "_stretched.jpg");
            ImageIO.write(stretchedImage, "JPEG", new File(outputImagePath));
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static int[] computeHistogram(BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] histogram = new int[256];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int grayValue = (pixel >> 16) & 0xFF; // Assuming grayscale image
                histogram[grayValue]++;
            }
        }
        return histogram;
    }

    private static int findMaxPixelValue(int[] histogram) {
        for (int i = histogram.length - 1; i >= 0; i--) {
            if (histogram[i] > 0) {
                return i;
            }
        }
        return 0;
    }

    private static int findMinPixelValue(int[] histogram) {
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > 0) {
                return i;
            }
        }
        return 255;
    }

    private static int findMostOccurringPixelValue(int[] histogram) {
        int mostOccurringValue = 0;
        int maxOccurrences = 0;
        for (int i = 0; i < histogram.length; i++) {
            if (histogram[i] > maxOccurrences) {
                mostOccurringValue = i;
                maxOccurrences = histogram[i];
            }
        }
        return mostOccurringValue;
    }

    private static BufferedImage stretchHistogram(BufferedImage image, int min, int max) {
        int width = image.getWidth();
        int height = image.getHeight();
        BufferedImage stretchedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int pixel = image.getRGB(x, y);
                int grayValue = (pixel >> 16) & 0xFF;
                int stretchedValue = (int) (255.0 * (grayValue - min) / (max - min));
                int newPixel = (stretchedValue << 16) | (stretchedValue << 8) | stretchedValue;
                stretchedImage.setRGB(x, y, newPixel);
            }
        }

        return stretchedImage;
    }
}
