public class UsernameGenerator {
    private String username;

    public UsernameGenerator(String firstName, String lastName, String id) {
        generateUserName(firstName, lastName, id);
    }


    public UsernameGenerator(){}

    public String getUsername() {
        return username;
    }


    private void generateUserName(String firstName, String lastName, String id){
        this.username = String.valueOf(firstName.toLowerCase().charAt(0))+String.valueOf(firstName.toLowerCase().charAt(1))+String.valueOf(lastName.toLowerCase().charAt(0)+id+"@ju.edu.com" );

    }


}
