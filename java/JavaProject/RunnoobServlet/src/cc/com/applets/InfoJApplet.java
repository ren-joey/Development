package cc.com.applets;

import javax.swing.*;
import java.awt.*;

public class InfoJApplet extends JApplet {

    private javax.swing.JButton button;
    final String html1 = "<html><body style='width: ";
    final String html2 = "px'>";

    @Override
    public void init() {
        setLayout(null);
        button = new javax.swing.JButton();
        button.setText("Show param.");
        button.addActionListener((java.awt.event.ActionEvent evt) -> {
            String firstName = getParameter("firstName");
            String lastName = getParameter("lastName");
            String str = String.format("Hello, my name is %s - %s  %s."
                    , lastName, firstName, lastName);
            JLabel mylabel = new JLabel(html1 + "200" + html2 + str);
            mylabel.setFont(new Font("Arial", Font.BOLD, 20));
            JOptionPane.showMessageDialog(this, mylabel,
                    "Information", JOptionPane.INFORMATION_MESSAGE);
        });
        add(button);
        button.setBounds(50, 60, 130, 40);
    }

}
