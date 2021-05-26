import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class puerta_abrir here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class puerta_abrir extends Actor
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
        if (conteo1 < 20) {
           conteo1 += 1;
        }else{
          docnuevo();
          setImage(puerta_cerrada); 
          World myWorld = getWorld();
          myWorld.removeObject(this);
        } 

    }
    public void docnuevo()
    {
        doctor doc = new doctor();
        getWorld().addObject(doc,getX(),getY());

        }
}
    

