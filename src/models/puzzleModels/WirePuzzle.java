package models.puzzleModels;

import models.PuzzImg;

import java.awt.*;

public class WirePuzzle extends Puzzle {
    PuzzImg[] puzzImgs = new PuzzImg[16];

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean passed() {
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

    @Override
    public void handleInput() {

    }
}
