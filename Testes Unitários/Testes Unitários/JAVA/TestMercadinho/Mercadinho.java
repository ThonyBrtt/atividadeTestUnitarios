import java.util.ArrayList;
// Criei uma nova classe
public class Mercadinho {
    private ArrayList<Produto> produtos = new ArrayList<>();

    public boolean adicionarProduto(int id, String nome, double preco) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return false; // ID já existe
            }
        }
        produtos.add(new Produto(id, nome, preco));
        return true;
    }

    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
