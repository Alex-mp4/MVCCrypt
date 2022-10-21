package MVCCrypt;

import javax.swing.*;
import javax.xml.bind.DatatypeConverter;
import java.io.*;

class CompressModel {
    private String message;
    private String KeyFin;
    private String MessFin;
    private String cmess;


    public static void main(String[] args) {
        String hexMess = null;

        CompressModel cryptModel = new CompressModel();
        cryptModel.setMessage("HEJ");
        cryptModel.setKey(")");

        //MessFin = messageBin(message);

        cryptModel.cryptString();
    }

    private void setMessage(String message) {
        this.message = message;
    }

    private void setKey(String KeyFin) {
        this.KeyFin = KeyFin;
    }

    public void cryptString() {
        //String convertHex = JOptionPane.showInputDialog("Is your input in hexadecimal");
        String cryptOrDecrypt = JOptionPane.showInputDialog("Crypt or decrypt"); //radiobutton choice

        cmess = "";
        if("yo" == "yes") {
            CompressModel.hexWriter(message);
        }
        else {
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
/*
            try {
                hexMess = toHexadecimal(message);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
*/
            CompressModel.fileWriter(cmess);
        }
    }

    private static int descrobbler(int k, int c) {
        return (c^k);
    }

    private static int scrobbler(int c, int k) {
        return (c^k);
    }

    public String getMessageValue() {
        return cmess;
    }

    private static String getKey(String KeyFin, String message) {
        for (int o = 1; o < message.length(); o++) {
            KeyFin = KeyFin + KeyFin;
        }
        return KeyFin;
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

    private static String hexToAscii(String hexMess) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < hexMess.length(); i+=2) {
            String str = hexMess.substring(i, i+2);
            output.append((char)Integer.parseInt(str, 16));
        }
        return output.toString();
    }

    public static void hexWriter(String message) {
        //String fileNameForCrypt = "cryptmessage.txt";
        File foutCrypt = new File("cryptmessage.txt");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(foutCrypt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        String asciiOfHex = hexToAscii(message);
        try {
            bw.write(asciiOfHex);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(asciiOfHex);
    }

    public static void fileWriter(String cmess) {
        String fileNameForCrypt = "cryptmessage.txt";
        File foutCrypt = new File(fileNameForCrypt);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(foutCrypt);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

        try {
            bw.write(cmess);
            bw.newLine();
            //bw.write(hexMess);
            bw.flush();
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(cmess);
        //System.out.println(hexMess);
    }

}
