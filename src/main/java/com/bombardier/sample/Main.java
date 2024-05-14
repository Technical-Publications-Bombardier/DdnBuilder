package com.bombardier.sample;

import com.gluonhq.attach.display.DisplayService;
import com.gluonhq.attach.util.Platform;
import com.gluonhq.charm.glisten.application.AppManager;
import com.gluonhq.charm.glisten.visual.Swatch;
import com.gluonhq.cloudlink.client.push.PushClient;
import javafx.application.Application;
import javafx.geometry.Dimension2D;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class Main extends Application {

    private final AppManager appManager = AppManager.initialize(this::postInit);

    @Override
    public void init() {
        PushClient pushClient = new PushClient();
        pushClient.enable();

        AppViewManager.registerViewsAndDrawer();
    }

    @Override
    public void start(Stage stage) {
        appManager.start(stage);
    }

    private void postInit(Scene scene) {
        Swatch.LIGHT_GREEN.assignTo(scene);
        scene.getStylesheets().add(Objects.requireNonNull(Main.class.getResource("styles.css")).toExternalForm());
        ((Stage) scene.getWindow()).getIcons().add(new Image(Objects.requireNonNull(Main.class.getResourceAsStream("/icon.png"))));

        if (Platform.isDesktop()) {
            Dimension2D dimension2D = DisplayService.create()
                    .map(DisplayService::getDefaultDimensions)
                    .orElse(new Dimension2D(640, 480));
            scene.getWindow().setWidth(dimension2D.getWidth());
            scene.getWindow().setHeight(dimension2D.getHeight());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
