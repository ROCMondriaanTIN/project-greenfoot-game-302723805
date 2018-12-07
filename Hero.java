
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
    private int teller;
    private String letter;
    public static boolean paktLetterB;
    public static int Letter;
    private int score;
    
    
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
        
        getWorld().showText(getX()+ ", " + getY(),100,100);
    
    
        handleInput();
        letterB();
        
        velocityX *= drag;
        velocityY += acc;
        getWorld().showText("Letter = " + Integer.toString(Letter),950,50);
       
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
        
                for (Actor slak : getIntersectingObjects(slak.class)) {
            if (slak != null) {
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
        for (Actor letterB : getIntersectingObjects(LetterB.class)) {
            if (letterB != null) {
                //getWorld().removeObject(this);
                //Greenfoot.setWorld(new GameOver());
                //letter = letterB.getLetter();
                return;
            }
            
        }
    }
    
    public void Hartje()
    {
       
if  (isTouching(Hartje.class)){
    removeTouching (Hartje.class);
}
    }
    
     public void letterB()
    {
       getWorld().showText("Score:"+ Integer.toString(score),60,75);
 if (isTouching(LetterB.class)){
    removeTouching (LetterB.class);
    score = score +50;
  
}
}
//public void act()
//{
    //velocityX *= drag;
    //velocityX += acc;
    
    //getWorld().showText("Letter = " + Integer.toString(LetterB),950,50);
    //}


  
    
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
        if (Greenfoot.isKeyDown("w")){//&& velocityY == 0) {
            setImage("p1_jump.png");
            velocityY = -11;
        }

        if (Greenfoot.isKeyDown("a")) {
            velocityX =-5;
            rechts = false;
            Animate();
        } else if (Greenfoot.isKeyDown("d")) {
            velocityX = 5;
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
