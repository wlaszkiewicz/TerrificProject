package org.example.terrificproject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;

public class LoginController {
    public static ArrayList<User> users = new ArrayList<>();
    public static User loggedInUser;
    public static boolean whileRenting; // used to determine if the user is logging in while renting a vehicle
    @FXML
    private TextField usernameField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Text errorText;
    private Stage stage;

    @FXML
    void initialize() {
        users = loadUsers();
    }

    private ArrayList<User> loadUsers() { // get the users from the file
        File file = new File("db/users.json");
        if (!file.exists() || file.length() == 0) { // if the file does not exist or is empty, return an empty list
            return new ArrayList<>();
        }

        try (FileReader reader = new FileReader(file)) {
            Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new LocalDateTypeAdapter()).setPrettyPrinting().create();
            Type userListType = new TypeToken<ArrayList<User>>() {
            }.getType();
            ArrayList<User> users = gson.fromJson(reader, userListType);
            if (users == null) {
                users = new ArrayList<>();
            }
            return users;
        } catch (com.google.gson.JsonSyntaxException e) {
            e.printStackTrace();
            return new ArrayList<>();
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }

    }

    @FXML
    void loginPressed(ActionEvent event) throws IOException {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorText.setText("All fields must be filled");
            return;
        }

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                logIn();
                return;
            }
        }

        errorText.setText("Invalid username or password");


    }

    @FXML
    void registerPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("register.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backPressed(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("rental.fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);
        stage = (Stage) usernameField.getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    private void logIn() throws IOException {
        loggedInUser = users.stream().filter(user -> user.getUsername().equals(usernameField.getText())).findFirst().get();
        RentalController.loggedInUser = loggedInUser;
        FXMLLoader loader;

        if (whileRenting) { // if logging in while renting a vehicle, go to the reserveLoggedIn scene
            loader = new FXMLLoader(getClass().getResource("reserveLoggedIn.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(scene);
        } else { // if  logging in normally, go to the rental scene
            loader = new FXMLLoader(getClass().getResource("rental.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(scene);
        }

        stage.show();

        whileRenting = false; // reset the whileRenting variable
    }


}

