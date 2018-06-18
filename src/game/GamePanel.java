package game;

import helpers.Mouse;
import helpers.TextOutput;
import models.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import static java.awt.Font.PLAIN;
import static java.awt.Font.SANS_SERIF;

/**
 * this is the main frame which contains the game loop and the component that all the other classes draw on
 */
public class GamePanel extends JPanel implements Runnable, MouseListener, MouseMotionListener {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 800;
    private StateManager sm;
    public static Player p;
    public static TxtArea txtArea;

    private BufferedImage image;
    private Graphics2D g;

    private Thread thread;
    private boolean running;
    private final int FPS = 30;
    private final int TARGET_TIME = 1000 / FPS;

    GamePanel() {
        init();
    }

    /**
     * initializes the JFrame and adds the gamepanel as well as the eventlisteners that it implements
     * Thread for the program also is initialized which runs the run method
     *
     */
    private void init() {
        JFrame frame = new JFrame("School Simulator");
        frame.setSize(WIDTH,HEIGHT);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        setFocusable(true);
        requestFocus();
        addMouseListener(this);
        addMouseMotionListener(this);
        txtArea = new TxtArea();
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS ));
        this.add(Box.createRigidArea(new Dimension(600,600 )));
        this.add(txtArea);

        image = new BufferedImage(WIDTH, HEIGHT -200, 1);
        g = (Graphics2D) image.getGraphics();

        sm = new StateManager();
        p = new Player();
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Main game loop that updates at 30FPS
     *
     */
    public void run() {
        long start, elapsed, wait;
        while(running) {
            start = System.nanoTime();

            tick();

            elapsed =System.nanoTime() - start;
            wait = TARGET_TIME - elapsed / 1000000;

            if(wait <= 0) {
                wait = 5;
            }
            try{
                thread.sleep(wait);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }
    }

    /**
     * Methods that are called that are updated constantly
     */
    public void tick() {
        //System.out.println(Mouse.getX() + " " + Mouse.getY());
        sm.update();
        draw();

        drawToScreen();
        txtArea.setMessage(TextOutput.s);
        Mouse.update();
    }


    /**
     * calls the statemanager to draw using the given Graphics2D
     */
    public void draw() {

         sm.draw(g);
    }

    /**
     * Buffers the image to display
     */
    private void drawToScreen() {
        Graphics g2 = getGraphics();
        g2.drawImage(image, 0, 0, WIDTH , HEIGHT - 235, null);
        g2.dispose();
    }


    /**
     * methods that are implented from MouseListener and MouseMotionListener
     */
    @Override
    public void mouseClicked(MouseEvent e) {}
    @Override
    public void mousePressed(MouseEvent e) {
        Mouse.click(e.getX(),e.getY() ,true );
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        Mouse.setDragged(false);
        Mouse.click(e.getX(),e.getY() ,false );
    }
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    @Override
    public void mouseExited(MouseEvent e) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        Mouse.setX(e.getX());
        Mouse.setY(e.getY());
        Mouse.setDragged(true);
        //Mouse.setClickState(false);
    }
    @Override
    public void mouseMoved(MouseEvent e) {
        Mouse.setX(e.getX());
        Mouse.setY(e.getY());
    }
}

class TxtArea extends JTextArea {
    public TxtArea() {
        setLocation(0,600 );
        setSize(600, 200);
        setVisible(true);
        setBackground(Color.WHITE);
        setFont(new Font(SANS_SERIF,PLAIN ,27));
    }

    public void setMessage(String s) {
        setText(s);
    }




}