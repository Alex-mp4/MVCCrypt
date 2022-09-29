import javax.swing.*;

class CompressModel {
    private String messageValue;

    public void main(String[] args) {
        String message = JOptionPane.showInputDialog("Message");
        String cryptOrDecrypt = JOptionPane.showInputDialog("Crypt or decrypt");
        String cmess = "";
        int key = '(';
        int x = 0;
        char v = 0;
        for (int i = 0; i < message.length(); i++) {
            int c = message.charAt(x);
            if (cryptOrDecrypt == "crypt") {
                v = (char)scrobbler(c, key);
            }
            else {
                v = (char)descrobbler(key, c);
            }
            cmess = cmess + v;
            x++;
            if (x > message.length()) {
                x = 0;
            }
        }
        messageValue = cmess;
    }

    private static int descrobbler(int key, int c) {
        return (c^key);
    }

    private static int scrobbler(int c, int key) {
        return (c^key);
    }

    public String getMessageValue() {
        return messageValue;
    }
}