package states;

import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import game.StateManager;
import models.ImgObj;

import java.awt.*;

/**
 * the welcome screen of the game
 */
public class IntroState extends State {
    private ImgObj startBtn = Content.images.get(105);

    public IntroState(StateManager sm) {
        super(sm);
    }




    @Override
    public void init() {
    }

    @Override
    public void draw(Graphics2D g) {

        Drawer.draw(g,Content.images.get(-1));
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
    }
}
