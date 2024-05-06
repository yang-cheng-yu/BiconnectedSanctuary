import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Box here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Box extends Tile
{
    private int x;
    private int y;
    
    public static boolean pInteract;
    
    public Box(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Act - do whatever the Box wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkForPlayer();
    }
    
    public void checkForPlayer() {
        int activeX = Player.active.getGridX();
        int activeY = Player.active.getGridY();
        if (pInteract) {
            switch (Player.active.getDir()) {
                case 0:
                    if (activeX == x && activeY + 1 == y) {
                        pickup();
                    }
                case 1:
                    if (activeX == x && activeY - 1 == y) {
                        pickup();
                    }
                case 2:
                    if (activeX - 1 == x && activeY == y) {
                        pickup();
                    }
                case 3:
                    if (activeX + 1 == x && activeY == y) {
                        pickup();
                    }
            }
        }
    }
    
    public void pickup() {
        MyWorld world = (MyWorld) getWorld();
        int[][] level = MyWorld.level;
                        
        Player.active.setHolding(1);
        Player.active.setImage(Player.active.holdBox);
        
        level[y][x] = 1;
        world.buildLevel(level);
        world.redrawPlayers();
        
        pInteract = false;
        
        world.removeObject(this);
    }
    // Getters
    public int getGridX() {
        return x;
    }
    public int getGridY() {
        return y;
    }
    // Setters
    public void setX(int value) {
        x = value;
    }
    public void setY(int value) {
        y = value;
    }
}
