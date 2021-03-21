/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebaspsp;

import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

/**
 *
 * @author Raúl
 */
public class PruebasPsp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        
        usoInetAdress();
        
        
    }
    
    public static void usoInetAdress() throws UnknownHostException{
        
        InetAddress direccion = InetAddress.getLocalHost();
        
        System.out.println(direccion);
        
        direccion = InetAddress.getByName("linkiafp.es");
        
        System.out.println(direccion);
        
        direccion = InetAddress.getByName("marca.com");
        
        System.out.println(direccion);
        
        InetAddress sw[] = InetAddress.getAllByName("nba.com");
        
        for(InetAddress i:sw){
            
            System.out.println(i);
        }
    }
    
  
}
