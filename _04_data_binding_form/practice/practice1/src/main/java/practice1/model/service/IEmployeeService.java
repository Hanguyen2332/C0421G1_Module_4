package practice1.model.service;

import practice1.model.bean.Employee;

import java.util.List;

//@Service
public interface IEmployeeService {
    public List<Employee> showList();

    public void create(Employee employee);
}
