import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    static ConversorDeMoneda miConversor = new ConversorDeMoneda();
    public static void main(String[] args) {
        try {
            Scanner teclado = new Scanner(System.in);
            Integer opcionUser ;
            do {
                ConversorDeMoneda.mostrarMenu();
                opcionUser = Integer.valueOf(teclado.nextInt());
                ConsultarMoneda consulta = new ConsultarMoneda();

                switch (opcionUser) {

                    case 1:
                        System.out.println("Ingrese la cantidad de dolares a cambiar : ");
                        double cantidadUsd = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadUsd, "USD", "ARS", consulta.buscaMoneda("USD"));
                        break;

                    case 2:
                        System.out.println("Ingrese la cantidad de ARS a convertir a USD : ");
                        double cantidadArs = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadArs, "ARS", "USD", consulta.buscaMoneda("ARS"));
                        break;

                    case 3:
                        System.out.println("Ingrese la cantidad de Dolares a cambiar a BRL");
                        double cantidadUSDBRL = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadUSDBRL, "USD", "BRL", consulta.buscaMoneda("USD"));
                        break;

                    case 4:
                        System.out.println("Ingrese la cantidad de Reales Brasileños a cambiar a USD: ");
                        double cantidadBRLUSD = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadBRLUSD, "BRL", "USD", consulta.buscaMoneda("BRL"));
                        break;

                    case 5:
                        System.out.println("Ingrese la cantidad de USD a cambiar a Peso Colombiano: ");
                        double cantidadUSDCOP = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadUSDCOP, "USD", "COP", consulta.buscaMoneda("USD"));
                        break;

                    case 6:
                        System.out.println("Ingrese la cantidade de Pesos Colombianos para cambiar a USD: ");
                        double cantidadCOPUSD = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadCOPUSD, "COP", "USD", consulta.buscaMoneda("COP"));
                        break;

                    case 7:
                        System.out.println("Ingrese la cantidade de Dolares para cambiar a PEN: ");
                        double cantidadUSDPEN = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadUSDPEN, "USD", "PEN", consulta.buscaMoneda("USD"));
                        break;

                    case 8:
                        System.out.println("Ingrese la cantidade de PEN para cambiar a USD: ");
                        double cantidadPENUSD = teclado.nextDouble();
                        miConversor.conversionMoneda(cantidadPENUSD, "PEN", "USD", consulta.buscaMoneda("PEN"));
                        break;

                    case 9:
                        break;

                    default:
                        System.out.println("La opción no es valida");
                }

                FileWriter escritura = new FileWriter("historial.txt");
                escritura.write(String.valueOf(miConversor.listaInsertada()));
                escritura.close();

            }while(opcionUser != 9);

        }catch (InputMismatchException | NumberFormatException e ){
            System.out.println("Ocurrio un error, formato de ingreso incorrecto ");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}

