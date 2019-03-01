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
            byte[] pixels = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();
            {
                /*
                int i = 0;
                for (byte b : pixels) {
                    pixels[i++] = (byte) (b | 0x3);
                }
                */

                for(int i = 3*1280+1; i < 3*1280+1+100; i++){
                    pixels[i] = (byte)0xFF;
                }

                System.out.println(pixels.length);
            }

            for(int i = 0; i < pixels.length; i++) {
                bi.getRaster().getDataBuffer().setElem(i, pixels[i]);
            }

            ImageIO.write(bi, "jpg", Files.newOutputStream(Paths.get("test.jpg")));




        } catch(IOException e){
            System.err.println(e);
        }
    }
}
