import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Hospital here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hospital extends World
{

    /**
     * Constructor for objects of class Hospital.
     * 
     */
    public Hospital()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(887, 768, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        doctor doctor = new doctor();
        addObject(doctor,118,413);
        doctor.setLocation(40,680);
        Piso piso = new Piso();
        addObject(piso,364,750);
        piso.setLocation(527,750);
        Piso piso2 = new Piso();
        addObject(piso2,527,750);
        Piso piso3 = new Piso();
        addObject(piso3,360,575);
        Piso piso4 = new Piso();
        addObject(piso4,529,402);
        piso4.setLocation(527,401);
        Piso piso5 = new Piso();
        addObject(piso5,360,226);
        doctor.setLocation(41,682);
        doctor.setLocation(32,678);
        piso.setLocation(501,695);
        piso.setLocation(401,752);
        piso.setLocation(401,752);
        piso.setLocation(307,643);
        piso.setLocation(142,755);
        piso2.setLocation(522,750);
        doctor.setLocation(33,680);
        piso.setLocation(229,751);
        piso.setLocation(357,756);
        piso.setLocation(3,754);
        piso.setLocation(479,751);
        piso.setLocation(129,748);
        piso.setLocation(411,751);
        piso.setLocation(329,748);
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
        piso.setLocation(305,755);
        piso5.setLocation(447,226);
        Piso piso6 = new Piso();
        addObject(piso6,447,226);
        piso5.setLocation(4,231);
        piso4.setLocation(428,400);
        Piso piso7 = new Piso();
        addObject(piso7,428,400);
        piso4.setLocation(420,410);
        piso4.setLocation(865,399);
        piso4.setLocation(844,402);
        piso5.setLocation(56,229);
        piso5.setLocation(56,228);
        piso3.setLocation(39,576);
        piso3.setLocation(447,576);
        Piso piso8 = new Piso();
        addObject(piso8,447,576);
        doctor.setLocation(166,152);
        doctor.setLocation(150,148);
    }
}
