package ex2.model.service;

import ex2.model.repository.ICalculationRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalculationServiceImpl implements ICalculationService {
    @Autowired
    private ICalculationRepos calculationRepos;


    @Override
    public double calculate(String operand, double a, double b) {
        return calculationRepos.calculate(operand,a,b);
    }
}
