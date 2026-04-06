import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter source path: ");
        String sourcePath = sc.nextLine();
        System.out.print("Enter destination path: ");
        String destPath = sc.nextLine();

        FileReader fr = null;
        BufferedReader br = null;
        FileWriter fw = null;
        PrintWriter pw = null;

        int lineCount = 0;

        try {
            fr = new FileReader(sourcePath);
            br = new BufferedReader(fr);
            fw = new FileWriter(destPath);
            pw = new PrintWriter(fw);
            String line;
            while ((line = br.readLine()) != null) {
                pw.println(line);
                lineCount++;
            }
            System.out.println("Copying successful");
            System.out.println("Total lines: " + lineCount);
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (fr != null) fr.close();
                if (br != null) br.close();
                if (fw != null) fw.close();
                if (pw != null) pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
