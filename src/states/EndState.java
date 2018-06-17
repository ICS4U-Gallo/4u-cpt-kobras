package states;

import game.StateManager;
import helpers.Content;
import helpers.Drawer;

import java.awt.*;

public class EndState extends State{
    public EndState(StateManager sm, int id) {
        super(sm);
    }

    @Override
    public void init() {

    }

    @Override
    public void draw(Graphics2D g) {
        Drawer.draw(g, Content.images.get(98));
    }

    @Override
    public void update() {

    }

    @Override
    public void handleInput() {

    }
}
