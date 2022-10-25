module com.poethan.swordwindclient {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.poethan.swordwindclient to javafx.fxml;
    exports com.poethan.swordwindclient;
}