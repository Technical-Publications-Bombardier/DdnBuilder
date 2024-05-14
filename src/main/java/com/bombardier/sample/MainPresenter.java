package com.bombardier.sample;

import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableObject;
import com.gluonhq.connect.converter.InputStreamInputConverter;
import com.gluonhq.connect.converter.JsonInputConverter;
import com.gluonhq.connect.provider.DataProvider;
import com.gluonhq.connect.provider.InputStreamObjectDataReader;
import com.gluonhq.connect.provider.ObjectDataReader;
import com.gluonhq.connect.source.BasicInputDataSource;
import com.gluonhq.connect.source.InputDataSource;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

public class MainPresenter {

    private final String javafxVersion = System.getProperty("javafx.version");

    @FXML
    private View main;

    @FXML
    private Label color;

    @FXML
    private Label label;

    @FXML
    private ResourceBundle resources;

    public void initialize() {
        main.showingProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                AppBar appBar = AppManager.getInstance().getAppBar();
                appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> AppManager.getInstance().getDrawer().open()));
                appBar.setTitleText("Data Dispatch Node Builder");
            }
        });
        label.setText(String.format(resources.getString("label.text"), "JavaFX", javafxVersion));

        loadUserName(label);
    }

    private void loadUserName(Label label) {
        // create a DataSource that loads data from a classpath resource
        InputDataSource dataSource = new BasicInputDataSource(Main.class.getResourceAsStream("user.json"));

        // create a Converter that converts a json object into a java object
        InputStreamInputConverter<User> converter = new JsonInputConverter<>(User.class);

        // create an ObjectDataReader that will read the data from the DataSource and converts
        // it from json into an object
        ObjectDataReader<User> objectDataReader = new InputStreamObjectDataReader<>(dataSource, converter);

        // retrieve an object from the DataProvider
        GluonObservableObject<User> user = DataProvider.retrieveObject(objectDataReader);

        // when the object is initialized, bind its properties to the JavaFX UI controls
        user.initializedProperty().addListener((obs, oldValue, newValue) -> {
            if (newValue) {
                label.textProperty().bind(Bindings.format(resources.getString("label.text"), user.get().nameProperty(), javafxVersion));
            }
        });
    }

    @FXML
    private void updateColor() {
        Random random = new Random();
        this.color.setTextFill(Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }
}
