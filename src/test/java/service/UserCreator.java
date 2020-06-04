package service;


import model.User;

public class UserCreator extends User {


    public UserCreator(String username, String password) {
        super(username, password);
    }


    public static User withCredentialsFromProperty() {
        return new User(getParamFromProperty("email"), getParamFromProperty("password"));
    }

    public static User withEmptyUserName() {
        return new User("", getParamFromProperty("password"));
    }

    public static User withEmptyPassword() {
        return new User(getParamFromProperty("email"), "");
    }
}
