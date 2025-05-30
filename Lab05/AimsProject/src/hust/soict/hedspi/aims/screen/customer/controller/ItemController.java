package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.Cart.*;
import javafx.fxml.FXML;
import hust.soict.hedspi.aims.exception.*;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;


public class ItemController {
    private Media media;
    private Cart cart;

    @FXML
    private Label lb1Title;

    @FXML
    private Label lb1Cost;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnAddToCart;

    public void setData(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        lb1Title.setText(media.getTitle());
        lb1Cost.setText(String.format("$%.2f", media.getCost()));

        btnPlay.setVisible(media instanceof Playable);
    }
    
    @FXML
    void btnAddToCartClicked(ActionEvent event) {
        cart.addMedia(media);
        Alert alert = new Alert(Alert.AlertType.INFORMATION, "Added to cart!");
        alert.show();
    }
    
    @FXML
    void btnPlayClicked(ActionEvent event) {
        if (media == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "No media selected!");
            alert.show();
            return;
        }

        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error playing media: " + e.getMessage());
                alert.show();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING, "This media cannot be played!");
            alert.show();
        }
    }

}
