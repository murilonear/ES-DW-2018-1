package dw;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AnimalModel {
  private String nome;
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }

  private Integer idade;
  public Integer getIdade() {
    return idade;
  }
  public void setIdade(Integer idade) {
    this.idade = idade;
  }

  private String raca;
  public String getRaca() {
    return raca;
  }
  public void setRaca(String raca) {
    this.raca = raca;
  }

  private static Connection obterConexao() throws SQLException {
    //Estabelecer uma conexão com o banco de dados.
    String url = "jdbc:derby://localhost:1527/animaldb;create=true";
    String user = "app";
    String password = "app";
    return DriverManager.getConnection(url, user, password);
  }

  public void incluir() throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "insert into animal (nome, idade, raca) values (?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, nome);
    pstmt.setInt(2, idade);
    pstmt.setString(3, raca);
    pstmt.execute();
  }

  public void salvar() throws SQLException {
    Connection conn = obterConexao();

    //Obter sentença SQL.
    String sql = "update animal set nome = ?, idade = ? where nome = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, nome);
    pstmt.setInt(2, idade);
    pstmt.setString(3, raca);
    pstmt.execute();
  }

  public void excluir() throws SQLException {
    Connection conn = obterConexao();
    
    //Obter sentença SQL.
    String sql = "delete from animal where nome = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, nome);
    pstmt.execute();
  }

  public static List<AnimalModel> listar() throws SQLException {
    Connection conn = obterConexao();
    
    Statement stmt = conn.createStatement();
    String sql = "select nome, idade, raca from animal order by nome";
    ResultSet rs = stmt.executeQuery(sql);
  
    List<AnimalModel> listaDeAnimais = new ArrayList<AnimalModel>();
    while (rs.next()) {
      AnimalModel venda = new AnimalModel();
      venda.setNome(rs.getString("nome"));
      venda.setIdade(rs.getInt("idade"));
      venda.setRaca(rs.getString("raca"));
      listaDeAnimais.add(venda);
    }
    return listaDeAnimais;
  }
}
