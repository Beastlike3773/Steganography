import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Picture{

    List<Pixel> pixels;
    byte[] data;
    BufferedImage bi;

    public Picture(BufferedImage bufferedImage){

        this.bi = bufferedImage;
        pixels = new ArrayList<>();
        data = ((DataBufferByte) bi.getRaster().getDataBuffer()).getData();

        for(int i = 0; i < data.length-2; i += 3) {
            Pixel p = new Pixel(data[i + 2], data[i + 1], data[i]);
            pixels.add(p);
        }

        for(Pixel p : pixels){
            if(p.isWhite()){
                p.setGreen(0xFF);
            }
        }
    }

    private void updateData(){
        int l = 0;
        for(Pixel p : pixels) {
            data[l++] = (byte)p.getBlue();
            data[l++] = (byte)p.getGreen();
            data[l++] = (byte)p.getRed();
        }
    }

    public void writePicture(String path){
        updateData();
        for(int i = 0; i < data.length; i++) {
            bi.getRaster().getDataBuffer().setElem(i, data[i]);
        }
        try {
            ImageIO.write(bi, "jpg", Files.newOutputStream(Paths.get("test.jpg")));
        }catch(IOException e){
            e.printStackTrace();
        }
    }


}
