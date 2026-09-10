package model;

import java.util.ArrayList;
import java.util.List;

public class LivroRepositorio {
	 private List<Livro> livros = new ArrayList<>();
	 public void salvar(Livro a) {
		// 1. as regras do objeto sozinho, ja escritas no Model
		 String problema = a.validar();
		 if (problema != null) {
		 throw new IllegalArgumentException(problema);
		 }
		 // 2. a regra que depende dos OUTROS registros
		 //if ((a.getNome() == a.)) {
		 //throw new IllegalArgumentException(
		 //"Ja tem um livro com este nome.");
		 //}
		 // 3. so agora grava: valide antes de alterar o estado
		 livros.add(a);
		 }
		 public boolean existe(String nome) {
		 for (Livro a : livros) {
		 // equals e nao ==: a pergunta e sobre CONTEUDO
		 if (a.getNome().equals(nome) && a.getNome().equals(nome)) {
		 return true;
		 }
		 }
		 return false;
		 }
		 public List<Livro> listarTodos() {
		 // devolve uma COPIA: ninguem altera a colecao interna por fora
		 return new ArrayList<>(livros);
		 }
		 public int contar() {
		 return livros.size();
		 }
}