import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScherm here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScherm extends World
{

    
    public StartScherm()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("StartShermaf.png");
    }
 
        public void act()
        {
         if(Greenfoot.mouseClicked(this)||Greenfoot.isKeyDown("space")){
          Greenfoot.setWorld(new MyWorld());
   
    }
}
}




