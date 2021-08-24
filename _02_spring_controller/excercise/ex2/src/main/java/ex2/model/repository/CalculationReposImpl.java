package ex2.model.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CalculationReposImpl implements ICalculationRepos {


    @Override
    public double calculate(String operand, double a, double b) {
        double result = 0;
        switch (operand) {
            case "Addition":
                result =  a + b;
                break;
            case "Subtraction":
                result =  a - b;
                break;
            case "Multiplication":
                result = a * b;
            break;
            case "Division":
                result = a/b;
            break;
            default:
                break;
        }
        return result;
    }
}

