package view;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
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
 // Um atributo por campo da tela.
 private JTextField txtNome;
 private JTextField txtAutor;
 private JTextField txtPaginas;
 private JTextField txtCopias;
 // Os botoes tambem sao atributos: o Controller precisa alcanca-los
 // para pendurar o ouvinte.
 private JButton btnCadastrar;
 private JButton btnLimpar;
 private JButton btnFechar;
 public JanelaLivro() {
 setTitle("Cadastro de Animais - Pet Shop");
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 setBounds(100, 100, 460, 300);
 contentPane = new JPanel();
 contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 setContentPane(contentPane);
 contentPane.setLayout(null);
 JLabel lblNome = new JLabel("Nome");
 lblNome.setBounds(10, 21, 80, 14);
 contentPane.add(lblNome);
 txtNome = new JTextField();
 txtNome.setBounds(110, 18, 110, 20);
 contentPane.add(txtNome);
 JLabel lblEspecie = new JLabel("Especie");
 lblEspecie.setBounds(10, 60, 80, 14);
 contentPane.add(lblEspecie);
 txtAutor = new JTextField();
 txtAutor.setBounds(110, 57, 110, 20);
 contentPane.add(txtAutor);
 JLabel lblPeso = new JLabel("Peso (kg)");
 lblPeso.setBounds(10, 99, 80, 14);
 contentPane.add(lblPeso);
 txtPaginas = new JTextField();
 txtPaginas.setBounds(110, 96, 110, 20);
 contentPane.add(txtPaginas);
 JLabel lblDono = new JLabel("Dono");
 lblDono.setBounds(10, 138, 80, 14);
 contentPane.add(lblDono);
 txtDono = new JTextField();
 txtDono.setBounds(110, 135, 110, 20);
 contentPane.add(txtDono);
 // 105 px: com menos, o texto "Cadastrar" sai cortado.
 btnCadastrar = new JButton("Cadastrar");
 btnCadastrar.setBounds(250, 17, 105, 22);
 contentPane.add(btnCadastrar);
 btnLimpar = new JButton("Limpar");
 btnLimpar.setBounds(250, 56, 105, 22);
 contentPane.add(btnLimpar);
 btnFechar = new JButton("Fechar");
 btnFechar.setBounds(250, 95, 105, 22);
 ontentPane.add(btnFechar);
 }
 // ---- Grupo 1: entregar componentes ao Controller ------------------
 public JTextField getTxtNome() {
 return txtNome;
 }
 public JTextField getTxtEspecie() {
 return txtEspecie;
 }
 public JTextField getTxtPeso() {
 return txtPeso;
 }
 public JTextField getTxtDono() {
 return txtDono;
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
 txtEspecie.setText("");
 txtPeso.setText("");
 txtDono.setText("");
 txtNome.requestFocus();
 }
 public void fechar() {
 dispose();
 }
}