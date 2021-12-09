package word;


public class EnglishSpellChecker implements SpellChecker {

    private Dictionary dictionary;

    public EnglishSpellChecker(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    @Override
    public void check(String text) {
        if (!dictionary.contains(text))
            throw new IllegalArgumentException();
    }
}
