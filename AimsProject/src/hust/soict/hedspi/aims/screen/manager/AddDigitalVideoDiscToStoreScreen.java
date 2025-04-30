package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;

import javax.swing.*;
import java.awt.*;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    public AddDigitalVideoDiscToStoreScreen(Store store) {
        super(store);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField costField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Director:"));
        panel.add(directorField);
        panel.add(new JLabel("Length:"));
        panel.add(lengthField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);

        JButton addButton = new JButton("Add DVD");
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());
            float cost = Float.parseFloat(costField.getText());

            DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, director, length, cost);
            store.addMedia(dvd);
            JOptionPane.showMessageDialog(this, "DVD added to store!");
        });

        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }
}
