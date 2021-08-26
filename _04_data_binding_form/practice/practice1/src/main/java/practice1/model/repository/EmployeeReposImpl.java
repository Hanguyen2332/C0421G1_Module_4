package practice1.model.repository;

import org.springframework.stereotype.Repository;
import practice1.model.bean.Employee;

import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeReposImpl implements IEmployeeRepos {
    private static List<Employee> employeeList;
static {
    employeeList = new ArrayList<>();
    employeeList.add(new Employee("1","Phan Thành Bại","0909123456"));
    employeeList.add(new Employee("2","Lê Bất Bại","0935145269"));
    employeeList.add(new Employee("3","Trần Bất Công","0918765432"));
    employeeList.add(new Employee("4","Nguyễn Bất Chấp","0986271929"));
}

    @Override
    public List<Employee> showList() {
        return employeeList;
    }

    @Override
    public void create(Employee employee) {
        employeeList.add(employee);
    }

}

