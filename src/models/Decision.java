package models;

import models.puzzleModels.Puzzle;

public class Decision {

    public int id;
    public String[] choices;
    public int[] effects;
    public int[] dialogue;
    public Puzzle puzzle;
    public Dialogue[] dialogues;


    public Decision(int id, String[] choices, int[] effects, int[] dialogue, Puzzle puzzle ) {
        this.id = id;
        this.choices = choices;
        this.dialogue = dialogue;
        this.puzzle = puzzle;
        this.effects = effects;
        dialogues = new Dialogue[2];
    }


}
