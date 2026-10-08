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
 private JTextField textField;
 private JLabel lblAutor;
 private JTextField textField_1;
 private JLabel lblPaginas;
 private JTextField textField_2;
 private JLabel lblCopias;
 private JTextField textField_3;
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
 
 textField = new JTextField();
 GridBagConstraints gbc_textField = new GridBagConstraints();
 gbc_textField.weightx = 1.0;
 gbc_textField.insets = new Insets(0, 0, 5, 0);
 gbc_textField.fill = GridBagConstraints.HORIZONTAL;
 gbc_textField.gridx = 0;
 gbc_textField.gridy = 1;
 panel.add(textField, gbc_textField);
 
 lblAutor = new JLabel("Autor");
 GridBagConstraints gbc_lblAutor = new GridBagConstraints();
 gbc_lblAutor.insets = new Insets(0, 0, 5, 0);
 gbc_lblAutor.gridx = 0;
 gbc_lblAutor.gridy = 2;
 panel.add(lblAutor, gbc_lblAutor);
 
 textField_1 = new JTextField();
 GridBagConstraints gbc_textField_1 = new GridBagConstraints();
 gbc_textField_1.weightx = 1.0;
 gbc_textField_1.insets = new Insets(0, 0, 5, 0);
 gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
 gbc_textField_1.gridx = 0;
 gbc_textField_1.gridy = 3;
 panel.add(textField_1, gbc_textField_1);
 
 lblPaginas = new JLabel("Paginas");
 GridBagConstraints gbc_lblPaginas = new GridBagConstraints();
 gbc_lblPaginas.insets = new Insets(0, 0, 5, 0);
 gbc_lblPaginas.gridx = 0;
 gbc_lblPaginas.gridy = 4;
 panel.add(lblPaginas, gbc_lblPaginas);
 
 textField_2 = new JTextField();
 GridBagConstraints gbc_textField_2 = new GridBagConstraints();
 gbc_textField_2.weightx = 1.0;
 gbc_textField_2.insets = new Insets(0, 0, 5, 0);
 gbc_textField_2.fill = GridBagConstraints.HORIZONTAL;
 gbc_textField_2.gridx = 0;
 gbc_textField_2.gridy = 5;
 panel.add(textField_2, gbc_textField_2);
 
 lblCopias = new JLabel("Copias");
 GridBagConstraints gbc_lblCopias = new GridBagConstraints();
 gbc_lblCopias.insets = new Insets(0, 0, 5, 0);
 gbc_lblCopias.gridx = 0;
 gbc_lblCopias.gridy = 6;
 panel.add(lblCopias, gbc_lblCopias);
 
 textField_3 = new JTextField();
 GridBagConstraints gbc_textField_3 = new GridBagConstraints();
 gbc_textField_3.weightx = 1.0;
 gbc_textField_3.fill = GridBagConstraints.HORIZONTAL;
 gbc_textField_3.gridx = 0;
 gbc_textField_3.gridy = 7;
 panel.add(textField_3, gbc_textField_3);
 
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