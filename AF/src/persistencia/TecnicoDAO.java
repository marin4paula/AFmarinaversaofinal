package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import controle.Controlador;

public class TecnicoDAO {
    public void inserir() {
        try {
            Connection conexao = new Conexao().getConexao();

            PreparedStatement inserir = conexao.prepareStatement("INSERT INTO tecnico (tecnico) VALUES (?)");
            inserir.setString(1, Controlador.aluno);

            inserir.executeUpdate();

            conexao.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
