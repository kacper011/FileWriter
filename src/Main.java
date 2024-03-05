import java.io.File;
import java.io.FileWriter;
import java.util.Formatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File file = new File("C:\\\\Users\\Public\\Desktop\\plik.txt");

        if (!file.exists()) {
            try {
                file.createNewFile();
                System.out.println("Plik został utworzony.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (file.canWrite()) {
            try {
                FileWriter fileWriter = new FileWriter(file, true);
                Formatter formatter = new Formatter(fileWriter);
                Scanner scannerFile = new Scanner(file);

                Scanner scanner = new Scanner(System.in);
                System.out.println("Podaj tekst do pliku: ");
                String text = scanner.nextLine();
                formatter.format("%s \r\n", text);
                System.out.println("Zapisano!");

                formatter.close();
                fileWriter.close();

                System.out.println("\nZawartość pliku: ");
                while (scannerFile.hasNextLine()) {
                    System.out.println(scannerFile.nextLine());
                }
                scanner.close();
                scannerFile.close();

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }
}