import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class MercadinhoApp extends JFrame {
    private ArrayList<Produto> produtos = new ArrayList<>();
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> listaProdutos = new JList<>(listModel);

    private JTextField campoId = new JTextField(5);
    private JTextField campoNome = new JTextField(10);
    private JTextField campoPreco = new JTextField(7);
    private JTextField campoQuantidade = new JTextField(5); // Campo de quantidade

    public MercadinhoApp() {
        super("Mercadinho CRUD");

        setLayout(new BorderLayout());

        // Painel de entrada
        JPanel painelEntrada = new JPanel();
        painelEntrada.add(new JLabel("ID:"));
        painelEntrada.add(campoId);
        painelEntrada.add(new JLabel("Nome:"));
        painelEntrada.add(campoNome);
        painelEntrada.add(new JLabel("Preço:"));
        painelEntrada.add(campoPreco);
        painelEntrada.add(new JLabel("Quantidade:"));
        painelEntrada.add(campoQuantidade);

        JButton btnAdd = new JButton("Adicionar");
        JButton btnUpdate = new JButton("Atualizar");
        JButton btnDelete = new JButton("Remover");

        painelEntrada.add(btnAdd);
        painelEntrada.add(btnUpdate);
        painelEntrada.add(btnDelete);

        add(painelEntrada, BorderLayout.NORTH);
        add(new JScrollPane(listaProdutos), BorderLayout.CENTER);

        // Eventos
        btnAdd.addActionListener(e -> adicionarProduto());
        btnUpdate.addActionListener(e -> atualizarProduto());
        btnDelete.addActionListener(e -> removerProduto());

        listaProdutos.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int index = listaProdutos.getSelectedIndex();
                if (index >= 0) {
                    Produto p = produtos.get(index);
                    campoId.setText(String.valueOf(p.getId()));
                    campoNome.setText(p.getNome());
                    campoPreco.setText(String.valueOf(p.getPreco()));
                    campoQuantidade.setText(String.valueOf(p.getQuantidade()));
                }
            }
        });

        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    // Adicionar produto
    void adicionarProduto() {
        try {
            int id = Integer.parseInt(campoId.getText());
            String nome = campoNome.getText();
            double preco = Double.parseDouble(campoPreco.getText());
            int quantidade = Integer.parseInt(campoQuantidade.getText());

            Produto p = new Produto(id, nome, preco, quantidade);
            produtos.add(p);
            listModel.addElement(p.toString());

            limparCampos();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao adicionar produto! Verifique os dados.");
        }
    }

    // Atualizar produto
    private void atualizarProduto() {
        int index = listaProdutos.getSelectedIndex();
        if (index >= 0) {
            try {
                int id = Integer.parseInt(campoId.getText());
                String nome = campoNome.getText();
                double preco = Double.parseDouble(campoPreco.getText());
                int quantidade = Integer.parseInt(campoQuantidade.getText());

                Produto p = new Produto(id, nome, preco, quantidade);
                produtos.set(index, p);
                listModel.set(index, p.toString());

                limparCampos();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Erro ao atualizar produto! Verifique os dados.");
            }
        }
    }

    // Remover produto
    private void removerProduto() {
        int index = listaProdutos.getSelectedIndex();
        if (index >= 0) {
            produtos.remove(index);
            listModel.remove(index);
            limparCampos();
        }
    }

    // Limpar campos
    private void limparCampos() {
        campoId.setText("");
        campoNome.setText("");
        campoPreco.setText("");
        campoQuantidade.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MercadinhoApp::new);
    }
}
