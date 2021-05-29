import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este actor es es la puerta al inicio de cada nivel, cuando se crea el 
 * nivel este actor crea al actor jugable y desaparece para no seguir
 * creando doctores.
 */
public class puerta_abrir extends Actor
{
    private int conteo1 = 0;
    GreenfootSound sdoor = new GreenfootSound("door.mp3");

    private int conteo2 = 0;
    GreenfootImage puerta_abierta = new GreenfootImage("puerta_abierta.png");
    GreenfootImage puerta_cerrada = new GreenfootImage("puerta_cerrada.png");
    /**
     * Act - do whatever the puerta_abrir wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(conteo1 == 0){sdoor.play();}
        if (conteo1 < 40) {
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
    

