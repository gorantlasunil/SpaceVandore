import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Alien here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Alien extends Actor
{
    /**
     * Act - do whatever the Alien wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int speed;
    public Alien()
    {
        getImage().scale(getImage().getWidth()/10,getImage().getHeight()/10);
    }
    public Alien(int speed)
    {
        this();
        this.speed=speed;
        
    }
    public void act()
    {
        // Add your action code here.
    }
}
