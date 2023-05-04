package com.example.helloSpring.service;

import com.example.helloSpring.domain.Calculator;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public void calculate(Calculator calculator){
        switch (calculator.getOp()){
            case '+':
                calculator.setResult(calculator.getA() + calculator.getB());
                break;
            case '-':
                calculator.setResult(calculator.getA() - calculator.getB());
                break;
            case '*':
                calculator.setResult(calculator.getA() * calculator.getB());
                break;
            case '/':
                calculator.setResult(calculator.getA() / calculator.getB());
                break;
        }
    }
}
