package com.iharnoor.chemistryencoder;

import java.util.HashMap;

public class Encryption {

    public String encode(String message, int key) {
        message = caesarEncrypt(message, key);
        String chemStr = "";
        HashMap<Integer, String> chemSymbols = chemSymbols();
        for (int i = 0; i < message.length(); i++) {
            char currentChar = message.charAt(i);

            chemStr += chemSymbols.get((int) currentChar);
        }
        return chemStr;
    }

    public String decode(String message, int key) {
        HashMap<Integer, String> chemU = chemSymbols();
        String output = "";
        for (int i = 0; i < message.length(); i += 2) {

            String currentPair = message.substring(i, i + 2);
            if (chemU.containsValue(currentPair)) {
                int decoded = (int) getKeyFromValue(chemU, currentPair);
                char decoded2 = (char) (decoded);
                output += decoded2;
            } else {
                System.out.println("Error finding the Value in HashMap");
                break;
            }
        }
        String caesarDecoded = output;
        output = caesarEncrypt(output, 26 - key);
        return output;
    }

    public Object getKeyFromValue(HashMap hm, Object value) {
        for (Object o : hm.keySet()) {
            if (hm.get(o).equals(value)) {
                return o;
            }
        }
        return null;
    }

    private String caesarEncrypt(String message, int key) {
        int i;
        char ch;
        StringBuilder encoded = new StringBuilder();
        for (i = 0; i < message.length(); ++i) {
            ch = message.charAt(i);
            if (ch >= 'a' && ch <= 'z') {//is lower case
                ch = (char) (((ch - 'a') + key) % 26 + 'a');
                encoded.append(ch);
            } else if (ch >= 'A' && ch <= 'Z') {//is upper case
                ch = (char) (((ch - 'A') + key) % 26 + 'A');
                encoded.append(ch);
            } else encoded.append(ch);
        }
        return encoded.toString();
    }

    private HashMap<Integer, String> chemSymbols() {
        HashMap<Integer, String> chem = new HashMap<>();
        chem.put(32, "Ds");
        chem.put(33, "Sc");
        chem.put(64, "Co");
        chem.put(63, "Ni");
        chem.put(46, "Cu");
        chem.put(47, "Zn");
        chem.put(69, "Ga");
        chem.put(70, "Ge");
        chem.put(71, "Bh");
        chem.put(48, "Rg");
        chem.put(49, "Re");
        chem.put(50, "Fr");
        chem.put(51, "Np");
        chem.put(52, "Rn");
        chem.put(53, "Tl");
        chem.put(54, "Lu");
        chem.put(55, "Pm");
        chem.put(56, "Ac");
        chem.put(57, "Ir");
        chem.put(65, "Os");
        chem.put(66, "At");
        chem.put(67, "Rf");
        chem.put(68, "Hf");
        chem.put(69, "Xe");
        chem.put(70, "Eu");
        chem.put(71, "As");
        chem.put(72, "Se");
        chem.put(73, "Br");
        chem.put(74, "Kr");
        chem.put(75, "Rb");
        chem.put(76, "Sr");
        chem.put(77, "Zr");
        chem.put(78, "Nb");
        chem.put(79, "Mo");
        chem.put(80, "Tc");
        chem.put(81, "Ru");
        chem.put(82, "Rh");
        chem.put(83, "Pd");
        chem.put(84, "Cd");
        chem.put(85, "In");
        chem.put(86, "Sn");
        chem.put(87, "Sb");
        chem.put(88, "Te");
        chem.put(89, "Cs");
        chem.put(90, "Ba");
        chem.put(97, "Lr");
        chem.put(98, "He");
        chem.put(99, "Li");
        chem.put(100, "Be");
        chem.put(101, "No");
        chem.put(102, "Md");
        chem.put(103, "Fm");
        chem.put(104, "Es");
        chem.put(105, "Cm");
        chem.put(106, "Ne");
        chem.put(107, "Na");
        chem.put(108, "Mg");
        chem.put(109, "Al");
        chem.put(110, "Si");
        chem.put(111, "Pu");
        chem.put(112, "Th");
        chem.put(113, "Cl");
        chem.put(114, "Ar");
        chem.put(115, "Gd");
        chem.put(116, "Ca");
        chem.put(117, "Mt");
        chem.put(118, "Ti");
        chem.put(119, "Ra");
        chem.put(120, "Cr");
        chem.put(121, "Mn");
        chem.put(122, "Fe");

        return chem;
    }
}
