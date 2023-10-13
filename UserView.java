import java.util.Scanner;
import javax.swing.JOptionPane;

public class UserView {
    Scanner scanner = new Scanner(System.in);

    public void printUserDetails(User user) {
        String message = "\n Detalles del usuario: ";

        message += ("\nNombre de usuario: " + user.getUsername());
        message += ("\nContraseña: " + user.getPassword());
        message += ("\nCorreo: " + user.getEmail());

        JOptionPane.showMessageDialog(null, message);
    }

    public String getInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public void displayMenu() {
        String message = "Menú de opciones:\n" +
                            "1. Crear usuario\n" +
                            "2. Ver detalles de usuario\n" +
                            "3. Modificar usuario\n" +
                            "4. Eliminar usuario\n" +
                            "5. Salir";

        JOptionPane.showMessageDialog(null, message);
    }
}
