package word;

public class WordProcessor {

    private String text;
    private SpellChecker checker;

    public WordProcessor(SpellChecker checker) {
        this.checker = checker;
    }

    void check() {
        checker.check(text);
    }
}
