

import java.awt.Font;

/**
 *
 * @author Ayush kumar
 */
public class numberGame extends javax.swing.JFrame {
    int computerNumber = 0;
    String str2 = "";

    public numberGame() {
        initComponents();
        Font customFont = new Font("Arial", Font.BOLD, 16); // You can change size & font here

        comuter.setFont(customFont);
        result.setFont(customFont);
        jButton1.setFont(customFont);
        number.setFont(customFont); // for text field too

        setTitle("Number Guessing Game 🎲");
        computerNumber = (int) (Math.random() * 100 + 1);

        getContentPane().setBackground(new java.awt.Color(159, 189, 154));
    }

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        comuter = new javax.swing.JLabel();
        result = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        number = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("image.png")));
        // NOI18N
        jLabel1.setText("jLabel1");
        jLabel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel2.setText("Enter the Number Between 1 and 100");

        comuter.setText("Show the Number");
        comuter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comuterMouseClicked(evt);
            }
        });

        result.setText("Status");

        jButton1.setText("Check");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 324,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30,
                                                        Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(comuter)
                                                        .addComponent(result)))
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 209,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE, 179,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jButton1)))
                                .addContainerGap(102, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(161, 161, 161)
                                                .addComponent(comuter)
                                                .addGap(93, 93, 93)
                                                .addComponent(result)
                                                .addGap(122, 122, 122))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
                                                layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(39, 39, 39)))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(number, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton1))
                                .addContainerGap(26, Short.MAX_VALUE)));

        pack();
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        int userGuess = Integer.parseInt(number.getText());

        if (userGuess <= 0 || userGuess > 100) {
            result.setText("Invalid Guess ❌");
        } else if (userGuess == computerNumber) {
            result.setText("Correct Guess 🎉");
        } else if (userGuess < computerNumber) {
            result.setText("Too Low 🔽");
        } else {
            result.setText("Too High 🔼");
        }
    }

    private void comuterMouseClicked(java.awt.event.MouseEvent evt) {
        comuter.setText(Integer.toString(computerNumber));
    }

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(numberGame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(numberGame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(numberGame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(numberGame.class.getName()).log(java.util.logging.Level.SEVERE, null,
                    ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new numberGame().setVisible(true);
            }
        });
    }

    private javax.swing.JLabel comuter;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField number;
    private javax.swing.JLabel result;
}

