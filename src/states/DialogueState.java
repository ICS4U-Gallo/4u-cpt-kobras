package states;

import game.StateManager;
import helpers.Content;
import helpers.Mouse;
import models.Dialogue;
import models.Speaker;

import java.awt.*;

public class DialogueState extends State {
    Speaker[] speakers;
    private int index;
    private Dialogue dialogue;

    public DialogueState(StateManager sm, int id) {
        super(sm);
        dialogue = Content.dialogues.get(id);
        speakers = dialogue.getSpeakers();
        index = 0;
    }

    @Override
    public void init() {
    }

    @Override
    public void draw(Graphics2D g) {
        // draw background
        // draw the character
    }

    @Override
    public void update() {
        handleInput();
        // set texts TextOutput.s = ;
        //
    }

    @Override
    public void handleInput() {
        // if mouse clicked
        if(Mouse.isClicked()) {

        }
        // then switch over to next speaker
        // if no more speakers, then if decision
        // switch to setState(decision, decision id)
        // else set state to Location
    }
}
