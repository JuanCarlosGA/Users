import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserRegistration {
    private List<String> usernames = new ArrayList<>();
    private List<String> passwords = new ArrayList<>();
    private List<String> emails = new ArrayList<>();

    private Scanner scanner = new Scanner(System.in);

    public void displayMenu() {
        boolean keepRunning = true;

        while (keepRunning) {
            System.out.println("\nMenu");
            System.out.println("1. Registrar Usuario");
            System.out.println("2. Consultar Usuario");
            System.out.println("3. Modificar Usuario");
            System.out.println("4. Eliminar Usuario");
            System.out.println("5. Salir");
            System.out.print("Elige tu opción: ");

            String option = scanner.nextLine();
            switch (option) {
                case "1":
                    createUser();
                    break;
                case "2":
                    consultUser();
                    break;
                case "3":
                    modifyUser();
                    break;
                case "4":
                    deleteUser();
                    break;
                case "5":
                    keepRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void createUser() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();
        System.out.print("Contraseña: ");
        String password = scanner.nextLine();
        System.out.print("Correo electrónico: ");
        String email = scanner.nextLine();

        usernames.add(username);
        passwords.add(password);
        emails.add(email);
    }

    private int getUserIndexByUsername(String username) {
        return username.indexOf(username);
    }

    private void consultUser() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();

        int index = getUserIndexByUsername(username);
        if (index != -1) {
            System.out.println("Nombre de usuario: " + usernames.get(index));
            System.out.println("Correo electrónico: " + emails.get(index));
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private void modifyUser() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();

        int index = getUserIndexByUsername(username);
        if (index != -1) {
            System.out.print("Correo electrónico (actual: "+emails.get(index)+"): ");
            String email = scanner.nextLine();

            emails.set(index, email);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    private void deleteUser() {
        System.out.print("Nombre de usuario: ");
        String username = scanner.nextLine();

        int index = getUserIndexByUsername(username);
        if (index != -1) {
            usernames.remove(index);
            passwords.remove(index);
            emails.remove(index);
        } else {
            System.out.println("Usuario no encontrado");
        }
    }

    public static void main(String[] args) {
        new UserRegistration().displayMenu();
    }
}