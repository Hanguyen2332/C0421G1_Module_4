package ex2.model.repository;

import org.springframework.stereotype.Repository;

import java.util.List;
//@Repository
public interface ICalculationRepos {
    double calculate(String operand, double a, double b);
}
