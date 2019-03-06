public class Pixel {

    private static final int WHITESUM = 650;
    private static final int BLACKSUM = 40;

    private short red;
    private short green;
    private short blue;

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    public void setRed(int red){
        this.red = (short)red;
    }

    public void setGreen(int green){
        this.green = (short)green;
    }

    public void setBlue(int blue){
        this.blue = (short)blue;
    }

    public Pixel(int red, int green, int blue){
        if(red < 0){
            red += 256;
        }if(green < 0){
            green += 256;
        }if(blue < 0){
            blue += 256;
        }
        setPixel(red, green, blue);
    }

    public void setPixel(int red, int green, int blue){
        setRed(red);
        setGreen(green);
        setBlue(blue);
    }

    public boolean isBlack(){
        return (red + green + blue) < BLACKSUM;
    }

    public int getSum(){
        return red + green + blue;
    }

    public boolean isWhite(){
        return (red + green + blue) > WHITESUM;
    }
}
