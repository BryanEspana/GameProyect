    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class Startscreen here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
public class Startscreen extends World
{
    GreenfootSound cancion_inicio = new GreenfootSound(" ");
    /**
     * Constructor for objects of class Startscreen.
     * 
     */
    public Startscreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(887, 768, 1); 
        cancion_inicio.playLoop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Play play = new Play();
        addObject(play,411,279);
        Exit exit = new Exit();
        addObject(exit,407,433);
        afkleft afkleft = new afkleft();
        addObject(afkleft,700,592);
    }
}
