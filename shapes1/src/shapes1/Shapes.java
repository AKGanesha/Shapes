/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shapes1;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javafx.application.Application;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Point3D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Box;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Transform;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

/**
 *
 * @author hp
 */
public class Shapes extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane mainpane = new BorderPane();

        StackPane left = new StackPane();
        //left.setStyle("-fx-background-image: url('https://th.bing.com/th/id/OIP.JjRIiXR6RfQBuy666eWxSgHaHY?w=209&h=208&c=7&r=0&o=5&pid=1.7'); ");
        BackgroundImage myBI = new BackgroundImage(new Image(this.getClass().getResource("axial.jpg").toExternalForm()),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT,
                BackgroundSize.DEFAULT);
//then you set to your node
        left.setBackground(new Background(myBI));
        left.setStyle("-fx-background-color: silver;");
        

        StackPane center = new StackPane();
        center.setStyle("-fx-background-color: silver;");

        StackPane right = new StackPane();
        right.setStyle("-fx-background-color: silver;");

        Box b1 = new Box(100, 100, 5);
        Box b2 = new Box(100, 100, 5);
        Box b3 = new Box(100, 100, 5);

        Transform transform2 = new Rotate(90, Rotate.X_AXIS);
        b2.getTransforms().add(transform2);
        b2.setTranslateZ(b2.getHeight() / 2);

        Transform transform3 = new Rotate(90, Rotate.X_AXIS);
        Transform transform4 = new Rotate(90, Rotate.Z_AXIS);
        b3.getTransforms().addAll(transform3, transform4);
        b3.setTranslateZ(b2.getHeight() / 2);

        PerspectiveCamera camera1 = new PerspectiveCamera();
        //camera1.getTransforms().addAll(new Translate(0, 0));
        PerspectiveCamera camera2 = new PerspectiveCamera();
        //camera2.getTransforms().addAll(new Translate(0, 0));
        PerspectiveCamera camera3 = new PerspectiveCamera();
        //camera3.getTransforms().addAll(new Translate(0, 0));

        SubScene sc1 = new SubScene(left, 512, 512);
        //Image axialImg = new Image("https://th.bing.com/th/id/OIP.JjRIiXR6RfQBuy666eWxSgHaHY?w=209&h=208&c=7&r=0&o=5&pid=1.7");
//        sc1.setStyle("-fx-background-image: url('https://th.bing.com/th/id/OIP.JjRIiXR6RfQBuy666eWxSgHaHY?w=209&h=208&c=7&r=0&o=5&pid=1.7'); ");
        //ImagePattern pattern = new ImagePattern(axialImg);
        //sc1.setFill(pattern);
        sc1.setCamera(camera1);

        SubScene sc2 = new SubScene(center, 512, 512);
        sc2.setCamera(camera2);

        SubScene sc3 = new SubScene(right, 512, 512);
        sc3.setCamera(camera3);

//        b1.setTranslateX(0);
//        b1.setTranslateY(0);
//        b1.setTranslateZ(0);
//        b2.setTranslateX(400);
//        b2.setTranslateY(250);
//        b2.setTranslateZ(0);
//        
//        b3.setTranslateX(600);
//        b3.setTranslateY(250);
//        b3.setTranslateZ(0);
        left.getChildren().addAll(b1);
        center.getChildren().addAll(b2);
        right.getChildren().addAll(b3);
        
        mainpane.setPrefSize(1536,512);
        mainpane.setLeft(sc1);
        mainpane.setCenter(sc2);
        mainpane.setRight(sc3);
        Scene scene = new Scene(mainpane);
        //scene.setFill(javafx.scene.paint.Color.SILVER);

        scene.addEventHandler(javafx.scene.input.KeyEvent.KEY_PRESSED, (event) -> {
            //System.out.println(event.getCode());
            switch (event.getCode()) {
                case UP:
                    b1.setWidth(b1.getWidth() + 10);
                    b1.setHeight(b1.getHeight() + 10);

                    b2.setWidth(b2.getWidth() + 10);
                    b2.setHeight(b2.getHeight() + 10);

                    b3.setWidth(b3.getWidth() + 10);
                    b3.setHeight(b3.getHeight() + 10);

                    break;
                case DOWN:
                    b1.setWidth(b1.getWidth() - 10);
                    b1.setHeight(b1.getHeight() - 10);

                    b2.setWidth(b2.getWidth() - 10);
                    b2.setHeight(b2.getHeight() - 10);

                    b3.setWidth(b3.getWidth() - 10);
                    b3.setHeight(b3.getHeight() - 10);

                    break;
            }
        });
        // b1.setVisible(false);

        b1.addEventHandler(MouseEvent.MOUSE_ENTERED, (event) -> {
            System.out.println(b1.getTranslateX() + (b1.getWidth() / 2));
        });
       
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
