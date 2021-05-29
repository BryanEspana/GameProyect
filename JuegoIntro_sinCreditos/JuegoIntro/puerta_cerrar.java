import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Este actor es creado cuando el actor jugable vence a todos los COVIDs,
 *se crea como una puerta abierta estatica, cuando el actor jugable la 
 *intersecta se pasa al siguiente nivel.
 */
public class puerta_cerrar extends Actor
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
        next();
    }
    
    public void next() //modulo para cambiar de nivel en orden.
    {
        Actor doctor = getOneIntersectingObject(doctor.class);
        if(doctor != null)
        {
            if (conteo2 < 20) //20 actos despues de que el actor jugable interseccione se cambiara de nivel.
            {
                setImage(puerta_abierta);
                conteo2 += 1;
            }else {//el actor verá en que mundo esta y cambiara al siguente nivel.
            if (getWorld() instanceof Hospital){
                Greenfoot.setWorld(new Hospital2());}
            if (getWorld() instanceof Hospital2){
                Greenfoot.setWorld(new Hospital3());}
            if (getWorld() instanceof Hospital3){
            Greenfoot.setWorld(new Startscreen());}
        }   
        }
    }

}
    

