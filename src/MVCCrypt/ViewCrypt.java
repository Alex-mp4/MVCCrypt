package MVCCrypt;

import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewCrypt {

    private JPanel panel;
    private JTextField textField1;
    private JTextArea textArea1;
    private JButton button1;
    private JRadioButton radioButton1;
    private JRadioButton radioButton2;
    private JRadioButton radioButton3;
    ButtonGroup buttonGroup = new ButtonGroup();

    public ViewCrypt() {
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getTextField() {
        return textField1.getText();
    }

    public void setCrypt(String cmess) {
        textArea1.setText(cmess);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("View");
        frame.setContentPane(new ViewCrypt().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public void setCryptListener(ActionListener cryptListener) {
        button1.addActionListener(cryptListener);
    }
}
