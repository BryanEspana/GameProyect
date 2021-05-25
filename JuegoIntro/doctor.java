import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class doctor extends Actor
{


GifImage myGif = new GifImage("doc.gif");
GifImage afkaniR = new GifImage("doc.gif");
GifImage runaniR = new GifImage("rundoc.gif");
GifImage afkaniL = new GifImage("afkleft.gif");
GifImage runaniL = new GifImage("runleft.gif");
GifImage subir = new GifImage("PersonajeSubir.gif");
GifImage disparoR = new GifImage("PersonajeDisparoR.gif");
GifImage disparoL = new GifImage("PersonajeDisparoL.gif");
GifImage morir = new GifImage("PersonajeMorir.gif");
int speed = 2;
int count = 0;


private int jumpHeight = 6;
private int walkSpeed = 5;
private double fallSpeed = 0.4;
private boolean facingLeft = false;
private int pausem = 50;
private int paused = 15;
private boolean disparoani = false;
private boolean covidtocar = false;


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
    if(covidtocar)
    {
        muerte();
    }
    else{
    if(inTheAir)
    {
        fall();
    }
    else{
        getCommand();
    }
    move();
    animate();
    disparoanim();
    hitCovid();
    }
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
        
    } else if (Greenfoot.isKeyDown("up") && (isOnLadder()) ){
        inTheAir = false;
    }
    
    else {
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
    } else if(Greenfoot.isKeyDown("up"))
            {
              if(isOnLadder())  {
              myGif = subir;
              int ypos = getY();
              ypos = ypos - 5;
              setLocation(getX(),ypos);
            }else {
                jump();}
            }
        else if ("space".equals(Greenfoot.getKey())){
            disparoani = true;
            fire();
        }
        
        
        else
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
    }
    private void fire() {
        Tiro tiro = new Tiro();
        getWorld().addObject(tiro,getX()+25,getY()-10);
        if (facingLeft) {
          tiro.setRotation(180); 
          tiro.setLocation(getX()-50, getY()-10);
        }
    }
    private void animate()
    {
       if (Greenfoot.isKeyDown("left")) facingLeft = true;
       if (Greenfoot.isKeyDown("right")) facingLeft = false;
    }
    public boolean isOnLadder()
    {
        return isTouching(escalera.class);
    
    }
    private void disparoanim()
    {
        if (disparoani) {
            if(facingLeft){
            myGif = disparoL;}
            else{
                myGif = disparoR;
            }
            if (paused>0){paused--;}
            else{
            disparoani = false;
            paused = 15;
        }
        }
    } 
    private void hitCovid()
    {
        Actor covid = getOneIntersectingObject(covid.class);
        if(covid != null)
            {covidtocar = true;}
    }
    private void muerte()
    {
        myGif = morir;
        if (pausem>0){pausem--;}
        else{
        World myWorld = getWorld();
        myWorld.removeObject(this);
        GameOver gameover = new GameOver();
        myWorld.addObject(gameover, myWorld.getWidth()/2, myWorld.getHeight()/2);
    }
    }
}

