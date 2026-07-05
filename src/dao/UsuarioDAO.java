package dao;

import conexion.ConexionBD;
import modelo.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class UsuarioDAO {

    // INSERTAR
    public void insertar(Usuario usuario) {

        String sql = "INSERT INTO usuarios(nombre, apellido, correo, rol, estado) VALUES (?, ?, ?, ?, ?)";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getCorreo());
            ps.setString(4, usuario.getRol());
            ps.setString(5, usuario.getEstado());

            ps.executeUpdate();

            System.out.println("Usuario registrado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al insertar usuario: " + e.getMessage());

        }

    }

    // LISTAR
    public void listar() {

        String sql = "SELECT * FROM usuarios";

        try {

            Connection conexion = ConexionBD.conectar();

            Statement st = conexion.createStatement();

            ResultSet rs = st.executeQuery(sql);

            System.out.println("\n======= LISTA DE USUARIOS =======");

            while (rs.next()) {

                System.out.println(
                        rs.getInt("id_usuario") + " | " +
                                rs.getString("nombre") + " | " +
                                rs.getString("apellido") + " | " +
                                rs.getString("correo") + " | " +
                                rs.getString("rol") + " | " +
                                rs.getString("estado")
                );

            }

            rs.close();
            st.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al consultar usuarios: " + e.getMessage());

        }

    }

    // ACTUALIZAR
    public void actualizar(int id, String nuevoRol) {

        String sql = "UPDATE usuarios SET rol = ? WHERE id_usuario = ?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setString(1, nuevoRol);
            ps.setInt(2, id);

            ps.executeUpdate();

            System.out.println("Usuario actualizado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al actualizar usuario: " + e.getMessage());

        }

    }

    // ELIMINAR
    public void eliminar(int id) {

        String sql = "DELETE FROM usuarios WHERE id_usuario = ?";

        try {

            Connection conexion = ConexionBD.conectar();

            PreparedStatement ps = conexion.prepareStatement(sql);

            ps.setInt(1, id);

            ps.executeUpdate();

            System.out.println("Usuario eliminado correctamente.");

            ps.close();
            conexion.close();

        } catch (SQLException e) {

            System.out.println("Error al eliminar usuario: " + e.getMessage());

        }

    }

}