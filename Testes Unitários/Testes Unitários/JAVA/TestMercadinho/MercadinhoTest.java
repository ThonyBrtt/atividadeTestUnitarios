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
}
