package ex2.model.service;

//import ex2.model.repository.IDictionaryRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryServiceImpl implements IDictionaryService {
    @Override
    public Map<String, String> translate() {
        return null;
    }
}
