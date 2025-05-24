package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;

import javax.swing.*;
import java.awt.*;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    public AddCompactDiscToStoreScreen(Store store) {
        super(store);

        JPanel panel = new JPanel(new GridLayout(7, 2));

        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField directorField = new JTextField();
        JTextField lengthField = new JTextField();
        JTextField costField = new JTextField();
        JTextField artistField = new JTextField();

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
        panel.add(new JLabel("Artist:"));
        panel.add(artistField);

        JButton addButton = new JButton("Add CD");
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            String director = directorField.getText();
            int length = Integer.parseInt(lengthField.getText());
            float cost = Float.parseFloat(costField.getText());
            String artist = artistField.getText();

            CompactDisc cd = new CompactDisc(id, title, category, cost, length, artist);
            store.addMedia(cd);
            JOptionPane.showMessageDialog(this, "CD added to store!");
        });

        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }
}