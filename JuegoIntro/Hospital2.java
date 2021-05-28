import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hospital2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospital2 extends World
{
    /**
     * Constructor for objects of class Hospital2.
     * 
     */
    public Hospital2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(887, 768, 1); 
        setPaintOrder(GameOver.class,doctor.class,puerta_abrir.class,puerta_cerrar.class,
        Tiro.class, covid.class, escalera.class);
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        puerta_abrir puerta_abrir = new puerta_abrir();
        addObject(puerta_abrir,93,683);
        Piso piso = new Piso();
        addObject(piso,447,754);
        piso.setLocation(447,749);

        escalera escalera3 = new escalera();
        addObject(escalera3,837,598);
        covid covid = new covid();
        addObject(covid,480,701);
        covid covid2 = new covid();
        addObject(covid2,561,524);
        covid covid3 = new covid();
        addObject(covid3,273,521);
        covid covid4 = new covid();
        addObject(covid4,526,347);
        covid4.setLocation(531,350);
        covid covid5 = new covid();
        addObject(covid5,281,348);
        covid covid6 = new covid();
        addObject(covid6,549,177);
        covid covid7 = new covid();
        addObject(covid7,256,175);

        escalera escalera = new escalera();
        addObject(escalera,831,251);
        escalera escalera2 = new escalera();
        addObject(escalera2,44,423);

        Piso piso2 = new Piso();
        addObject(piso2,347,228);
        Piso piso3 = new Piso();
        addObject(piso3,520,402);
        Piso piso4 = new Piso();
        addObject(piso4,360,576);
        covid3.setLocation(177,516);
        covid2.setLocation(481,524);
        covid4.setLocation(711,356);
        covid5.setLocation(376,341);
        covid2.setLocation(378,529);
        covid5.setLocation(304,375);
        covid5.setLocation(341,346);
        covid6.setLocation(526,179);
        canciones canciones = new canciones();
        addObject(canciones,880,760);
        canciones.setLocation(884,766);
        canciones.setLocation(876,751);
        removeObject(piso);
        removeObject(canciones);
        addObject(piso,448,748);
        covid5.setLocation(39,338);
        covid4.setLocation(587,333);
        removeObject(escalera3);
        removeObject(escalera);
        removeObject(escalera2);
        addObject(escalera3,836,598);
    }
}
