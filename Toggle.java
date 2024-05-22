import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Toggle here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Toggle extends Tile
{
    private int x;
    private int y;
    
    private static boolean trigger;
    public static boolean active;
    
    
    
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
        
        if (activeX == x && activeY == y && trigger) {
            world.toggle();
            Greenfoot.playSound("bridgeOnOff.wav");
            trigger = false;
            
        }
        if (activeX != x || activeY != y) {
            trigger = true;
            
        }
    }
}
