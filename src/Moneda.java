import java.util.HashMap;
import java.util.Map;

public record Moneda(String result,
                     String base_code,
                     HashMap<String, Double> conversion_rates) {
}
