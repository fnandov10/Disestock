package principal;

import dao.UsuarioDAO;
import modelo.Usuario;

public class Main {

    public static void main(String[] args) {

        UsuarioDAO dao = new UsuarioDAO();

        // Usuario 1
        Usuario usuario1 = new Usuario();
        usuario1.setNombre("Fernando");
        usuario1.setApellido("Montoya");
        usuario1.setCorreo("fernando.montoya@disestock.com");
        usuario1.setRol("Administrador");
        usuario1.setEstado("Activo");

        // Usuario 2
        Usuario usuario2 = new Usuario();
        usuario2.setNombre("Laura");
        usuario2.setApellido("Gomez");
        usuario2.setCorreo("laura.gomez@disestock.com");
        usuario2.setRol("Bodeguero");
        usuario2.setEstado("Activo");

        // Registrar usuarios
        dao.insertar(usuario1);
        dao.insertar(usuario2);

        System.out.println("\n===== USUARIOS REGISTRADOS =====");
        dao.listar();

        // Actualizar usuario
        dao.actualizar(2, "Supervisor");

        System.out.println("\n===== DESPUÉS DE ACTUALIZAR =====");
        dao.listar();

        // Eliminar usuario
        dao.eliminar(2);

        System.out.println("\n===== DESPUÉS DE ELIMINAR =====");
        dao.listar();

    }

}