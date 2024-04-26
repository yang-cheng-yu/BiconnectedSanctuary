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
        int[][] level = MyWorld.getLevel();
        if (currentTime - lastMoveTime >= MOVE_DELAY) {
            if (Greenfoot.isKeyDown("W")) {
                if (active.y != 0 && isLegalTile('w', level)) {
                    active.setLocation(getX(), getY() - 120);
                    active.y--;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    bumpSound.play();
                }
            }
            if (Greenfoot.isKeyDown("S")){
                if (active.y != 8 && isLegalTile('s', level)) {
                    active.setLocation(getX(), getY() + 120);
                    active.y++;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    bumpSound.play();
                }
            }
            if (Greenfoot.isKeyDown("A")) {
                if (active.x != 0 && isLegalTile('a', level)) {
                    active.setLocation(getX() - 120, getY());
                    active.x--;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    bumpSound.play();
                }
            }
            if (Greenfoot.isKeyDown("D")) {
                if (active.x != 15 && isLegalTile('d', level)) {
                    active.setLocation(getX() + 120, getY());
                    active.x++;
                    lastMoveTime = currentTime;
                    return;
                } else {
                    bumpSound.play();
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
        return tile == 1 || tile == 2 || tile == 3 || tile == 4 || tile == 7;
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
