package models.puzzleModels;

import helpers.Drawer;
import helpers.Mouse;
import models.Dialogue;
import models.ImgObj;

import java.awt.*;
import java.io.IOException;

/*
PORTIAAAA
change of plans
so no extra class cuz its useless
to rotate
you have an int array that you keep ttrack of whatever
to change it look under handle input
 */
public class WirePuzzle extends Puzzle {
    ImgObj[] imgObjs = new ImgObj[12];
    // see wireList.txt
    // the numbers in the bottom right of each picture equals index + 1

    int[] rot = {1, 0, 3, 2, 2, 1, 0, 0, 2, 2, 3, 0};
    boolean[] correct = {false, true, false, false, false, false, true, true, false, false, false, true};
    boolean quit = false;

    public WirePuzzle(Dialogue d) throws IOException {

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.drawString("Find a path for the wires to connect from start to end", 50, 50);
        for(int i = 0; i < imgObjs.length; i++) {
            Drawer.draw(g,imgObjs[i]);
        }
    }

    @Override
    public boolean passed() {
        for (int i = 0; i < rot.length; i++){
            if ((rot[i] % 4) != 0) {
                correct[i] = false;
            }
        }

        // for the two straight pipes
        if (rot[0]%2 == 0)
             correct[0] = true;
        if (rot[5]%2 == 0)
            correct[5] = true;

        for (int i = 0; i < correct.length; i++){
            if (!correct[i]){
                return false;
            }
        }

        return true;
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
                    g2.rotate(Math.toRadians(90));
                    rot[i]++;
                    // these must always be correct (the unused pipes)
                    rot[6] = 0;
                    rot[11] = 0;
                }
            }
        }
    }

    @Override
    public boolean isCompleted() {
        return passed();
    }

}
