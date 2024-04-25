import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
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
    public static final int[][] LEVEL1 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 4}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    public static final int[][] LEVEL2 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 1, 1, 6, 1, 1, 1, 1, 1, 1, 4}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    public static final int[][] LEVEL3 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 5, 0, 0, 0, 0, 0, 1, 6, 1, 0, 0, 0, 0}, 
                                            {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 1, 1, 6, 1, 0, 1, 1, 1, 1, 4}, 
                                            {0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 5, 0, 0, 0, 1, 6, 1, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    public static final int[][] LEVEL4 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
                                            {0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0}, 
                                            {0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {0, 0, 8, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {2, 1, 1, 1, 1, 1, 5, 1, 1, 1, 7, 6, 6, 1, 1, 4}, 
                                            {0, 0, 8, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {0, 0, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0}, 
                                            {0, 0, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 8, 0, 0}, 
                                            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
    public static final int[][] LEVEL5 =    {{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 
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
        setPaintOrder(Player.class, Decal.class, Tile.class);
        buildLevel(LEVEL3);
    }
    public void buildLevel(int[][] level) {
        Actor objectToAdd = null;
        Actor objectToAdd2 = null;
        for (int i = 0; i < level.length; i++) {
            for (int j = 0; j < level[i].length; j++) {
                if (level[i][j] == 1) {
                    if(level[i][j - 1] == 0) {
                        addObject(new GroundL(), (j - 1) * 120 + 60, i * 120 + 61);
                    }
                    if(level[i][j + 1] == 0) {
                        addObject(new GroundR(), (j + 1) * 120 + 60, i * 120 + 61);
                    }
                }
                switch(level[i][j]) {
                    case 1 :
                        objectToAdd = new Ground();
                        break;
                    case 2 :
                        objectToAdd = new Ground();
                        objectToAdd2 = new Player1();
                        break;
                    case 3 :
                        objectToAdd = new Ground();
                        objectToAdd2 = new Player2();
                        break;
                    case 4 :
                        objectToAdd = new Completion();
                        break;
                    case 5 :
                        objectToAdd = new Box();
                        break;
                    case 6 :
                        objectToAdd = new Lava();
                        break;
                    default :
                        objectToAdd = null;
                }
                if (objectToAdd != null) {
                    addObject(objectToAdd, j * 120 + 60, i * 120 + 60);
                }
                if (objectToAdd2 != null) {
                    addObject(objectToAdd2, j * 120 + 60, i * 120 + 60);
                }
            }
        }
    }
}
