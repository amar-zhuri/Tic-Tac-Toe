module org.example.testtictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.tinylog.api;

    // Allow reflection for FXML
    opens org.example.tictactoe to javafx.fxml;
    opens org.example.tictactoe.controllers to javafx.fxml;

    // Export the main package
    exports org.example.tictactoe;
}
