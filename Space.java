import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Space here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Space extends World
{

    /**
     * Constructor for objects of class Space.
     * 
     */
    private int timecounter=0;
    private static final int delayTime=200;
    public Space()
    {    
            super(1000,500,1);
            addSpaceShip();
            addAlienType1();
            addAlienType2();
            
        }
        
        public void act()
        {
            displayScore();
            nextLevel();
        }
    
        public void addSpaceShip()
        {
       Greenfoot.playSound("Space_Background.wav");
         int x=Greenfoot.getRandomNumber(1000);
        int y=Greenfoot.getRandomNumber(500);
        addObject(new SpaceShip(3,5),x,y);   
        }
        public void addAlienType1()
        {
            for(int i=0;i<=4;i++)
            {
                addObject(new Alien(3),412+(i*61),198);
            }
        }
        public void addAlienType2()
        {
            for(int i=0;i<=10;i++)
            {
                int x=Greenfoot.getRandomNumber(1000);
                int y=Greenfoot.getRandomNumber(500);
                addObject(new Alien(),x,y);
            }
        }
        
        public void displayScore()
        {
            showText("Score:"+SpaceShip.score,892,50);
        }
        
        public void nextLevel()
        {
            if(SpaceShip.score==16)
            {
                timecounter++;
                if(timecounter>=delayTime)
                {
                    setBackground("");
                }
                else
                {
                    Greenfoot.setWorld(new Gameover());
                }
            }
        }
    
 }
