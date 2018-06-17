package models;

import java.awt.image.BufferedImage;

public class ImgObj {
    public int id;
    public int x;
    public int y;
    public int height;
    public int width;
    public BufferedImage img;

    public ImgObj(int id, int x, int y, int width, int height, BufferedImage img) {
        this.id = id;
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.img = img;
    }
}
