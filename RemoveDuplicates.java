
import java.io.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        try {
            FileInputStream fin =
                    new FileInputStream("input.txt");

            StringBuilder input = new StringBuilder();
            int ch;

            // Read characters from the file
            while ((ch = fin.read()) != -1) {
                input.append((char) ch);
            }
            fin.close();

            String str = input.toString();
            String result = "";

            // Remove duplicate characters
            for (int i = 0; i < str.length(); i++) {
                char current = str.charAt(i);

                if (result.indexOf(current) == -1) {
                    result += current;
                }
            }

            System.out.println(result);

        } catch (IOException e) {
            System.out.println("File error: "
                    + e.getMessage());
        }
    }
}
