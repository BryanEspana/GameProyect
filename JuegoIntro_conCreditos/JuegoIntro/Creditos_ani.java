import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este actor le muestra al jugador los creditos del juego una vez haya 
 * vencido todos los niveles. Contiene un gif y una cancion que son iniciados 
 * al mismo momento. Ambos duran 15 segundos. Se creo un contador que al 
 * terminar esos 15 segundos se regresara al mundo Startscreen.
 */
public class Creditos_ani extends Actor
{
    GifImage creditos = new GifImage("Creditos.gif");
    public GreenfootSound cancion_creditos = new GreenfootSound("Roundabout.mp3");
    
    private int count = 900;
    /**
     * Act - do whatever the Creditos_ani wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        
        cancion_creditos.setVolume (30);
        cancion_creditos.playLoop();
        
        if (Greenfoot.mouseClicked(this)) {
            cancion_creditos.stop();
            Greenfoot.setWorld(new Startscreen());
            
        }
        tiempo();
    }    
    public void tiempo()
    {
        if(count > 0){
            count --;
        } if(count >= 225){
            setImage(creditos.getCurrentImage());
        }
        else{
            cancion_creditos.stop();
            Greenfoot.setWorld(new Startscreen());
        }
    }
}
