import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends starscreen_actores
{
    public GreenfootSound cancion_inicio = new GreenfootSound("AllStar.mp3");
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        cancion_inicio.setVolume (30);
        cancion_inicio.playLoop();
        if (Greenfoot.mouseClicked(this)) {
            cancion_inicio.stop();
            Greenfoot.setWorld(new Hospital());
            
        }
    }    
}
