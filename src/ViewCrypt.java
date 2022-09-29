import javax.swing.*;
import java.awt.event.ActionListener;

public class ViewCrypt {
    private JTextField textField1 = new JTextField("Input");
    private JTextArea textArea1 = new JTextArea("Output");
    private JButton button1 = new JButton("");
    private JRadioButton radioButtonCrypt = new JRadioButton("Crypt");
    private JRadioButton radioButtonDeCrypt = new JRadioButton("Decrypt");

    //JRadioButton cryptButton = radioButtonCrypt;
    //JRadioButton decryptButton = radioButtonDeCrypt;

    //ButtonGroup buttonGroup = new ButtonGroup();
    //buttonGroup.add(radioButtonCrypt);
    //buttonGroup.add(decryptButton);

    ViewCrypt() {
        JPanel panel = new JPanel();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 200);
        panel.add(textField1);
        panel.add(textArea1);
        panel.add(radioButtonCrypt);
        panel.add(radioButtonDeCrypt);
        this.add(panel);
    }

    public String getTextField() {
        return textField1.getText();
    }
}
