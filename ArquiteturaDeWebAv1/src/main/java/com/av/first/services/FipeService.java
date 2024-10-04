package com.av.first.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FipeService {

    private final RestTemplate restTemplate = new RestTemplate();

    private String consultarURL(String apiUrl) {

        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {

            return responseEntity.getBody();
        } else {

            return "Falha ao obter dados. Código de status: " + responseEntity.getStatusCode();
        }
    }

    public String consultarMarcas() {

        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas";

        return consultarURL(apiUrl);
    }

    public String consultarModelos(int marca) {

        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos";

        return consultarURL(apiUrl);
    }
    public String consultarAnos(int marca, int modelo) {

        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/" + modelo + "/anos";

        return consultarURL(apiUrl);
    }

    public String consultarValor(int marca, int modelo, String ano) {

        String apiUrl = "https://parallelum.com.br/fipe/api/v1/carros/marcas/" + marca + "/modelos/" + modelo + "/anos/" + ano;

        return consultarURL(apiUrl);
    }
}
