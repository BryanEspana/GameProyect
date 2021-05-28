import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Creditos_ani here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Creditos_ani extends Actor
{
    GifImage creditos = new GifImage("Creditos.gif");
    public GreenfootSound cancion_creditos = new GreenfootSound("Roundabout.mp3");
    
    private int count = 900;
    /**
     * Act - do whatever the Creditos_ani wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        cancion_creditos.setVolume (30);
        cancion_creditos.playLoop();
        
        if (Greenfoot.mouseClicked(this)) {
            cancion_creditos.stop();
            Greenfoot.setWorld(new Startscreen());
            
        }
        tiempo();
    }    
    public void tiempo()
    {
        if(count > 0){
            count --;
        } if(count >= 225){
            setImage(creditos.getCurrentImage());
        }
        else{
            cancion_creditos.stop();
            Greenfoot.setWorld(new Startscreen());
        }
    }
}
