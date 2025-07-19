import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class atmInterface extends JFrame {
    private double balance = 1000.0;

    private JLabel balanceLabel;
    private JTextField amountField;
    private JButton withdrawButton;
    private JButton depositButton;
    private JButton checkBalanceButton;
    private static String storedPin = "1234"; 
    private static int attemptsLeft = 3;


    public atmInterface() {
        setTitle("ATM Machine");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        Font font = new Font("Arial", Font.BOLD, 18);

        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(240, 248, 255));
        leftPanel.setLayout(new BoxLayout(leftPanel, BoxLayout.Y_AXIS));
        leftPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        amountField = new JTextField();
        amountField.setFont(font);
        amountField.setMaximumSize(new Dimension(300, 40));
        amountField.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(amountField);

        leftPanel.add(Box.createVerticalStrut(80));

        balanceLabel = new JLabel("Balance: ₹" + balance);
        balanceLabel.setVisible(false);
        balanceLabel.setFont(font);
        balanceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        leftPanel.add(balanceLabel);
        leftPanel.add(Box.createVerticalGlue());


        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 239, 213));
        rightPanel.setLayout(new GridLayout(3, 1, 10, 10));
        rightPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));

        withdrawButton = new JButton("Withdraw");
        withdrawButton.setFont(font);
        withdrawButton.setBackground(new Color(248, 108, 108));
        withdrawButton.setForeground(Color.WHITE);
        withdrawButton.addActionListener(this::withdrawAction);
        rightPanel.add(withdrawButton);

        depositButton = new JButton("Deposit");
        depositButton.setFont(font);
        depositButton.setBackground(new Color(152, 215, 89));
        depositButton.setForeground(Color.WHITE);
        depositButton.addActionListener(this::depositAction);
        rightPanel.add(depositButton);

        checkBalanceButton = new JButton("Check Balance");
        checkBalanceButton.setFont(font);
        checkBalanceButton.setBackground(new Color(129, 164, 238));
        checkBalanceButton.setForeground(Color.WHITE);

        checkBalanceButton.addActionListener(e -> {
            updateBalanceLabel();
            balanceLabel.setVisible(true);
        });



        rightPanel.add(checkBalanceButton);

        add(leftPanel, BorderLayout.CENTER);
        add(rightPanel, BorderLayout.EAST);

        getContentPane().setBackground(new Color(224, 255, 255));
        setVisible(true);
    }



    private void updateBalanceLabel() {
        balanceLabel.setText("Balance: ₹" + String.format("%.2f", balance));
    }

    private void withdrawAction(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0 || amount > balance) {
                JOptionPane.showMessageDialog(this, "Invalid amount or insufficient balance.");
            } else {
                balance -= amount;
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Withdrawal successful!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number.");
        }
    }

    private void depositAction(ActionEvent e) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount <= 0) {
                JOptionPane.showMessageDialog(this, "Enter a positive amount.");
            } else {
                balance += amount;
                updateBalanceLabel();
                JOptionPane.showMessageDialog(this, "Deposit successful!");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Enter a valid number.");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> showPinFrame());
    }

    private static void showPinFrame() {
        JFrame pinFrame = new JFrame("Enter PIN");
        pinFrame.setSize(300, 180);
        pinFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        pinFrame.setLayout(new GridLayout(4, 1));
        pinFrame.setLocationRelativeTo(null);

        JLabel label = new JLabel("Enter 4-digit PIN:");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        pinFrame.add(label);

        JPasswordField pinField = new JPasswordField();
        pinField.setHorizontalAlignment(SwingConstants.CENTER);
        pinFrame.add(pinField);

        JLabel statusLabel = new JLabel("Attempts left: " + attemptsLeft);
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pinFrame.add(statusLabel);

        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String enteredPin = new String(pinField.getPassword());

            if (enteredPin.equals(storedPin)) {
                pinFrame.dispose();
                atmInterface atm = new atmInterface();
                atm.showChangePinDialog();
            } else {
                attemptsLeft--;
                statusLabel.setText("Attempts left: " + attemptsLeft);
                pinField.setText("");
                if (attemptsLeft == 0) {
                    JOptionPane.showMessageDialog(pinFrame, "Too many failed attempts. Exiting.");
                    System.exit(0);
                } else {
                    JOptionPane.showMessageDialog(pinFrame, "Incorrect PIN. Try again.");
                }
            }
        });
        pinFrame.add(loginButton);
        pinFrame.setVisible(true);
    }

    public void showChangePinDialog() {
        int choice = JOptionPane.showConfirmDialog(this, "Do you want to change your PIN?", "Change PIN", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            JPanel panel = new JPanel(new GridLayout(2, 2));
            JPasswordField newPinField = new JPasswordField();
            JPasswordField confirmPinField = new JPasswordField();

            panel.add(new JLabel("New PIN:"));
            panel.add(newPinField);
            panel.add(new JLabel("Confirm PIN:"));
            panel.add(confirmPinField);

            int result = JOptionPane.showConfirmDialog(this, panel, "Change PIN", JOptionPane.OK_CANCEL_OPTION);

            if (result == JOptionPane.OK_OPTION) {
                String newPin = new String(newPinField.getPassword());
                String confirmPin = new String(confirmPinField.getPassword());

                if (newPin.matches("\\d{4}") && newPin.equals(confirmPin)) {
                    storedPin = newPin;
                    JOptionPane.showMessageDialog(this, "✅ PIN changed successfully.");
                } else {
                    JOptionPane.showMessageDialog(this, "⚠️ Invalid PIN or mismatch.");
                }
            }
        }
    }
}