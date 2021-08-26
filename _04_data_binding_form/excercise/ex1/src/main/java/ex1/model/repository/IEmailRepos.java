package ex1.model.repository;

import ex1.model.bean.Email;

import java.util.List;

//@Repository
public interface IEmailRepos {
    public Email showDetailEmail();

    public void update(Email updateEmail);

    public List<String> showLanguages();

    public List<Integer> showPageSizeList();

}
