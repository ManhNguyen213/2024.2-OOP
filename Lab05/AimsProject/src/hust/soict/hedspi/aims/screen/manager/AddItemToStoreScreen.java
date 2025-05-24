package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.store.*;

import javax.swing.*;
import java.awt.*;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;

    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setTitle("Add Item to Store");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setJMenuBar(createMenuBar());
    }

    protected JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menu = new JMenu("Options");
        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });

        JMenu updateStoreMenu = new JMenu("Update Store");
        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });

        updateStoreMenu.add(addBookItem);
        updateStoreMenu.add(addCDItem);
        updateStoreMenu.add(addDVDItem);

        menu.add(viewStoreItem);
        menu.add(updateStoreMenu);

        menuBar.add(menu);
        return menuBar;
    }
}
