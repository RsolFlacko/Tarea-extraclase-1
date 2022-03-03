/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class Servidor extends Observable implements Runnable{
    
    private int puerto;

    public Servidor(int puerto){
        this.puerto = puerto;
    }

    @Override
    public void run() {
       
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;

        try{
            //Creamos el socket del servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado");

            // Estará siempre atento a escuchar peticiones
            while (true) {

                //Esperamos al cliente
                try {
                    sc = servidor.accept();

                    System.out.println("Cliente conectado");
                    in = new DataInputStream(sc.getInputStream());

                    //Leo el mensaje que envia
                    String mensaje = in.readUTF();

                    System.out.println(mensaje);

                    this.setChanged();
                    this.notifyObservers(mensaje);
                    this.clearChanged();

                    //Cierro el socket
                    sc.close();
                    System.out.println("Cliente desconectado");
                }
                catch (IOException ex) {
                    Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    
}       catch (IOException ex) {
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }}}
