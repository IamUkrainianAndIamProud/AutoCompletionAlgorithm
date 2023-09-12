import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
//      Scanner and Filter setting up.
        Scanner scanner = new Scanner(System.in);
        Filter filter = new Filter();
//      Language settings.
        Language english = new Language();

        setupLanguage(english, "LanguageSets/EnglishWords.txt");
//      Setup file for source.
        File demoFile = new File("text.txt");
//      Setup AutoCompletion.
        AutoCompletion autoCompletion = new AutoCompletion(english, demoFile);
//      Logics

        while (true) {
//            Set auto-completion logics here.
//                By user writing in a file and choosing word in the console and writing it in the file.
        }

    }


    private static void setupLanguage(Language language, String filePath) {
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine();
                language.addWords(word);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error!");
            e.printStackTrace();
        }
    }
}
