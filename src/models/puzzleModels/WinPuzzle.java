package models.puzzleModels;

import java.awt.*;

public class WinPuzzle extends Puzzle {

    public WinPuzzle(int id, int dialogue) {
        super(id, dialogue);
    }

    @Override
    public void init() {
    }

    @Override
    public void draw(Graphics2D g) {
    }

    @Override
    public boolean passed() {
        return true;
    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public void handleInput() {

    }
}
