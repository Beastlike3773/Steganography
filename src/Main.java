import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {


    public static void main(String[] args){
        try{
            BufferedImage bi = ImageIO.read(Files.newInputStream(Paths.get("halo_007.jpg")));

            Picture p = new Picture(bi);
            p.writePicture("test.jpg");





        } catch(IOException e){
            System.err.println(e);
        }
    }
}
