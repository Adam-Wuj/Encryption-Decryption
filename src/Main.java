import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {

        String method = "shift";
        String operation = "enc";
        int key = 0;
        String data = "";
        boolean isData = false;
        boolean toFile = false;
        String directory = null;


        for (int i = 0; i < args.length; i++) {
            if (args[i].equals("unicode") && args[i - 1].equals("-alg")) {
                method = "unicode";
            } else if (args[i].equals("dec") && args[i - 1].equals("-mode")) operation = args[i];
            else if (args[i].matches("\\d+") && args[i - 1].equals("-key")) {
                key = Integer.parseInt(args[i]);
            } else if (args[i].equals("-data")) {

                if (args[i + 1] != null) data = args[i + 1];
                isData = true;
            }
            if (args[i].equals("-in") && !isData) {
                try {
                    data = Files.readString(Paths.get(args[i + 1]));
                } catch (IOException e) {
                    System.out.println("Error, file not found");
                }
            }
            if (args[i].equals("-out")) {
                toFile = true;
                directory = args[i + 1];
            }
        }

        Converter converter = ConverterFactory.makeConverter(method, data, key);
        assert converter != null;
        messageWriter(toFile, converter.convert(operation), directory);
    }

    static void messageWriter(boolean toFile, String message, String directory) {

        if (toFile) {
            try {
                FileWriter writer = new FileWriter(directory);
                writer.write(message);
                writer.close();
            } catch (IOException e) {
                System.out.println("Error, no such directory");
            }
        } else {
            System.out.println(message);
        }
    }
}