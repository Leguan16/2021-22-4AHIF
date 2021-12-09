package word;

public class App {

    public static void main(String[] args) {
        var dictionary = new EnglishDictionary();
        var checker = new EnglishSpellChecker(dictionary);
        new WordProcessor(checker);
    }
}
