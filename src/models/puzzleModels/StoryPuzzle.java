package models.puzzleModels;

import helpers.Drawer;
import helpers.Mouse;
import models.Dialogue;
import models.ImgObj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class StoryPuzzle extends Puzzle {

    // placeholder for the boxes
    ImgObj ch1 = new ImgObj(50, 100, 100, 50, 50, ImageIO.read(StoryPuzzle.class.getResource("/images/chbutton1.png")));
    ImgObj ch2 = new ImgObj(51, 200, 100, 50, 50, ImageIO.read(StoryPuzzle.class.getResource("/images/chbutton1.png")));
    ImgObj ch3 = new ImgObj(52, 300, 100, 50, 50, ImageIO.read(StoryPuzzle.class.getResource("/images/chbutton1.png")));

    String[] choices0 = {"plum", "pear", "pineapple"};
    String[] choices1 = {"excited", "horrid", "rambunctious"};
    String[] choices2 = {"dog", "squirrel", "gargoyle"};
    String[] choices3 = {"barked", "screeched", "sneezed"};
    String[] choices4 = {"surprised", "annoyed", "in awe"};
    String[][] arr = {choices0, choices1, choices2, choices3, choices4};

    String[] words = new String[arr.length];

    // story
    String story = "You were walking down the hallway, eating a " + words[0] + ". Suddenly, you saw a " +
            words[1] + " " + words[2] + " jump out in front of you! You threw your " + words[0] + " at the " +
            words[2] + ", and it " + words[3] + " very " + words[1] + "ly! You were " + words[4] + ", and you " +
            "hurried away, wondering about the fate of your half-eaten " + words[0] + ".";

    public StoryPuzzle(Dialogue d) throws IOException {

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        Drawer.draw(g, ch1);
        Drawer.draw(g, ch2);
        Drawer.draw(g, ch3);
        g.drawString("Choose words to finish the story", 50, 50);
        // accessing the 2D array of choices
        for (int i = 0; i < arr.length; i++){
            g.drawString(arr[i][0], 100, 100);
            g.drawString(arr[i][1], 200, 100);
            g.drawString(arr[i][2], 300, 100);
            // wait for choice to be made before the words change
        }
    }

    @Override
    public boolean passed() {
        for (int i = 0; i < words.length; i++){
            if (words[i].equals(null)){
                return false;
            }
        }
        return true;
    }

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
        for (int i = 0; i < words.length; i++) {
            if (Mouse.isClicked()) {
                if (Mouse.isCollided(ch1)) {
                    words[i] = arr[i][0];
                }
                if(Mouse.isCollided(ch2)) {
                    words[i] = arr[i][1];
                }
                if(Mouse.isCollided(ch3)) {
                    words[i] = arr[i][2];
                }
            }
        }
    }

    @Override
    public boolean isCompleted() {
        return passed();
    }

}
