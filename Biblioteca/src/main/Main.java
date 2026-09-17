package main;
import controller.LivroController;
import model.LivroRepositorioBD;
import view.JanelaLivro;
/**
 * PASSO 9 - junta as tres camadas. Execute SEMPRE esta classe.
 */
public class Main {
 public static void main(String[] args) {
 LivroRepositorioBD repositorio = new LivroRepositorioBD();
 JanelaLivro view = new JanelaLivro();
 LivroController controller = new LivroController(repositorio, view);
 controller.iniciarTela();
 }
}
