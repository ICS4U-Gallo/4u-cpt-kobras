package models.puzzleModels;

import java.awt.*;

public class PianoPuzzle extends Puzzle {
    public PianoPuzzle(int id, int dialogue) {
        super(id, dialogue);
    }

    @Override
    public void init() {
        isCompleted= false;
    }

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
