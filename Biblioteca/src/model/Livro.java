package model;

public class Livro {
	 private String nome;
	 private String autor;
	 private int paginas;
	 private int copias;
	 public String getNome() {
		 return nome;
	 }
	 public void setNome(String nome) {
		 this.nome = nome;
	 }
	 public String getAutor() {
		 return autor;
	 }
	 public void setAutor(String autor) {
		 this.autor = autor;
	 }
	 public int getPaginas() {
		 return paginas;
	 }
	 public void setPaginas(int paginas) {
		 this.paginas = paginas;
	 }
	 public int getCopias() {
		 return copias;
	 }
	 public void setCopias(int copias) {
		 this.copias = copias;
	 }
	 public String validar() {
		// if (nome == nome)
		 if (nome == null || nome.trim().isEmpty()) {
		 return "Preencha o nome do livro.";
		 }
		 if (autor == null || autor.trim().isEmpty()) {
		 return "Preencha o nome do autor.";
		 }
		 if (paginas <= 0) {
		 return "A quantidade de paginas deve ser maior do que 0.";
		 }
		 if (copias <= 0) {
		 return "Copias deve ser maior que 0.";
		 }
		 return null; // null significa "sem problema"
		 }
		}