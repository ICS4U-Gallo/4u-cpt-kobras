package models;

public class Speaker {
    public String text;
    public String name;
    public ImgObj image;

    public Speaker(String text, ImgObj image,String name) {
        this.text = text;
        this.image = image;
        this.name = name;
    }
}
