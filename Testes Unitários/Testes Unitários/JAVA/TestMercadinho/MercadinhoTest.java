/**
 * MercadinhoTest.java
 * Autor: Anthony Cesar
 * Data: 18/09/2025
 *
 * Cenário de Teste:
 * Testar cadastro de produto válido no Mercadinho.
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;


/*1. Cadastro de produto válido
*	Ao adicionar um produto novo com ID único, o método deve retornar true.
*	A lista de produtos deve conter o produto cadastrado.
*/

public class MercadinhoTest {
    private Mercadinho mercadinho;

    @BeforeEach
    void setUp() {
        mercadinho = new Mercadinho();
    }

    @Test
    void testCadastroProdutoValido() {
        // Cenários de Teste:
        // Produto com ID único deve ser adicionado com sucesso

        // Execução:
        boolean resultado = mercadinho.adicionarProduto(1, "Arroz", 10.0);

        // Verificação:
        assertTrue(resultado, "Produto com ID único deveria ser adicionado com sucesso");
        assertEquals(1, mercadinho.getProdutos().size(), "Deveria conter 1 produto na lista");

        Produto p = mercadinho.getProdutos().get(0);
        assertEquals(1, p.getId(), "ID do produto deve ser 1");
        assertEquals("Arroz", p.getNome(), "Nome do produto deve ser 'Arroz'");
        assertEquals(10.0, p.getPreco(), 0.01, "Preço do produto deve ser 10.0");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     *
     */

    /**
     * 2. Cadastro de produto duplicado
     * Cenário de Teste:
     * Ao tentar adicionar um produto com um ID já existente, o método deve retornar false.
     * A lista de produtos não deve ser alterada — deve continuar com apenas o primeiro produto.
     */

    @Test
    void testCadastroProdutoDuplicado() {
        // Execução:
        boolean resultado1 = mercadinho.adicionarProduto(1, "Arroz", 10.0);
        boolean resultado2 = mercadinho.adicionarProduto(1, "Feijão", 8.0); // mesmo ID

        // Verificação:
        assertTrue(resultado1, "Primeiro produto deveria ser adicionado com sucesso");
        assertFalse(resultado2, "Segundo produto com ID duplicado não deveria ser adicionado");

        assertEquals(1, mercadinho.getProdutos().size(), "A lista deve conter apenas 1 produto");

        Produto p = mercadinho.getProdutos().get(0);
        assertEquals("Arroz", p.getNome(), "O produto na lista deve ser o primeiro cadastrado");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     *
     */

    /**
     * 3. Busca de produto existente
     * Cenário de Teste:
     * Ao buscar um produto válido, o método deve retornar o objeto correto.
     * O nome, preço e ID devem ser iguais aos cadastrados.
     */

    @Test
    void testBuscaProdutoExistente() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        Produto resultado = mercadinho.buscarProdutoPorId(1);

        // Verificação:
        assertNotNull(resultado, "Produto com ID existente deve ser encontrado");
        assertEquals(1, resultado.getId(), "ID deve ser 1");
        assertEquals("Arroz", resultado.getNome(), "Nome deve ser 'Arroz'");
        assertEquals(10.0, resultado.getPreco(), 0.01, "Preço deve ser 10.0");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 4. Busca de produto inexistente
     * Cenário de Teste:
     * Ao buscar um produto com um ID que não existe, o método deve retornar null.
     */

    @Test
    void testBuscaProdutoInexistente() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        Produto resultado = mercadinho.buscarProdutoPorId(99); // ID inexistente

        // Verificação:
        assertNull(resultado, "Produto com ID inexistente deve retornar null");
    }

    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 5. Atualização de nome do produto
     * Cenário de Teste:
     * Ao atualizar apenas o nome de um produto existente, os demais campos devem permanecer iguais.
     * O retorno deve ser true.
     */

    @Test
    void testAtualizacaoNomeProduto() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        boolean resultado = mercadinho.atualizarNomeProduto(1, "Arroz Integral");

        // Verificação:
        assertTrue(resultado, "Deve retornar true ao atualizar o nome de produto existente");

        Produto p = mercadinho.buscarProdutoPorId(1);
        assertNotNull(p, "Produto atualizado deve continuar existindo");
        assertEquals("Arroz Integral", p.getNome(), "Nome deve ter sido atualizado");
        assertEquals(1, p.getId(), "ID deve permanecer igual");
        assertEquals(10.0, p.getPreco(), 0.01, "Preço deve permanecer igual");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 6. Atualização de preço do produto
     * Cenário de Teste:
     * Ao atualizar apenas o preço, o novo valor deve ser salvo.
     * O retorno deve ser true.
     */

    @Test
    void testAtualizacaoPrecoProduto() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        boolean resultado = mercadinho.atualizarPrecoProduto(1, 12.5);

        // Verificação:
        assertTrue(resultado, "Deve retornar true ao atualizar o preço de produto existente");

        Produto p = mercadinho.buscarProdutoPorId(1);
        assertNotNull(p, "Produto atualizado deve continuar existindo");
        assertEquals("Arroz", p.getNome(), "Nome deve permanecer igual");
        assertEquals(1, p.getId(), "ID deve permanecer igual");
        assertEquals(12.5, p.getPreco(), 0.01, "Preço deve ter sido atualizado");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 7. Atualização de produto inexistente
     * Cenário de Teste:
     * Ao tentar atualizar um produto que não existe, o método deve retornar false.
     */

    @Test
    void testAtualizacaoProdutoInexistente() {
        // Nenhum produto foi adicionado ainda

        boolean resultadoNome = mercadinho.atualizarNomeProduto(99, "Produto Inexistente");
        boolean resultadoPreco = mercadinho.atualizarPrecoProduto(99, 99.99);

        // Verificação:
        assertFalse(resultadoNome, "Atualizar nome de produto inexistente deve retornar false");
        assertFalse(resultadoPreco, "Atualizar preço de produto inexistente deve retornar false");
    }

    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 8. Remoção de produto existente
     * Cenário de Teste:
     * Ao remover um produto válido, o método deve retornar true.
     * O produto não deve mais aparecer na lista.
     */

    @Test
    void testRemocaoProdutoExistente() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        boolean resultadoRemocao = mercadinho.removerProduto(1);

        // Verificação:
        assertTrue(resultadoRemocao, "Remover produto existente deve retornar true");
        assertEquals(0, mercadinho.getProdutos().size(), "A lista deve estar vazia após remoção");
        assertNull(mercadinho.buscarProdutoPorId(1), "Produto removido não deve mais ser encontrado");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 9. Tentativa de remoção de produto inexistente
     * Cenário de Teste:
     * Ao tentar remover um produto que não existe, o método deve retornar false.
     * A lista de produtos não deve ser alterada.
     */

    @Test
    void testRemocaoProdutoInexistente() {
        // Preparação:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);

        // Execução:
        boolean resultadoRemocao = mercadinho.removerProduto(99); // ID inexistente

        // Verificação:
        assertFalse(resultadoRemocao, "Remoção de produto inexistente deve retornar false");
        assertEquals(1, mercadinho.getProdutos().size(), "A lista não deve ser alterada");
        assertNotNull(mercadinho.buscarProdutoPorId(1), "Produto existente deve continuar na lista");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 10. Listagem de produtos
     * Cenário de Teste:
     * Após adicionar dois produtos, a listagem deve retornar uma lista com exatamente esses dois.
     */

    @Test
    void testListagemProdutos() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        mercadinho.adicionarProduto(2, "Feijão", 8.5);

        // Verificação:
        ArrayList<Produto> produtos = mercadinho.getProdutos();

        assertEquals(2, produtos.size(), "Deve retornar exatamente dois produtos");

        Produto p1 = produtos.get(0);
        assertEquals(1, p1.getId(), "Primeiro produto deve ter ID 1");
        assertEquals("Arroz", p1.getNome(), "Primeiro produto deve ser 'Arroz'");
        assertEquals(10.0, p1.getPreco(), 0.01, "Preço do primeiro produto deve ser 10.0");

        Produto p2 = produtos.get(1);
        assertEquals(2, p2.getId(), "Segundo produto deve ter ID 2");
        assertEquals("Feijão", p2.getNome(), "Segundo produto deve ser 'Feijão'");
        assertEquals(8.5, p2.getPreco(), 0.01, "Preço do segundo produto deve ser 8.5");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 11. Limpeza da lista
     * Cenário de Teste:
     * Após adicionar produtos e chamar limpar(), a lista deve estar vazia.
     */

    @Test
    void testLimpezaDaLista() {
        // Execução:
        mercadinho.adicionarProduto(1, "Arroz", 10.0);
        mercadinho.adicionarProduto(2, "Feijão", 8.5);

        mercadinho.limpar();  // método a ser testado

        // Verificação:
        assertEquals(0, mercadinho.getProdutos().size(), "A lista deve estar vazia após limpar()");
    }
    /**
     * MercadinhoTest.java
     * Autor: Anthony Cesar
     * Data: 24/09/2025
     */

    /**
     * 12. Controle de estoque
     * Cenário de Teste:
     * Ao atualizar a quantidade de um produto, a alteração deve ser refletida corretamente.
     */

    @Test
    void testAtualizacaoQuantidadeProduto() {

        //Execução:

        // Adiciona produto com quantidade inicial 5 (ajuste o método se necessário)
        mercadinho.adicionarProduto(1, "Arroz", 10.0, 5);

        // Verificação:

        // Atualiza a quantidade do produto para 12
        boolean resultado = mercadinho.atualizarQuantidadeProduto(1, 12);

        assertTrue(resultado, "Atualizar quantidade deve retornar true");

        Produto atualizado = mercadinho.buscarProdutoPorId(1);
        assertNotNull(atualizado, "Produto deve existir após atualização");
        assertEquals(12, atualizado.getQuantidade(), "Quantidade deve ser atualizada para 12");
    }

}

