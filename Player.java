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
    private int dir;
    private int x;
    private int y;
    
    /* Holding
     * 0 = nothing
     * 1 = box
     * 2 = p1
     * 3 = p2
     */
    private int holding;
    
    private long lastMoveTime = 0;
    private static final long MOVE_DELAY = 350;
    public static final int Y_OFFSET = 40;
    
    private static long currentTime;
    private static int[][] level;
    
    private GreenfootSound bumpSound = new GreenfootSound("bumpintowall.wav");
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        processInputs();
        if (!Greenfoot.isKeyDown("W") && !Greenfoot.isKeyDown("S") && !Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D")) {
            lastMoveTime = 0;
        }
    }
    
    public void processInputs() {
        currentTime = System.currentTimeMillis();
        level = MyWorld.getLevel();
        
        Box.pInteract = false;
        if (currentTime - lastMoveTime >= MOVE_DELAY) {
            if (Greenfoot.isKeyDown("W")) {
                if (active.y != 0 && isLegalTile('w', level)) {
                    active.setLocation(getX(), getY() - 120);
                    
                    active.y--;
                    dir = 1;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    dir = 1;
                    bumpSound.play();
                    return;
                }
            }
            if (Greenfoot.isKeyDown("S")){
                if (active.y != 8 && isLegalTile('s', level)) {
                    active.setLocation(getX(), getY() + 120);
                    
                    active.y++;
                    dir = 0;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    dir = 0;
                    bumpSound.play();
                    return;
                }
            }
            if (Greenfoot.isKeyDown("A")) {
                if (active.x != 0 && isLegalTile('a', level)) {
                    active.setLocation(getX() - 120, getY());
                    
                    active.x--;
                    dir = 2;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    dir = 2;
                    bumpSound.play();
                    return;
                }
            }
            if (Greenfoot.isKeyDown("D")) {
                if (active.x != 15 && isLegalTile('d', level)) {
                    active.setLocation(getX() + 120, getY());
                    
                    active.x++;
                    dir = 3;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    dir = 3;
                    bumpSound.play();
                    return;
                }
            }
            if (Greenfoot.isKeyDown("space")) {
                switch (holding) {
                    case 0:
                        if (level[active.y][active.x] != 23) {
                            Box.pInteract = true;
                            lastMoveTime = currentTime;
                            return;
                        }
                }
            }
        }
    }
    
    private static boolean isLegalTile(char key, int[][] level) {
        switch (key) {
            case 'w':
                return isLegalTile(level[active.y - 1][active.x]);
            case 's':
                return isLegalTile(level[active.y + 1][active.x]);
            case 'a':
                return isLegalTile(level[active.y][active.x - 1]);
            case 'd':
                return isLegalTile(level[active.y][active.x + 1]);
            default:
                return false;
        }
    }

    private static boolean isLegalTile(int tile) {
        return tile == 1 || tile == 2 || tile == 3 || tile == 4 || tile == 7 || tile == 23 && active.holding == 0;
    }

    // Getters
    public int getGridX() {
        return x;
    }
    public int getGridY() {
        return y;
    }
    public int getDir() {
        return dir;
    }
    public int getHolding() {
        return holding;
    }
    // Setters
    public void setX(int value) {
        x = value;
    }
    public void setY(int value) {
        y = value;
    }
    public void setDir(int value) {
        dir = value;
    }
    public void setHolding(int value) {
        holding = value;
    }
}
