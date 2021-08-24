package ex1.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface ICondimentRepos {
    List<String> showCondiments();
}
