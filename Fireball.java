import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fireball here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fireball extends Actor
{
    private int speed;
    public Fireball(int speed)
    {
        getImage().scale(getImage().getWidth()/18,getImage().getHeight()/18);
        this.speed=speed;
    }
    public void act()
    {
        move(speed);
        destroy();
        
    }
    public void destroy()
    {
        Alien alien = (Alien)getOneIntersectingObject(Alien.class);
        if(alien!=null)
        {
            World world = getWorld();
            //remove current alien
            world.removeObject(alien);
            //remove current fireball
            world.removeObject(this);
            Greenfoot.playSound("destroy.wav");
            SpaceShip.score++;
        }
        else if(isAtEdge())
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
     //or //
    /*public void reachEnd()
    {
        if(isAtEdge())
        {
            World world = getWorld();
            world.removeObject(this);
        }
    }
    */
}
