package DentaSoft.Persistencia;

import java.sql.DriverManager;

/**
 *
 * @author estdi
 */
public class AccesoDatosJDBCPostgreSQL extends AccesoDatosJDBC {

    @Override
    public void abrirConexion() throws Exception {
        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://localhost:5432/dentasoft";
            conexion = DriverManager.getConnection(url, "postgres", "123"); // ya ahora debe f
        } catch (Exception e) {
            throw new Exception("Ocuurio un problema en la conexión con la base de datos.", e);
        }

    }

}
