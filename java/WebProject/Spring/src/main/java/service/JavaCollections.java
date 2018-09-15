package service;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class JavaCollections {

    private Map map;
    private Set set;
    private List list;
    private Properties properties;
    private Set<TextEditer> textEditers;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
        System.out.println("Set element Map as " + map);
    }

    public Set getSet() {
        return set;
    }

    public void setSet(Set set) {
        this.set = set;
        System.out.println("Set element Set as " + set);
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        System.out.println("Set element List as " + list);
        this.list = list;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        System.out.println("Set element Properties as " + properties);
        this.properties = properties;
    }

    public Set<TextEditer> getTextEditers() {
        return textEditers;
    }

    public void setTextEditers(Set<TextEditer> textEditers) {
        for (TextEditer textEditer: textEditers){
            System.out.println("Set element textEditers as " + textEditer.getSpellChecker());
        }

        this.textEditers = textEditers;
    }
}
