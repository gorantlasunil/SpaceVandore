import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SpaceShip here.
 * 
 * @author (SUNIL GORANTLA) 
 * @version (a version number or a date)
 */
public class SpaceShip extends Actor
{
    /**
     * Act - do whatever the SpaceShip wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int timeCounter=0;
    private static final int reLoadTime=20;
    private int speed;
    private int rotation;
    public static int score=0;
    public SpaceShip(int speed,int rotation)
    {
        
        this.speed=speed;
        this.rotation=rotation;
    }
    public void act()
    {
        timeCounter++;
        move(speed);
        wrapAround();
        upDownSide();
        rotateCW();
        rotateACW();
        fire();
    }
    
    public void wrapAround()
    {
         if(getX()==999)
         {
             setLocation(0,getY());
        }
        else if(getX()==0)
         {
             setLocation(999,getY());
        }
    }
    
     public void upDownSide()
     {
        if(getY()==499)
         {
             setLocation(getX(),0);
        }
        else if(getY()==0)
         {
             setLocation(getX(),499);
        }
        
    }
    
    public void move(int distance)
    {
        setImage("SpaceShipWithoutBooster.png");
        if(Greenfoot.isKeyDown("right"))
        {
            setImage("SpaceShipWithBooster.png");
            setLocation(getX()+distance,getY());
        }
        if(Greenfoot.isKeyDown("left"))
        {
            setLocation(getX()-distance,getY());
        }
        if(Greenfoot.isKeyDown("down"))
        {
            setLocation(getX(),getY()+distance);
        }
         if(Greenfoot.isKeyDown("up"))
        {
            setLocation(getX(),getY()-distance);
        }
    }
    public void rotateCW()
    {
        if(Greenfoot.isKeyDown("q"))
        {
            turn(rotation);
        }
    }
    
    public void rotateACW()
    {
        if(Greenfoot.isKeyDown("p"))
        {
            turn(-rotation);
        }
    }
    
    public void fire()
    {
        if(timeCounter>=reLoadTime)
        {
        if(Greenfoot.isKeyDown("space"))
        {
            releaseFireball();
            timeCounter=0;
        }
        }
    }
    
    public void releaseFireball()
    {
    Greenfoot.playSound("shotgun.wav");
       World world = getWorld();
       Fireball fireball = new Fireball(10);
       world.addObject(fireball,getX(),getY());
       fireball.setRotation(getRotation());
    }
    
}

