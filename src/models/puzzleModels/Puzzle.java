package models.puzzleModels;

import java.awt.Graphics2D;

public abstract class Puzzle {
    public int id;
    private boolean isCompleted;

    public abstract void draw(Graphics2D g);

    public abstract boolean passed();

    public abstract boolean failed();

    public abstract boolean quit();

    public abstract void handleInput();

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
