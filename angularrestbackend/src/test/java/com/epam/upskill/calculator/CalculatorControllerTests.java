package com.epam.upskill.calculator;

import static org.junit.Assert.assertEquals;

import com.epam.upskill.calculator.controllers.CalculatorController;
import com.epam.upskill.calculator.util.Constants;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTests {

	@Autowired
	private MockMvc mockMvc;

	// Test for adding two positive numbers
	@Test
	public void addPositiveNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": 1, \"operand2\": 1}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":2}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for adding two negative numbers
	@Test
	public void addNegativeNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": -1, \"operand2\": -1}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":-2}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for handling null values in addition
	@Test
	public void addNullValuesTest() throws Exception {
		String jsonBody = "{\"operand1\": null, \"operand2\": null}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"Error: One of the operands is not valid\",\"error\":true,\"result\":null}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for dividing by zero
	@Test
	public void divideByZeroTest() throws Exception {
		String jsonBody = "{\"operand1\": -1, \"operand2\": 0}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"Error: Can't divide by zero\",\"error\":true,\"result\":null}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for dividing two negative numbers
	@Test
	public void divideNegativeNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": -1, \"operand2\": -1}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":1.0000000000}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for multiplying two positive numbers
	@Test
	public void multiplyPositiveNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": 3, \"operand2\": 2}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/multiply")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":6}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for multiplying a number by zero
	@Test
	public void multiplyByZeroTest() throws Exception {
		String jsonBody = "{\"operand1\": 3, \"operand2\": 0}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/multiply")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":0}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for subtracting positive numbers
	@Test
	public void subtractPositiveNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": 10, \"operand2\": 5}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/subtract")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":5}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for subtracting negative numbers
	@Test
	public void subtractNegativeNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": -10, \"operand2\": -5}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/subtract")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":-5}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for subtracting a positive and a negative number
	@Test
	public void subtractPositiveAndNegativeNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": 10, \"operand2\": -5}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/subtract")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":15}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for handling null values in subtraction
	@Test
	public void subtractNullValuesTest() throws Exception {
		String jsonBody = "{\"operand1\": null, \"operand2\": null}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/subtract")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"Error: One of the operands is not valid\",\"error\":true,\"result\":0}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for dividing positive numbers
	@Test
	public void dividePositiveNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": 10, \"operand2\": 2}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":5.0000000000}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for dividing a positive and a negative number
	@Test
	public void dividePositiveAndNegativeNumbersTest() throws Exception {
		String jsonBody = "{\"operand1\": 10, \"operand2\": -2}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/divide")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		String expectedResult = "{\"message\":\"\",\"error\":false,\"result\":-5.0000000000}";

		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertEquals(expectedResult, response.getContentAsString());
	}

	// Test for handling unsupported HTTP methods
	@Test
	public void unsupportedMethodTest() throws Exception {
		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(Constants.CALCULATOR_PATH + "/add")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.METHOD_NOT_ALLOWED.value(), response.getStatus());
	}

	// Test for handling invalid JSON input
	@Test
	public void invalidJsonTest() throws Exception {
		String jsonBody = "{invalid}";

		RequestBuilder requestBuilder = MockMvcRequestBuilders.post(Constants.CALCULATOR_PATH + "/add")
				.accept(MediaType.APPLICATION_JSON)
				.contentType(MediaType.APPLICATION_JSON)
				.content(jsonBody);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.BAD_REQUEST.value(), response.getStatus());
	}
}
