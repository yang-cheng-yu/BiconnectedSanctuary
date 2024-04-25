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
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        move();
    }
    public void move()
    {
        if (Greenfoot.isKeyDown("W")) {
            active.setLocation(getX(), getY() - 120);
        }
        if (Greenfoot.isKeyDown("S")){
            active.setLocation(getX(), getY() + 120);
        }
        if (Greenfoot.isKeyDown("A")) {
            active.setLocation(getX() - 120, getY());
        }
        if (Greenfoot.isKeyDown("D")) {
            active.setLocation(getX() + 120, getY());
        }
    }
}
