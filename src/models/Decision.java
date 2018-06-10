package models;

import models.puzzleModels.Puzzle;

public class Decision {


    public String[] choices;
    public int[] effects;
    public int[] dialogue;
    public Puzzle puzzle;
    public Dialogue[] dialogues;


    public Decision(String[] choices, int[] effects, int[] dialogue, Puzzle puzzle ) {
        this.choices = choices;
        this.dialogue = dialogue;
        this.puzzle = puzzle;
        this.effects = effects;
        dialogues = new Dialogue[2];
    }


}
