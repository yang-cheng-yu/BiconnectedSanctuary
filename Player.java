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
    private int holding = 0;
    
    private long lastMoveTime = 0;
    private static final long MOVE_DELAY = 350;
    public static final int Y_OFFSET = 40;
    
    private static long currentTime;
    private static int[][] level = MyWorld.level;
    
    private GreenfootSound bumpSound = new GreenfootSound("bumpintowall.wav");
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        active.processInputs();
        if (!Greenfoot.isKeyDown("W") && !Greenfoot.isKeyDown("S") && !Greenfoot.isKeyDown("A") && !Greenfoot.isKeyDown("D")) {
            lastMoveTime = 0;
        }
    }
    
    public void processInputs() {
        currentTime = System.currentTimeMillis();
        level = MyWorld.level;
        
        Box.pInteract = false;
        if (currentTime - lastMoveTime >= MOVE_DELAY) {
            if (Greenfoot.isKeyDown("W")) {
                if (y != 0 && active.isLegalTile('w', level)) {
                    setLocation(getX(), getY() - 120);
                    active.debug();
                    
                    y--;
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
                if (y != 8 && active.isLegalTile('s', level)) {
                    setLocation(getX(), getY() + 120);
                    
                    y++;
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
                if (x != 0 && active.isLegalTile('a', level)) {
                    setLocation(getX() - 120, getY());
                    
                    x--;
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
                if (x != 15 && active.isLegalTile('d', level)) {
                    setLocation(getX() + 120, getY());
                    
                    x++;
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
                        if (level[y][x] != 23) {
                            Box.pInteract = true;
                            lastMoveTime = currentTime;
                        }
                        return;
                    case 1:
                        if (level[y][x] != 23) {
                            active.putDown();
                            lastMoveTime = currentTime;
                        }
                        return;
                }
            }
        }
    }
    
    private boolean isLegalTile(char key, int[][] level) {
        switch (key) {
            case 'w':
                return isLegalTile(level[y - 1][x]);
            case 's':
                return isLegalTile(level[y + 1][x]);
            case 'a':
                return isLegalTile(level[y][x - 1]);
            case 'd':
                return isLegalTile(level[y][x + 1]);
            default:
                return false;
        }
    }

    private static boolean isLegalTile(int tile) {
        return tile == 1 || tile == 2 || tile == 3 || tile == 4 || tile == 7 || tile == 23 && active.holding == 0;
    }
    
    private void putDown() {
        switch (dir) {
            case 0 :
                if (level[y + 1][x] == 1) {
                    level[y + 1][x] = 5;
                }
                if (level[y + 1][x] == 6) {
                    level[y + 1][x] = 23;
                }
                holding = 0;
                break;
            case 1 :
                if (level[y - 1][x] == 1) {
                    level[y - 1][x] = 5;
                }
                if (level[y - 1][x] == 6) {
                    level[y - 1][x] = 23;
                }
                holding = 0;
                break;
            case 2 :
                if (level[y][x - 1] == 1) {
                    level[y][x - 1] = 5;
                }
                if (level[y][x - 1] == 6) {
                    level[y][x - 1] = 23;
                }
                holding = 0;
                break;
            case 3 :
                if (level[y][x + 1] == 1) {
                    level[y][x + 1] = 5;
                }
                if (level[y][x + 1] == 6) {
                    level[y][x + 1] = 23;
                }
                holding = 0;
                break;
        }
        MyWorld world = (MyWorld) getWorld();
        world.buildLevel(level);
        world.redrawPlayers();
    }
    
    private void debug() {
        System.out.printf("tileatpos (%d)\ntileup (%d)\ntiledown (%d)\ntileleft (%d)\ntileright (%d)\n", level[y][x], level[y - 1][x], level[y + 1][x], level[y][x - 1], level[y][x + 1]);
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
