import java.io.Serializable;

public class LoginInfo implements Serializable {
    private String username;
    private String password;
    private String type;

    public LoginInfo(){
        super();
    }

    public LoginInfo(String username, String password, String type){
        super();
        this.password = password;
        this.username = username;
        this.type = type;
    }

    public String getUsername(){
        return username;
    }

    public String getPassword(){
        return password;
    }

    public String getType(){
        return type;
    }

    public void setPassword(String password){this.password = password;}

}
