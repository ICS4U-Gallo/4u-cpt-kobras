package states;

import game.StateManager;
import helpers.Content;
import helpers.Drawer;
import helpers.Mouse;
import helpers.TextOutput;
import models.Dialogue;
import models.Player;
import models.Speaker;
import java.awt.*;
import java.awt.image.BufferedImage;

public class DialogueState extends State {
    Speaker[] speakers;
    private int index;
    private Dialogue dialogue;

    public DialogueState(StateManager sm, int id) {
        super(sm);
        dialogue = Content.dialogues.get(id);
        dialogue.spoken = true;
        speakers = dialogue.getSpeakers();
        index = 0;
    }

    @Override
    public void init() {
    }

    @Override
    public void draw(Graphics2D g) {
        // draw background
        Drawer.draw(g,LocationState.location.getBackground());
        // draw the character
        Drawer.draw(g,speakers[index].image);
    }

    @Override
    public void update() {
        handleInput();
        TextOutput.s = speakers[index].name + ":\n"+ speakers[index].text;
        TextOutput.formatString();

    }

    @Override
    public void handleInput() {
        // if mouse clicked
        if(Mouse.isClicked()) {
            index++;
            if(index >= speakers.length) {
                index--;
                if(dialogue.hasDecision()) {
                    sm.setState(StateManager.DECISION, dialogue.getDecision().id );
                } else {
                    sm.setState(StateManager.LOCATION,-1);
                }
            }
        }
        // then switch over to next speaker
        // if no more speakers, then if decision
        // switch to setState(decision, decision id)
        // else set state to Location
    }
}
