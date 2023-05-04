package com.example.helloSpring.controller;

import com.example.helloSpring.domain.Calculator;
import com.example.helloSpring.service.CalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CalculatorController {
    private final CalculatorService calculatorService;
    @Autowired
    public CalculatorController(CalculatorService calculatorService){
        this.calculatorService = calculatorService;
    }
    @GetMapping("cal")
    @ResponseBody
    public Calculator calculate(Model model,
                            @RequestParam(name="a") float a,
                            @RequestParam(name="b") float b,
                            @RequestParam(name="op") char op){

        Calculator calculator = new Calculator();
        calculator.setA(a);
        calculator.setB(b);
        calculator.setOp(op);
        calculatorService.calculate(calculator);

        return calculator;
    }
}
