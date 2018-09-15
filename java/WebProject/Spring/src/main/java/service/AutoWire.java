package service;

/**
 * 用以展示 auto-wire 自動裝配 properties
 */
public class AutoWire {
    private SpellChecker spellChecker;

    public SpellChecker getSpellChecker() {
        return spellChecker;
    }

    public void setSpellChecker(SpellChecker spellChecker) {
        this.spellChecker = spellChecker;
    }

    public void spellCheck() {
        System.out.println("Auto-Wired!");
        spellChecker.checkSpelling();
    }
}
