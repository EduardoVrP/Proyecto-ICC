//ENCABEZADO
/**
 * Clase para mandar errores de movimientos invalidos
 * 
 * @author Eduardo Vargas Perez
 * @version 1.0
 **/
public class MovimientoInvalido extends Exception {

    //CUERPO
    //No hay atributos

    //Comportamiento
    //Constructores
    /**
     * Constructor con parametros, recibe el mensaje de error
     *
     * @param mensaje El mensaje de error
     **/
    public MovimientoInvalido(String mensaje){
	super(mensaje);
    }

    /**
     * Constructor sin parametros
     *
     **/
    public MovimientoInvalido(){
	super();
    }
    
}
