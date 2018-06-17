package models;

public class Dialogue {
    public ImgObj obj;
    private int id;
    private Speaker[] speakers;
    private Decision decision;
    private boolean hasDecision = false;

    // id is in the order of room, grade(0-3),before/after(0,1), convo#(0,9)
    public Dialogue(Speaker[] speakers, int id, ImgObj obj) {
        this.speakers = speakers;
        this.id = id;
        this.obj = obj;
    }
    public Dialogue(Speaker[] speakers, int id, ImgObj obj, Decision decision) {
        this(speakers, id, obj);
        hasDecision = true;
        this.decision = decision;
    }

    public Speaker[] getSpeakers() {
        return speakers;
    }

    public Decision getDecision() {
        return decision;
    }

    public boolean hasDecision() {
        return hasDecision;
    }

    public int getID() {
        return id;
    }

    public ImgObj getObj() {
        return obj;
    }
}
