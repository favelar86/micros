package tech.ada.produto.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tech.ada.produto.model.Produto;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProdutoController {

    private static List<Produto> produtos = new ArrayList<>();

    @PostMapping
    public Produto create(@RequestBody Produto produto) {
        produto.setId(produtos.size());
        produtos.add(produto);
        return produto;
    }

    @GetMapping("{id}")
    public Produto get(@PathVariable int id) {
        return produtos.get(id);
    }
}
