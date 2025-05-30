package hust.soict.hedspi.test.screen.customer.store;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.Cart.*;
import hust.soict.hedspi.aims.screen.customer.controller.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class TestViewStoreScreen extends Application {

    private static Store store;
    private static Cart cart;

    @Override
    public void start(Stage primaryStage) throws Exception {
        final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));

        fxmlLoader.setControllerFactory(controllerClass -> {
            if (controllerClass == ViewStoreController.class) {
                return new ViewStoreController(store, cart);
            } else {
                try {
                    return controllerClass.getDeclaredConstructor().newInstance();
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Parent root = fxmlLoader.load(); 

        primaryStage.setTitle("Store");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
    
    


    public static void main(String[] args) {
        store = new Store();
        cart = new Cart(); 

        store.addMedia(new DigitalVideoDisc(1, "The Lion King", "Animation", "Roger Allers", 87, 19.95f));
        store.addMedia(new DigitalVideoDisc(2, "Star Wars", "Science Fiction", "George Lucas", 124, 24.95f));
        store.addMedia(new Book(3, "Effective Java", "Programming", 35.50f));
        store.addMedia(new CompactDisc(4, "Greatest Hits", "Music", 12.99f, 60, "Various Artists"));
        store.addMedia(new DigitalVideoDisc(5, "Avengers: Endgame", "Action", "Russo Brothers", 181, 29.99f));
        store.addMedia(new Book(6, "Clean Code", "Programming", 40.00f));
        store.addMedia(new CompactDisc(7, "Top Hits 2020", "Music", 15.00f, 75, "Various Artists"));
        store.addMedia(new DigitalVideoDisc(8, "Inception", "Thriller", "Christopher Nolan", 148, 22.99f));
        store.addMedia(new Book(9, "Design Patterns", "Programming", 45.00f));

        launch(args);
    }
}

