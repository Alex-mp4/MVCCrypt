package MVCCrypt;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controller extends JFrame {
    CompressModel ModelCrypt;
    ViewCrypt ViewCrypt;

    public Controller(CompressModel m, ViewCrypt v) {
        this.ModelCrypt = m;
        this.ViewCrypt = v;
        this.setContentPane(ViewCrypt.getPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
        ViewCrypt.setCryptListener(new cryptListener());
    }

    private class cryptListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ModelCrypt.setMessage(ViewCrypt.getTextField());
            //ModelCrypt.setKey(ViewCrypt.getKey());
            CompressModel.cryptString();
            ViewCrypt.setCrypt(ModelCrypt.getMessageValue());
        }
    }

    public static void main(String[] args) {
        CompressModel m = new CompressModel();
        ViewCrypt v = new ViewCrypt();
        Controller thisIsTheProgram = new Controller(m,v);
        thisIsTheProgram.setVisible(true);

    }
}