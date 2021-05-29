import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Mundo de creditos, en este mundo se mostrara al jugador cuando haya vencido
 * todos los niveles.
 */
public class Creditos extends World
{
    /**
     * Constructor for objects of class Creditos.
     * 
     */
    public Creditos()
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
        Contador contador = new Contador();
        addObject(contador,883,765);
    }
}
