package lab4p1_diegomaradiaga;

import java.util.Scanner;

public class Lab4P1_DiegoMaradiaga {

    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println(">>>>>>     MENU     <<<<<<");
            System.out.println("1) Sumador binario           ");
            System.out.println("2) Contains                  ");
            System.out.println("3) Alpha                     ");
            System.out.println("4) Salida                    ");
            System.out.print("Ingrese su opcion: ");
            opcion = leer.nextInt();
            System.out.println("");

            switch (opcion) {
                case 1:
                    String cadena1, cadena2;
                    System.out.println("Ingrese el primer numero: ");
                    cadena1 = leer.next();
                    System.out.println("Ingrese el segundo numero: ");
                    cadena2 = leer.next();
                    
                    while (cadena1.length()!=cadena2.length()){
                        System.out.println("Los números deben de tener el mismo número de bits.");
                        System.out.println("Ingrese el primer numero: ");
                        cadena1 = leer.next();
                        System.out.println("Ingrese el segundo numero: ");
                        cadena2 = leer.next();
                    }//Fin while
                    
                    boolean a;
                    a = false;
                    
                    for (int i = 0; i < cadena1.length(); i++) {
                        char letra = cadena1.charAt(i);
                        int entero1 = Character.getNumericValue(letra);
                        if (entero1!=1||entero1!=0){
                            a = false;                
                        }                       
                    }//Fin for
                    if (a){
                        System.out.println("El primer numero contiene caracteres distintos de '0' y '1");
                    }
                    
                    boolean b;
                    b = false;
                    for (int i = 0; i < cadena2.length(); i++) {
                        char letra2 = cadena2.charAt(i);
                        int entero2 = Character.getNumericValue(letra2);
                        if (entero2!=1||entero2!=0){
                            b = false;                
                        }                       
                    }//Fin for
                    if (b){
                        System.out.println("El segundo numero contiene caracteres distintos de '0' y '1");
                    }
                                        
                    sumadorbinario(cadena1, cadena2);
                    
                    break;
                case 2:
                    String frase1,
                     frase2;
                    System.out.println("Ingrese la primera cadena: ");
                    leer.nextLine();
                    frase1 = leer.nextLine();
                   
                    System.out.println("Ingrese la segunda cadena: ");
                    frase2 = leer.nextLine();
                    
                    while (frase1.length()<frase2.length()){
                        System.out.println("El tamaño de la segunda cadena no puede ser mayor que el de la primera.");
                        System.out.println("Ingrese la primera cadena: ");
                        frase1 = leer.nextLine();
                   
                        System.out.println("Ingrese la segunda cadena: ");
                        frase2 = leer.nextLine();
                    }//Fin while
                   
                    contains(frase1,frase2);
                    break;
                case 3:
                    String cadena;
                    System.out.println("Ingrese la cadena que desea evaluar: ");
                    cadena = leer.next().toLowerCase();
                    alpha(cadena);
                    break;
            }//Fin switch

        } while (opcion != 4);

    }//Fin main

    public static void sumadorbinario(String cadena1, String cadena2) {
       
        String suma = "";
        char acumulador = '0';
        for (int i = cadena1.length() - 1; i >= 0; i--) {
            if (cadena1.charAt(i) == '0' && cadena2.charAt(i) == '0') {
                if (acumulador == '0') {
                    suma = "0" + suma;
                } else {
                    suma = "1" + suma;
                }//Fin else validacion 1
            } else if ((cadena1.charAt(i) == '0' && cadena2.charAt(i) == '1')
                    || (cadena1.charAt(i) == '1' && cadena2.charAt(i) == '0')) {
                if (acumulador == '0') {
                    suma = "1" + suma;
                } else {
                    acumulador = '1';
                    suma = "0" + suma;
                }//Fin else if validacion 3 y 4
            } else if ((cadena1.charAt(i) == '1' && cadena2.charAt(i) == '1')) {
                if (acumulador == '0') {
                    acumulador = '1';
                    suma = "0" + suma;
                } else {
                    suma = "1" + suma;
                }
            }//Fin else if validacion 4
        }//Fin for
        if (acumulador == '1') {
            suma = acumulador + suma;
        }
        System.out.println("La suma es: "+suma);
        System.out.println("");
    }//Metodo sumadorbinario

    public static void contains(String frase1, String frase2) {
  
        String contenedor = "";
        String contenedor2 = "";

        for (int i = 0; i < frase2.length(); i++) {
            char c22 = ' ';
            char c2 = frase2.charAt(i);
            if (i != frase2.length() - 1) {
                c22 = frase2.charAt(i + 1);
            }
            for (int j = 0; j < frase1.length(); j++) {
                char c1 = frase1.charAt(j);
                char c11 = ' ';
                if (j != frase1.length() - 1) {
                    c11 = frase1.charAt(j + 1);
                }
                if (c2 == c1 && c22 == c11) {
                    contenedor = contenedor + c1;
                }
            }//Fin for j
        }//Fin for i
        int size = frase2.length() - 1;
        contenedor2 = contenedor2 + frase1.charAt(size);        
        if (contenedor.equals(frase2)) {
            System.out.println("La cadena " + frase1 + " contiene a la cadena " + frase2 + ". ");
        } else {
            System.out.println("La cadena " + frase1 + " no contiene a la cadena " + frase2 + ". ");
        }

    }//Metodo contains

    public static void alpha(String cadena) {
        boolean c;
        c = true;

        for (int j = 0; j < cadena.length(); j++) {
            char letra = cadena.charAt(j);
            if ((int) letra >= 97 && (int) letra < 123) {
                c = true;
            }//Fin if
        }//Fin for interno

        if (c) {
            System.out.println("La cadena sólo contiene letras.");
        } else {
            System.out.println("La cadena contiene caracteres que no son letras");
        }
    }//Metodo alpha
}//Fin clase
