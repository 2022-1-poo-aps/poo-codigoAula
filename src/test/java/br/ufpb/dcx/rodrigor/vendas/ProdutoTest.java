package br.ufpb.dcx.rodrigor.vendas;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProdutoTest {

    Produto produto;

    @BeforeEach
    void setup(){
        produto = new Produto(123,"sapato");
    }

    @Test
    void getNomeCodigo() {
        assertEquals("sapato",produto.getNome());
        assertEquals(123,produto.getCodigo());

        produto.setNome("sapato preto");
        assertEquals("sapato preto",produto.getNome());
    }

    @Test
    void getDescricao() {
        assertEquals("",produto.getDescricao());
        produto.setDescricao("descricao qualquer");
        assertEquals("descricao qualquer",produto.getDescricao());
    }

    @Test
    void testPreco() {
        assertEquals(0.0,produto.getPreco());

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                produto.setPreco(-1));
        assertEquals("Valor inválido!", exception.getMessage());


    }
}