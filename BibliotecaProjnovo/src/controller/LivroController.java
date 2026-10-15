package controller;

import model.Livro;
import model.LivroRepositorioBD;
import view.JanelaLivro;
import javax.swing.table.DefaultTableModel;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class LivroController implements ActionListener, TableModelListener {
    private LivroRepositorioBD repositorio;
    private JanelaLivro view;
    private boolean ignorarEventosTabela = false;

    public LivroController(LivroRepositorioBD repositorio, JanelaLivro view) {
        this.repositorio = repositorio;
        this.view = view;
        
        this.view.getBtnCadastrar().addActionListener(this);
        this.view.getBtnLimpar().addActionListener(this);
        this.view.getBtnFechar().addActionListener(this);
        
        this.view.getModeloTabela().addTableModelListener(this);
        
        atualizarTabela();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.view.getBtnCadastrar()) {
            cadastrar();
        } else if (e.getSource() == this.view.getBtnLimpar()) {
            this.view.limparCampos();
        } else if (e.getSource() == this.view.getBtnFechar()) {
            this.view.fechar();
        }
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        if (ignorarEventosTabela) return;

        if (e.getType() == TableModelEvent.UPDATE) {
            int linha = e.getFirstRow();
            DefaultTableModel modelo = this.view.getModeloTabela();

            try {
                String novoNome = modelo.getValueAt(linha, 0).toString().trim();
                String novoAutor = modelo.getValueAt(linha, 1).toString().trim();
                int novasPaginas = Integer.parseInt(modelo.getValueAt(linha, 2).toString().trim());
                int novasCopias = Integer.parseInt(modelo.getValueAt(linha, 3).toString().trim());

                if (novoNome.isEmpty() || novoAutor.isEmpty() || novasPaginas <= 0 || novasCopias <= 0) {
                    throw new IllegalArgumentException("Dados inválidos inseridos na tabela.");
                }

                Livro livroAtualizado = new Livro();
                livroAtualizado.setNome(novoNome);
                livroAtualizado.setAutor(novoAutor);
                livroAtualizado.setPaginas(novasPaginas);
                livroAtualizado.setCopias(novasCopias);

                List<Livro> livrosDoBanco = this.repositorio.listarTodos();
                Livro livroAntigo = livrosDoBanco.get(linha);

                this.repositorio.atualizar(livroAntigo.getNome(), livroAntigo.getAutor(), livroAtualizado);
                
                this.view.mostrarMensagem("Livro atualizado diretamente no banco!");

            } catch (Exception erro) {
                this.view.mostrarErro("Erro ao atualizar linha: Verifique se inseriu números válidos.");
                atualizarTabela();
            }
        }
    }

    private void atualizarTabela() {
        ignorarEventosTabela = true;
        DefaultTableModel modelo = this.view.getModeloTabela();
        modelo.setRowCount(0);
        
        List<Livro> livros = this.repositorio.listarTodos();
        for (Livro livro : livros) {
            Object[] linha = {
                livro.getNome(),
                livro.getAutor(),
                livro.getPaginas(),
                livro.getCopias()
            };
            modelo.addRow(linha);
        }
        ignorarEventosTabela = false;
    }

    private void cadastrar() {
        int paginas;
        try {
            paginas = Integer.parseInt(this.view.getTxtPaginas().getText().trim());
        } catch (NumberFormatException erro) {
            this.view.mostrarErro("As páginas devem ser um número inteiro válido.");
            return;
        }

        int copias;
        try {
            copias = Integer.parseInt(this.view.getCopias().getText().trim()); 
        } catch (NumberFormatException erro) {
            this.view.mostrarErro("As cópias devem ser um número inteiro válido.");
            return;
        }

        Livro livro = new Livro();
        livro.setNome(this.view.getTxtNome().getText());
        livro.setAutor(this.view.getTxtAutor().getText());
        livro.setPaginas(paginas);
        livro.setCopias(copias);

        try {
            this.repositorio.salvar(livro);
        } catch (IllegalArgumentException erro) {
            this.view.mostrarErro(erro.getMessage());
            return;
        }

        this.view.mostrarMensagem("Cadastrado com sucesso! Total: " + this.repositorio.contar());
        this.view.limparCampos();
        atualizarTabela(); 
    }

    public void iniciarTela() {
        this.view.setVisible(true);
    }
}