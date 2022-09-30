import javax.swing.*;

class CompressModel {
    private String messageValue;

    public static void main(String[] args) {
        String message = JOptionPane.showInputDialog("Message"); //take message from view-textfield
        //String IMess = Integer.toBinaryString(Integer.valueOf(Integer.parseInt(message)));
        String IMess = "";
        int key = '(';
        String IKey = Integer.toBinaryString(key);
        for (int o = 1; o < message.length(); o++) {
            char c = message.charAt(o);
            System.out.println((int)c);
            IMess += Integer.toBinaryString(c);
            IKey = IKey + IKey;
        }
        System.out.print(IMess);
        String cryptOrDecrypt = JOptionPane.showInputDialog("Crypt or decrypt"); //radiobutton choice
        String cmess = "";
        int x = 0;
        char v = 0;
        for (int i = 0; i < IMess.length(); i++) {
            int c = IMess.charAt(x);
            int k = IKey.charAt(x);
            if (cryptOrDecrypt == "crypt") {
                v = (char)scrobbler(c, k);
            }
            else {
                v = (char)descrobbler(k, c);
            }
            cmess = cmess + v; //convert v (should be in binary) to decimal, then to ascii
            x++;
            if (x > message.length()) {
                x = 0;
            }
        }
        System.out.println(cmess);
        //messageValue = cmess;
    }

    private static int descrobbler(int k, int c) {
        return (c^k);
    }

    private static int scrobbler(int c, int k) {
        return (c^k);
    }

    public String getMessageValue() {
        return messageValue;
    }
}
