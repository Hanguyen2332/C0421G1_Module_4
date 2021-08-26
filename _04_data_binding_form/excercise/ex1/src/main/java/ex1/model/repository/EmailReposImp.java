package ex1.model.repository;

import org.springframework.stereotype.Repository;
import ex1.model.bean.Email;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmailReposImp implements IEmailRepos {
    private static Email email;
    static {
        email = new Email("English", 5, false, "Ha Thos");
    }
    //language:
    private static List<String> languageList;
    static {
        languageList = new ArrayList<>();
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
    }
    //pageSize:
    private static List<Integer> pageSizeList;
    static {
        pageSizeList = new ArrayList<>();
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }
//show language
    @Override
    public List<String> showLanguages() {
        return languageList;
    }
    //show pageSize
    @Override
    public List<Integer> showPageSizeList() {
        return pageSizeList;
    }

//show Email
    @Override
    public Email showDetailEmail() {
        return email;
    }

    @Override
    public void update(Email updateEmail) {
        email.setLanguage(updateEmail.getLanguage());
        email.setPageSize(updateEmail.getPageSize());
        email.setSpamFilter(updateEmail.isSpamFilter());
        email.setSignature(updateEmail.getSignature());
    }
}

