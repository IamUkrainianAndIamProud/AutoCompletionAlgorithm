public class Language {
    private WordsToComplete wordsToComplete = new WordsToComplete();


    public void addWords(String... words) {
        wordsToComplete.addWords(words);
    }

    public WordsToComplete getWordsToComplete() {
        return wordsToComplete;
    }
}