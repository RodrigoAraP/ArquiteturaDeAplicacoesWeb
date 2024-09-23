package com.example.RestAPI.service;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class Service {
    public String welcomeMessage(){
        return "Essa é imnha primeira API REST";
    }

    public String exampleMessage(){
        return "Mensagem de exemplo";
    }

    public String registrarToken(){
        String apiUrl = "http://apiadvisor.climatempo.com.br/api-manager/user-token/7b37f044434938ad8dd0e0e340a091de/locales";
        RestTemplate restTemplate = new RestTemplate();

        //Configura o header para indicar que estamos enviando um formulario
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        //Registra o id da cidade
        String requestBody = "localeId[]=6879";

        //Cria a requisicao HTTP
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        //Envia o PUT para registrar o localeId
        ResponseEntity<String> response = restTemplate.exchange(apiUrl,HttpMethod.PUT, entity, String.class);

        //Verifica se a requisicao foi bem sucedida
        if (response.getStatusCode().is2xxSuccessful()){
            return "Cidade registrada com sucesso: " + response.getBody();
        } else {
            return "Falha ao registrar cidade. Codigo de status: " + response.getStatusCode();
        }
    }   

    public String preverTempo(){
        String dadosMeteorologicos = "";
        String apiUrl = "https://apiadvisor.climatempo.com.br/api/v1/weather/locale/6879/current?token=7b37f044434938ad8dd0e0e340a091de";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if(responseEntity.getStatusCode().is2xxSuccessful()){
            dadosMeteorologicos = responseEntity.getBody();
            return dadosMeteorologicos;
        } else {
            dadosMeteorologicos = "Falha ao obter dados meterológicos. Codigo de status: " + responseEntity.getStatusCode();
            return dadosMeteorologicos;
        }
    }
}
