package models;

import helpers.Content;
import models.puzzleModels.Puzzle;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * class that stores user information
 */
public class Player {
    public static int grade;
    public static int location;
    public static int credits;

    public Player() {
        credits = 0;
        location = 0;
        grade = 9;
    }

    public static int getGrade() {
        return grade;
    }

    public static void setGrade(int in) {
        grade += in;
        if(grade >= 13) {
            grade = 9;
        }
    }

    public static Location getLocation() {
        return Content.locations.get(location);
    }

    public static void setLocation(int move) {
        location = move;
    }

    public static void increaseCredit() {
        credits++;
    }


}
