package ex1.model.service;

import ex1.model.repository.ICondimentRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CondimentServiceImpl implements ICondimentService {
    @Autowired
    private ICondimentRepos iConvertRepos;

    @Override
    public List<String> showCondiments() {
        return iConvertRepos.showCondiments();
    }
}
