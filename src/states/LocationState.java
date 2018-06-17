package states;

import game.StateManager;
import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import models.ImgObj;
import models.Location;
import models.storyline.Storyline;

import java.awt.*;
import java.awt.image.BufferedImage;

import static game.StateManager.DIALOGUE;
import static game.StateManager.ENDING;
import static game.StateManager.INTRO;


/**
 * displays the current room as well as possible directions
 * Allows the user to click on arrows to move, or interact with surroundings
 */
public class LocationState extends State {

    private static ImgObj[] arrows = {Content.images.get(101),Content.images.get(102), Content.images.get(103), Content.images.get(104)};
    private static Location location = Content.locations.get(0);
    private static boolean questing;


    public LocationState(StateManager sm) {
        super(sm);
    }

    @Override
    public void init() {
        // if quest puzzle is completed set next quest
        if(!Storyline.nextQuest()) {
            sm.setState(ENDING,0 );
        }
        if(Storyline.quests.get(Storyline.currQuest).roomNum == location.id) {
            questing = true;
        } else {
            questing = false;
        }
    }

    @Override
    public void draw(Graphics2D g) {

        // draw background
        Drawer.draw(g,location.getBackground());
        for(ImgObj a: arrows) {
            Drawer.draw(g,a);
        }
        // draw room obj
        if(location.getDialogue().getID() != -1) {
            Drawer.draw(g, location.getDialogue().obj);
        }
        if(questing) {
            Drawer.draw(g, Storyline.quests.get(Storyline.currQuest).dialogue.obj);
        }


    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void handleInput() {
        //if mouse collides with entity spot start dialogue
        if(questing) {
            if (Mouse.isCollided(Storyline.quests.get(Storyline.currQuest).dialogue.obj)) {
                sm.setState(DIALOGUE, Storyline.quests.get(Storyline.currQuest).dialogue.getID());
            }
        }else if(Mouse.isCollided(location.getDialogue().getObj())) {
            sm.setState(DIALOGUE, location.getDialogue().getID());
        }

        // if mouse clicked arrow button
        if(Mouse.isClicked()) {
            for (int i = 0; i < 4; i++) {
                if(Mouse.isCollided(arrows[i])) {
                    int move = location.getDirection(i);
                    if(move != -1) {

                        location = Content.locations.get(move);
                    }
                }
            }



        }

    }
}
