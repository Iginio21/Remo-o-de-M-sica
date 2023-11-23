import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Musica {
    private int id;
    private String nome;
    private boolean ativo;

    // Construtor, getters e setters aqui...

    public void desativar() {
        this.ativo = false;
        atualizarNoBancoDeDados();
    }

    private void atualizarNoBancoDeDados() {
        String url = "jdbc:mysql://localhost:3306/seubanco";
        String usuario = "seuusuario";
        String senha = "suasenha";

        try (Connection conexao = DriverManager.getConnection(url, usuario, senha)) {
            String sql = "UPDATE musicas SET ativo = ? WHERE id = ?";
            try (PreparedStatement declaracao = conexao.prepareStatement(sql)) {
                declaracao.setBoolean(1, this.ativo);
                declaracao.setInt(2, this.id);
                declaracao.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Métodos adicionais, se necessário...
}
