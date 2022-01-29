//ENCABEZADO
/**
 * Clase que representa a la Reina/Dama en el ajedrez
 *
 * @author Eduardo Vargas Perez
 * @version 1.0
 * @see Clase Pieza
 **/
public class Dama extends Pieza{
    //CUERPO

    //Estructura
    //La misma que clase pieza

    //Comportamiento

    //Metodos constructores
    /**
     * Constructor con parametros, recibe todas las caracteristicas
     * para crear a la Reina
     *
     * @param color El valor boolean del color
     * @param x La coordenada x
     * @param y La coordenada y
     **/
    public Dama(boolean color, int x, int y){
	super(color,x,y);
	this.vacia = false;
    }

    /**
     * Constructor sin parametros, crea una Dama blanca
     *
     **/
    public Dama(){
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
	//La reina puede avanzar en lineas rectas o en diagonales
	
	//Para los movimientos en diagonal vere que el incremento en x
	//    sea igual al incremento en y

	int incrementoX = Math.abs(x2 - this.x);
	int incrementoY = Math.abs(y2 - this.y); //Me interesa el valor absoluto en ambos

	//Primero los casos de las lineas rectas
	if(this.x == x2){
	    this.setY(y2);
	}else if(this.y == y2){
	    this.setX(x2);
	}else if(incrementoX == incrementoY){//Para moverse en diagonal
	    this.setX(x2);
	    this.setY(y2);
	}else {
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
	//La reina puede comer en lineas rectas o en diagonales
	
	//Para los movimientos en diagonal vere que el incremento en x
	//    sea igual al incremento en y
	
	int incrementoX = Math.abs(x2 - this.x);
	int incrementoY = Math.abs(y2 - this.y); //Me interesa el valor absoluto en ambos
	
	//Primero los casos de las lineas rectas
	if(this.x == x2){
	    this.setY(y2);
	}else if(this.y == y2){
	    this.setX(x2);
	}else if(incrementoX == incrementoY){//Para comer en diagonal
	    this.setX(x2);
	    this.setY(y2);
	}else {
	    //Si no es ninguno de los tres casos es invalido
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de comer

    //Metodos especiales
    /**
     * Metodo toString
     *
     * @return "D" si es blanca, "d" si es negra
     **/
    @Override
    public String toString(){
	if(this.color){
	    return "D";
	}else{
	    return "d";
	}
    }//Fin de toString
    
}//Fin de la clase
