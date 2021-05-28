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
    boolean edge = false;
 
    /**
     * Act - do whatever the covid wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( gifImage.getCurrentImage());
        count++;
        edge = false;
        if (edge = false){
        hitTheEdge();
        }
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
    private void hitTheEdge()
    {
        int x = getX();
        World myWorld = getWorld();
        int myWorldWidth = myWorld.getWidth() - 1;
        if(x == 0 || x == myWorldWidth)
        {
            count = 120;
            edge = true;
        }
    }
}
