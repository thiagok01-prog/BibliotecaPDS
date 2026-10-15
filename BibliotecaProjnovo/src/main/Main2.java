package main;
import controller.LivroController;
import model.LivroRepositorioBD;
import view.JanelaLivro;


public class Main2 {
 public static void main(String[] args) {
 LivroRepositorioBD repositorio = new LivroRepositorioBD();
 JanelaLivro view = new JanelaLivro();
 LivroController controller = new LivroController(repositorio, view);
 controller.iniciarTela();
 }
}