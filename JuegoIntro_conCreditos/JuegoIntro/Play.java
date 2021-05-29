import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boton para inciar el juego, este es creado y comenzará a sonar la musica 
 * del inicio. Al ser presionado la musica parará y se pasara al primer nivel.
 */
public class Play extends starscreen_actores
{
    public GreenfootSound cancion_inicio = new GreenfootSound("AllStar.mp3");
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        cancion_inicio.setVolume (30);
        cancion_inicio.playLoop();
        if (Greenfoot.mouseClicked(this)) {
            cancion_inicio.stop();
            Greenfoot.setWorld(new Hospital());
            
        }
    }    
}
