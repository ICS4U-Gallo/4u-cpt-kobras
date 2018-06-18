package models.puzzleModels;

import game.GamePanel;
import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import helpers.TextOutput;
import models.Dialogue;
import models.ImgObj;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.Arrays;

public class StoryPuzzle extends Puzzle {

    String[] choices0 = {"plum", "pear", "pineapple"};
    String[] choices1 = {"excited", "horrid", "rambunctious"};
    String[] choices2 = {"dog", "squirrel", "gargoyle"};
    String[] choices3 = {"barked", "screeched", "sneezed"};
    String[] choices4 = {"surprised", "annoyed", "in awe"};
    String[][] arr = {choices0, choices1, choices2, choices3, choices4};
    String[] words = new String[5];
    int index = 0;
    int storyInt = 0;
    boolean done = false;
    // story
    String story;
    ImgObj ch1;
    ImgObj ch2;
    ImgObj ch3;
    ImgObj exit;
    public StoryPuzzle(int id, int dialogue) {
        super(id, dialogue);
    }

    @Override
    public void init() {
        isCompleted= false;
        ch1 = Content.images.get(20);
        ch2 = Content.images.get(21);
        ch3 = Content.images.get(22);
        exit = Content.images.get(-5);
        Arrays.fill(words,"" );
    }

    @Override
    public void draw(Graphics2D g) {
        if(index < 5) {
        g.setColor(Color.WHITE);
        g.fillRect(0,0 ,600  ,600 );
        Drawer.draw(g, ch1);
        Drawer.draw(g, ch2);
        Drawer.draw(g, ch3);
        TextOutput.s = "Choose words to finish the story";
//        g.drawString("Choose words to finish the story", 50, 50);
        // accessing the 2D array of choices
        g.setColor(Color.BLACK);

            g.drawString(arr[index][0], 120, 500);
            g.drawString(arr[index][1], 275, 500);
            g.drawString(arr[index][2], 415, 500);
        }
            // wait for choice to be made before the words change
        if (index >= 5) {
//            g.setColor(Color.WHITE);
//            g.drawRect(0, 0, 610, 810);
//            g.setColor(Color.BLACK);
//            g.drawString(story, 50, 100);
            g.setColor(Color.WHITE);
            g.fillRect(0,0 ,600  ,600 );

            setStory();
            int length = story.indexOf(" ", story.length()/2);
            if(storyInt ==0) {
                TextOutput.s = story.substring(storyInt* length, length + 1);
            } else {
                TextOutput.s = story.substring(storyInt* length);

            }
            TextOutput.formatString();

            Drawer.draw(g, exit);
        }
    }

    @Override
    public boolean passed() {
        return done;
    }


    @Override
    public boolean quit() {
        return false;
    }

    private void setStory() {
        story = "You were walking down the hallway, eating a " + words[0] + ". Suddenly, you saw a " +
                words[1] + " " + words[2] + " jump out in front of you! You threw your " + words[0] + " at the " +
                words[2] + ", and it " + words[3] + " very " + words[1] + "ly! You were " + words[4] + ", and you " +
                "hurried away, wondering about the fate of your half-eaten " + words[0] + ".";
    }
    // this updates frequently
    @Override
    public void handleInput() {
        if (Mouse.isClicked() && index != 5) {
            if (Mouse.isCollided(ch1)) {
                words[index] = arr[index][0];
                index++;

            }
            if(Mouse.isCollided(ch2)) {
                words[index] = arr[index][1];
                index++;

            }
            if(Mouse.isCollided(ch3)) {
                words[index] = arr[index][2];
                index++;

            }
        }


        if(Mouse.isClicked() && index == 5) {
            if (Mouse.isCollided(exit)) {
                done = true;
            }
            storyInt++;
            if(storyInt >1) {
                storyInt =0;
            }
        }
    }

    @Override
    public boolean isCompleted() {
        return isCompleted;
    }

}
