package model;

import pages.MainPage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;


public class User extends MainPage {

    private String username;
    private String password;



    protected static String getParamFromProperty(String propertyName) {
        FileInputStream fis;
        Properties properties = new Properties();
        String emailFromPropertyFile = "";
        try {
            fis = new FileInputStream("./src/test/resources/dev.properties");
            properties.load(fis);
            emailFromPropertyFile = properties.getProperty(propertyName);
        } catch (FileNotFoundException e) {
            logger.warn("Check out file's path");
        } catch (IOException e) {
            logger.warn(e.getMessage());
        }
        return emailFromPropertyFile;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return getParamFromProperty("email");
    }

    public String getPassword() {
        return getParamFromProperty("password");
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getUsername(), user.getUsername()) &&
                Objects.equals(getPassword(), user.getPassword());
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUsername(), getPassword());
    }

}