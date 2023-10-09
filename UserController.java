public class UserController {
    private UserModel model;
    private UserView view;

    public UserController(UserModel model, UserView view){
        this.model = model;
        this.view = view;
    }

    public void run() {
        boolean keepRunning = true;

        while(keepRunning){
            view.displayMenu();
            int option = Integer.parseInt(view.getInput("Ingrese una opción: "));

            switch(option){
                case 1:
                    createUser();
                    break;
                case 2:
                    consultUser();
                    break;
                case 3:
                    modifyUser();
                    break;
                case 4:
                    deleteUser();
                    break;
                case 5:
                    keepRunning = false;
                    break;
                default:
                    view.showMessage("Opción inválida");
            }
        }

        view.showMessage("Hasta luego!");
    }

    private void createUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        String password = view.getInput("Ingrese la contraseña: ");
        String email = view.getInput("Ingrese el correo: ");

        User user = new User(username, password, email);
        model.addUser(user);
        view.showMessage("Usuario creado");
    }

    private void consultUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        User user = model.getUserByUsername(username);

        if(user != null){
            view.printUserDetails(user);
        } else {
            view.showMessage("El usuario no existe");
        }
    }

    private void modifyUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        User user = model.getUserByUsername(username);

        if(user != null){
            String email = view.getInput("Ingrese el correo (actual: "+user.getEmail()+"): ");

            user.setEmail(email);
            System.out.println("Usuario modificado");
        } else {
            view.showMessage("El usuario no existe");
        }
    }

    private void deleteUser() {
        String username = view.getInput("Ingrese el nombre de usuario: ");
        User user = model.getUserByUsername(username);

        if(user != null){
            model.deleteUser(user);
            view.showMessage("Usuario eliminado");
        } else {
            view.showMessage("El usuario no existe");
        }
    }
}
