package helpers;

import models.ImgObj;

import java.awt.*;

public class Drawer {
    public static void draw(Graphics2D g, ImgObj obj) {
        // g.drawImage(obj.img,obj.x ,obj.y ,obj.width,obj.height, null );
        g.drawImage(obj.img,obj.x  ,obj.y,obj.width, obj.height, null );

    }
}
