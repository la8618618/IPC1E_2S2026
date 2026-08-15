import java.util.Scanner;

public class   Sistema_de_Estacionamiento{
    static String[][] parqueo = new String[11][11];
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
                case 1->Ingresar_vehiculo();
                case 3->Mostrar_estacionamiento();
                case 7->continuaMenu=false;

                default-> System.out.println("Opcion invalida");
            }
        }
        while(continuaMenu);
    }

    //METODO PARA INGRESAR VEHICULO
    private static void Ingresar_vehiculo(){
        var consola = new Scanner(System.in);
        System.out.println("Ingrese la placa: ");
        var placa = consola.nextLine();


        //Se realizan las validaciones correspondientes de la placa
        //Si la placa tiene menos o mas de 7 caracteres se invalida
        if(placa.length()<7 || placa.length()>7){
            System.out.println("Placa invalida");
            //Si la placa no inicia con P mayuscula, se invalida
            return;
        }
        var numeros = placa.substring(1,4);
        var mayusculas = placa.substring(4,7);

        if (placa.charAt(0)!= 'P') {
            System.out.println("Placa invalida no inicia con P");
        }
        //Si la placa luego de la P no tiene 3 digitos del 0 al 9 se invalida
        else if (!numeros.matches("\\d+")) {

            System.out.println("Placa invalida, no tiene los tres digitos correspondientes.");
            //Si los ultimos caracteres de la placa son minusculas, se invalida igualmente
        }else if(!mayusculas.equals(mayusculas.toUpperCase())){

            System.out.println("Placa invalida, los ultimos caracteres no estan en mayusculas");

        }else{
            estacionamiento();
        }



    }
//METODO PARA MOSTRAR TABLERO

    public static void estacionamiento() {

        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {

                //Se agrega la numeracion requerida en la fila 0
                if ((i == 0) && (j >= 2) && (j <= 9)) {
                    for (int k = 2; k <= 9; k++) {
                        parqueo[i][k] = String.valueOf(k - 1);
                    }
                }

                //Se agrega la numeracion requerida en la columna 0
                else if ((j == 0) && i >= 2 && i <= 9) {
                    for (int k = 2; k <= 9; k++) {
                        parqueo[k][j] = String.valueOf(k - 1);
                    }

                    //Si el espacio del parqueo esta vacio desde la columna 2 y fila 2, se agrega L indicando que esta vacio
                } else if (i >= 2 && i <= 9 && j >= 2 && j <= 9 && parqueo[i][j] == null) {
                    parqueo[i][j] = "L";

                    //Si el espacio del parqueo esta ocupado desde la columna 2 y fila 2, se agrega A indicando que esta ocupado
                } else if (i >= 2 && i <= 9 && j >= 2 && j <= 9 && parqueo[i][j] != null) {
                    parqueo[i][j] = "A";
                    //Se agregan los signos igual alrededor del parqueo
                } else if (i >= 1 && j >= 1 && i <= 10 && j <= 10) {
                    parqueo[i][j] = "=";

                } else if (parqueo[i][j] == null) {

                    parqueo[i][j] = " ";
                }


            }
        }


    }
    //Opcion Mostrar estacionamiento
    private static void Mostrar_estacionamiento(){
        estacionamiento();
//Impresion del tablero
        for (int i = 0; i <= 10; i++) {
            for (int j = 0; j <= 10; j++) {
                System.out.print(parqueo[i][j] + " ");
                if (j >= 10)
                    System.out.println(" ");

            }
        }

    }}