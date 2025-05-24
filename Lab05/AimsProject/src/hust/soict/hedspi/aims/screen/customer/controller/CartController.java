package hust.soict.hedspi.aims.screen.customer.controller;

import hust.soict.hedspi.aims.Cart.*;
import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.exception.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.collections.transformation.FilteredList;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.RadioButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.SimpleFloatProperty;




public class CartController {
	private Store store;
    private Cart cart;
    
    public CartController(Store store, Cart cart) {
        this.store = store;
    	this.cart = cart;
    }

    @FXML
    private TableView<Media> tblMedia;

    @FXML
    private TableColumn<Media, Integer> colMediaId;

    @FXML
    private TableColumn<Media, String> colMediaTitle;

    @FXML
    private TableColumn<Media, String> colMediaCategory;

    @FXML
    private TableColumn<Media, Float> colMediaCost;

    @FXML
    private Label costLabel;

    @FXML
    private Button btnPlay;

    @FXML
    private Button btnRemove;

    @FXML
    private ToggleGroup filterCategory;
    
    @FXML
    private TextField tfFilter;
    
    @FXML
    private RadioButton radioBtnFilterId;
    
    @FXML
    private RadioButton radioBtnFilterTitle;


    private FilteredList<Media> filteredData;

    @FXML
    void btnPlayPressed(ActionEvent event) {
        Media media = tblMedia.getSelectionModel().getSelectedItem();
        if (media instanceof Playable) {
            try {
                ((Playable) media).play();
            } catch (PlayerException e) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Playback Error");
                alert.setHeaderText("Cannot play media");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        }
    }


    @FXML
    void btnRemovePressed(ActionEvent event) {
        Media media = (Media) tblMedia.getSelectionModel().getSelectedItem();
        if (media != null) {
            cart.removeMedia(media);
            updateTotalCost();
        }
    }

    @FXML
    void btnViewStorePressed(ActionEvent event) {
        try {
            final String STORE_FXML_FILE_PATH = "/hust/soict/hedspi/aims/screen/customer/view/Store.fxml";
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(STORE_FXML_FILE_PATH));
            Parent storeRoot = fxmlLoader.load();
            
            ViewStoreController storeController = fxmlLoader.getController();
            
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Store");
            stage.setScene(new Scene(storeRoot));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    
    @FXML
    public void initialize() {
    	colMediaId.setCellValueFactory(cellData -> new SimpleIntegerProperty(cellData.getValue().getId()).asObject());
    	colMediaTitle.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitle()));
    	colMediaCategory.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCategory()));
    	colMediaCost.setCellValueFactory(cellData -> new SimpleFloatProperty(cellData.getValue().getCost()).asObject());

        filteredData = new FilteredList<>(cart.getItemsOrdered(), p -> true);
        tblMedia.setItems(filteredData);

        btnPlay.setVisible(false);
        btnRemove.setVisible(false);

        tblMedia.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> updateButtonBar(newValue)
        );

        tfFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            showFilteredMedia(newValue);
        });
        updateTotalCost();
        System.out.println("Cart size: " + cart.getItemsOrdered().size());

    }
    
    private void updateButtonBar(Media media) {
        if (media == null) {
            btnPlay.setVisible(false);
            btnRemove.setVisible(false);
        } else {
            btnRemove.setVisible(true);
            if (media instanceof Playable) {
                btnPlay.setVisible(true);
            } else {
                btnPlay.setVisible(false);
            }
        }
    }

    private void showFilteredMedia(String filterValue) {
        if (filterValue == null || filterValue.isEmpty()) {
            filteredData.setPredicate(media -> true);
            updateTotalCost();
            return;
        }

        filteredData.setPredicate(media -> {
            if (radioBtnFilterId.isSelected()) {
                try {
                    int id = Integer.parseInt(filterValue);
                    return media.getId() == id;
                } catch (NumberFormatException e) {
                    return false;
                }
            } else if (radioBtnFilterTitle.isSelected()) {
                return media.getTitle().toLowerCase().contains(filterValue.toLowerCase());
            }
            return true;
        });
        updateTotalCost();
    }


    private void updateTotalCost() {
        costLabel.setText(String.format("%.2f $", cart.getTotalCost()));
    }
    
}
