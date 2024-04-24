import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1 extends Player
{
    /**
     * Act - do whatever the Player1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        move(120);
        launch();
    }
    public void move()
    {
    if (Greenfoot.isKeyDown("D")) 
    {
        Player1 player1 = new Player1();
        player1.setLocation(getX() + 120, getY());
    }
    if (Greenfoot.isKeyDown("W"))
    {
        Player1 player1 = new Player1();
        player1.setLocation(getX(), getY() - 120);
    }
    if (Greenfoot.isKeyDown("S"))
    {
        Player1 player1 = new Player1();
        player1.setLocation(getX(), getY() + 120);
    }
      if (Greenfoot.isKeyDown("A")) 
    {
        Player1 player1 = new Player1();
        player1.setLocation(getX() - 120, getY());
    }
    }
    public void launch()
    {
        if (Greenfoot.isKeyDown("Q"))
        {
            Box box = new Box();
            MyWorld world = getWorld(); 
            getWorld().removeObject(box);
            Ground ground = new Ground();
            getWorld().addObject(new Ground(), box.getX(), box.getY());
            box.setLocation(getX() + 240, getY());
        }
    }
}
