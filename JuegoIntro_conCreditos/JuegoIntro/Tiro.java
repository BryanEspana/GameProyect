import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este actor es el disparo de la vacuna del doctor, al ser creado se mueve 
 * por 15 actos y desaparece.
 */

public class Tiro extends Actor
{
    private int conteo = 0;
    /**
     * Act - do whatever the Tiro wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       if (conteo < 15) {
       move(5); 
       conteo += 1;
    }else {
        World myWorld = getWorld();
        myWorld.removeObject(this);
    }
    }    
}
