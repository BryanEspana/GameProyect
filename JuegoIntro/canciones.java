    import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
    
    /**
     * Write a description of class canciones here.
     * 
     * @author (your name) 
     * @version (a version number or a date)
     */
    public class canciones extends Actor
    {
        GreenfootSound cancion_nivel1 = new GreenfootSound("Miles8.mp3");
        GreenfootSound cancion_nivel2 = new GreenfootSound("Radioactive.mp3");
        GreenfootSound cancion_nivel3 = new GreenfootSound("Astronomia.mp3");
        public GreenfootSound cancion = new GreenfootSound("AllStar.mp3");
        private boolean cambio = true;
        /**
         * Act - do whatever the canciones wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
    public void act() 
    {
        if(cambio){
            canciones();
            cambio = false;
            cancion.setVolume (30);
        }
        if(cancion.isPlaying() == false){cancion.play();}
    }    
    public void canciones()
    {
        if (getWorld() instanceof Hospital){
            cancion.stop();
            cancion = cancion_nivel1;
        }
            if (getWorld() instanceof Hospital2){
            cancion.stop();
            cancion = cancion_nivel2;
        }
            if (getWorld() instanceof Hospital3){
            cancion.stop();
            cancion = cancion_nivel3;
        }
    }
}
