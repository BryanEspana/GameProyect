import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class puerta_abrir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class puerta_cerrar extends Actor
{
    private int conteo1 = 0;

    private int conteo2 = 0;
    GreenfootImage puerta_abierta = new GreenfootImage("puerta_abierta.png");
    GreenfootImage puerta_cerrada = new GreenfootImage("puerta_cerrada.png");
    /**
     * Act - do whatever the puerta_abrir wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        next();
    }
    
    public void next()
    {
        Actor doctor = getOneIntersectingObject(doctor.class);
        if(doctor != null)
        {
            if (conteo2 < 20) {
                setImage(puerta_abierta);
                conteo2 += 1;
            }else {
                Greenfoot.setWorld(new Hospital2());
        }   
        }
    }

}
    

