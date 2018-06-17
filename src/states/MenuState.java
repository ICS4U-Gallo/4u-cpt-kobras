package states;

import game.StateManager;

import java.awt.*;

public class MenuState extends State {
    public MenuState(StateManager sm) {
        super(sm);
    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        // draw bg
        // draw backbutton
        // draw character stat
        // will have char stats in it

    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void handleInput() {
        // if clicked on certain buttons
        // then perform that task
    }
}
