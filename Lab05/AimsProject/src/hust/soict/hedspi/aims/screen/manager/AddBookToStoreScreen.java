package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.*;
import hust.soict.hedspi.aims.media.*;

import javax.swing.*;
import java.awt.*;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    public AddBookToStoreScreen(Store store) {
        super(store);

        JPanel panel = new JPanel(new GridLayout(5, 2));

        JTextField idField = new JTextField();
        JTextField titleField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField costField = new JTextField();

        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Title:"));
        panel.add(titleField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Cost:"));
        panel.add(costField);

        JButton addButton = new JButton("Add Book");
        addButton.addActionListener(e -> {
            int id = Integer.parseInt(idField.getText());
            String title = titleField.getText();
            String category = categoryField.getText();
            float cost = Float.parseFloat(costField.getText());

            Book book = new Book(id, title, category, cost);
            store.addMedia(book);
            JOptionPane.showMessageDialog(this, "Book added to store!");
        });

        panel.add(new JLabel());
        panel.add(addButton);

        add(panel);
        setVisible(true);
    }
}
