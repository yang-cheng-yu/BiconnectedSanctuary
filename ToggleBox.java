import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ToggleBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ToggleBox extends Toggler
{
    private int x;
    private int y;
    
    public static boolean pInteract;
    
    private GreenfootSound pickSound = new GreenfootSound("pickup.wav");
    
    public ToggleBox(int x, int y) {
        this.x = x;
        this.y = y;
        active++;
    }
    /**
     * Act - do whatever the ToggleBox wants to do. This method is called whenever
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
        
        pickSound.play();
        
        level[y][x] = 7;
        world.buildLevel(level);
        world.redrawPlayers();
        
        pInteract = false;
        active--;
        
        world.removeObject(this);
    }
}
