import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Contador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Contador extends Actor
{   
    private int contador = 10;
    private World myWorld;
    int worldHeight;
    int worldWidth;
        
    public void addedToWorld(World myWorld)
        {
            this.myWorld = myWorld;
            this.worldHeight = myWorld.getHeight();
            this.worldWidth = myWorld.getWidth();
        }
    public void act() 
    {
        if(contador > 0){
            contador --;
        }
        else{
            getWorld().addObject(new Creditos_ani(), worldWidth/2, worldHeight/2);
            myWorld.removeObject(this);
        } 
    }    
}
