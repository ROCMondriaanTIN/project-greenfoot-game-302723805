import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LetterI here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LetterI extends Mover {

    private int walkRange;
    private int xMin;
    private int xMax;
    private boolean firstAct;
    private int speed;

    public LetterI() {
        super();
        setImage("letter_I.png");
        getImage().mirrorHorizontally();
        walkRange = 400;
        firstAct = true;
        speed = 1;
    }
      

    @Override
    public void act() {
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
}
