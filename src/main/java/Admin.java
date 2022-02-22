public class Admin extends User{
    public Admin() {
        super();
    }

    public Admin(String firstName, String lastName, String email, String type) {
        super(firstName, lastName, email, "admin");
    }

}
