    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
    * Modelo utilizado en la pantalla de inicio, es un gif del personaje
    * en su posición afk viendo hacia el lado izquierdo donde estan los botones.
    */
    public class afkleft1 extends starscreen_actores
    {
        GifImage gifImage = new GifImage("afkleft2.gif");
    /**
     * Act - do whatever the afkleft1 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        setImage( gifImage.getCurrentImage());
    }    
}
