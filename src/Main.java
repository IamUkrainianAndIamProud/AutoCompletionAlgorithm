import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception {
//      Scanner and Filter setting up.
        Scanner scanner = new Scanner(System.in);
        Filter filter = new Filter();
//      Language settings.
        Language english = new Language();

        setupLanguage(english, "LanguageSets/EnglishWords.txt");
//      Logics
        autoComplete(scanner, filter, english.getWordsToComplete());
    }

    private static void autoComplete(Scanner scanner, Filter filter, WordsToComplete wordsToComplete) {
        List<String> filteredWords;


        while (true) {
            try {
                filteredWords = filter.find(scanner.next(), wordsToComplete.getCompletionWords());
                if (filteredWords.size() >= 16) {
                    System.out.print("There are: " + filteredWords.size() +
                            " answers to your filtered word.\n\t\tDo you want to continue?(yes / no)\n\t\t\t -->");
                    if (scanner.next() == "yes") {
                        for (int i = 0; i < filteredWords.size() + 1; i++) {
                            System.out.println(filteredWords.get(i) + "-->" + i);
                        }
                        System.out.println(filteredWords.get(scanner.nextInt() - 1));
                    } else {
                        continue;
                    }
                } else {
                    for (int i = 0; i < filteredWords.size(); i++) {
                        System.out.println(filteredWords.get(i) + "-->" + i);
                    }
                    System.out.println(filteredWords.get(scanner.nextInt()));
                }
            } catch (Exception e) {
                System.out.println("");
            }
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
