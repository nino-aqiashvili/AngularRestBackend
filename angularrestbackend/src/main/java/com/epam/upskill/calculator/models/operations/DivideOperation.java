package com.epam.upskill.calculator.models.operations;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.epam.upskill.calculator.models.Result;
import com.epam.upskill.calculator.util.Constants;

public class DivideOperation extends OperationAbstract {

	private final BigDecimal ZERO = new BigDecimal(0);

	/**
	 * Description:
	 * Divides the first number by the second number provided in the request body.
	 * The operands must be valid numbers. If the second operand is zero, the API returns a 400 Bad Request
	 * with an error message indicating division by zero. If either operand is null or cannot be parsed as a number,
	 * the API returns a 400 Bad Request with an error message indicating that one of the operands is not valid.
	 */

	@Override
	public Result perform() throws Exception {
		Result result = operandsValidator();
		if (!result.getError()) {
			if(operand2.compareTo(ZERO) == 0) {
				result.setError(Boolean.TRUE);
				result.setMessage(Constants.ERROR_MESSAGE_DIVIDE_BY_ZERO);
				getLogger().error("Can't divide by Zero"); }
			else {
				result.setResult(operand1.divide(operand2, 10, RoundingMode.CEILING));
				result.setError(Boolean.FALSE);
			}}
		return result;
	}

	@Override
	public String toString() {
		return super.toString("Divide ");
	}

}
