package states;

import game.StateManager;
import helpers.Content;
import models.Player;
import models.puzzleModels.Puzzle;

import java.awt.*;

public class puzzleState extends State{
    private int id;
    private Puzzle puzz;
    public puzzleState(StateManager sm, int id) {
        super(sm);
        this.id = id;
        puzz = Content.puzzles.get(id);
    }

    @Override
    public void init() {
        puzz.init();
    }

    @Override
    public void draw(Graphics2D g) {
        // pass draw to the instance of the puzzle
        puzz.draw(g);

    }

    @Override
    public void update() {

        puzz.handleInput();
        if(puzz.quit()){
            sm.setState(StateManager.DIALOGUE,puzz.getDialogue().getID() );
        }
        if(puzz.passed()) {
            sm.setState(StateManager.LOCATION,0 );
        }
    }

    @Override
    public void handleInput() {

    }
}
