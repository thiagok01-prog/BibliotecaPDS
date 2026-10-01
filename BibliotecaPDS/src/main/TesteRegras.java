package main;

import model.Livro;

public class TesteRegras {

	public static void main(String[] args) {
		 // um objeto por caso de teste
		 Livro a = new Livro();
		 a.setNome("Enciclopedia");
		 a.setAutor("Eu");
		 a.setPaginas(300);
		 a.setCopias(20);
		 System.out.println("Enciclopedia -> " + a.validar()); // esperado: null
		 Livro b = new Livro();
		 b.setNome("Exemplo");
		 b.setAutor("Exemplar");
		 b.setPaginas(50);
		 b.setCopias(1);
		 System.out.println("Exemplo -> " + b.validar()); // esperado: mensagem do peso
		}
}
