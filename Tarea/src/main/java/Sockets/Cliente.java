
package Sockets;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * Cliente representa al cliente del socket y hilo
 * @author Roger Solano
 */
public class Cliente implements Runnable {
    
    private int puerto;
    private String mensaje;
/**
 * Crea un puerto para el cliente 
 * @param puerto puerto
 * @param mensaje String mensaje
 */
    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;

    }

    @Override
    public void run() {
        //Host del servidor
        final String HOST = "127.0.0.1";
        //Puerto del servidor
        DataOutputStream out;

        try {
            //Se crea el socket para conectarse con el cliente
            Socket sc = new Socket(HOST, puerto);

            out = new DataOutputStream(sc.getOutputStream());
            
            System.out.println(mensaje);
            
            //Envio un mensaje al cliente
            out.writeUTF(mensaje);
            
            //Cierro el socket
            sc.close();

        } catch (IOException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
