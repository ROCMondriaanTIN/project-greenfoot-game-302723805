
import greenfoot.*;

/**
 *
 * @author R. Springer
 */
public class Hero extends Mover {
    
    

    private final double gravity;
    private final double acc;
    private final double drag;
    private boolean mirror;
    private boolean rechts;
    
    //private GreenfootImage run1 = new GreenfootImage ("p1_walk01.png");
    //private GreenfootImage run2 = new GreenfootImage ("p1_walk02.png");
    //private GreenfootImage run3 = new GreenfootImage ("p1_walk03.png");
    //private GreenfootImage run4 = new GreenfootImage ("p1_walk04.png");
    //private GreenfootImage run5 = new GreenfootImage ("p1_walk05.png");
    //private GreenfootImage run6 = new GreenfootImage ("p1_walk06.png");
    //private GreenfootImage run7 = new GreenfootImage ("p1_walk07.png");
    //private GreenfootImage run8 = new GreenfootImage ("p1_walk08.png");
    //private GreenfootImage run9 = new GreenfootImage ("p1_walk09.png");
    //private GreenfootImage run10 = new GreenfootImage ("p1_walk10.png");
    //private GreenfootImage run11 = new GreenfootImage ("p1_walk11.png");
    
    private int frame = 1;
    public Hero() {
        super();
        gravity = 9.8;
        acc = 0.6;
        drag = 0.8;
        setImage("p1.png");
    }

    @Override
    public void act() {
        handleInput();
        
        velocityX *= drag;
        velocityY += acc;
        if (velocityY > gravity) {
            velocityY = gravity;
        }
        applyVelocity();

        for (Actor enemy : getIntersectingObjects(Enemy.class)) {
            if (enemy != null) {
                getWorld().removeObject(this);
                Greenfoot.setWorld(new GameOver());
                return;
            }
        }
                for (Actor Slime : getIntersectingObjects(Slime.class)) {
            if (Slime != null) {
                getWorld().removeObject(this);
                Greenfoot.setWorld(new GameOver());
                return;
            }
        }
                for (Actor Dood : getIntersectingObjects(Dood.class)) {
            if (Dood != null) {
                getWorld().removeObject(this);
               Greenfoot.setWorld(new GameOver());
                return;
            }
        }
    }
    
    public void Animate()
    
   {
     switch(frame){
        case 1:
    
        setImage ("p1_walk01.png");
        break;
        case 2:
        
        setImage ("p1_walk02.png");
        break;
        case 3:
        
        setImage ("p1_walk03.png");
        break;
        case 4:
        
        setImage ("p1_walk04.png");
        break;
         case 5:
           
            setImage ("p1_walk05.png");
            break;
       case 6:
          
            setImage ("p1_walk06.png");
            break;
       case 7:
           
            setImage ("p1_walk07.png");
            break;
       case 8:
          
            setImage ("p1_walk08.png");
            break;
       case 9: 
            
            setImage ("p1_walk09.png");
            break;
       case 10:
        
            
            setImage ("p1_walk10.png");
            break;    
       case 11:
       
        setImage ("p1_walk11.png");
        frame = 0;
        break;
      } 
    frame ++;
    mirrorImage();
}

    

    public void handleInput() {
        if (Greenfoot.isKeyDown("w")) {//&& velocityY == 0
            setImage("p1_jump.png");
            velocityY = -10;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX = -2;
            rechts = false;
            Animate();
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 2;
              rechts = true;
            Animate();
        }
    }
    
    
    public void mirrorImage(){
        if (mirror && rechts){
            getImage().mirrorHorizontally();
        }
        
        else if (!mirror && !rechts) { 
            getImage().mirrorHorizontally();
        }
    }
    

    public int getWidth() {
        return getImage().getWidth();
    }

    public int getHeight() {
        return getImage().getHeight();
    }
}
