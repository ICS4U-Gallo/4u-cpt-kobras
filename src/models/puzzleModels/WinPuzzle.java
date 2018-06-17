package models.puzzleModels;

import java.awt.*;

public class WinPuzzle extends Puzzle {

    public WinPuzzle(int id, int dialogue) {
        super(id, dialogue);
    }

    @Override
    public void init() {
        isCompleted = true;
    }

    @Override
    public void draw(Graphics2D g) {

    }

    @Override
    public boolean passed() {
        return true;
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
