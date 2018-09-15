package service;

public class TextEditer {

    private SpellChecker spellChecker;
    private String str;

    public TextEditer(SpellChecker spellChecker, String str) {
        System.out.println("Inside TextEditor constructor." );
        this.str = str;
        this.spellChecker = spellChecker;
    }

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        System.out.println(str);
        spellChecker.checkSpelling();
    }
}
