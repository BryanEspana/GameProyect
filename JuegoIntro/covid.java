import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class covid here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class covid extends Actor
{
    GifImage gifImage = new GifImage("covid.gif");
   
    int speed = 2;
    int count = 0;
 
    /**
     * Act - do whatever the covid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( gifImage.getCurrentImage());
        count++;
        moveAround();
        hitTiro();
    }    
    public void moveAround()
    {
        if(count < 120){
            setLocation(getX()+ speed, getY());
        } else{
            speed = -speed;
            getImage().mirrorHorizontally();
            count=0;
        }
    }
    private void hitTiro()
    {
        Actor Tiro = getOneIntersectingObject(Tiro.class);
        if(Tiro != null)
        {
            World myWorld = getWorld();
            myWorld.removeObject(this);
        }
    }
}
