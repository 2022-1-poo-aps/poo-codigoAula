package br.ufpb.dcx.rodrigor.vendas;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemCestaTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void testeProdutoQuantidade() {

        Produto produto = new Produto(123,"produto");
        ItemCesta item = new ItemCesta(produto);

        assertEquals(produto,item.getProduto());
        assertEquals(1,item.getQuant());

        item.setQuant(4);
        assertEquals(4,item.getQuant());

        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                item.setQuant(-1));
        assertEquals("Quantidade não pode ser menor ou igual a zero!", exception.getMessage());


    }


    @Test
    void testValorTotal(){

    }
}