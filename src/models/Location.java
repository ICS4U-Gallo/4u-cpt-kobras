package models;

import helpers.Content;

public class Location {
    public int id;
    private int[] roomLocations; // up right down left
    private ImgObj background;
    private Dialogue[][] dialogues; // [year][puzzleDone]

    public Location(int id, int[] roomLocations, ImgObj background, Dialogue[][] dialogues) {
        this.id = id;
        this.roomLocations = roomLocations;
        this.background = background;
        this.dialogues = dialogues;

    }
    public int getId() {
        return id;
    }

    public int getDirection(int index) {
        return roomLocations[index];
    }

    public ImgObj getBackground() {
        return background;
    }

    public Dialogue getDialogue() {
        int a = 0;
        if(isPuzzleDone()) {
            a++;
        }
        return dialogues[Player.getGrade() - 9][a];
    }
    public boolean isPuzzleDone() {
        if(hasPuzzle() && Content.puzzles.get(id *100 + Player.getGrade() - 9).isCompleted()) {
            return true;
        }
        return false;
    }

    public boolean hasPuzzle() {
        return Content.puzzles.containsKey(Integer.parseInt(id + "" + (Player.getGrade() - 9)));
    }
}
