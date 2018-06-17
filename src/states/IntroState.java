package states;

import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import game.StateManager;
import helpers.TextOutput;
import models.ImgObj;

import java.awt.*;

/**
 * the welcome screen of the game
 */
public class IntroState extends State {
    private ImgObj startBtn = Content.images.get(105);
    ImgObj bg = Content.images.get(99);

    public IntroState(StateManager sm) {
        super(sm);
    }




    @Override
    public void init() {
    }

    @Override
    public void draw(Graphics2D g) {

        Drawer.draw(g,bg);
        Drawer.draw(g,startBtn);

    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void handleInput() {
        if(Mouse.isClicked() && Mouse.isCollided(startBtn))
            sm.setState(sm.LOCATION, 0);

       // if(Mouse.isClicked())
       //     TextOutput.s = "You were walking down a hallway\nSuddenly you see an indigo bat jump in fornt of you!\nYou threw your trusty sidekick at the bat and it\nsaid very loud words!You were frightened\n and hurried awaty wondering about the state of your half eaten ...";
    }
}
