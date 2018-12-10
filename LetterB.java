import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class letterB here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterB extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;
    public String letter = "B";

    public LetterB() {
        super();  
        setImage("letter_B.png");
        getImage().mirrorHorizontally();
        walkRange = 360;
        firstAct = true;
        speed = 1;
    }


    @Override
    public void act() 
    {
    

        int x = getX();
        int y = getY();

        if (firstAct) 
        
        {
            firstAct = false;
            xMin = x - walkRange / 2;
            xMax = x + walkRange / 2;
        }

        velocityX = speed;
        applyVelocity();
        if (getX() >= xMax) 
        {
            speed *= -1;
            x = xMax;
            getImage().mirrorHorizontally();
        } else if (getX() <= xMin) 
        
        {
            speed *= -1;

            x = xMin;
            getImage().mirrorHorizontally();
        }
    }
    public String getLetter()
    {
        return letter;
    }
}

