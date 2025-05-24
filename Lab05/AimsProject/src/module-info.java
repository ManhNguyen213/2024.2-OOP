/**
 * 
 */
/**
 * 
 */
module AimsProject {
	requires java.desktop;
	requires javafx.controls;
	requires javafx.fxml;
	
	exports hust.soict.hedspi.test.screen.customer.store to javafx.graphics, javafx.fxml;
	opens hust.soict.hedspi.aims.screen.customer.controller to javafx.fxml;
	exports hust.soict.hedspi.aims.screen.customer.controller to javafx.fxml;
}