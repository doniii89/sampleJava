package application;

public class Model {
	
	public int intEqual(int number1, int number2, char operation) {
		int result = 0;
		
		switch(operation) {
		case '+': result = number1 + number2;
		break;
		case '-': result = number1 - number2;
		break;
		case '÷': if(number1 == 0 || number2 == 0) return 0; 
				   result = number1 / number2;
		break;
		case 'x': result = number1 * number2;
		break;
		case '%': result = number1 % number2;
		break;
		default: break;
		}
		return result;
	}
	
	public double doubleEqual(double dNumber1, double dNumber2, char operation) {
		double result = 0;
		
		switch(operation) {
		case '+': result = dNumber1 + dNumber2;
		break;
		case '-': result = dNumber1 - dNumber2;
		break;
		case '÷': if(dNumber1 == 0 || dNumber2 == 0) return 0;
				  result = dNumber1 / dNumber2;
		break;
		case 'x': result = dNumber1 * dNumber2;
		break;
		case '%': result = dNumber1 % dNumber2;
		break;
		default: break;
		}
		return result;
	}

}
