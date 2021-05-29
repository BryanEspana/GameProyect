import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boton para salir del juego, cuando el mouse lo presiona se cerrara Greenfoot
 */
public class Exit extends starscreen_actores
{
    /**
     * Act - do whatever the Exit wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.stop();
            System.exit(0);
    } 
}   
}
