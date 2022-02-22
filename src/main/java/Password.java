public class Password {
    private String password;


    public Password(){}

    public Password(String firstName, String lastName){
        generatePassword(firstName, lastName);

    }

    public String generateRandomNum(){
        Integer random_int = (int)Math.floor(Math.random()*(6000-1000+1)+1000);
        return random_int.toString();
    }

    public void generatePassword(String firstName, String lastName){
        this.password =  String.valueOf(firstName.toLowerCase().charAt(0))+String.valueOf(firstName.toLowerCase().charAt(1))+String.valueOf(lastName.toLowerCase().charAt(0)+ generateRandomNum());
    }


    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword(){
        return password;
    }
}

