import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    public static Player active;
    /* Direction
    * 0 = down
    * 1 = up
    * 2 = left
    * 3 = right
    */
    private int dir = 0;
    private int x;
    private int y;
    
    private long lastMoveTime = 0;
    private static final long MOVE_DELAY = 350;
    
    private GreenfootSound bumpSound = new GreenfootSound("bumpintowall.wav");
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move();
    }
    public void move()
    {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastMoveTime >= MOVE_DELAY) {
            if (Greenfoot.isKeyDown("W")) {
                active.setLocation(getX(), getY() - 120);
                lastMoveTime = currentTime;
                return;
            }
            if (Greenfoot.isKeyDown("S")){
                active.setLocation(getX(), getY() + 120);
                lastMoveTime = currentTime;
                return;
            }
            if (Greenfoot.isKeyDown("A")) {
                active.setLocation(getX() - 120, getY());
                lastMoveTime = currentTime;
                return;
            }
            if (Greenfoot.isKeyDown("D")) {
                active.setLocation(getX() + 120, getY());
                lastMoveTime = currentTime;
                return;
            }
        }
    }
    public int getGridX() {
        return x;
    }
    public int getGridY() {
        return y;
    }
    public void setX(int value) {
        x = value;
    }
    public void setY(int value) {
        y = value;
    }
}
