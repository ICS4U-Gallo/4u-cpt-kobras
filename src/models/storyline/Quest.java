package models.storyline;

import models.Dialogue;

public class Quest {
    public int roomNum;
    public Dialogue dialogue;

    public Quest(int roomNum, Dialogue dialogue) {
        this.roomNum = roomNum;
        this.dialogue = dialogue;
    }
}
