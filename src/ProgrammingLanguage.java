import java.util.ArrayList;
import java.util.Collections;

public abstract class ProgrammingLanguage {
    private ArrayList<String> classes_programming = new ArrayList<>();
    private ArrayList<String> defaultMethods_programming = new ArrayList<>();
    private ArrayList<String> keyWords = new ArrayList<>();

    private ArrayList<String> userVars_programming = new ArrayList<>();
    private ArrayList<String> userMethods_programming = new ArrayList<>();
    private ArrayList<String> userClasses_programming = new ArrayList<>();

    public ArrayList<String> addClasses(String... words) {
        Collections.addAll(defaultMethods_programming, words);
        return classes_programming;
    }

    public ArrayList<String> addDefaultMethods(String... words) {
        Collections.addAll(defaultMethods_programming, words);
        return defaultMethods_programming;
    }

    public ArrayList<String> addKeyWords(String... words) {
        Collections.addAll(defaultMethods_programming, words);
        return keyWords;
    }

    public ArrayList<String> addUserVars(String... words) {
        Collections.addAll(userVars_programming, words);
        return classes_programming;
    }

    public ArrayList<String> addUserMethods(String... words) {
        Collections.addAll(userMethods_programming, words);
        return defaultMethods_programming;
    }

    public ArrayList<String> addUserClasses(String... words) {
        Collections.addAll(userClasses_programming, words);
        return keyWords;
    }

    public ArrayList<String> getClasses_programming() {
        return classes_programming;
    }

    public ArrayList<String> getDefaultMethods_programming() {
        return defaultMethods_programming;
    }

    public ArrayList<String> getKeyWords() {
        return keyWords;
    }

    public ArrayList<String> getUserVars_programming() {
        return userVars_programming;
    }

    public ArrayList<String> getUserMethods_programming() {
        return userMethods_programming;
    }

    public ArrayList<String> getUserClasses_programming() {
        return userClasses_programming;
    }
}
