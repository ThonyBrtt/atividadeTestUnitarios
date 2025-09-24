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

    public Produto buscarProdutoPorId(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public boolean atualizarNomeProduto(int id, String novoNome) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setNome(novoNome);
                return true;
            }
        }
        return false;
    }

    public boolean atualizarPrecoProduto(int id, double novoPreco) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setPreco(novoPreco);
                return true;
            }
        }
        return false;
    }

    public boolean removerProduto(int id) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                produtos.remove(p);
                return true;
            }
        }
        return false;
    }

    public void limpar() {
        produtos.clear();
    }


    public boolean adicionarProduto(int id, String nome, double preco, int quantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                return false; // ID já existe
            }
        }
        produtos.add(new Produto(id, nome, preco, quantidade));
        return true;
    }

    public boolean atualizarQuantidadeProduto(int id, int novaQuantidade) {
        for (Produto p : produtos) {
            if (p.getId() == id) {
                p.setQuantidade(novaQuantidade);  // importante: setQuantidade, não setId!
                return true;
            }
        }
        return false;
    }


    public ArrayList<Produto> getProdutos() {
        return produtos;
    }
}
