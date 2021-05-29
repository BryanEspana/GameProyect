import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase unicamente utilizada en el mundo de Creditos. El proposito de este 
 * actor es funcionar como un contador para crear al actor Creditos_ani
 * donde se muestran los creditos del juego. Este actor es necesario ya que 
 * si el actor Creditos_ani se creara junto con el mundo al vencer todos los
 * niveles, Greenfoot tiene problemas de espacio de memoria. 
 */
public class Contador extends Actor
{   
    private int contador = 10;
    private World myWorld;
    int worldHeight;
    int worldWidth;
        
    public void addedToWorld(World myWorld)
        {
            this.myWorld = myWorld;
            this.worldHeight = myWorld.getHeight();
            this.worldWidth = myWorld.getWidth();
        }
    public void act() 
    {
        if(contador > 0){
            contador --;
        }
        else{
            getWorld().addObject(new Creditos_ani(), worldWidth/2, worldHeight/2);
            myWorld.removeObject(this);
        } 
    }    
}
