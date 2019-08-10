package com.udemy.microservico.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.microservico.execption.UnsuportedMathOperationExecption;
import com.udemy.microservico.refactorycode.ConverteMethod;
import com.udemy.microservico.refactorycode.RefactoryCleanCode;

@RestController
public class MathController {

	private RefactoryCleanCode math = new RefactoryCleanCode();
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!ConverteMethod.isNumeric(numberOne) || !ConverteMethod.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExecption("Please set a numeric value!");
		}
	
		return math.sum(ConverteMethod.convertToDouble(numberOne), ConverteMethod.convertToDouble(numberTwo));
		
	}
	
	@RequestMapping(value="/subtraction/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtraction(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!ConverteMethod.isNumeric(numberOne) || !ConverteMethod.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExecption("Please set a numeric value!");
		}
		return math.subtract(ConverteMethod.convertToDouble(numberOne), ConverteMethod.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/multiplication/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double multiplication(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!ConverteMethod.isNumeric(numberOne) || !ConverteMethod.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExecption("Please set a numeric value!");
		}
		return math.multiplication(ConverteMethod.convertToDouble(numberOne), ConverteMethod.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/division/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double division(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!ConverteMethod.isNumeric(numberOne) || !ConverteMethod.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExecption("Please set a numeric value!");
		}
		return math.division(ConverteMethod.convertToDouble(numberOne), ConverteMethod.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/media/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double media(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!ConverteMethod.isNumeric(numberOne) || !ConverteMethod.isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationExecption("Please set a numeric value!");
		}
		return math.mean(ConverteMethod.convertToDouble(numberOne), ConverteMethod.convertToDouble(numberTwo));
	}
	
	@RequestMapping(value="/squareRoot/{number}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable("number") String number)  throws Exception {
		if(!ConverteMethod.isNumeric(number)) {
			throw new UnsuportedMathOperationExecption("Please set a numeric value!");
		}
		return math.squareRoot(ConverteMethod.convertToDouble(number));
	}
}

