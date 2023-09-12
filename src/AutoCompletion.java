import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutoCompletion {
    private Language language;
    private File source;

    private Filter filter = new Filter();

    public AutoCompletion(Language language, File source) {
        this.language = language;
        this.source = source;
    }

    public void autoComplete(String findWord, int position) {
        String data = readFromSource().substring(position);
        List<String> filteredWords = filter.find(findWord, language.getCompletionWords());

        Scanner scanner = new Scanner(System.in);

        if (filteredWords.size() >= 16) {
            for (int i = 0; i < filteredWords.size(); i++) {
                System.out.println(filteredWords.get(i) + i);
            }
            System.out.println("Write number u choose!\n\n\t\t:");
            writeToSource(filteredWords.get(scanner.nextInt()), position);
        } else {
            System.out.println("Sorry, but your find word must be more concrete. Because there are: " + filteredWords.size()
                    + " words that match. Try again.");
        }
    }

    private String readFromSource() {
        String data = null;
        try (FileInputStream fis = new FileInputStream(source)) {
            ArrayList<Character> lineBuffer = new ArrayList<>();
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while ((i = fis.read()) != -1) {
                if (i != '\n') {
                    lineBuffer.add((char) i);
                } else {
                    for (Character symbol : lineBuffer) {
                        stringBuilder.append(symbol);
                    }
                    lineBuffer.clear();
                    data = String.valueOf(stringBuilder);
                    stringBuilder = new StringBuilder();
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }

    private void writeToSource(String message, int position) {
        try(FileOutputStream fos = new FileOutputStream(source)) {
            byte[] buffer = message.getBytes();
            fos.write(buffer, position, buffer.length);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
