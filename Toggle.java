import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Toggle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Toggle extends Toggler
{
    private int x;
    private int y;
    
    private boolean on;
    
    public Toggle(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the Completion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        checkForPlayer();
    }
    
    public void checkForPlayer() {
        int activeX = Player.active.getGridX();
        int activeY = Player.active.getGridY();
        MyWorld world = (MyWorld) getWorld();
        
        if (activeX == x && activeY == y && !on) {
            on = true;
            active++;
        } else if ((activeX != x || activeY != y) && on) {
            on = false;
            active--;
        }
    }
}
