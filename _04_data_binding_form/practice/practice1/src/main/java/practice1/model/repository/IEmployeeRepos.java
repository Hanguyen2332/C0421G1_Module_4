package practice1.model.repository;

import practice1.model.bean.Employee;

import java.util.List;

//@Repository
public interface IEmployeeRepos {
    public List<Employee> showList();

    public void create(Employee employee);
}
