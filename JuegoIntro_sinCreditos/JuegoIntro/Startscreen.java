    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**Mundo creado para darle al jugador una pantalla de inicio, 
     * donde comenzar el juego no solo al jugar por primera vez.
     * Tambien cuando sea vencido por el COVID y cuando llegue al final.
    */
public class Startscreen extends World
{
   
    /**
     * Constructor for objects of class Startscreen.
     * 
     */
    public Startscreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(887, 768, 1);
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
        afkleft1 afkleft = new afkleft1();
        addObject(afkleft,700,592);
        play.setLocation(360,298);
        play.setLocation(344,302);
        exit.setLocation(100,555);
        play.setLocation(97,372);
        play.setLocation(240,352);
        play.setLocation(237,366);
        exit.setLocation(304,512);
        exit.setLocation(289,538);
        play.setLocation(272,377);
        play.setLocation(178,363);
        play.setLocation(200,375);
        play.setLocation(168,407);
        play.setLocation(171,409);
        removeObject(play);
        addObject(play,288,380);
    }
}
