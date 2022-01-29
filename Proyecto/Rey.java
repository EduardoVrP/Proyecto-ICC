//ENCABEZADO
/**
 * Clase para representar al Rey en el ajedrez
 *
 * @author Eduardo Vargas Perez
 * @version 1.0
 * @see Clase Pieza
 **/

public class Rey extends Pieza{
    //CUERPO

    //Estructura
    //La misma que la clase Pieza

    //Comportamiento
    //Metodos constructores
    /**
     * Constructor con parametros, recibe todas las caracteristicas
     * para crear al Rey
     *
     * @param color El valor boolean del color
     * @param x La coordenada x
     * @param y La coordenada y
     **/
    public Rey(boolean color, int x, int y){
	super(color,x,y);
	this.vacia = false;
    }

    /**
     * Constructor sin parametros, crea un Rey blanco
     *
     **/
    public Rey(){
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
	//El rey se puede mover solo una casilla en cualquier direccion
	
	//Para los movimientos en diagonal vere que ambos incrementos sean 1

	int incrementoX = Math.abs(x2 - this.x);
	int incrementoY = Math.abs(y2 - this.y); //Me interesa el valor absoluto en ambos

	//Primero los movimientos rectos
	if(this.x == x2 && (y2 == this.y - 1 || y2 == this.y + 1)){
	    this.setY(y2);
	}else if(this.y == y2 && (x2 == this.x - 1 || x2 == this.x + 1)){
	    this.setX(x2);
	}else if(incrementoX == 1 && incrementoY == 1){//Para los movimientos diagonales
	    this.setX(x2);
	    this.setY(y2);
	}else{
	    //Si no es ninguno de los tres casos es invalido
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
	//El rey puede comer como se mueve
	
	//Para los movimientos en diagonal vere que ambos incrementos sean 1

	int incrementoX = Math.abs(x2 - this.x);
	int incrementoY = Math.abs(y2 - this.y); //Me interesa el valor absoluto en ambos

	//Primero los movimientos rectos
	if(this.x == x2 && (y2 == this.y - 1 || y2 == this.y + 1)){
	    this.setY(y2);
	}else if(this.y == y2 && (x2 == this.x - 1 || x2 == this.x + 1)){
	    this.setX(x2);
	}else if(incrementoX == 1 && incrementoY == 1){//Para los movimientos diagonales
	    this.setX(x2);
	    this.setY(y2);
	}else{
	    //Si no es ninguno de los tres casos es invalido
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de comer

    //Metodos especiales
    /**
     * Metodo toString
     *
     * @return "R" si es blanca, "r" si es negra
     **/
    @Override
    public String toString(){
	if(this.color){
	    return "R";
	}else{
	    return "r";
	}
    }//Fin de toString
    
}//Fin de la clase Rey
