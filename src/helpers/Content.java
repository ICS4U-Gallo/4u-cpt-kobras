package helpers;

import models.*;
import models.puzzleModels.Puzzle;
import models.storyline.Quest;
import models.storyline.Storyline;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

/**
 * loads all the images and files into this class
 * contains static methods
 */
public class Content {

    public static HashMap<Integer, Dialogue> dialogues = new HashMap<>();
    public static HashMap<Integer, Puzzle> puzzles = new HashMap<>();
    public static HashMap<Integer, ImgObj> images = new HashMap<>();
    public static HashMap<Integer, Location> locations = new HashMap<>();
    public static HashMap<Integer, Decision> decisions = new HashMap<>();

    public static void init() {
        new Storyline();
        initImages();
        initPuzzles();
        initDecisions();
        initDialogues();
        initLocations();
        initQuests();
        setDecisions();
    }

    private static void setDecisions() {
        for(int i = 0; i < decisions.size();i++) {
            Decision dec = Content.decisions.get(i);
            if(dec!= null){
                dec.dialogues = new Dialogue[] {Content.dialogues.get(dec.dialogue[0]), Content.dialogues.get(dec.dialogue[1])};
            }
        }
    }


    public static void initPuzzles() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("resources/gamedat/puzzles.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }


    public static void initDialogues() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("resources/gamedat/dialogues.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNextLine()) {
            Scanner sc2 = null;
            try{
                String s = sc.nextLine();
                sc2 = new Scanner(new FileReader(s));
            }catch(FileNotFoundException e) {
                e.printStackTrace();
            }
            int id = Integer.parseInt(sc2.nextLine());
            ImgObj img = Content.images.get(Integer.parseInt(sc2.nextLine()));
            int decision = -1;
            if(sc2.hasNext(";;")) {
                String s2 = sc2.nextLine();
                    decision = Integer.parseInt(s2.substring(0,s2.length() -2));
            } else {
                sc2.nextLine();
            }
            List<Speaker> speakers = new ArrayList<>();
            while(sc2.hasNextLine()) {
                String name = sc2.nextLine();
                String text = sc2.nextLine();
                ImgObj spImg = Content.images.get(Integer.parseInt(sc2.nextLine()));
                speakers.add(new Speaker(text,spImg , name));
            }
            Speaker[] sp = speakers.toArray(new Speaker[speakers.size()]);
            if(decisions.containsKey(decision)) {
                dialogues.put(id, new Dialogue(sp, id, img, decisions.get(decision)));
            }
            else {
                dialogues.put(id, new Dialogue(sp, id, img));
            }

        }
    }

    /**
     * a method that initializes images to be used in the game
     */
    public static void initImages() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("resources/images/imageList.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while(sc.hasNextLine()) {
            String s = sc.nextLine();
            Scanner imgSc = new Scanner(s);
            try {
                int id = Integer.parseInt(imgSc.next());
                int x = Integer.parseInt(imgSc.next());
                int y = Integer.parseInt(imgSc.next());
                int width = Integer.parseInt(imgSc.next());
                int height = Integer.parseInt(imgSc.next());
                BufferedImage img = ImageIO.read(Content.class.getResource(imgSc.next()));

                images.put(id, new ImgObj(id ,x, y, width, height, img) );
            } catch (IOException e) {
                e.printStackTrace();
            }
            imgSc.close();
        }


    }

    public static void initLocations() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("resources/gamedat/locations.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            Scanner sc2 = new Scanner(s);
            try {
                int id = sc2.nextInt();
                int[] directions = new int[4];
                for(int i = 0; i < 4; i++) {
                    directions[i] = sc2.nextInt();
                }
                ImgObj img = Content.images.get(sc2.nextInt());
                Dialogue[][] dialogue = new Dialogue[4][2]; // [grade] , [before and after]
                for(int i = 0; i < 4; i++) {
                    for(int j = 0; j < 2; j++) {
                        int a = sc2.nextInt();
                        dialogue[i][j] = Content.dialogues.get(a);
                    }
                }
                Location i = new Location(id, directions ,img , dialogue );
                Content.locations.put(id,i);

            }catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void initQuests() {
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("resources/gamedat/quests.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while(sc.hasNextLine()) {
            Scanner sc2 = new Scanner(sc.nextLine());
            int order = sc2.nextInt();
            int roomId = sc2.nextInt();
            Dialogue d = Content.dialogues.get(sc2.nextInt());

            Storyline.quests.add(order, new Quest(roomId, d));
        }
    }

    public static void initDecisions(){
        Scanner sc = null;
        try {
            sc = new Scanner(new FileReader("resources/gamedat/decisions.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (sc.hasNextLine()) {
            int id = Integer.parseInt(sc.nextLine());
            String choice1 = sc.nextLine();
            String choice2 = sc.nextLine();
            Scanner sc2 = new Scanner(sc.nextLine());
            int dio1 = sc2.nextInt();
            int dio2 = sc2.nextInt();
            int eff1 = sc2.nextInt();
            int eff2 = sc2.nextInt();
            int puzzle = sc2.nextInt();
            Content.decisions.put(id,new Decision(id,new String[] {choice1, choice2}, new int[] {eff1, eff2}, new int[] {dio1, dio2},Content.puzzles.get(puzzle)));
        }
    }



}
