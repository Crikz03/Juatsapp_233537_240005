/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excepciones;

/**
 *
 * @author eljulls
 */
public class ConexionException extends RuntimeException {

    /**
     * Creates a new instance of <code>ConexionException</code> without detail
     * message.
     */
    public ConexionException() {
    }

    public ConexionException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructs an instance of <code>ConexionException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ConexionException(String msg) {
        super(msg);
    }
}
