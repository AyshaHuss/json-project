import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public abstract class User implements Serializable {

    private String id;
    private String firstName;
    private String lastName;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Address address;
    private String username;
    private String password;
    private String email;
    @JsonIgnore
    private static int count;
    private String type;

    public User(){
        super();
        countIncrease();
    }

    public User (String firstName, String lastName, String email, String type){
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.type = type;
        countIncrease();
        generateID();
        generateUsername();
        setInitialPassword();
       // LoginServices.addLogin(new LoginInfo(username, password, type));
    }



    private void countIncrease(){count++;}
    private void generateUsername(){
        UsernameGenerator username = new UsernameGenerator(firstName, lastName, id);
        this.username = username.getUsername();
    }

    private void generateID(){
        IdGenerator newUser = new IdGenerator(count);
        this.id = newUser.generateID();
    }

    private void setInitialPassword(){
        password = new Password(firstName, lastName).getPassword();
    }
    public void setPassword(String password){
        this.password = password;
    }
    public void setAddress(Address address){
        this.address = address;
    }
    public void setEmail(String email){this.email = email;}
    public String getFirstName(){
        return firstName;
    }
    public String getLastName() {return  lastName;}
    @JsonIgnore
    public String getFullName(){return firstName+" "+lastName;}
    public String getUsername(){
        return username;
    }
    public String getId(){return id;}

    public String getPassword(){
        return password;
    }
    public Address getAddress(){
        return address;
    }

    public static int getCount(){
        return count;
    }
    public String getEmail(){return email;}


    public String getType(){
        return type;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", address=" + address +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}



