package states;

import game.StateManager;

import java.awt.Graphics2D;

/**
 * just a basic outline of the state class
 * this will be the game controller so to speak
 */
public abstract class State {
    protected StateManager sm;

    public State(StateManager sm) {
        this.sm = sm;
    }

    public abstract void init();

    public abstract void draw(Graphics2D g);

    public abstract void update();

    public abstract void handleInput();

}
