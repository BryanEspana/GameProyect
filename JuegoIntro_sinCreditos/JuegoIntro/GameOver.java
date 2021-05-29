import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este actor se crea cuando el jugador es tocado por el COVID, despues de 100 
 * actos se retorna al mundo de Startscreen.
 */
public class GameOver extends Actor
{
    private int conteo = 0;
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (conteo < 100) {
                conteo += 1;
            }else {
                Greenfoot.setWorld(new Startscreen());
        }   
    }    
}
