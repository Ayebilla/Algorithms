import java.io.*;
import java.util.Scanner;
/*
This programs determines the existence of a given pattern of text in a given text.
It can be executed in two ways; interactively where it takes inputs text from the user and displays results to
to the screen or file mode where it takes input from a file included in the code files and displays the result to
another file also in the code files called Output.txt
in a file mode where it takes input
 */
/*
@author Ayebeilla Avoka
version 1.0
 */

public class StringMatching {
    int index = -1;
    public int indexFound(String text, String pattern) {
        int i, j, n, m;
        n = text.length();
        m = pattern.length();
        for (i = 0; i < n - m; i++) {
            j = 0;
            while (j < m && pattern.charAt(j) == text.charAt(i + j)) {
                j = j + 1;
            }
            if (j == m) {
                index = i;
                return index;
            } else {
                index = index;
            }
        }
        return index;

    }

    public void interactiveMode() {
        System.out.println("Enter a text and a pattern you want to search for ");
        Scanner scanner1 = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter text:  ");
        String Text = scanner1.nextLine();
        // System.out.println();
        System.out.println("enter pattern to search: ");
        String pattern = scanner2.nextLine();
        System.out.println(indexFound(Text,pattern));
    }
    public void fileMode() throws IOException {

        BufferedReader reader;
        try {
            FileWriter fileWriter = new FileWriter("Output.txt");
            reader = new BufferedReader(new FileReader(
                    "input.txt"));
            String line = reader.readLine();
            String numOfTestCases = line;
            line = reader.readLine();
            fileWriter.write(numOfTestCases + "\n");

            while (line != null) {
                String line2 = reader.readLine();
                String ans =  Integer.toString(indexFound(line, line2)) + "\n";

                fileWriter.write(ans);
                // read next line

                line = reader.readLine();
            }
            reader.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //Main method for testing.

    public static void main(String[] args) throws IOException {
        StringMatching mat = new StringMatching();
        if(args[0].equalsIgnoreCase("interactive")){
            mat.interactiveMode();
        }
        else if(args[0].equalsIgnoreCase("file")){
            mat.fileMode();

        }
        else {
            System.out.println("Expected one of two inputs; 'interactive' or 'file' ");
        }
    }

}