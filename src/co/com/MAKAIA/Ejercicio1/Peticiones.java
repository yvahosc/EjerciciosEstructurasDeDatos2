package co.com.MAKAIA.Ejercicio1;

import java.util.Scanner;

public class Peticiones {
    public static String pedirTexto(String mensaje){
        Scanner scannerString = new Scanner(System.in);
        System.out.println(mensaje);
        String valorIngresado = scannerString.nextLine();
        //scannerString.close();
        return valorIngresado;
    }

    public static int pedirNumeroEntero(String mensaje){
        Scanner scannerInt = new Scanner(System.in);
        System.out.println(mensaje);
        int valorIngresado = scannerInt.nextInt();
        //scannerInt.close();
        return valorIngresado;
    }

}
