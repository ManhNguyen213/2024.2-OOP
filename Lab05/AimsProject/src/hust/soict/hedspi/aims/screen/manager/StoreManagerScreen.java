package hust.soict.hedspi.aims.screen.manager;

import hust.soict.hedspi.aims.media.*;
import hust.soict.hedspi.aims.store.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class StoreManagerScreen extends JFrame {
    private Store store;

    public StoreManagerScreen(Store store) {
        this.store = store;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setTitle("Store");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        // View Store
        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            dispose();
            new StoreManagerScreen(store);
        });
        menu.add(viewStore);

        // Update Store submenu
        JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            dispose();
            new AddBookToStoreScreen(store);
        });
        smUpdateStore.add(addBook);

        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            dispose();
            new AddCompactDiscToStoreScreen(store);
        });
        smUpdateStore.add(addCD);

        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            dispose();
            new AddDigitalVideoDiscToStoreScreen(store);
        });
        smUpdateStore.add(addDVD);

        menu.add(smUpdateStore);

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;
    }

    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(Box.createRigidArea(new Dimension(10, 10)));
        return header;
    }

    private JPanel createCenter() {
        JPanel center = new JPanel(new GridLayout(3, 3, 2, 2));
        List<Media> mediaInStore = store.getItemsInStore();

        // Số cell = 3x3 = 9
        int cells = 9;
        for (int i = 0; i < cells; i++) {
            if (i < mediaInStore.size()) {
                center.add(new MediaStore(mediaInStore.get(i)));
            } else {
                // nếu không có media, thêm một panel trống để giữ layout
                center.add(new JPanel());
            }
        }

        return center;
    }
}
