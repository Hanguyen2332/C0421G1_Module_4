package ex2.model.service;

import ex2.model.repository.IDictionaryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements IDictionaryService{
    @Autowired
    private IDictionaryRepos iDictionaryRepos;
    @Override
    public String translate(String key) {
        return iDictionaryRepos.translate(key);
    }
}
