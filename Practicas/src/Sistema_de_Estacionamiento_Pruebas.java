import java.util.Scanner;

public class Sistema_de_Estacionamiento_Pruebas {
    public static void main(String[]args){
        var consola = new Scanner(System.in);
        boolean continuaMenu=true;
        do{
            System.out.print("""
                ===SISTEMA DE ESTACIONAMIENTO===
                1. Ingresar vehiculo
                2. Retirar vehiculo
                3. Mostrar estacionamiento
                4. Buscar vehiculo por placa
                5. Mostrar ruta mas corta entre entrada y salida
                6. Mostrar ingresos 
                7. Salir
                Elija una opcion: """);
           int opcion=consola.nextInt();
            switch (opcion){
                case 1->opcion1();
                case 7->continuaMenu=false;

                default-> System.out.println("Opcion invalida");
            }
        }
        while(continuaMenu);
    }

    private static void opcion1(){

}}
