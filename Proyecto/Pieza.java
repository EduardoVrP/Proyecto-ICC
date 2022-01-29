//ENCABEZADO
/**
 * Clase que modela piezas del juego de extincion,
 * variante del ajedrez
 *
 * @author Eduardo Vargas Pérez
 * @version 1.0
 **/
public abstract class Pieza{
    //CUERPO

    //Estructura(Atributos)
    //Representa el color true si es blanca/ false si es negra 
    protected boolean color;
    //Representa la coordenada x del tablero donde se encuentra la pieza
    protected int x;
    //Representa la coordenada x del tablero donde se encuentra la pieza
    protected int y;
    //Representa si es vacia o no
    protected boolean vacia;
    
    //Comportamiento (Métodos)

    //Constructores

    /**
     * Constructor con parametros, recibe todas las caracteristicas
     *
     * @param color El valor boolean del color
     * @param x La coordenada x
     * @param y La coordenada y
     **/
    public Pieza(boolean color, int x, int y){
	this.color = color;
	this.x = x;
	this.y = y;
    }//Fin primer constructor
    
    /**
     * Constructor sin parametros, crea una pieza blanca
     *
     **/
    public Pieza(){
	this.color = true;
    }//FIn constructor sin parametros

    //Metodos modificadores
    /**
     * Metodo para cambiar el color de una pieza
     *
     * @param color El nuevo color, true si es blanca, false si es negra
     **/
    public void setColor(boolean color){
	this.color = color;
    }//Fin setColor

    /**
     * Metodo para cambiar la coordenada x de una pieza
     *
     * @param x La nueva coordenada
     **/
    public void setX(int x){
	this.x = x;
    }//Fin setX

    /**
     * Metodo para cambiar la coordenada y de una pieza
     *
     * @param y La nueva coordenada
     **/
    public void setY(int y){
	this.y = y;
    }//Fin setY
    
    /**
     * Metodo para cambiar si una pieza es vacia
     *
     * @param vacia Valor boolean dependiendo si es vacia
     **/
    public void setVacia(boolean vacia){
	this.vacia = vacia;
    }//Fin setVacia
    
    //Metodos observadores
    /**
     * Metodo para conocer el color de la pieza
     *
     * @return El color de la pieza (true es blanca, false es negra)
     **/
    public boolean getColor(){
	return this.color;
    }//Fin getColor

    /**
     * Metodo para conocer la coordenada x donde esta la pieza
     *
     * @return La coordenada x
     **/
    public int getX(){
	return this.x;
    }//Fin getX

    /**
     * Metodo para conocer la coordenada y donde esta la pieza
     *
     * @return La coordenada y
     **/
    public int getY(){
	return this.y;
    }//Fin getY

    /**
     * Metodo para conocer si una pieza es vacia
     *
     * @return Valor boolean dependiendo si la pieza es vacia
     **/
    public boolean getVacia(){
	return this.vacia;
    }//Fin getVacia
    
    //Metodos calculadores
    
    /**
     * Metodo abstracto para mover la pieza
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si se hace un movimiento invalido
     **/
    public abstract void mover(int x2, int y2) throws MovimientoInvalido;

    /**
     * Metodo abstracto para comer piezas
     *
     * @param x2 La coordenada x a donde mover
     * @param y2 La coordenada y a donde mover
     * @throws Ocurre un error si no se come de forma correcta
     **/
    public abstract void comer(int x2, int y2) throws MovimientoInvalido;    

    //Metodos especiales
    /**
     * Metodo equals. Permite saber si dos piezas son iguales
     *
     * @param p La contra la que se va a comparar 
     * @return Un valor boolean, true si son iguales, false en otro caso
     **/
    public boolean equals(Object p){
	Pieza q = (Pieza) p;
	return this.color == q.getColor() && this.x == q.getX() && this.y == q.getY() && this.vacia == q.getVacia();
    }//Fin de equals

    /**
     * Metodo toString
     *
     * @return La pieza en mayuscula si es blanca, si
     *         es negra en minuscula
     **/
    public abstract String toString();

}//Fin de la clase Pieza
