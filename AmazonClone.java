import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class AmazonClone extends JFrame {
    private JPanel productPanel, cartPanel;
    private DefaultListModel<String> cartModel;

    public AmazonClone() {
        setTitle("Amazon Clone");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JLabel header = new JLabel("Welcome to Amazon Clone!", JLabel.CENTER);
        header.setFont(new Font("Arial", Font.BOLD, 24));
        add(header, BorderLayout.NORTH);

        productPanel = new JPanel(new GridLayout(0, 2, 10, 10));
        cartPanel = new JPanel();
        cartModel = new DefaultListModel<>();
        JList<String> cartList = new JList<>(cartModel);

        JScrollPane productScroll = new JScrollPane(productPanel);
        JScrollPane cartScroll = new JScrollPane(cartList);

        cartPanel.setLayout(new BorderLayout());
        cartPanel.add(new JLabel("Shopping Cart", JLabel.CENTER), BorderLayout.NORTH);
        cartPanel.add(cartScroll, BorderLayout.CENTER);

        JButton checkoutBtn = new JButton("Checkout");
        checkoutBtn.addActionListener(e -> JOptionPane.showMessageDialog(this, "Checkout completed!"));
        cartPanel.add(checkoutBtn, BorderLayout.SOUTH);

        add(productScroll, BorderLayout.CENTER);
        add(cartPanel, BorderLayout.EAST);

        addProducts();

        setVisible(true);
    }

    private void addProducts() {
        String[] products = {"Laptop - $999", "Smartphone - $699", "Headphones - $199", "Camera - $499"};

        for (String product : products) {
            JPanel panel = new JPanel(new BorderLayout());
            JLabel name = new JLabel(product, JLabel.CENTER);
            JButton addBtn = new JButton("Add to Cart");

            addBtn.addActionListener(e -> cartModel.addElement(product));

            panel.add(name, BorderLayout.CENTER);
            panel.add(addBtn, BorderLayout.SOUTH);
            panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

            productPanel.add(panel);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(AmazonClone::new);
    }
}
