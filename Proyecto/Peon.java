//ENCABEZADO
/**
 * Clase que modela peones para el ajedrez,
 * hereda de Pieza
 *
 * @author Eduardo Vargas Perez
 * @version 1.0
 * @see Clase Pieza
 **/
public class Peon extends Pieza{
    //CUERPO
    
    //Estructura
    // Misma estructura que Pieza

    //Comportamiento

    //Metodos constructores
    /**
     * Constructor con parametros, recibe todas las caracteristicas
     *
     * @param color El valor boolean del color
     * @param x La coordenada x
     * @param y La coordenada y
     **/
    public Peon(boolean color, int x, int y){
	super(color,x,y);
	this.vacia = false;
    }

    /**
     * Constructor sin parametros, crea un peon blanco
     *
     **/
    public Peon(){
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
	//El peon solo puede avanzar una casilla hacia adelante
	//Las negras avanzan hacia arriba
	if(!(this.color) && this.x == x2 && y2 == this.y - 1){
	    this.setY(y2);
	    //Las blancas avanzan hacia abajo
	} else if(this.color && this.x == x2 && y2 == this.y + 1){
	    this.setY(y2);
	} else{
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
	//El peon come en diagonal y una sola casilla
	if(!(this.color)){//Si el peon es negro come hacia arriba
	    if((y2 == this.y -1) && (x2 == this.x - 1 || x2 == this.x + 1)){
		this.setY(y2);
		this.setX(x2);
	    } else{
		throw new MovimientoInvalido("Movimiento invalido");
	    }//Fin del blanco
	}else if(this.color){//Si el peon es blanco come hacia abajo
	    if((y2 == this.y + 1) && (x2 == this.x - 1 || x2 == this.x + 1)){
		this.setY(y2);
		this.setX(x2);
	    }else{
		throw new MovimientoInvalido("Movimiento invalido");
	    } 
	}//Fin del peon negro
    }//Fin de comer

    //Metodos especiales
    /**
     * Metodo toString
     *
     * @return "P" si es blanca, "p" si es negra
     **/
    @Override
    public String toString(){
	if(this.color){
	    return "P";
	}else{
	    return "p";
	}
    }//Fin de toString
}//Fin de clase Peon
