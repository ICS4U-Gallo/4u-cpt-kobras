package models.storyline;

import helpers.TextOutput;
import models.Player;

import java.util.ArrayList;

public class Storyline {
    public static ArrayList<Quest> quests;
    public static int currQuest;
    public Storyline() {
        quests = new ArrayList<>();

    }

    public static boolean nextQuest() {
        // if currQuest puzzle is completed (quest.dialogue.decision.puzzle.isCompleted())
        if (quests.get(currQuest).dialogue.decision.puzzle.isCompleted()) {
            increaseLevel();
            if (currQuest >= quests.size()) {
                storyFinished();
                return false;
            }
        }
        // then increaseLevel();
        // if currQuest >= quests
        // then storyFinished and return false;
        return true;
    }
    public static void startQuest() {
        // set current quest to 0
        currQuest = 0;
    }
    public static void storyFinished() {
        // output Thanks for playing JDialogue
        TextOutput.s = "Thanks for playing!!!!!!!";
        // set quests currQuests to 0
        startQuest();
        new Player();
    }
    public static void increaseLevel() {
        currQuest++;
        // if done a certain num of quests then increase grade
        if (currQuest == 1) {
            Player.grade = 12;
        }
    }

}
