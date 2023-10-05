package Chameleon;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Scanner;
import javax.imageio.ImageIO;






public class Exam {
    private static BufferedImage img;
    private static int width;
    private static int height;



    private static void image(String imgName) {
        try {
            img = ImageIO.read(new File(imgName));
            width = img.getWidth();
            height = img.getHeight();
            System.out.println("Image loaded successfully.");
            System.out.println("Height: " + height);
            System.out.println("Width: " + width);
        } catch (IOException e) {
            System.out.println("Error");
        }
    }


    static void Horizontal(){

        //Displaying in Horizontal Flip

        BufferedImage horizontalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int color = img.getRGB(j, i);
                horizontalImg.setRGB(width - j - 1, i, color);
            }
        }

        File horizontalfile = new File("1horizontal_pic.jpg");

        try {
            ImageIO.write(horizontalImg, "jpg", horizontalfile);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    static void Vertical(){

        BufferedImage verticalImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = height - 1; i >= 0; i--){
            for(int j = 0; j < width; j++){
                int color = img.getRGB(j, i);
                verticalImg.setRGB(j, height - i - 1, color);
            }
        }

        File verticalfile = new File("2vertical_pic.jpg");

        try {
            ImageIO.write(verticalImg, "jpg", verticalfile);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    static void Segmented(){

        // first segment of pic
        BufferedImage firstseg = new BufferedImage(width / 2 , height /2, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height / 2; i++){
            for (int j = 0; j < width / 2; j++){
                int color = img.getRGB(j, i);
                firstseg.setRGB(j, i, color);
            }
        }



        File firstsegment = new File("4firstsegment.jpg");

        try{
            ImageIO.write(firstseg, "jpg", firstsegment);
            System.out.println("saved");
        }catch (IOException e){
            System.out.println("Error: " + e);
        }

        // second segment of pic
        BufferedImage secondseg = new BufferedImage(width / 2 , height /2, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height / 2; i++){
            for (int j = 0; j < width / 2; j++){
                int color = img.getRGB(j + width / 2, i);
                secondseg.setRGB(j, i, color);
            }
        }


        File secondsegment = new File("5secondsegment.jpg");

        try{
            ImageIO.write(secondseg, "jpg", secondsegment);
            System.out.println("saved");
        }catch (IOException e){
            System.out.println("Error: " + e);
        }

        // third segment of pic
        BufferedImage thirdseg = new BufferedImage(width / 2 , height /2, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height / 2; i++){
            for (int j = 0; j < width / 2; j++){
                int color = img.getRGB(j, i + height / 2);
                thirdseg.setRGB(j, i, color);
            }
        }

        File thirdsegment = new File("3thirdsegment.jpg");

        try{
            ImageIO.write(thirdseg, "jpg", thirdsegment);
            System.out.println("saved");
        }catch (IOException e){
            System.out.println("Error: " + e);
        }


        // fourth segment of pic
        BufferedImage fourthseg = new BufferedImage(width / 2 , height /2, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height / 2; i++){
            for (int j = 0; j < width / 2; j++){
                int color = img.getRGB(j + width / 2, i + height / 2);
                fourthseg.setRGB(j, i, color);
            }
        }

        File fourthsegment = new File("6fourthsegment.jpg");

        try{
            ImageIO.write(fourthseg, "jpg", fourthsegment);
            System.out.println("saved");
        }catch (IOException e){
            System.out.println("Error: " + e);
        }
    }


    private static int getRed(int pixel) {
        return (pixel &(255 << 16));
    }

    static void RedClr(){
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
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }
    private static int getBlue(int pixel) {
        return (pixel & 255);
    }
    static void BlueClr(){
        BufferedImage blueImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int blueChannel_of_lastPixel = getBlue(current_Pixel);
                blueImg.setRGB(j, i, blueChannel_of_lastPixel);
            }
        }
        File blueImage = new File("blue_pic.jpg");
        try {
            ImageIO.write(blueImg, "jpg", blueImage);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    private static int getGreen(int pixel) {
        return (pixel& (255 << 8));
    }


    static void GreenClr(){

        BufferedImage greenImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int greenChannel_of_lastPixel = getGreen(current_Pixel);
                greenImg.setRGB(j, i, greenChannel_of_lastPixel);
            }
        }
        File greenImage = new File("green_pic.jpg");
        try {
            ImageIO.write(greenImg, "jpg", greenImage);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
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



    static void Average(){


        BufferedImage ave_output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int redChannel_of_lastPixel = Red_gs(current_Pixel);
                int greenChannel_of_lastPixel = Green_gs(current_Pixel);
                int blueChannel_of_lastPixel = Blue_gs(current_Pixel);
                int average = (redChannel_of_lastPixel + greenChannel_of_lastPixel + blueChannel_of_lastPixel)/3;
                ave_output.setRGB(j, i, average <<16 | average<<8 | average);
            }
        }
        File ave = new File("average.jpg");

        try {
            ImageIO.write(ave_output, "jpg",ave);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }


    static void Luminosity(){

        BufferedImage lum_output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);


        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int redChannel_of_lastPixel = Red_gs(current_Pixel);
                int greenChannel_of_lastPixel = Green_gs(current_Pixel);
                int blueChannel_of_lastPixel = Blue_gs(current_Pixel);
                int luminosity = (int) (0.21 * redChannel_of_lastPixel + 0.72 * greenChannel_of_lastPixel + 0.07 * blueChannel_of_lastPixel);
                lum_output.setRGB(j, i, luminosity <<16 | luminosity<<8 | luminosity);
            }
        }
        File lum = new File("luminosity.jpg");

        try {
            ImageIO.write(lum_output, "jpg",lum);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }

    }

    static void Lightness(){

        BufferedImage light_output = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int redChannel_of_lastPixel = Red_gs(current_Pixel);
                int greenChannel_of_lastPixel = Green_gs(current_Pixel);
                int blueChannel_of_lastPixel = Blue_gs(current_Pixel);
                int lightness = (int) ((Math.max(Math.max(redChannel_of_lastPixel,greenChannel_of_lastPixel),blueChannel_of_lastPixel))+(Math.min(Math.min(redChannel_of_lastPixel,greenChannel_of_lastPixel),blueChannel_of_lastPixel)))/2;
                light_output.setRGB(j, i, lightness <<16 | lightness<<8 | lightness);
            }
        }
        File light = new File("lightness.jpg");

        try {
            ImageIO.write(light_output, "jpg",light);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }


    }


    static void Negative_GS(){

        BufferedImage grayscale_invert = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int redChannel_of_lastPixel = 255 - Red_gs(current_Pixel);
                int greenChannel_of_lastPixel = 255 -Green_gs(current_Pixel);
                int blueChannel_of_lastPixel = 255 -Blue_gs(current_Pixel);
                int average = (redChannel_of_lastPixel + greenChannel_of_lastPixel + blueChannel_of_lastPixel)/3;

                grayscale_invert.setRGB(j, i, average << 16 | average << 8 | average);
            }
        }
        File invert_gray = new File("inverted_grayscale.jpg");

        try {
            ImageIO.write(grayscale_invert, "jpg",invert_gray);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    }

    static void Negative_Color(){

        BufferedImage color_invert = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < height; i++){
            for(int j = width - 1; j >= 0; j--){
                int current_Pixel = img.getRGB(j, i);
                int redChannel_of_lastPixel = 255 - Red_gs(current_Pixel);
                int greenChannel_of_lastPixel = 255 - Green_gs(current_Pixel);
                int blueChannel_of_lastPixel = 255 - Blue_gs(current_Pixel);
                color_invert.setRGB(j, i, (redChannel_of_lastPixel << 16) | (greenChannel_of_lastPixel << 8) | blueChannel_of_lastPixel);
            }
        }
        File invert_color = new File("inverted_color.jpg");

        try {
            ImageIO.write(color_invert, "jpg",invert_color);
            System.out.println("saved");
        } catch (IOException e) {
            System.out.println("Error: " + e);
        }


    }








    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter image name:");
        String imageName = sc.nextLine();

        image(imageName);



        int option;

        while (true) {
            System.out.println("1. Fundamentals\n 2. Color Filter\n 3. Grayscale\n 4. Negative \n 5. Choose Another Image\n 6. End");
            System.out.println("Choose option:");
            option = sc.nextInt();

            switch (option) {
                case 1:
                    int option1;
                    System.out.println("\n1. Horizontal Flip\n 2. Vertical Flip\n 3. Segmented \n 4. Back");
                    System.out.println("Choose option:");
                    option1 = sc.nextInt();


                    switch (option1) {
                        case 1:
                            Horizontal();
                            break;
                        case 2:
                            Vertical();
                            break;
                        case 3:
                            Segmented();
                            break;
                        case 4:
                            break;

                    }
                    break;



                case 2:
                    int option2;
                    System.out.println("\n1. Red Color\n 2. Blue Color\n 3. Green Color \n 4. Back");
                    System.out.println("Choose option:");
                    option2 = sc.nextInt();


                    switch (option2){
                        case 1:
                            RedClr();
                            break;
                        case 2:
                            BlueClr();
                            break;
                        case 3:
                            GreenClr();
                            break;
                        case 4:
                            break;
                    }

                    break;

                case 3:
                    int option3;
                    System.out.println("\n1. Average Method\n 2.Luminosity Method\n 3. Lightness Method \n 4. Back");
                    System.out.println("Choose option:");
                    option3 = sc.nextInt();


                    switch (option3){
                        case 1:
                            Average();
                            break;
                        case 2:
                            Luminosity();
                            break;
                        case 3:
                            Lightness();
                            break;
                        case 4:
                            break;
                    }

                    break;

                case 4:
                    int option4;
                    System.out.println("\n1. Negative GrayScale\n 2. Negative Color\n 3. Back ");
                    System.out.println("Choose option:");
                    option4 = sc.nextInt();


                    switch (option4){
                        case 1:
                            Negative_GS();
                            break;
                        case 2:
                            Negative_Color();
                            break;
                        case 3:
                            break;
                    }

                    break;



                case 5:
                    Scanner imgScanner = new Scanner(System.in);
                    System.out.println("Enter image name:");
                    String imgName = imgScanner.nextLine();
                    image(imgName);
                    break;


                case 6:

                    return;

            }

        }
    }

}

