import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConversorDeMoneda {


    public List<String> historial = new ArrayList<String>();
    private LocalDateTime fechaHora;

    public static void mostrarMenu(){
        System.out.println("""
                    ***********************************************************
                    Sea bienivendio/a al Conversor de moneda =]
                    
                    1) Dólar =>> Peso Argentino
                    2) Peso Argentino =>> Dólar
                    3) Dólar =>> Real brasileño
                    4) Real brasileño =>> Dólar
                    5) Dólar =>> Peso colombiano
                    6) Peso colombiano =>> Dólar
                    7) Dolar =>> Sol Peruano 
                    8) Sol Peruano =>> Dolar
                    9) Salir 
                    Elija una opción valida :
                    ************************************************************
                """);
    }

    public List<String> conversionMoneda(double cantidad, String monedaOrg, String monedaDest, Moneda moneda){

        String operacion;
        this.fechaHora = LocalDateTime.now();
        HashMap<String, Double > monedaA = new HashMap<String,Double>();
        monedaA = (HashMap<String, Double>) moneda.conversion_rates();
        // Agregando a traves del metodo .get(key) el valor del HashMaps a valorArg
        Double valorDes = monedaA.get(monedaDest);
        operacion = "El valor de "+ cantidad + " "+ monedaOrg + " corresponde al valor de =>>> " + cantidad * valorDes + " " + monedaDest;

        // añade al array
        this.historial.add(this.fechaHora + " " + operacion + "\n");
        System.out.println(operacion);

        return historial ;

    }

    public List<String> listaInsertada() {


        return this.historial;
    }


}
