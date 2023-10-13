import java.util.Scanner;

public class UserView {
    Scanner scanner = new Scanner(System.in);

    public void printUserDetails(User user) {
        System.out.println("\n Detalles del usuario: ");
        System.out.println("Nombre de usuario: " + user.getUsername());
        System.out.println("Contraseña: " + user.getPassword());
        System.out.println("Correo: " + user.getEmail());
    }

    public String getInput(String message) {
        System.out.print(message);
        return this.scanner.nextLine();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void displayMenu() {
        System.out.println("\n Menú de opciones: ");
        System.out.println("1. Crear usuario");
        System.out.println("2. Ver detalles de usuario");
        System.out.println("3. Modificar usuario");
        System.out.println("4. Eliminar usuario");
        System.out.println("5. Salir");
        System.out.println("Ingrese una opción: ");
    }
}
