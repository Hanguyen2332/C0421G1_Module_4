package practice1.model.service;

import practice1.model.bean.Employee;
import practice1.model.repository.IEmployeeRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    @Autowired
    private IEmployeeRepos calculationRepos;


    @Override
    public List<Employee> showList() {
        return calculationRepos.showList();
    }

    @Override
    public void create(Employee employee) {
        calculationRepos.create(employee);
    }
}
