package tech.ada.pedido.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.pedido.model.Pedido;
import tech.ada.pedido.service.ValidarProduto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PedidoController {

    private static List<Pedido> pedidos = new ArrayList<>();
    private final ValidarProduto validarProduto;

    public PedidoController(ValidarProduto validarProduto) {
        this.validarProduto = validarProduto;
    }

    @PostMapping
    public Pedido create(@RequestBody Pedido pedido) {
        pedido.setId(pedidos.size());
        validarProduto.execute(pedido.getProdutoId());
        pedidos.add(pedido);
        return pedido;
    }

    @GetMapping
    public Pedido get(@PathVariable int id) {
        return pedidos.get(id);
    }
}
