package ex1.model.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CondimentReposImpl implements ICondimentRepos{
    @Override
    public List<String> showCondiments() {
        List<String> condimentList = new ArrayList<>();
        condimentList.add("Lettuce");
        condimentList.add("Tomato");
        condimentList.add("Mustard");
        condimentList.add("Sprouts");

        return condimentList;
    }
}
