package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
/**
 * VIEW - a tela. PASSO 7 do roteiro.
 *
 * Um par rotulo + campo por atributo do Model, e os botoes.
 *
 * Dois grupos de metodos, e nada alem disso:
 * Grupo 1 - get... devolvendo componentes ao Controller;
 * Grupo 2 - metodos que exibem ou fazem o que mandarem.
 *
 * Confira com Ctrl+F: nao ha "addActionListener" e nao ha "if" aqui.
 */
public class JanelaLivro extends JFrame {
 private static final long serialVersionUID = 1L;
 private JPanel contentPane;
 private JPanel panel;
 private JPanel panel_1;
 private JLabel lblNome;
 private JTextField txtNome;
 private JLabel lblAutor;
 private JTextField txtAutor;
 private JLabel lblPaginas;
 private JTextField txtPaginas;
 private JLabel lblCopias;
 private JTextField txtCopias;
 private JButton btnCadastrar;
 private JButton btnLimpar;
 private JButton btnFechar;
 public JanelaLivro() {
 setTitle("Cadastro de Livros - Biblioteca");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(100, 100, 460, 300);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(new BorderLayout(0, 0));
 
 panel = new JPanel();
 contentPane.add(panel, BorderLayout.CENTER);
 GridBagLayout gbl_panel = new GridBagLayout();
 gbl_panel.columnWidths = new int[]{0, 0};
 gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
 gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
 gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
 panel.setLayout(gbl_panel);
 
 lblNome = new JLabel("Nome");
 GridBagConstraints gbc_lblNome = new GridBagConstraints();
 gbc_lblNome.insets = new Insets(0, 0, 5, 0);
 gbc_lblNome.gridx = 0;
 gbc_lblNome.gridy = 0;
 panel.add(lblNome, gbc_lblNome);
 
 txtNome = new JTextField();
 GridBagConstraints gbc_txtNome = new GridBagConstraints();
 gbc_txtNome.weightx = 1.0;
 gbc_txtNome.insets = new Insets(0, 0, 5, 0);
 gbc_txtNome.fill = GridBagConstraints.HORIZONTAL;
 gbc_txtNome.gridx = 0;
 gbc_txtNome.gridy = 1;
 panel.add(txtNome, gbc_txtNome);
 
 lblAutor = new JLabel("Autor");
 GridBagConstraints gbc_lblAutor = new GridBagConstraints();
 gbc_lblAutor.insets = new Insets(0, 0, 5, 0);
 gbc_lblAutor.gridx = 0;
 gbc_lblAutor.gridy = 2;
 panel.add(lblAutor, gbc_lblAutor);
 
 txtAutor = new JTextField();
 GridBagConstraints gbc_txtAutor = new GridBagConstraints();
 gbc_txtAutor.weightx = 1.0;
 gbc_txtAutor.insets = new Insets(0, 0, 5, 0);
 gbc_txtAutor.fill = GridBagConstraints.HORIZONTAL;
 gbc_txtAutor.gridx = 0;
 gbc_txtAutor.gridy = 3;
 panel.add(txtAutor, gbc_txtAutor);
 
 lblPaginas = new JLabel("Paginas");
 GridBagConstraints gbc_lblPaginas = new GridBagConstraints();
 gbc_lblPaginas.insets = new Insets(0, 0, 5, 0);
 gbc_lblPaginas.gridx = 0;
 gbc_lblPaginas.gridy = 4;
 panel.add(lblPaginas, gbc_lblPaginas);
 
 txtPaginas = new JTextField();
 GridBagConstraints gbc_txtPaginas = new GridBagConstraints();
 gbc_txtPaginas.weightx = 1.0;
 gbc_txtPaginas.insets = new Insets(0, 0, 5, 0);
 gbc_txtPaginas.fill = GridBagConstraints.HORIZONTAL;
 gbc_txtPaginas.gridx = 0;
 gbc_txtPaginas.gridy = 5;
 panel.add(txtPaginas, gbc_txtPaginas);
 
 lblCopias = new JLabel("Copias");
 GridBagConstraints gbc_lblCopias = new GridBagConstraints();
 gbc_lblCopias.insets = new Insets(0, 0, 5, 0);
 gbc_lblCopias.gridx = 0;
 gbc_lblCopias.gridy = 6;
 panel.add(lblCopias, gbc_lblCopias);
 
 txtCopias = new JTextField();
 GridBagConstraints gbc_txtCopias = new GridBagConstraints();
 gbc_txtCopias.weightx = 1.0;
 gbc_txtCopias.fill = GridBagConstraints.HORIZONTAL;
 gbc_txtCopias.gridx = 0;
 gbc_txtCopias.gridy = 7;
 panel.add(txtCopias, gbc_txtCopias);
 
 panel_1 = new JPanel();
 contentPane.add(panel_1, BorderLayout.EAST);
 
 btnCadastrar = new JButton("Cadastrar");
 panel_1.add(btnCadastrar);
 
 btnLimpar = new JButton("Limpar");
 panel_1.add(btnLimpar);
 
 btnFechar = new JButton("Fechar");
 panel_1.add(btnFechar);
 }
 // ---- Grupo 1: entregar componentes ao Controller ------------------
 public JTextField getTxtNome() {
 return txtNome;
 }
 public JTextField getTxtAutor() {
 return txtAutor;
 }
 public JTextField getTxtPaginas() {
 return txtPaginas;
 }
 public JTextField getCopias() {
 return txtCopias;
 }
 public JButton getBtnCadastrar() {
 return btnCadastrar;
 }
 public JButton getBtnLimpar() {
 return btnLimpar;
 }
 public JButton getBtnFechar() {
 return btnFechar;
 }
 // ---- Grupo 2: capacidades da propria tela -------------------------
 public void mostrarMensagem(String texto) {
 JOptionPane.showMessageDialog(this, texto);
 }
 public void mostrarErro(String texto) {
 JOptionPane.showMessageDialog(this, texto, "Atencao",
 JOptionPane.WARNING_MESSAGE);
 }
 public void limparCampos() {
 txtNome.setText("");
 txtAutor.setText("");
 txtPaginas.setText("");
 txtCopias.setText("");
 txtNome.requestFocus();
 }
 public void fechar() {
 dispose();
 }
}