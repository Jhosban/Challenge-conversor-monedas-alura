import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultarDatosAPI {

    public DatosConversion consultarDatos(String codigoBase, String codigoDestino, double cantidad) {
        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b22e29fa659611e1dfb22e33/pair/"+codigoBase+"/"+codigoDestino+"/"+cantidad);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();
        try {
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return new Gson().fromJson(response.body(), DatosConversion.class);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
