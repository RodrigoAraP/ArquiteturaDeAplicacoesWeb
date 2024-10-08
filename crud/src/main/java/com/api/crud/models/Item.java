package com.api.crud.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Data
@Document(collection = "itens")
public class Item {
    @Id
    private String id;
    private String nome;
    private String descricao;
}
