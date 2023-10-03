package tech.ada.pedido.model;

import lombok.Data;

@Data
public class Pedido {

    int id;
    int produtoId;
    int quantidade;
}
