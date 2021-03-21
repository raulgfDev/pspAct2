package act2_ej2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Raúl
 */
public class ServidorJuego {
    
    private static ServerSocket servidorSocket;
    private static String datosViajeros;
    private static int numeroAleatorio;
    private static int contador = 0;
    
    public static void main(String[] args) {
        
        numeroAleatorio = (int) (Math.random() * 100);
        
        try {
            
            servidorSocket = new ServerSocket();
            
            System.out.println("Servidor de Juego-ONLINE");
            System.out.println("Esperando conexion...");
            
            InetSocketAddress direccion = new InetSocketAddress("localhost", 5050);
            
            servidorSocket.bind(direccion);
            
            Socket socket = servidorSocket.accept();
            
            System.out.println("Conexion Establecida");
            System.out.println("Juego de adivinar el numero magico");
            System.out.println("------------------------------------");
            
            //mediante esta clase se emite la info (datosViajeros) al cliente
            PrintStream emisor = new PrintStream(socket.getOutputStream(), true);
            
            //mediante esta clase se recibe la info (datosViajeros) del cliente
            BufferedReader receptor = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            
            do {   
                
                //metodo receptor
                datosViajeros = receptor.readLine();

                datosViajeros = algoritmo(datosViajeros);
                
                //metodo emisor
                emisor.println(datosViajeros);
                
            } while (!datosViajeros.startsWith("CORRECTO") && datosViajeros != null);
            
            System.out.println("FIN");
            socket.close();
            servidorSocket.close();
            
        } catch (Exception e) {
            
            System.out.println(e.getMessage());
            
        }
    }
    
    public static String algoritmo (String entrada){
        
        contador++;
        
        int comparar = Integer.parseInt(entrada);
        
        String salida = null;
       
        if (comparar == numeroAleatorio) {
            
            salida = "CORRECTO, has necesitado " + contador + " intentos.";
            
        }else if(comparar > numeroAleatorio){
            
            salida = comparar + " es mayor que el numero magico";
            
        }else{
            
            salida = salida = comparar + " es menor que el numero magico";
        }
        
        return salida;
    }
    
}
