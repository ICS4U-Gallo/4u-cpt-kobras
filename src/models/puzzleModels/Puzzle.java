package models.puzzleModels;

import helpers.Content;
import models.Dialogue;

import java.awt.Graphics2D;

public abstract class Puzzle {
    public int id;
    protected boolean isCompleted;
    private int dialogue;

    public Dialogue getDialogue() {return Content.dialogues.get(dialogue);}


    public abstract void init();

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
