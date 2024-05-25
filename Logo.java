import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Logo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Logo extends Actor
{
    private static GreenfootImage currentFrame;
    private static GreenfootImage[] frames = {new GreenfootImage("Vanier1.png"), 
                                                new GreenfootImage("Vanier2.png"), 
                                                new GreenfootImage("Vanier3.png"), 
                                                new GreenfootImage("Vanier4.png"), 
                                                new GreenfootImage("Vanier5.png"), 
                                                new GreenfootImage("Vanier6.png"), 
                                                new GreenfootImage("Vanier7.png"), 
                                                new GreenfootImage("Vanier8.png"), 
                                                new GreenfootImage("Vanier9.png"), 
                                                new GreenfootImage("Vanier10.png"), 
                                                new GreenfootImage("Vanier11.png")};
    
    private int fCount = 0;
    
    private long lastFrameTime = 0;
    private static long currentTime;
    private static final long FRAME_DELAY = 300;
    /**
     * Act - do whatever the Logo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        while (fCount < 10) {
            currentTime = System.currentTimeMillis();
            if (currentTime - lastFrameTime >= FRAME_DELAY) {
                currentFrame = frames[fCount++];
                setImage(currentFrame);
                lastFrameTime = currentTime;
            }
        }
        while (currentTime - lastFrameTime < 3000) {
            currentTime = System.currentTimeMillis();
        }
        Intro world = (Intro) getWorld();
        Greenfoot.setWorld(new MyWorld());
    }
}
