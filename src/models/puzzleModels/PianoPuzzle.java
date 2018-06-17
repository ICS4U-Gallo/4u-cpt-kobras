package models.puzzleModels;

import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import models.Dialogue;
import models.ImgObj;

import java.awt.*;
import java.io.IOException;

public class PianoPuzzle extends Puzzle {

    ImgObj p1 = Content.images.get(31);
    ImgObj p2 = Content.images.get(32);
    ImgObj p3 = Content.images.get(33);
    ImgObj p4 = Content.images.get(34);
    ImgObj p5 = Content.images.get(35);
    ImgObj p6 = Content.images.get(36);
    // ImgObj exit = Content.images.get(-5);

    int[] sequence = {2, 1, 5, 5, 3, 6};
    int[] played = new int[6];

    boolean showSeq = true;
    boolean showIncorrect = false;
    int timesClicked = 0;

    public PianoPuzzle(Dialogue d) throws IOException {

    }

    @Override
    public void init() {
        for (int i = 0; i < played.length; i++) {
            played[i] = 0;
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.BLACK);
        Drawer.draw(g, p1);
        Drawer.draw(g, p2);
        Drawer.draw(g, p3);
        Drawer.draw(g, p4);
        Drawer.draw(g, p5);
        Drawer.draw(g, p6);
        if (showSeq) {
            g.drawString("Play this sequence: 2, 1, 5, 5, 3, 6", 250, 400);
        }
        else {
            // cover sequence
            g.setColor(Color.WHITE);
            g.drawRect(245, 395, 300, 40);
            g.setColor(Color.BLACK);
        }

        if (showIncorrect) {
            g.drawString("Nope! Try again.", 300, 450);
        }
        else {
            // cover incorrect warning
            g.setColor(Color.WHITE);
            g.drawRect(295, 445, 200, 40);
            g.setColor(Color.BLACK);
        }
    }

    @Override
    public boolean passed() {
        if (timesClicked == 6) {
            for (int i = 0; i < played.length; i++) {
                if (played[i] != sequence[i]) {
                    showSeq = true;
                    showIncorrect = true;
                    timesClicked = 0;
                    return false;
                }
            }
            return true;
        }
        return false;
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
        while (!passed()) {
            for (int i = 0; i < played.length; i++) {
                if (Mouse.isClicked()) {
                    if (Mouse.isCollided(p1)) {
                        played[i] = 1;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    } else if (Mouse.isCollided(p2)) {
                        played[i] = 2;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    } else if (Mouse.isCollided(p3)) {
                        played[i] = 3;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    } else if (Mouse.isCollided(p4)) {
                        played[i] = 4;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    } else if (Mouse.isCollided(p5)) {
                        played[i] = 5;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    } else if (Mouse.isCollided(p6)) {
                        played[i] = 6;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    } else {
                        played[i] = 0;
                        timesClicked++;
                        showSeq = false;
                        showIncorrect = false;
                    }
                }
            }
        }
    }

    @Override
    public boolean isCompleted() {
        return passed();
    }

}
