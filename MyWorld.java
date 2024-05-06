import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private Player p1 = null;
    private Player p2 = null;
    
    /* Object IDs
     * 0 = void
     * 1 = ground
     * 2 = p1 spawn
     * 3 = p2 spawn
     * 4 = completion
     * 5 = box
     * 6 = lava
     * 7 = toggle
     * 8 = toggleable tiles (off state)
     * 9 = toggleable tiles (on state)
     * 10 = recovery
     * 11 = respawn
     * 12 = warp 1.1
     * 13 = warp 1.2
     * 14 = warp 2.1
     * 15 = warp 2.2
     * 16 = warp 3.1
     * 17 = warp 3.2
     * 18 = warp 4.1
     * 19 = warp 4.2
     * 20 = warp 5.1
     * 21 = warp 5.2
     * 22 = lava w/box
     * 23 = toggle w/box
     */
    
    //Levels
    public static int[][] level;
    private static int levelId;
    private static final int[][] LEVEL1 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] LEVEL2 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 4}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] LEVEL3 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 5, 0, 0, 0, 0, 0, 1, 6, 1, 0, 0, 0, 0}, 
                                            {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 1, 1, 6, 1, 0, 1, 1, 1, 1, 4}, 
                                            {0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 5, 0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] LEVEL4 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0}, 
                                            {0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {0, 0, 8, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 5, 1, 1, 1, 7, 6, 6, 1, 1, 4}, 
                                            {0, 0, 8, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    private static final int[][] LEVEL5 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 1, 0, 0, 5, 1, 1, 0, 0, 0, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 15, 1, 1, 1, 4}, 
                                            {0, 0, 0, 1, 0, 0, 13, 1, 1, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 14, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    
                                            /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        super(1920, 1080, 1);
        prepare();
    }
    
    public void prepare() {
        levelId = 1;
        level = toLevelArray(levelId);
        buildLevel(level);
        initPlayers(level);
    }
    
    /**
     * Builds inputted level in the world
     * @param level level array
     */
    public void buildLevel(int[][] level) {
        Actor objectToAdd = null;
        Completion.numTiles = 0;
        Completion.numActive = 0;
        // Tile
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                switch(level[i][j]) {
                    case 1 :
                        objectToAdd = new Ground();
                        break;
                    case 2 :
                        objectToAdd = new Ground();
                        break;
                    case 3 :
                        objectToAdd = new Ground();
                        break;
                    case 4 :
                        objectToAdd = new Completion(j, i);
                        Completion.numTiles++;
                        break;
                    case 5 :
                        objectToAdd = new Box(j, i);
                        break;
                    case 6 :
                        objectToAdd = new Lava();
                        break;
                    case 23 :
                        objectToAdd = new LavaBox();
                        break;
                    default :
                        objectToAdd = null;
                }
                if (objectToAdd != null) {
                    addObject(objectToAdd, j * 120 + 60, i * 120 + 60);
                }
            }
        }
        // Decal
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level[i][j] == 1 || level[i][j] == 5) {
                    if(isGroundSideTile(level[i][j - 1])) {
                        addObject(new GroundL(), (j - 1) * 120 + 60, i * 120 + 61);
                    }
                    if(isGroundSideTile(level[i][j + 1])) {
                        addObject(new GroundR(), (j + 1) * 120 + 60, i * 120 + 61);
                    }
                }
            }
        }
    }
    
    private boolean isGroundSideTile(int tile) {
        return tile == 0 || tile == 6 || tile == 23;
    }
    
    public void initPlayers(int[][] level) {
        // Player
        outer:
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                switch(level[i][j]) {
                    case 2 :
                        p1 = new Player1();
                        addObject(p1, j * 120 + 60, i * 120 + 61 - Player.Y_OFFSET);
                        p1.setX(j);
                        p1.setY(i);
                        break;
                    case 3 :
                        p2 = new Player2();
                        addObject(p2, j * 120 + 60, i * 120 + 61 - Player.Y_OFFSET);
                        p2.setX(j);
                        p2.setY(i);
                        break;
                }
                if (p1 != null && p2 != null) {
                    break outer;
                }
            }
        }
        Player.active = p1;
    }
    
    public void redrawPlayers() {
        if (p1 != null) {
            int p1X = p1.getX();
            int p1Y = p1.getY();
            
            removeObject(p1);
            addObject(p1, p1X, p1Y);
        }
        if (p2 != null) {
            int p2X = p2.getX();
            int p2Y = p2.getY();
            
            removeObject(p2);
            addObject(p2, p2X, p2Y);
        }
    }
    /**
     * Creates a copy of level array for simulation
     * @param level level array
     * @return copy of level array
     */
    public static int[][] copyLevel(int[][] level) {
        int[][] out = new int[level.length][];

        for (int i = 0; i < level.length; i++) {
            out[i] = new int[level[i].length];
            
            for (int j = 0; j < level[i].length; j++) {
                out[i][j] = level[i][j];
            }
        }
        return out;
    }
    
    /**
     * Converts a level id to corresponding level array
     * @param levelId level id
     * @return level array
     */
    public static int[][] toLevelArray(int levelId) {
        switch (levelId) {
            case 1:
                return copyLevel(LEVEL1);
            case 2:
                return copyLevel(LEVEL2);
            case 3:
                return copyLevel(LEVEL3);
            case 4:
                return copyLevel(LEVEL4);
            case 5:
                return copyLevel(LEVEL5);
            default:
                return null;
        }
    }
    
    public void nextLevel() {
        List objects = getObjects(Actor.class);
        if (objects != null) {
            removeObjects(objects);
        }
        
        level = toLevelArray(++levelId);
        buildLevel(level);
        initPlayers(level);
    }
}
