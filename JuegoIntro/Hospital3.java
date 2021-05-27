import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hospital3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospital3 extends World
{

    /**
     * Constructor for objects of class Hospital3.
     * 
     */
    public Hospital3()
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
        addObject(puerta_abrir,105,163);

        covid covid = new covid();
        addObject(covid,744,177);
        covid.setLocation(225,351);
        covid covid2 = new covid();
        addObject(covid2,475,357);
        covid covid3 = new covid();
        addObject(covid3,659,357);
        covid covid4 = new covid();
        addObject(covid4,312,531);
        covid covid5 = new covid();
        addObject(covid5,545,529);
        covid covid6 = new covid();
        addObject(covid6,716,529);
        covid covid7 = new covid();
        addObject(covid7,205,703);
        covid covid8 = new covid();
        addObject(covid8,418,698);
        covid covid9 = new covid();
        addObject(covid9,606,694);
        covid9.setLocation(607,698);

        Piso piso = new Piso();
        addObject(piso,362,227);
        Piso piso2 = new Piso();
        addObject(piso2,522,403);
        Piso piso3 = new Piso();
        addObject(piso3,370,577);
        escalera escalera = new escalera();
        addObject(escalera,838,250);
        escalera escalera2 = new escalera();
        addObject(escalera2,45,426);
        escalera escalera3 = new escalera();
        addObject(escalera3,845,602);
        Piso piso4 = new Piso();
        addObject(piso4,456,753);
        covid covid10 = new covid();
        addObject(covid10,306,175);
        covid covid11 = new covid();
        addObject(covid11,611,181);
        piso2.setLocation(386,404);
        covid4.setLocation(213,530);
        covid5.setLocation(447,519);
    }
}
