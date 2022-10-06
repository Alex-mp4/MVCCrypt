import javax.swing.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;


class CompressModel {
    private String messageValue;

    public static void main(String[] args) {
        String message = JOptionPane.showInputDialog("Message"); //take message from view-textfield
        String IKey = ")";

        String KeyFin = getKey(message, IKey);
        String MessFin = messageBin(message);

        String cryptOrDecrypt = JOptionPane.showInputDialog("Crypt or decrypt"); //radiobutton choice
        String cmess = "";
        int x = 0;
        char v = 0;
        for (int i = 0; i < MessFin.length(); i++) {
            int c = MessFin.charAt(x);
            int k = KeyFin.charAt(x);
            if (cryptOrDecrypt == "crypt") {
                v = (char)scrobbler(c, k);
            }
            else {
                v = (char)descrobbler(k, c);
            }

            cmess = cmess + v;
            x++;
            if (x > message.length()) {
                x = 0;
            }
        }

        String hexMess = null;
        
        try {
            hexMess = toHexadecimal(cmess);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //fix the god-damn filereader below

        File fout = new File("cryptmessage.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(fout);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
        String output = getMessageValue(cmess);
        try {
            bw.write(output);
            bw.newLine();
            bw.write(hexMess);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(cmess);
    }

    private static int descrobbler(int k, int c) {
        return (c^k);
    }

    private static int scrobbler(int c, int k) {
        return (c^k);
    }

    private static String getMessageValue(String cmess) {
        String messageValue = cmess;
        return messageValue;
    }

    private static String getKey(String message, String IKey) {
        for (int o = 1; o < message.length(); o++) {
            IKey = IKey + IKey;
        }
        return IKey;
    }

    private static String messageBin(String message) {
        String IMess = "";
        for (int o = 0; o < message.length(); o++) {
            char c = message.charAt(o);
            IMess += c;
        }
        return IMess;
    }

    public static String toHexadecimal(String cmess) throws UnsupportedEncodingException
    {
        byte[] myBytes = cmess.getBytes("UTF-8");
        return DatatypeConverter.printHexBinary(myBytes);
    }
}
