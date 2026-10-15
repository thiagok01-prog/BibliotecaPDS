package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LivroRepositorioBD {
 private static final String URL = "jdbc:mysql://localhost:3306/biblioteca";
 private static final String USER = "aluno_cd";
 private static final String SENHA = "aluno_pw";

 private Connection abrir() throws SQLException {
 return DriverManager.getConnection(URL, USER, SENHA);
 }
 public void salvar(Livro a) {
 String problema = a.validar();
 if (problema != null) {
 throw new IllegalArgumentException(problema);
 }
 if (existe(a.getNome(), a.getCopias())) {
 throw new IllegalArgumentException(
 "Ja existe um livro com este nome.");
 }
 String sql = "INSERT INTO livro (nome, autor, paginas, copias) VALUES (?, ?, ?, ?)";
 try (Connection con = abrir();
 PreparedStatement ps = con.prepareStatement(sql)) {

	 ps.setString(1, a.getNome().trim());
	 ps.setString(2, a.getAutor().trim());
	 ps.setInt(3, a.getPaginas());
	 ps.setInt(4, a.getCopias());
	 ps.executeUpdate();
	 } catch (SQLException erro) {
	 throw new RuntimeException("Erro ao gravar: " + erro.getMessage(), erro);
	 }
	 }
	 public boolean existe(String nome, int i) {
	 String sql = "SELECT id FROM livro WHERE nome = ? AND autor = ?";
	 try (Connection con = abrir();
	 PreparedStatement ps = con.prepareStatement(sql)) {
	 ps.setString(1, nome.trim());
	 ps.setInt(2, i);
	 try (ResultSet rs = ps.executeQuery()) {
	 return rs.next();
	 }
	 } catch (SQLException erro) {
	 throw new RuntimeException("Erro ao consultar: " + erro.getMessage(),
	erro);
	 }
	 }
	 public List<Livro> listarTodos() {
	 String sql = "SELECT nome, autor, paginas, copias FROM livro ORDER BY nome";
	 List<Livro> lista = new ArrayList<>();
	 try (Connection con = abrir();
	 PreparedStatement ps = con.prepareStatement(sql);
	 ResultSet rs = ps.executeQuery()) {
	 while (rs.next()) {
		 
	 Livro a = new Livro();
	 a.setNome(rs.getString("nome"));
	 a.setAutor(rs.getString("autor"));
	 a.setPaginas(rs.getInt("paginas"));
	 a.setCopias(rs.getInt("copias"));
	 lista.add(a);
	 }
	 } catch (SQLException erro) {
	 throw new RuntimeException("Erro ao listar: " + erro.getMessage(), erro);
	 }
	 return lista;
	 }
	 public int contar() {
	 String sql = "SELECT COUNT(*) FROM livro";
	 try (Connection con = abrir();
			 PreparedStatement ps = con.prepareStatement(sql);
			 ResultSet rs = ps.executeQuery()) {
			 if (rs.next()) {
			 return rs.getInt(1);
			 }
			 return 0;
			 } catch (SQLException erro) {
			 throw new RuntimeException("Erro ao contar: " + erro.getMessage(), erro);
			 }
			 }
			 public static void main(String[] args) {
			 LivroRepositorioBD bd = new LivroRepositorioBD();
			 try (Connection con = bd.abrir()) {
			 System.out.println("Conexao OK com " + con.getCatalog());
			 System.out.println("Registros: " + bd.contar());
			 } catch (SQLException e) {
			 System.out.println("Falha: " + e.getMessage());
			 }
			 }
			 public void atualizar(String nomeAntigo, String autorAntigo, Livro novoLivro) {
				    String sql = "UPDATE livro SET nome = ?, autor = ?, paginas = ?, copias = ? WHERE nome = ? AND autor = ?";
				    try (Connection con = abrir();
				         PreparedStatement ps = con.prepareStatement(sql)) {
				        
				        ps.setString(1, novoLivro.getNome().trim());
				        ps.setString(2, novoLivro.getAutor().trim());
				        ps.setInt(3, novoLivro.getPaginas());
				        ps.setInt(4, novoLivro.getCopias());
				        
				        ps.setString(5, nomeAntigo.trim());
				        ps.setString(6, autorAntigo.trim());
				        
				        ps.executeUpdate();
				    } catch (SQLException erro) {
				        throw new RuntimeException("Erro ao atualizar: " + erro.getMessage(), erro);
				    }
				}
}