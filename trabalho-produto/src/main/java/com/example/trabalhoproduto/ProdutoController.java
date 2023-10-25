package com.example.trabalhoproduto;

import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping("/criar")
    public Produto createProduto(@RequestBody ProdutoRequest produtoRequest) {


        return produtoRepository.save(
                new Produto(produtoRequest.getDescricao(), produtoRequest.getPreco(), produtoRequest.getQtde())
        );
    }

    @GetMapping("/listar")
    public List<Produto> getAllProduto() {
        return produtoRepository.findAll();
    }

    @PutMapping("/atualizar/{id}")
    public Produto updateProduto(@PathVariable Integer id, @RequestBody ProdutoRequest produtoRequest) {
        Produto oldProduto = produtoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Produto não encontrado")
        );

        oldProduto.setDescricao(produtoRequest.getDescricao());
        oldProduto.setPreco(produtoRequest.getPreco());
        oldProduto.setQtde(produtoRequest.getQtde());

        return produtoRepository.save(oldProduto);

    }

    @DeleteMapping("/deletar/{codigo}")
    public Message deleteProduct(@PathVariable Integer codigo) {
        produtoRepository.deleteById(codigo);
        return new Message("Produto com codigo " + codigo + " deletado.");
    }

    public class Message {
        private String message;

        public Message(String message) {
            this.message = message;
        }
    }
}
