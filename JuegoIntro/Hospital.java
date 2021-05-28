import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospital extends World
{
    GreenfootSound cancion_nivel1 = new GreenfootSound(" ");
    /**
     * Constructor for objects of class Hospital.
     * 
     */
    public Hospital()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(887, 768, 1);
        setPaintOrder(GameOver.class,doctor.class,puerta_abrir.class,puerta_cerrar.class,
        Tiro.class, covid.class, escalera.class);
        cancion_nivel1.playLoop();
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {

        covid covid = new covid();
        addObject(covid,487,432);
        covid.setLocation(521,687);
        covid.setLocation(517,708);
        covid covid2 = new covid();
        addObject(covid2,228,522);
        covid covid3 = new covid();
        addObject(covid3,489,347);
        covid covid4 = new covid();
        addObject(covid4,318,172);

        Piso piso = new Piso();
        addObject(piso,354,227);
        Piso piso2 = new Piso();
        addObject(piso2,519,403);
        Piso piso3 = new Piso();
        addObject(piso3,357,577);
        Piso piso4 = new Piso();
        addObject(piso4,447,752);

        escalera escalera = new escalera();
        addObject(escalera,831,253);
        escalera.setLocation(831,251);
        escalera escalera2 = new escalera();
        addObject(escalera2,42,425);
        escalera2.setLocation(43,424);
        escalera escalera3 = new escalera();
        addObject(escalera3,837,600);
        escalera3.setLocation(837,599);

        puerta_abrir puerta_abrir = new puerta_abrir();
        addObject(puerta_abrir,88,160);

    }
}
