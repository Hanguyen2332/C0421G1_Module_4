package ex2.model.repository;

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class DictionaryReposImpl implements IDictionaryRepos {
    @Override
    public String translate(String key) {
        Map<String, String> dictionaries = new HashMap<>();
        dictionaries.put("flower","Hoa");
        dictionaries.put("rose","Hoa hồng");
        dictionaries.put("lavender","Hoa oải hương");
        dictionaries.put("river","Sông");
        dictionaries.put("people","Người");

        String lowerKey  = key.toLowerCase();
        if (dictionaries.containsKey(lowerKey)) {
            return dictionaries.get(lowerKey);
        }
        return "NOT FOUND this word";
    }
}
