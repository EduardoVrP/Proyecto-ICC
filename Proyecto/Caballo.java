//ENCABEZADO
/**
 * Clase para representar caballos en el ajedrez
 *
 * @author Eduardo Vargas Perez
 * @version 1.0
 * @see Clase Pieza
 **/
public class Caballo extends Pieza{
    //CUERPO

    //Estructura
    //La misma que en clase Pieza

    //Comportamiento

    //Metodos constructores
    /**
     * Constructor con parametros, recibe todas las caracteristicas
     * para crear al Caballo
     *
     * @param color El valor boolean del color
     * @param x La coordenada x
     * @param y La coordenada y
     **/
    public Caballo(boolean color, int x, int y){
	super(color,x,y);
	this.vacia = false;
    }

    /**
     * Constructor sin parametros, crea un Caballo blanco
     *
     **/
    public Caballo(){
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
	//Los caballos se mueven en "L"

	//Para validar el movimiento del caballo corroborare que
	// uno el incremento en un eje sea de 2 y en el otro
	// de 1

	int incrementoX = Math.abs(x2 - this.x);
	int incrementoY = Math.abs(y2 - this.y); //Me interesa el valor absoluto en ambos

	if(incrementoX == 2 && incrementoY == 1){
	    this.setX(x2);
	    this.setY(y2);
	}else if(incrementoY == 2 && incrementoX == 1){
	    this.setX(x2);
	    this.setY(y2);
	}else{
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de mover
    
    /**
     * Metodo para comer piezas
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si no se mueve de forma correcta
     **/
    @Override
    public void comer(int x2, int y2) throws MovimientoInvalido{
	//Los caballos comen como se mueven

	//Para validar el movimiento del caballo corroborare que
	// uno el incremento en un eje sea de 2 y en el otro
	// de 1

	int incrementoX = Math.abs(x2 - this.x);
	int incrementoY = Math.abs(y2 - this.y); //Me interesa el valor absoluto en ambos

	if(incrementoX == 2 && incrementoY == 1){
	    this.setX(x2);
	    this.setY(y2);
	}else if(incrementoY == 2 && incrementoX == 1){
	    this.setX(x2);
	    this.setY(y2);
	}else{
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de comer

    //Metodos especiales
    /**
     * Metodo toString
     *
     * @return "C" si es blanca, "c" si es negra
     **/
    @Override
    public String toString(){
	if(this.color){
	    return "C";
	}else{
	    return "c";
	}
    }//Fin de toString

}//Fin de la clase Caballo
