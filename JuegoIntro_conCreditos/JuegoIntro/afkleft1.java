    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
    * Write a description of class afkleft1 here.
    * 
    * @author (your name) 
    * @version (a version number or a date)
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
