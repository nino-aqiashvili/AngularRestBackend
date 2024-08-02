package com.epam.upskill.calculator.models.operations;

import com.epam.upskill.calculator.models.Result;

public class AddOperation extends OperationAbstract {

	/**
	 * Description:
	 * Adds two numbers provided in the request body. The operands must be valid numbers.
	 * If either operand is null or cannot be parsed as a number, the API returns a 400 Bad Request
	 * with an error message indicating that one of the operands is not valid.
	 */

	@Override
	public Result perform() throws Exception {
		Result result = operandsValidator();
		if (!result.getError()) {
			result.setResult(operand1.add(operand2));
			result.setError(Boolean.FALSE);
		}
		return result;
	}

	@Override
	public String toString() {
		return super.toString("Add ");
	}
}
