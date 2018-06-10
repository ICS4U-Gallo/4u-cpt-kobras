package models.storyline;

import java.util.ArrayList;

public class Storyline {
    public static ArrayList<Quest> quests;
    public static int currQuest;

    public static boolean nextQuest() {
        // if currQuest puzzle is completed (quest.dialogue.decision.puzzle.isCompleted();
        // then increaseLevel();
        // if currQuest >= quests
        // then storyFinished and return false;
        return true;
    }
    public static void startQuest() {
        // set current quest to 0

    }
    public static void storyFinished() {
        // output Thanks for playing JDialogue
        // set quests currQuests to 0
        // new Player();
    }
    public static void increaseLevel() {
        // currQuest++();
        // if done a certain num of quests then increase grade
        //
    }

}
