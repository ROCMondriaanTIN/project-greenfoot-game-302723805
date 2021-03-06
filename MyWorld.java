import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 *
 * @author R. Springer
 */
public class MyWorld extends World { 

    private CollisionEngine ce;

    /**
     * Constructor for objects of class MyWorld.
     *
     */
    public MyWorld() {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 800, 1, false);
        this.setBackground("background4.png");

        int[][] map = {
            {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,194,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,194,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,194,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,194,-1,-1,194,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,212,-1,-1,-1,-1,194,-1,-1,194,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,77,-1,-1,-1,-1,194,-1,-1,212,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1,-1,-1,-1,-1,134,-1,197,-1,76,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,212,-1,-1,-1,-1,-1,140,47,47,47,47,47,42,-1,-1,-1,-1,-1,-1,-1,-1,-1,194,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,-1,-1,-1,-1,-1,-1,212,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,72,72,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,-1,101,-1,-1,-1,-1,-1,-1,-1,101,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,67,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,-1,89,95,15,15,15,15,15,15,15,95,91,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,67,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,-1,89,90,80,155,155,155,155,155,155,155,80,92,91,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,66,67,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{-1,-1,-1,-1,-1,-1,89,90,80,80,153,153,153,153,153,153,153,80,80,92,91,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1,55,-1,-1,-1,55,-1,-1,-1,171,-1,-1,-1,33,-1,-1,-1,-1,78,-1,-1,-1,-1,-1,-1,-1,67,50,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{101,-1,-1,-1,-1,89,90,80,80,80,153,153,153,153,153,153,153,80,80,80,92,91,-1,-1,-1,-1,-1,-1,-1,210,210,210,-1,-1,-1,-1,-1,-1,-1,-1,-1,210,210,210,15,15,15,-1,-1,-1,-1,15,15,15,210,210,210,-1,-1,50,50,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{82,95,95,95,95,90,80,80,80,80,153,153,153,153,153,153,153,80,80,80,80,92,95,95,95,95,84,-1,-1,17,17,17,208,208,208,208,208,208,208,208,208,17,17,17,104,104,104,104,104,104,104,104,104,104,17,17,17,208,208,50,50,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,102,102,102,102,102,102,102,102,102,102,17,17,17,17,17,50,50,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,102,102,102,102,102,102,102,102,102,102,17,17,17,17,17,50,50,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},
{153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,153,17,17,17,17,17,17,17,17,17,17,17,17,17,17,17,102,102,102,102,102,102,102,102,102,102,17,17,17,17,17,50,50,50,50,50,50,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1},

           
        };

        // Declareren en initialiseren van de TileEngine klasse om de map aan de world toe te voegen
        TileEngine te = new TileEngine(this, 60, 60, map);
        // Declarenre en initialiseren van de camera klasse met de TileEngine klasse 
        // zodat de camera weet welke tiles allemaal moeten meebewegen met de camera
        Camera camera = new Camera(te);
        // Declareren en initialiseren van een main karakter van het spel mijne heet Hero. Deze klasse 
        // moet de klasse Mover extenden voor de camera om te werken
        Hero hero = new Hero();

        // Laat de camera een object volgen. Die moet een Mover instatie zijn of een extentie hiervan.
        camera.follow(hero);

        // Alle objecten toevoegen aan de wereld: camera, main karakter en mogelijke enemies
        addObject(camera, 200, 1212);
        addObject(hero, 200, 1212);
        
        Slime slime = new Slime();
        addObject(slime, 815, 1010);
        
        addObject(new Hartje(), 815, 1010);
        
        addObject(slime, 815, 1010);
        
        addObject(new slak(), 1466, 1247);
        
       addObject(new LetterB(), 300, 972);
       
       addObject(new LetterI(), 2053, 900);
       
       addObject(new LetterK(), 2951, 1000);
       
       addObject(new LetterC(), 2900, 1000);
       
       addObject(new LetterE(), 3568, 200);
        //addObject(new Enemy(), 1170, 410);
        
        // Force act zodat de camera op de juist plek staat.
        camera.act();
        hero.act();

        // Initialiseren van de CollisionEngine zodat de speler niet door de tile heen kan lopen.
        // De collision engine kijkt alleen naar de tiles die de variabele solid op true hebben staan.
        ce = new CollisionEngine(te, camera);
        // Toevoegen van de mover instantie of een extentie hiervan
        ce.addCollidingMover(hero);
    }

    @Override
    public void act() {
        ce.update();
    }
    public void resetStatic() {
       
        
        
    }
}
