import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class afkleft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class afkleft extends starscreen_actores
{
    GifImage gifImage = new GifImage("afkleft.gif");
    int speed = 2;
    int count = 0;
   
    public void act() 
    {
        setImage( gifImage.getCurrentImage());
        count++;
    }    
}
