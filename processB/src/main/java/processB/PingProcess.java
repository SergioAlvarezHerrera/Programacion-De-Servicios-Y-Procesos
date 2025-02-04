package processB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PingProcess {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
       
        System.out.print("Ingrese una dirección web (ejemplo: www.google.com): ");
        String direccionWeb = scanner.nextLine();
        
        
        ProcessBuilder processBuilder = new ProcessBuilder("ping", direccionWeb);
        
        try {
            
            Process process = processBuilder.start();
            
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            
       
            int exitCode = process.waitFor();
            System.out.println("El comando terminó con el código de salida: " + exitCode);
            
        } catch (IOException e) {
            System.err.println("Error al ejecutar el comando: " + e.getMessage());
        } catch (InterruptedException e) {
            System.err.println("El proceso fue interrumpido: " + e.getMessage());
            Thread.currentThread().interrupt(); 
        } finally {
            scanner.close(); 
        }
    }
}
