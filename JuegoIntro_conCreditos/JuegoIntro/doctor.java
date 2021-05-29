        import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
            /**
            * Actor jugable, este no solo tiene modulos para movimiento
            * y disparo. Tambien contiene para crear la pantalla de GameOver,
            * cambiar de musica al cambiar de nivel y crear la puerta para
            * cambiar de nivel cuando vence a todos los COVIDs.
            */
        
        public class doctor extends Actor
        {
            //se introducen las variable que seran utilizadas en los modulos
            //Gifs de movimiento y estatico
        GifImage myGif = new GifImage("doc.gif");
        GifImage afkaniR = new GifImage("doc.gif");
        GifImage runaniR = new GifImage("rundoc.gif");
        GifImage afkaniL = new GifImage("afkleft.gif");
        GifImage runaniL = new GifImage("runleft.gif");
        GifImage subir = new GifImage("PersonajeSubir.gif");
        GifImage disparoR = new GifImage("PersonajeDisparoR.gif");
        GifImage disparoL = new GifImage("PersonajeDisparoL.gif");
        GifImage morir = new GifImage("PersonajeMorir.gif");
        //Sonidos utilizados al ser tocado por COVID, cambiar de nivel y disparar
        GreenfootSound smuerte = new GreenfootSound("muerte.mp3");
        GreenfootSound cancion_nivel1 = new GreenfootSound("Miles8.mp3");
        GreenfootSound cancion_nivel2 = new GreenfootSound("Radioactive.mp3");
        GreenfootSound cancion_nivel3 = new GreenfootSound("Astronomia.mp3");
        public GreenfootSound cancion = new GreenfootSound("AllStar.mp3");
        private boolean cambio = true;
        
        GreenfootSound svacuna = new GreenfootSound("vacuna.mp3");
        
        //variables para movimiento y contadores
        int speed = 2;
        int count = 0;
        int conteo2 = 1;
        private int jumpHeight = 6;
        private int walkSpeed = 5;
        private double fallSpeed = 0.4;
        private boolean facingLeft = false;
        private int pausem = 50;
        private int paused = 15;
        private boolean disparoani = false;
        private boolean covidtocar = false;
        
        //variables para dar posición al actor
        private boolean inTheAir = false;
        private double deltaX = 0;
        private double deltaY = 0;
        private int groundHeight = (getImage().getHeight())/2;
        private int sideWidht = (getImage().getWidth())/2;
        private World myWorld;
        int worldHeight;
        int worldWidth;
        
        public void addedToWorld(World myWorld) //modulo para encontrar las medidas del mundo.
        {
            this.myWorld = myWorld;
            this.worldHeight = myWorld.getHeight();
            this.worldWidth = myWorld.getWidth();
        }
        /**
         * Act - do whatever the doctor wants to do. This method is called whenever
         * the 'Act' or 'Run' button gets pressed in the environment.
         */
        public void act() 
        {
            setImage(myGif.getCurrentImage()); //cada acto se cambia de imagen al GIF
            if(covidtocar) //Si el modulo para detectar cuando el jugador sea tocado por un COVID es activado se pasara a dar un GameOver.
            {
                muerte();
                if (smuerte.isPlaying() != true){
                    smuerte.play();} //Si la musica de muerte no esta tocando se activará
            }
            else{ //Si el jugador no esta tocando un COVID se le permitira moverse, de esta manera evitar que pueda salvarse de un GameOver
            if(inTheAir) // Se identifica si el actor no esta en sobre una plataforma y se crea un efecto de gravedad
            {
                fall(); //el actor se mueve hacia abajo.
            }
            else{
                getCommand(); //Si el actor no esta cayendo busca que tecla esta siendo presionada
            }
            move(); //con la tecla presionada se procede a dar movimiento al actor
            animate(); //según que movimiento se haga se le da una animación al actor
            disparoanim(); //si la tecla space es presionado se disparara un Tiro
            hitCovid(); //si el actor intersecciona con un COVID se identificara
            aparecer(); //Cuando el jugador venzá el nivel se creara una puerta_cerrar para cambiar de nivel.
            hitPuerta(); //Si el jugador intersecciona con una puerta_cerrar se para la musica, de esta manera se evita que al cambiar de nivel suenen dos canciones
            if(cambio){ //despues de un cambio de nivel se reiniciara la musica
                    canciones();
                    cambio = false;
                    cancion.setVolume (30);
                }
            if(cancion.isPlaying() == false){cancion.play();} //se crea un loop de la cancion
            }
        }    
        private void run(String direction) //modulo para darle movimiento al jugador dependiendo de la dirección
        {
            if(direction == "left")
                deltaX =walkSpeed*-1;
            else
                deltaX = walkSpeed;
        }
        private void stop() //cuando el jugador deja de presionar una tecla se para el movimiento
        {
            deltaX = 0;
        }
        private void jump() //si el jugador desea saltar
        {
            deltaY += jumpHeight;
            inTheAir = true;
        }
        private void fall() //si el actor no esta en una plataforma se le da un efecto de gravedad
        {
            deltaY -= fallSpeed;
        } 
        private void move() //modulo que identifica si el jugador esta sobre una plataforma y cambia su ubicación para que siempre este sobre la plataforma, tambien le da movimiento al jugador.
        {
            double newX = getX() + deltaX;
            double newY = getY() - deltaY;
            
            Actor platformBelow = getOneObjectAtOffset(0,groundHeight + 5, Piso.class);
            if(platformBelow != null)
            {
                if(deltaY < 0)
                {
                deltaY = 0;
                inTheAir = false;
                GreenfootImage platformImage = platformBelow.getImage();
                int topOfPlatform = platformBelow.getY() - platformImage.getHeight()/2;
                newY = topOfPlatform - groundHeight;
            }
            } else if(getY()>= worldHeight - groundHeight)
            {
                deltaY = 0;
                inTheAir = false;
                
            } else if (Greenfoot.isKeyDown("up") && (isOnLadder()) ){ //si el jugador desea subir una escalera, se elimina la gravedad para que pueda subir.
                inTheAir = false;
            }
            
            else {
                inTheAir = true; //si el jugador no esta sobre una plataforma se dara el efecto de gravedad.
            }
            setLocation((int)newX,(int)newY); //se cambia la ubicación del jugador para que siempre que se presione una tecla se mueva concorde.
            
        }
            private void getCommand() //modulo para detectar la tecla que esta siendo presionada por el jugador y dar dirección. Tambien se cambia la animación.
            {
                if(Greenfoot.isKeyDown("left"))
                {
                run("left");
                myGif = runaniL;
            }   else if(Greenfoot.isKeyDown("right"))
                {
                run("right");
                myGif = runaniR;
                    }  else if(Greenfoot.isKeyDown("up"))
                    {
                      if(isOnLadder())  { //si el jugador sube una escalera se cambia la posición en Y para representar que esta subiendo.
                      myGif = subir;
                      int ypos = getY();
                      ypos = ypos - 5;
                      setLocation(getX(),ypos);
                    }else { //si la tecla "up" esta siendo presionada pero no se encuentra en una escalera solo se salta.
                        jump();
        
                    }
                }
               
        
                else if ("space".equals(Greenfoot.getKey())){ //se identifica cuando el jugador toca la tecla "space" y se dispara un Tiro. Si esto se realizara de la misma manera que las otras teclas se crearía un Tiro por cada acto que este siendo presionada la tecla.
                    disparoani = true;
                    fire();
                    if (svacuna.isPlaying() != true){
                        svacuna.stop();
                        svacuna.play();}
                }
                else //si ninguna tecla esta siendo presionada se ponen las animaciones de afk viendo hacia la dirección que el jugador se movio por ultimo
                {
                    stop();
                    if(facingLeft)
                    {
                        myGif = afkaniL;
                    }
                    else
                    {
                        myGif = afkaniR;
                    }
                }
            }
            private void fire() { //cuando el jugador dispare una vacuna se creara un nuevo Tiro
                Tiro tiro = new Tiro();
                getWorld().addObject(tiro,getX()+25,getY()-10);
                if (facingLeft) {  //dependiendo de la dirección en la que esta viendo el actor se da ubicación al Tiro para que parezca que esta saliendo de la jeringa.
                  tiro.setRotation(180); 
                  tiro.setLocation(getX()-50, getY()-10);
                }
            }
            private void animate() //se identifica hacia que dirección esta viendo el actor.
            {
               if (Greenfoot.isKeyDown("left")) facingLeft = true;
               if (Greenfoot.isKeyDown("right")) facingLeft = false;
            }
            public boolean isOnLadder() //se identifica si el actor esta sobre una escalera
            {
                return isTouching(escalera.class);
            
            }
            private void disparoanim() //se da la animación cuando el jugador dispara una vacuna
            {
                if (disparoani) {
                    if(facingLeft){
                    myGif = disparoL;}
                    else{
                        myGif = disparoR;
                    }
                    if (paused>0){paused--;}
                    else{
                    disparoani = false;
                    paused = 15;
                }
                }
            } 
            private void hitCovid() //Se identifica cuando el jugador toca con un COVID
            {
                Actor covid = getOneIntersectingObject(covid.class);
                if(covid != null)
                    {covidtocar = true;
                        cancion.setVolume(0);
            }
            
    }
    private void muerte() //Cuando el usuario toca un Covid se crea al actor GameOver.
    {
        myGif = morir;
        if (pausem>0){pausem--;} //contador de actos para que se vea la animación de muerte del actor.
        else{
        World myWorld = getWorld();
        myWorld.removeObject(this);
        GameOver gameover = new GameOver();
        myWorld.addObject(gameover, myWorld.getWidth()/2, myWorld.getHeight()/2);
    }
    }
        public void aparecer() //Cuando todos los COVIDs son vencidos se crea la puerta para cambiar de nivel, dependiendo del nivel se da una ubicación.
    {
        if (getWorld().getObjects(covid.class).isEmpty()){
            if (getWorld() instanceof Hospital){
            getWorld().addObject(new puerta_cerrar(),91,685);}
            if (getWorld() instanceof Hospital2){
            getWorld().addObject(new puerta_cerrar(),91,161);}
            if (getWorld() instanceof Hospital3){
            getWorld().addObject(new puerta_cerrar(),91,685);}
        }
    }
    public void canciones() //función para dar musica de fondo a los niveles.
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
    private void hitPuerta() //Cuando el actor toque la puerta para cambiar de nivel, se para la musica.
    {
        Actor puerta_cerrar = getOneIntersectingObject(puerta_cerrar.class);
        if(puerta_cerrar != null)
            {
                cancion.setVolume(0);
        }
    }
}

