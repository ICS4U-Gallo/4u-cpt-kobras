package models;

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
        if(!dialogues[Player.getGrade() - 9][0].spoken) {
            return dialogues[Player.getGrade() - 9][0];
        } else {
            return dialogues[Player.getGrade() - 9][1];
        }
    }
}
