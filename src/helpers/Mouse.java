package helpers;

import models.ImgObj;

/**
 * a class that mainly stores and returns data of mouseclicks
 * it is called in GamePanel
 */
public class Mouse  {
    private static int x;
    private static int y;
    private static boolean clickState;
    private static boolean prevClickState;
    private static boolean isDragged;

    /**
     *
     * @return whether mouse has been clicked
     */
    public static boolean isClicked() {
        if(clickState && !prevClickState)
            return true;
        return false;
    }

    /**
     * returns x component of mouse when last pressed
     * @return int
     */
    public static int getX() {
        return x;
    }

    /**
     * returns y component of mouse when last pressed
     * @return int
     */
    public static int getY() {
        return y;
    }

    /**
     * a method that sets whether mouse is clicked or not
     * @param b
     */
    public static void setClickState(boolean b) {
        clickState = b;
    }

    /**
     * a method that sets the data of x,y, and isClicked
     * @param x
     * @param y
     * @param clicked
     */
    public static void click(int x, int y, boolean clicked) {
        Mouse.x = x;
        Mouse.y = y;
        clickState = clicked;
    }

    public static void setX(int x) {
        Mouse.x = x;
    }

    public static void setY(int y) {
        Mouse.y = y;
    }

    public static boolean isCollided(ImgObj obj) {
        if(Mouse.x <= obj.x + obj.width && Mouse.x>=obj.x) {
            if(Mouse.y <= obj.y + obj.height && Mouse.y >= obj.y) {
                return true;
            }
        }
        return false;
    }
    public static boolean isCollided(int x, int y, int width, int height){
        if(Mouse.x <= x + width && Mouse.x>=x) {
            if(Mouse.y <= y + height && Mouse.y >= y) {
                return true;
            }
        }
        return false;
    }

    public static boolean isDragged() {
        return isDragged;
    }

    public static void setDragged(boolean isDragged) {
        Mouse.isDragged = isDragged;
    }

    public static void update() {
        prevClickState = clickState;
    }

}
