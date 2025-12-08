module edu.westga.cs1302.Collection {
    requires javafx.controls;
    requires javafx.fxml;
    requires transitive javafx.graphics;
	requires javafx.base;

    opens edu.westga.cs1302.Collection.view to javafx.fxml;
    exports edu.westga.cs1302.Collection;
    exports edu.westga.cs1302.Collection.model;
    exports edu.westga.cs1302.Collection.viewmodel;
    exports edu.westga.cs1302.Collection.view;
}
