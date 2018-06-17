package states;

import game.GamePanel;
import game.StateManager;
import helpers.Content;
import helpers.Mouse;
import models.Decision;

import java.awt.*;

public class DecisionState extends State {
    public static final int PUZZLE = 1;
    public static final int DIALOGUE = 2;
    public static final int GRADE = 3;
    public static final int MARK = 4;
    public static final int SOCIAL = 5;

    String[] choices = new String[2];
    private static final int RIGHT = 0;
    private static final int LEFT = 1;
    private static Decision decision;
    private static int choice;

    public DecisionState(StateManager sm, int id) {
        super(sm);
        decision = Content.decisions.get(id);
    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        // draw a translucent thing to darken the screen
        // draw the strings from the choices on 2 sides maybe in a box
        g.setColor(Color.WHITE);
        g.drawRect(0,325 , 280,50 );
        g.drawRect(325,325 ,280 , 50);
        g.setColor(Color.BLACK);
        g.drawString(decision.choices[LEFT], 5,330 );
        g.drawString(decision.choices[RIGHT],330 ,330 );


    }

    @Override
    public void update() {
        handleInput();
    }

    @Override
    public void handleInput() {
        // if clicked on one option then check the effects of that option (0 is right, 1 is left) for each choice
        if(Mouse.isClicked()) {
            if(Mouse.isCollided(0,0,GamePanel.WIDTH /2,(GamePanel.HEIGHT - 200)/2 )) {
                choice = LEFT;
            } else {
                choice = RIGHT;
            }
            int effect = decision.effects[choice];

            if(effect == DIALOGUE) {
                sm.setState(StateManager.DIALOGUE,decision.dialogue[choice]);
            } else if(effect == PUZZLE) {
                sm.setState(StateManager.PUZZLE, decision.puzzle.id);
            } else if(effect == GRADE) {
                sm.setState(StateManager.DIALOGUE, decision.dialogue[choice]);
            }
        }

    }
}
