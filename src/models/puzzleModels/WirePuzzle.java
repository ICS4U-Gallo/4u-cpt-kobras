package models.puzzleModels;

import helpers.Drawer;
import helpers.Mouse;
import models.Dialogue;
import models.ImgObj;

import java.awt.*;
/*
PORTIAAAA
change of plans
so no extra class cuz its useless
to rotate
you have an int array that you keep ttrack of whatever
to change it look under handle input
 */
public class WirePuzzle extends Puzzle {
    ImgObj[] imgObjs = new ImgObj[16];
    int[] rots = new int[16];
    boolean quit = false;

    public WirePuzzle(Dialogue d) {

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        for(int i = 0; i < imgObjs.length; i++) {
            Drawer.draw(g,imgObjs[i]);
        }
    }

    // the pass condition which is basically a for loop of the int[] return true to pass
    @Override
    public boolean passed() {
        return false;
    }

    // dw about this ;)
    @Override
    public boolean failed() {
        return false;
    }

    // oh right
    // theres also this
    // find image of back button
    // make in img obj of it
    // do the drawer.draw thing for the back button
    // copy mouse isCollided and add the backbutton img where specified
    // then...
    @Override
    public boolean quit() {
        return false;
    }


    // this updates frequently
    @Override
    public void handleInput() {
        if(Mouse.isClicked()) {
            for(int i =0; i < imgObjs.length; i++) {
                // this part is where you set whatever you need to set
                if(Mouse.isCollided(imgObjs[i])) {
                    Graphics2D g2 =(Graphics2D) imgObjs[i].img.getGraphics();
                    // g2.rotate(Whatever);
                    //rots[i]++; sorta thing
                }
            }
            // here
        }
    }
}
