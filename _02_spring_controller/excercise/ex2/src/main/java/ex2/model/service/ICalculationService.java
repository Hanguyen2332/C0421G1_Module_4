package ex2.model.service;

import org.springframework.stereotype.Service;

import java.util.List;

//@Service
public interface ICalculationService {
    double calculate(String operand, double a, double b);
}
