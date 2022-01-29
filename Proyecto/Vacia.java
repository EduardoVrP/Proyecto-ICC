//ENCABEZADO
/**
 * Clase para representar los espacios en blanco
 * del tablero de ajedrez mediante una pieza
 * vacia
 *
 * @author Eduardo Vargas Pérez 
 * @version 1.0
 **/
public class Vacia extends Pieza{
    //CUERPO
    //Estructura
    //La misma que Pieza

    //Comportamiento
    
    //Constructores
    /**
     * Constructor con parametros. Crea una pieza vacia
     *
     * @param color El color de la pieza
     * @param x La coordenada x de la pieza
     * @param y La coordenada y de la pieza
     **/
    public Vacia(boolean color, int x, int y){
	super(color,x,y);
	this.vacia = true;
    }

    //Metodos calculadores
    /**
     * Metodo para mover la pieza, en realidad no
     * se pueden mover las piezas vacias
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si se hace un movimiento invalido
     **/
    @Override
    public void mover(int x2, int y2) throws MovimientoInvalido{
	if( x != x2 || y != y2){
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de mover
    
    /**
     * Metodo para comer, en realidad no
     * se pueden mover las piezas vacias
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si se hace un movimiento invalido
     **/
    @Override
    public void comer(int x2, int y2) throws MovimientoInvalido{
	if( x != x2 || y != y2){
	    throw new MovimientoInvalido("Movimiento invalido");
	}
    }//Fin de comer

    //Metodos especiales
    /**
     * Metodo toString
     *
     * @return Un asterisco
     **/
    @Override
    public String toString(){
	return "-";
    }
}
