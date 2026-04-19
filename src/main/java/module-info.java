module com.example.javafx_regex {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_regex to javafx.fxml;
    exports com.example.javafx_regex;
}