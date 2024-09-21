package com.example.RestAPI.service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {
    public String welcomeMessage(){
        return "Essa é imnha primeira API REST";
    }

    public String exampleMessage(){
        return "Mensagem de exemplo";
    }

    public String preverTempo(){
        String dadosMeteorologicos = "";
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/weather/locale/6879/current?token=37281e9e81a01684c92a89c79e57acb5";
    
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dadosMeteorologicos = responseEntity.getBody();
        } else {
            dadosMeteorologicos = "Falha ao obter dados meterológicos. Codigo de status: " + responseEntity.getStatusCode();
        }

        return dadosMeteorologicos;
    }
}
