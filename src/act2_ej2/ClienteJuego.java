package act2_ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;


/**
 *
 * @author Raúl
 */
public class ClienteJuego {
    
    private static Socket socket;
    
    private static String datosViajeros;
    
    public static void main(String[] args) {
      
         socket = new Socket();
       
        InetSocketAddress direccion = new InetSocketAddress("localhost", 5050);
        
        try {
            
            socket.connect(direccion);
            
            System.out.println("CONECTADO!!!");
            
            //mediante esta clase se emite la info (datosViajeros) al servidor
            PrintStream emisor = new PrintStream(socket.getOutputStream(), true);
            
            //mediante esta se recibe la info (datosViajeros) del servidor
            BufferedReader receptor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            //para leer entrada por consola
            BufferedReader entradaUsuario = new BufferedReader(new InputStreamReader(System.in));
            
            System.out.println("Adivina el numero magico  entre 0 y 100");
            
            do { 
                
                datosViajeros = entradaUsuario.readLine();
                
                //metodo emisor
                emisor.println(datosViajeros);
                emisor.flush();
                
                //metodo receptor
                datosViajeros = receptor.readLine();

                System.out.println(datosViajeros + "\n");
              
            } while (!datosViajeros.startsWith("CORRECTO") && datosViajeros != null);
            
            System.out.println("FIN");
            socket.close();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
        }
    }
    
}
