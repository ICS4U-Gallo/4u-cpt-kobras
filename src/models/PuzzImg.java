package models;

import java.awt.image.BufferedImage;

public class PuzzImg extends ImgObj {
    public int rot;
    public PuzzImg(int id, int x, int y, int width, int height, BufferedImage img, int rot) {
        super(id, x, y, width, height, img);
        this.rot = rot;
    }

}
