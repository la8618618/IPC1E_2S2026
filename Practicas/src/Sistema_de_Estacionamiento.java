import java.util.Scanner;

public class   Sistema_de_Estacionamiento{
    static String[][] parqueo = new String[11][11];
    static double tarifa = 10;
    static double Monto;
    static int vehiculosPagaron = 0;
    static double ingresos=0;
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
                case 2->Retirar_vehiculo();
                case 3->Mostrar_estacionamiento();
                case 4->Buscar_vehiculo();
                case 6->Mostrar_ingresos();
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
            System.out.println("Ingrese la fila (del 1 al 8): ");
            var fila = consola.nextInt();
            System.out.println("Ingrese la colunma (del 1 al 8)");
            var columna = consola.nextInt();
            if(fila>=1 && fila<=8 && columna>=1 && columna<=8){
                do {
                    System.out.println("Ingrese la tarifa (Q10.00) ");
                    Monto = consola.nextDouble();
                }
                while(Monto<10);
                var cambio = Monto-tarifa;
                System.out.println("""
                   Placa: %s
                   Fila: %d
                   Columna: %d
                   Tarifa: Q %.2f
                   Monto Ingresado: Q %.2f
                   Cambio: Q %.2f
                   Vehiculo Ingresado Correctamente
                 
                   """.formatted(placa, fila, columna, tarifa, Monto,cambio));
                parqueo[fila+1][columna+1]=placa;
                vehiculosPagaron++;
                ingresos += 10;
            }
            else{
                System.out.println("La fila y la columna que  ingreso son invalidas");
                return;
            }

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
                }

                else if (parqueo[i][j] == null) {

                    parqueo[i][j] = " ";
                }


            }
        }


    }
    //Opcion Mostrar estacionamiento
    private static void Mostrar_estacionamiento() {

        estacionamiento();

        // Números de las columnas
        System.out.print("    ");

        for (int j = 2; j <= 9; j++) {
            System.out.print(parqueo[0][j] + " ");
        }

        System.out.println();

        // Filas del estacionamiento
        for (int i = 2; i <= 9; i++) {

            System.out.print(parqueo[i][0] + " = ");

            for (int j = 2; j <= 9; j++) {

                if (parqueo[i][j].equals("L")) {
                    System.out.print("L ");
                } else {
                    System.out.print("A ");
                }
            }

            System.out.println("=");
        }

        // Iguales de abajo
        System.out.print("  ");

        for (int j = 1; j <= 10; j++) {
            System.out.print("= ");
        }

        System.out.println();
    }
    private static void Retirar_vehiculo() {

        var consola = new Scanner(System.in);

        System.out.println("Ingrese la placa del vehiculo que desea retirar: ");
        var placa = consola.nextLine();

        // Validar que la placa tenga 7 caracteres
        if (placa.length() != 7) {
            System.out.println("Placa invalida");
            return;
        }

        var numeros = placa.substring(1, 4);
        var mayusculas = placa.substring(4, 7);

        // Validar que inicie con P
        if (placa.charAt(0) != 'P') {
            System.out.println("Placa invalida, no inicia con P");
            return;
        }

        // Validar los tres numeros
        if (!numeros.matches("\\d+")) {
            System.out.println("Placa invalida, no tiene los tres digitos correspondientes.");
            return;
        }

        // Validar las letras mayusculas
        if (!mayusculas.equals(mayusculas.toUpperCase())) {
            System.out.println("Placa invalida, los ultimos caracteres no estan en mayusculas");
            return;
        }

        // Buscar la placa
        for (int i = 2; i <= 9; i++) {

            for (int j = 2; j <= 9; j++) {

                if (parqueo[i][j] != null && parqueo[i][j].equals(placa)) {

                    // Mostrar ubicación
                    System.out.println("""
                        Vehiculo encontrado.
                        Placa: %s
                        Fila: %d
                        Columna: %d
                        """.formatted(placa, i - 1, j - 1));

                    // Liberar espacio
                    parqueo[i][j] = "L";

                    return;
                }
            }
        }

        // Si terminó los ciclos sin encontrar la placa
        System.out.println("El vehiculo con placa " + placa + " no existe en el estacionamiento.");
    }
    //METODO PARA MOSTRAR INGRESOS
    private static void Mostrar_ingresos() {

        System.out.println("""
            
            === INGRESOS DEL ESTACIONAMIENTO ===
            Vehiculos que realizaron el pago: %d
            Total recaudado: Q %.2f
            """.formatted(vehiculosPagaron, ingresos));
    }
//METODO PARA BUSCAR VEHICULO
    private static void Buscar_vehiculo() {

        var consola = new Scanner(System.in);

        System.out.println("Ingrese la placa del vehiculo: ");
        var placa = consola.nextLine();

        // Validar longitud
        if (placa.length() != 7) {
            System.out.println("Placa invalida");
            return;
        }

        var numeros = placa.substring(1, 4);
        var mayusculas = placa.substring(4, 7);

        // Validar que inicie con P
        if (placa.charAt(0) != 'P') {
            System.out.println("Placa invalida, no inicia con P");
            return;
        }

        // Validar los tres numeros
        if (!numeros.matches("\\d+")) {
            System.out.println("Placa invalida, no tiene los tres digitos correspondientes.");
            return;
        }

        // Validar las letras mayusculas
        if (!mayusculas.equals(mayusculas.toUpperCase())) {
            System.out.println("Placa invalida, los ultimos caracteres no estan en mayusculas");
            return;
        }

        // Buscar la placa en el estacionamiento
        for (int i = 2; i <= 9; i++) {

            for (int j = 2; j <= 9; j++) {

                if (parqueo[i][j] != null && parqueo[i][j].equals(placa)) {

                    System.out.println("""
                        
                        Vehiculo encontrado.
                        Placa: %s
                        Fila: %d
                        Columna: %d
                        """.formatted(placa, i - 1, j - 1));

                    return;
                }
            }
        }

        // Si no se encontró
        System.out.println("El vehiculo con placa " + placa +
                " no se encuentra en el estacionamiento.");
    }

}