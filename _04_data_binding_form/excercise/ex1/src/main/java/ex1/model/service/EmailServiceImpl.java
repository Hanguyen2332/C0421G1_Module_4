package ex1.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ex1.model.bean.Email;
import ex1.model.repository.IEmailRepos;

import java.util.List;

@Service
public class EmailServiceImpl implements IEmailService {
    @Autowired
    private IEmailRepos iEmailRepos;


    @Override
    public Email showDetailEmail() {
        return iEmailRepos.showDetailEmail();
    }

    @Override
    public void update(Email updateEmail) {
        iEmailRepos.update(updateEmail);
    }

    @Override
    public List<String> showLanguages() {
        return iEmailRepos.showLanguages();
    }

    @Override
    public List<Integer> showPageSizeList() {
        return iEmailRepos.showPageSizeList();
    }
}
