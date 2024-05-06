import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Completion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Completion extends Tile
{
    public static int numTiles;
    public static int numActive;
    
    private int x;
    private int y;
    
    private boolean active;
    
    public Completion(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the Completion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        checkForPlayer();
        if (numTiles == numActive) {
            MyWorld world = (MyWorld) getWorld();
            world.nextLevel();
        }
    }
    
    public void checkForPlayer() {
        int activeX = Player.active.getGridX();
        int activeY = Player.active.getGridY();
        
        if (active) {
            if (activeX != x || activeY != y) {
                numActive--;
                active = false;
            }
        } else {
            if (activeX == x && activeY == y) {
                numActive++;
                active = true;
            }
        }
    }
}
