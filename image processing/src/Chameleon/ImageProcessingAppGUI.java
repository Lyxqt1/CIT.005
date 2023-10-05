package Chameleon;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageProcessingAppGUI extends JFrame {
    private JLabel imageLabel;
    private JLabel imageOut;
    private String currentImagePath;
    private int maxImageWidth = 600;
    private int maxImageHeight = 600;
    private BufferedImage img;
    private static int width;
    private static int height;

    public ImageProcessingAppGUI() {
        setTitle("Image Processing App");
        setSize(9000, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        // Create buttons for the main options
        JButton fundamentalsButton = new JButton("Fundamentals");
        JButton colorFilterButton = new JButton("Color Filter");
        JButton grayscaleButton = new JButton("Grayscale");
        JButton negativeButton = new JButton("Negative");
        JButton chooseAnotherImageButton = new JButton("Choose Image");
        JButton endButton = new JButton("End");

        // Add action listeners to the buttons
        fundamentalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showFundamentalsOptions();
            }
        });
        colorFilterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showColorFilterOptions();
            }
        });

        chooseAnotherImageButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chooseAnotherImage();
            }
        });

        // Add buttons to the panelv
        buttonPanel.add(chooseAnotherImageButton);

        buttonPanel.add(fundamentalsButton);
        buttonPanel.add(colorFilterButton);
        buttonPanel.add(grayscaleButton);
        buttonPanel.add(negativeButton);
        buttonPanel.add(endButton);

        // Create an image display label
        imageLabel = new JLabel();
        imageLabel.setPreferredSize(new Dimension(maxImageWidth, maxImageHeight));
        imageLabel.setHorizontalAlignment(JLabel.CENTER);

        imageOut = new JLabel();
        imageOut.setPreferredSize(new Dimension(maxImageWidth, maxImageHeight));
        imageOut.setHorizontalAlignment(JLabel.RIGHT);

        // Create a main content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(buttonPanel, BorderLayout.WEST);
        contentPanel.add(imageLabel, BorderLayout.CENTER);
        contentPanel.add(imageOut, BorderLayout.EAST);

        setContentPane(contentPanel);
        endButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });
    }

    private void showColorFilterOptions() {
        // Create a dialog for Fundamentals options
        JDialog fundamentalsDialog = new JDialog(this, "Fundamentals Options", true);
        fundamentalsDialog.setSize(200, 200);
        fundamentalsDialog.setLocationRelativeTo(this);

        // Create buttons for Fundamentals sub-options
        JButton redButton = new JButton("Red Color");
        JButton blueButton = new JButton("Blue Color");
        JButton greenButton = new JButton("Green Color");
        JButton backButton = new JButton("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fundamentalsDialog.dispose();
            }
        });
        // Add action listeners to the sub-option buttons
        redButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage redImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= 0; j--) {
                        int current_Pixel = img.getRGB(j, i);
                        int redChannel_of_lastPixel = getRed(current_Pixel);

                        redImg.setRGB(j, i, redChannel_of_lastPixel);
                    }
                }
                File redImage = new File("red_pic.jpg");
                try {
                    ImageIO.write(redImg, "jpg", redImage);
                    System.out.println("saved");
                    ImageIcon icon = new ImageIcon(redImg);
                    imageOut.setIcon(icon);
                    fundamentalsDialog.dispose();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        });

        blueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage blueImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= 0; j--) {
                        int current_Pixel = img.getRGB(j, i);
                        int blueChannel_of_lastPixel = getBlue(current_Pixel);
                        blueImg.setRGB(j, i, blueChannel_of_lastPixel);
                    }
                }
                File blueImage = new File("blue_pic.jpg");
                try {
                    ImageIO.write(blueImg, "jpg", blueImage);
                    System.out.println("saved");
                    ImageIcon icon = new ImageIcon(blueImg);
                    imageOut.setIcon(icon);
                    fundamentalsDialog.dispose();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        });

        greenButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage greenImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= 0; j--) {
                        int current_Pixel = img.getRGB(j, i);
                        int greenChannel_of_lastPixel = getGreen(current_Pixel);
                        greenImg.setRGB(j, i, greenChannel_of_lastPixel);
                    }
                }
                File greenImage = new File("green_pic.jpg");
                try {
                    ImageIO.write(greenImg, "jpg", greenImage);
                    System.out.println("saved");
                    ImageIcon icon = new ImageIcon(greenImg);
                    imageOut.setIcon(icon);
                    fundamentalsDialog.dispose();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
            }
        });
        // ... Implement action listeners for other sub-options ...

        // Create a panel for sub-option buttons
        JPanel subOptionPanel = new JPanel(new GridLayout(4, 1));
        subOptionPanel.add(redButton);
        subOptionPanel.add(blueButton);
        subOptionPanel.add(greenButton);
        subOptionPanel.add(backButton);

        // Add the sub-option panel to the dialog
        fundamentalsDialog.add(subOptionPanel);

        // Show the dialog
        fundamentalsDialog.setVisible(true);
    }

    private void showFundamentalsOptions() {
        // Create a dialog for Fundamentals options
        JDialog fundamentalsDialog = new JDialog(this, "Fundamentals Options", true);
        fundamentalsDialog.setSize(200, 200);
        fundamentalsDialog.setLocationRelativeTo(this);

        // Create buttons for Fundamentals sub-options
        JButton horizontalButton = new JButton("Horizontal Flip");
        JButton verticalButton = new JButton("Vertical Flip");
        JButton segmentedButton = new JButton("Segmented");
        JButton backButton = new JButton("Back");

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fundamentalsDialog.dispose();
            }
        });
        // Add action listeners to the sub-option buttons
        horizontalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement Horizontal Flip logic here

                BufferedImage horizontalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height; i++) {
                    for (int j = width - 1; j >= 0; j--) {
                        int color = img.getRGB(j, i);
                        horizontalImg.setRGB(width - j - 1, i, color);
                    }
                }

                File horizontalfile = new File("1horizontal_pic.jpg");

                try {
                    ImageIO.write(horizontalImg, "jpg", horizontalfile);
                    System.out.println("saved");
                    ImageIcon icon = new ImageIcon(horizontalImg);
                    imageOut.setIcon(icon);
                    fundamentalsDialog.dispose();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }

            }
        });
        verticalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implement Horizontal Flip logic here

                BufferedImage verticalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

                for (int i = height - 1; i >= 0; i--) {
                    for (int j = 0; j < width; j++) {
                        int color = img.getRGB(j, i);
                        verticalImg.setRGB(j, height - i - 1, color);
                    }
                }

                File verticalfile = new File("2vertical_pic.jpg");

                try {
                    ImageIO.write(verticalImg, "jpg", verticalfile);
                    System.out.println("saved");
                    ImageIcon icon = new ImageIcon(verticalImg);
                    imageOut.setIcon(icon);
                    fundamentalsDialog.dispose();
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }

            }
        });
        segmentedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedImage[] imagesArr = new BufferedImage[4];
                BufferedImage firstseg = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        int color = img.getRGB(j, i);
                        firstseg.setRGB(j, i, color);
                    }
                }

                File firstsegment = new File("4firstsegment.jpg");

                try {
                    ImageIO.write(firstseg, "jpg", firstsegment);
                    System.out.println("saved");
                    BufferedImage bufferedFirst = ImageIO.read(firstsegment);
                    imagesArr[0] = bufferedFirst;
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }

                // second segment of pic
                BufferedImage secondseg = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        int color = img.getRGB(j + width / 2, i);
                        secondseg.setRGB(j, i, color);
                    }
                }

                File secondsegment = new File("5secondsegment.jpg");

                try {
                    ImageIO.write(secondseg, "jpg", secondsegment);
                    System.out.println("saved");
                    BufferedImage bufferedSecond = ImageIO.read(secondsegment);
                    imagesArr[1] = bufferedSecond;
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }

                // third segment of pic
                BufferedImage thirdseg = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        int color = img.getRGB(j, i + height / 2);
                        thirdseg.setRGB(j, i, color);
                    }
                }

                File thirdsegment = new File("3thirdsegment.jpg");

                try {
                    ImageIO.write(thirdseg, "jpg", thirdsegment);
                    System.out.println("saved");
                    BufferedImage bufferedThird = ImageIO.read(thirdsegment);
                    imagesArr[2] = bufferedThird;
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }

                // fourth segment of pic
                BufferedImage fourthseg = new BufferedImage(width / 2, height / 2, BufferedImage.TYPE_INT_RGB);

                for (int i = 0; i < height / 2; i++) {
                    for (int j = 0; j < width / 2; j++) {
                        int color = img.getRGB(j + width / 2, i + height / 2);
                        fourthseg.setRGB(j, i, color);
                    }
                }

                File fourthsegment = new File("6fourthsegment.jpg");

                try {
                    ImageIO.write(fourthseg, "jpg", fourthsegment);
                    System.out.println("saved");
                    BufferedImage bufferedFourth = ImageIO.read(fourthsegment);
                    imagesArr[3] = bufferedFourth;
                } catch (IOException ex) {
                    System.out.println("Error: " + ex);
                }
                displaySegmentedImages(imagesArr);
                fundamentalsDialog.dispose();
            }
        });
        // ... Implement action listeners for other sub-options ...

        // Create a panel for sub-option buttons
        JPanel subOptionPanel = new JPanel(new GridLayout(4, 1));
        subOptionPanel.add(horizontalButton);
        subOptionPanel.add(verticalButton);
        subOptionPanel.add(segmentedButton);
        subOptionPanel.add(backButton);

        // Add the sub-option panel to the dialog
        fundamentalsDialog.add(subOptionPanel);

        // Show the dialog
        fundamentalsDialog.setVisible(true);
    }

    private void chooseAnotherImage() {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter imageFilter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif", "bmp");
        fileChooser.setFileFilter(imageFilter);
        int result = fileChooser.showOpenDialog(this);

        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage newimg = ImageIO.read(selectedFile);
                BufferedImage scaledImage = scaleImage(newimg, maxImageWidth, maxImageHeight); // Scale the image
                updateImage(scaledImage);
                currentImagePath = selectedFile.getAbsolutePath();
                img = scaledImage;
                width = img.getWidth();
                height = img.getHeight();
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Error loading image.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private BufferedImage scaleImage(BufferedImage image, int maxWidth, int maxHeight) {
        int originalWidth = image.getWidth();
        int originalHeight = image.getHeight();
        int newWidth = originalWidth;
        int newHeight = originalHeight;

        // Calculate the new dimensions while preserving aspect ratio
        if (originalWidth > maxWidth) {
            newWidth = maxWidth;
            newHeight = (newWidth * originalHeight) / originalWidth;
        }
        if (newHeight > maxHeight) {
            newHeight = maxHeight;
            newWidth = (newHeight * originalWidth) / originalHeight;
        }

        // Create a scaled image
        Image scaledImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
        BufferedImage bufferedImage = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        g2d.drawImage(scaledImage, 0, 0, null);
        g2d.dispose();
        return bufferedImage;
    }

    private void updateImage(BufferedImage img) {
        if (img != null) {
            ImageIcon icon = new ImageIcon(img);
            imageLabel.setIcon(icon);
            imageOut.setIcon(icon);
            pack(); // Adjust the frame size to fit the image
        }
    }

    // Inside the displaySegmentedImages method
    private void displaySegmentedImages(BufferedImage[] segmentedImages) {
        JFrame segmentedImagesFrame = new JFrame("Segmented Images");
        segmentedImagesFrame.setSize(1000, 1000);
        segmentedImagesFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel imagesPanel = new JPanel(new GridLayout(2, 2));

        // Create a custom margin or padding value (adjust as needed)
        int marginSize = 20;

        for (int i = 0; i < 4; i++) {
            // Create a JPanel for each segmented image with margin
            JPanel imageContainer = new JPanel();
            imageContainer.setLayout(new BorderLayout());
            imageContainer.setBorder(BorderFactory.createEmptyBorder(marginSize, marginSize, marginSize, marginSize));

            JLabel label = new JLabel(new ImageIcon(segmentedImages[i]));
            imageContainer.add(label, BorderLayout.CENTER);

            imagesPanel.add(imageContainer);
        }

        segmentedImagesFrame.add(imagesPanel);
        segmentedImagesFrame.setVisible(true);
    }

    private static int getRed(int pixel) {
        return (pixel & (255 << 16));
    }

    private static int getBlue(int pixel) {
        return (pixel & 255);
    }

    private static int getGreen(int pixel) {
        return (pixel & (255 << 8));
    }
    private static int Blue_gs(int pixel) {
        return (pixel & 255);
    }

    private static int Green_gs(int pixel) {
        return (pixel& (255 << 8)) >> 8;
    }

    private static int Red_gs(int pixel) {
        return (pixel &(255 << 16)) >> 16;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ImageProcessingAppGUI().setVisible(true);
            }
        });
    }
}
