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
                case 3->Mostrar_estacionamiento();
                case 7->continuaMenu=false;

                default-> System.out.println("Opcion invalida");
            }
        }
        while(continuaMenu);
    }

    private static void opcion1(){

}

private static void Mostrar_estacionamiento()
{
    String[][] parqueo = new String[11][11];
    for(int i=0; i<=10;i++) {
        for (int j = 0; j <= 10; j++) {

            //Se agrega la numeracion requerida en la fila 0
            if ((i == 0) && (j >= 2) && (j <= 9)) {
                for (int k = 2; k <= 9; k++) {
                    parqueo[i][k] = String.valueOf(k-1);}
            }

            //Se agrega la numeracion requerida en la columna 0
            else if ((j==0) && i>=2 && i<=9){
                for (int k = 2; k <= 9; k++) {
                    parqueo[k][j] = String.valueOf(k-1);
                }

                //Si el espacio del parqueo esta vacio desde la columna 2 y fila 2, se agrega L indicando que esta vacio
            } else if (i>=2 && i<=9 && j>=2 && j<=9 && parqueo[i][j]==null) {
                parqueo[i][j]="L";

                //Si el espacio del parqueo esta ocupado desde la columna 2 y fila 2, se agrega A indicando que esta ocupado
            } else if (i>=2 && i<=9 && j>=2 && j<=9 && parqueo[i][j]!=null) {
                parqueo[i][j]="A";
                //Se agregan los signos igual alrededor del parqueo
            } else if (i>=1 && j>=1 && i<=10 && j<=10) {
                parqueo[i][j]="=";

            } else if (parqueo[i][j]==null) {

                parqueo[i][j]=" ";
            }

        }
    }
    //Impresion del tablero
    for(int i=0; i<=10; i++){
        for(int j=0; j<=10;j++){
            System.out.print(parqueo[i][j]+" ");
            if(j>=10)
                System.out.println(" ");

        }
    }

}}
