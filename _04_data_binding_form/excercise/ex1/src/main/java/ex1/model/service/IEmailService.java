package ex1.model.service;

import ex1.model.bean.Email;

import java.util.List;

//@Service
public interface IEmailService {
    public Email showDetailEmail();

    public void update(Email updateEmail);

    public List<String> showLanguages();

    public List<Integer> showPageSizeList();
}
