package game;

import states.*;

import java.awt.*;

/**
 * class that handles what event happens
 * It differentiates them by states
 */
public class StateManager {
    private static State[] states;
    private int currState;
    private int prevState;
    public static final int INTRO = 0;
    public static final int MENU = 1;
    public static final int PUZZLE = 2;
    public static final int DIALOGUE = 3;
    public static final int LOCATION = 4;
    public static final int DECISION = 5;
    public static final int NUM_STATES = 6;

    /**
     * when game is started
     */
    public StateManager() {
        states = new State[NUM_STATES];
        currState = 0;
        setState(INTRO, 0);
    }

    /**
     * initializes the state to an array of states
     * @param state
     *          the int of the index in the array of states
     */
    public void setState(int state, int id) {
        prevState = currState;
        destroy(prevState);
        currState = state;

        if(state == INTRO) {
            states[state] = new IntroState(this);
            states[state].init();
        } else if(state == MENU) {
            states[state] = new MenuState(this);
            states[state].init();
        }else if(state == PUZZLE) {
            states[state] = new puzzleState(this, id);
            states[state].init();
        }else if(state == DIALOGUE) {
            states[state] = new DialogueState(this, id);
            states[state].init();
        }else if(state == LOCATION) {
            states[state] = new LocationState(this);
            states[state].init();
        }else if(state == DECISION) {
            states[state] = new DecisionState(this, id);
            states[state].init();
        }
    }

    /**
     * sets the states to null
     * clears some data
     * @param a
     */
    public void destroy(int a) {
        states[a] = null;
    }

    /**
     * constantly draws the current state
     * @param g
     */
    public void draw(Graphics2D g) {

        if(states[currState] != null) {
            states[currState].draw(g);
        }


    }

    /**
     * calls the update methods of the state to change the state
     * it is called 30X per second
     */
    public void update() {
        if(states[currState] != null) {
            states[currState].update();
        }
    }

}
