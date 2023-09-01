import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Filter {
    List<String> find(String filterWord, List<String> wordList) {
        return wordList.stream().filter(word -> word.contains(filterWord)).collect(Collectors.toList());
    }
}
