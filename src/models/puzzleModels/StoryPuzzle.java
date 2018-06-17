package models.puzzleModels;

import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import helpers.TextOutput;
import models.Dialogue;
import models.ImgObj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class StoryPuzzle extends Puzzle {

    ImgObj ch1 = Content.images.get(20);
    ImgObj ch2 = Content.images.get(21);
    ImgObj ch3 = Content.images.get(22);
    ImgObj exit = Content.images.get(-5);

    String[] choices0 = {"plum", "pear", "pineapple"};
    String[] choices1 = {"excited", "horrid", "rambunctious"};
    String[] choices2 = {"dog", "squirrel", "gargoyle"};
    String[] choices3 = {"barked", "screeched", "sneezed"};
    String[] choices4 = {"surprised", "annoyed", "in awe"};
    String[][] arr = {choices0, choices1, choices2, choices3, choices4};

    String[] words = new String[arr.length];
    int index = 0;
    boolean done = false;

    // story
    String story = "You were walking down the hallway, eating a " + words[0] + ". \nSuddenly, you saw a " +
            words[1] + " " + words[2] + " jump out in front of you! \nYou threw your " + words[0] + " at the " +
            words[2] + ", and it " + words[3] + " very " + words[1] + "ly! \nYou were " + words[4] + ", and you " +
            "hurried away, wondering about the fate of your half-eaten " + words[0] + ".";

    public StoryPuzzle(Dialogue d) throws IOException {

    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        Drawer.draw(g, ch1);
        Drawer.draw(g, ch2);
        Drawer.draw(g, ch3);
        g.drawString("Choose words to finish the story", 50, 50);
        // accessing the 2D array of choices
        for ( ; index < arr.length; ){
            g.drawString(arr[index][0], 125, 500);
            g.drawString(arr[index][1], 225, 500);
            g.drawString(arr[index][2], 325, 500);
            // wait for choice to be made before the words change
        }
        if (index == 5) {
            g.setColor(Color.WHITE);
            g.drawRect(0, 0, 610, 810);
            g.setColor(Color.BLACK);
            g.drawString(story, 50, 100);
            Drawer.draw(g, exit);
        }
    }

    @Override
    public boolean passed() {
        return done;
    }

    @Override
    public boolean failed() {
        return false;
    }

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
            index++;
        }
        if (Mouse.isClicked()) {
            if (Mouse.isCollided(exit)) {
                done = true;
            }
        }
    }

    @Override
    public boolean isCompleted() {
        return passed();
    }

}
