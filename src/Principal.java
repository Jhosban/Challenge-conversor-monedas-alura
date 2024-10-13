import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ConsultarDatosAPI datos = new ConsultarDatosAPI();

        while (true) {
            System.out.println("");
            System.out.println("""
                    BIENVENIDO AL CONVERSOR DE MONEDAS DE JHOSBAN =)
                    |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||
                    Por favor, elija una de las siguientes opciones:
                    1) Convertir USD ==> COP.
                    2) Convertir COP ==> USD.
                    3) Convertir USD ==> BRL.
                    4) Convertir BRL ==> USD.
                    5) Convertir USD ==> ARS.
                    6) Convertir ARS ==> USD.
                    7) SALIR
                    |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||""");
            int eleccion = teclado.nextInt();
            if (eleccion == 7) {
                break;
            } else if (eleccion > 7) {
                System.out.println("Opcion no valida");
                continue;
            }
            System.out.println("Ingrese el valor a convertir: ");
            double valor = teclado.nextDouble();
            switch (eleccion) {
                case 1:
                    DatosConversion conversion = datos.consultarDatos("USD", "COP", valor);
                    System.out.println(valor+" USD equivalen a "+conversion.conversion_rate()+" COP");
                    break;
                case 2:
                    conversion = datos.consultarDatos("COP", "USD", valor);
                    System.out.println(valor+" COP equivalen a "+conversion.conversion_rate()+" USD");
                    break;
                case 3:
                    conversion = datos.consultarDatos("USD", "BRL", valor);
                    System.out.println(valor+" USD equivalen a "+conversion.conversion_rate()+" BRL");
                    break;
                case 4:
                    conversion = datos.consultarDatos("BRL", "USD", valor);
                    System.out.println(valor+" BRL equivalen a "+conversion.conversion_rate()+" USD");
                    break;
                case 5:
                    conversion = datos.consultarDatos("USD", "ARS", valor);
                    System.out.println(valor+" USD equivalen a "+conversion.conversion_rate()+" ARS");
                    break;
                case 6:
                    conversion = datos.consultarDatos("ARS", "USD", valor);
                    System.out.println(valor+" ARS equivalen a "+conversion.conversion_rate()+" USD");
                    break;
            }
        }
    }
}