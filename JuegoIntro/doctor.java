import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class doctor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class doctor extends Actor
{

    
    GifImage myGif = new GifImage("doc.gif");
    GifImage afkaniR = new GifImage("doc.gif");
    GifImage runaniR = new GifImage("rundoc.gif");
    GifImage afkaniL = new GifImage("afkleft.gif");
    GifImage runaniL = new GifImage("runleft.gif");
    int speed = 2;
    int count = 0;
    
    
    private int jumpHeight = 6;
    private int walkSpeed = 5;
    private double fallSpeed = 0.4;
    private boolean facingLeft = false;
    int anim;
    int atime;
    
    private boolean inTheAir = false;
    private double deltaX = 0;
    private double deltaY = 0;
    private int groundHeight = (getImage().getHeight())/2;
    private int sideWidht = (getImage().getWidth())/2;
    private World myWorld;
    int worldHeight;
    int worldWidth;
    
    public void addedToWorld(World myWorld)
    {
        this.myWorld = myWorld;
        this.worldHeight = myWorld.getHeight();
        this.worldWidth = myWorld.getWidth();
    }
    /**
     * Act - do whatever the doctor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage(myGif.getCurrentImage());
        if(inTheAir)
        {
            fall();
        }else{
            getCommand();
        }
        move();
        animate();
    }    
    private void run(String direction)
    {
        if(direction == "left")
            deltaX =walkSpeed*-1;
        else
            deltaX = walkSpeed;
    }
    private void stop()
    {
        deltaX = 0;
    }
    private void jump()
    {
        deltaY += jumpHeight;
        inTheAir = true;
    }
    private void fall()
    {
        deltaY -= fallSpeed;
    }
    private void move()
    {
        double newX = getX() + deltaX;
        double newY = getY() - deltaY;
        
        Actor platformBelow = getOneObjectAtOffset(0,groundHeight + 5, Piso.class);
        if(platformBelow != null)
        {
            if(deltaY < 0)
            {
            deltaY = 0;
            inTheAir = false;
            GreenfootImage platformImage = platformBelow.getImage();
            int topOfPlatform = platformBelow.getY() - platformImage.getHeight()/2;
            newY = topOfPlatform - groundHeight;
        }
        } else if(getY()>= worldHeight - groundHeight)
        {
            deltaY = 0;
            inTheAir = false;
            
        }
        
        else{
            inTheAir = true;
        }
        setLocation((int)newX,(int)newY);
        
    }
    private void getCommand()
    {
        if(Greenfoot.isKeyDown("left"))
        {
            run("left");
            myGif = runaniL;
        } else if(Greenfoot.isKeyDown("right"))
        {
            run("right");
            myGif = runaniR;
        } else
        {
            stop();
        if(facingLeft)
        {
            myGif = afkaniL;
        }
        else
        {
            myGif = afkaniR;
        }
        }
        if(Greenfoot.isKeyDown("up"))
        {
            jump();
        }
    }
    private void animate()
    {
       if (Greenfoot.isKeyDown("left")) facingLeft = true;
       if (Greenfoot.isKeyDown("right")) facingLeft = false;
    }
    }

