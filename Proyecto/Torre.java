//ENCABEZADO
/**
 * Clase que representa a la torre en el juego del ajedrez
 *
 * @author Eduardo Vargas Perez
 * @version 1.0
 * @see Clase Pieza
 **/

public class Torre extends Pieza{
    //CUERPO

    //Estructura
    //La misma que en clase Pieza

    //Comportamiento

    //Metodos constructores
    /**
     * Constructor con parametros, recibe todas las caracteristicas
     * para crear la torre
     *
     * @param color El valor boolean del color
     * @param x La coordenada x
     * @param y La coordenada y
     **/
    public Torre(boolean color, int x, int y){
	super(color,x,y);
	this.vacia = false;
    }

    /**
     * Constructor sin parametros, crea una Torre blanca
     *
     **/
    public Torre(){
	super();
	this.vacia = false;
    }

    //Metodos calculadores
    /**
     * Metodo para mover piezas
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si no se mueve de forma correcta
     **/
    @Override
    public void mover(int x2, int y2) throws MovimientoInvalido{
	//La torre solo avanza en lineas rectas
	if(this.x == x2){
	    this.setY(y2);
	}else if(this.y == y2){
	    this.setX(x2);
	}else{
	    //Si no es ninguno de los dos casos es invalido
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de mover

    /**
     * Metodo para comer piezas
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si no se come de forma correcta
     **/
    @Override
    public void comer(int x2, int y2) throws MovimientoInvalido{
	//La torre come en lineas rectas
	if(this.x == x2){
	    this.setY(y2);
	}else if(this.y == y2){
	    this.setX(x2);
	}else{
	    //Si no es ninguno de los dos casos es invalido
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de comer

    //Metodos especiales
    /**
     * Metodo toString
     *
     * @return "T" si es blanca, "t" si es negra
     **/
    @Override
    public String toString(){
	if(this.color){
	    return "T";
	}else{
	    return "t";
	}
    }//Fin de toString
    
}//Fin de la clase Torre
