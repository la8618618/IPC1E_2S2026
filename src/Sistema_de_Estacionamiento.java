import java.util.Scanner;

public class Sistema_de_Estacionamiento {
   public static void main(String[]args)  {

      menu();






    }
    private static void menu(){
        boolean continuaMenu = true;
        do{
            System.out.print("""
                   ==== SISTEMA DE ESTACIONAMIENTO ===
                   1. Ingresar vehiculo
                   2. Retirar vehiculo
                   3. Mostrar estacionamiento
                   4. Buscar vehiculo por placa
                   5. Mostrar ruta más corta entre entrada y salida
                   6. Mostrar ingresos
                   7. Salir 
                   Seleccione la opcion que desee: """);
            var consola = new Scanner(System.in);
            int opcion = consola.nextInt();

            if(opcion == 7){
                continuaMenu=false;
            }

        }
        while(continuaMenu);
    }
}
