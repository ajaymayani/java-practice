package File_IO_operation_with_database;

import java.util.Scanner;

public class MorseCodeToEnglishText {

    public static void main(String[] args) {
        char[] letters = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', '.', ',', '?', '@', '!', '&', '(', ')', '=', '+', '/', ':', '\'', '\"'};
        String[] morse_code = {".-", "-...", "-.-.", "-..", ".",
            "..-.", "--.", "....", "..", ".---",
            "-.-", ".-..", "--", "-.", "---",
            ".--.", "--.-", ".-.", "...", "-",
            "..-", "...-", ".--", "-..-", "-.--",
            "--..", ".----", "..---", "...--",
            "....--", ".....", "-....", "--..",
            "---..", "----.", "-----", ".-.-.-",
            "--..--", "..--..", ".--.-.", "-.-.--",
            ".-...", "-.--.", "-.--.-", "-...-",
            ".-.-.", "-..-.", "---...", ".----.", ".-..-."};
        char[] except_letter = {'#', '$', '%', '^', '*', '`', '~', '[', ']', '{', '}', ';', '>', '<', ' '};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter text convert for morse code : ");
        String text = sc.nextLine();

        for (int j = 0; j < text.length(); j++) {
            for (int i = 0; i < except_letter.length; i++) {
                if (text.charAt(j) == except_letter[i]) {
                    System.out.println(except_letter[i] + " Cannot translate into morse code");
                }
            }
        }

        String result = englishTextToMorseCode(letters, morse_code, text);
        System.out.println("Text to morse code : \n" + result);
        System.out.println("Morse code to Text : ");
        morseCodeToEnglishText(letters, morse_code, result);
    }

    public static String englishTextToMorseCode(char[] lettes, String[] morse_code, String str) {
        char[] ch = str.toCharArray();
        String result = "";
        for (int i = 0; i < ch.length; i++) {
            for (int j = 0; j < lettes.length; j++) {
                if (ch[i] == lettes[j]) {
                    result += morse_code[j] + " ";
                }
            }
        }
        return result;
    }

    public static void morseCodeToEnglishText(char[] letters, String[] morse_code, String str) {
        String[] str1 = str.split(" ");
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < morse_code.length; j++) {
                if (str1[i].equals(morse_code[j])) {
                    System.out.print(letters[j]);
                }
            }
        }
    }
}