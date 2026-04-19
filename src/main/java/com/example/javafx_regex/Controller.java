package com.example.javafx_regex;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.fxml.FXMLLoader;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Handles validation and form submission.
 * @author Armaan
 */
public class Controller {

    @FXML private TextField firstNameField, lastNameField, emailField, dobField, zipField;
    @FXML private Label firstNameError, lastNameError, emailError, dobError, zipError;
    @FXML private Button addButton;

    // Regex Patterns
    private final Pattern namePattern = Pattern.compile("^[A-Za-z]{2,25}$");
    private final Pattern dobPattern = Pattern.compile("^(0[1-9]|1[0-2])/([0-2][0-9]|3[01])/\\d{4}$");
    private final Pattern emailPattern = Pattern.compile("^[A-Za-z0-9._%+-]+@farmingdale\\.edu$");
    private final Pattern zipPattern = Pattern.compile("^\\d{5}$");

    @FXML
    public void initialize() {
        setupValidation();
    }

    private void setupValidation() {

        firstNameField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateFirstName();
        });

        lastNameField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateLastName();
        });

        emailField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateEmail();
        });

        dobField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateDOB();
        });

        zipField.focusedProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal) validateZip();
        });
    }

    private void validateFirstName() {
        if (!namePattern.matcher(firstNameField.getText()).matches()) {
            firstNameError.setText("Invalid (2-25 letters)");
        } else {
            firstNameError.setText("");
        }
        checkAllValid();
    }

    private void validateLastName() {
        if (!namePattern.matcher(lastNameField.getText()).matches()) {
            lastNameError.setText("Invalid (2-25 letters)");
        } else {
            lastNameError.setText("");
        }
        checkAllValid();
    }

    private void validateEmail() {
        if (!emailPattern.matcher(emailField.getText()).matches()) {
            emailError.setText("Use @farmingdale.edu email");
        } else {
            emailError.setText("");
        }
        checkAllValid();
    }

    private void validateDOB() {
        if (!dobPattern.matcher(dobField.getText()).matches()) {
            dobError.setText("Format MM/DD/YYYY");
        } else {
            dobError.setText("");
        }
        checkAllValid();
    }

    private void validateZip() {
        if (!zipPattern.matcher(zipField.getText()).matches()) {
            zipError.setText("5-digit zip only");
        } else {
            zipError.setText("");
        }
        checkAllValid();
    }

    private void checkAllValid() {
        boolean valid =
                namePattern.matcher(firstNameField.getText()).matches() &&
                        namePattern.matcher(lastNameField.getText()).matches() &&
                        emailPattern.matcher(emailField.getText()).matches() &&
                        dobPattern.matcher(dobField.getText()).matches() &&
                        zipPattern.matcher(zipField.getText()).matches();

        addButton.setDisable(!valid);
    }

    @FXML
    private void handleAdd() throws IOException {
        Stage stage = (Stage) addButton.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/com/example/javafx_regex/success.fxml"))));
    }
}