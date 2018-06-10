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

    }

    @Override
    public void draw(Graphics2D g) {
        // pass draw to the instance of the puzzle
        // puzz.draw(g);
    }

    @Override
    public void update() {
//         passes update to the puzzle class
//        puzz.handleInput();;
//         check if puzzle is completed then change state to location
//        if(puzz.isCompleted()) {
//            sm.setState(StateManager.LOCATION, Player.location);
//        }
    }

    @Override
    public void handleInput() {

    }
}
