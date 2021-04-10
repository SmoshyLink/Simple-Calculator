
/*
 * 
 *  Code by Nizar Masri 
 *  
*/

package cmps252.hw5_1;

import java.util.Stack;

public class PostfixEval {
	int index;
	String result = "";

	public PostfixEval(String output) {
		String[] parsedOutput = output.split(" ");
		Stack<String> stack = new Stack<>();
		Evaluate(parsedOutput, stack);
	}

	public String Result() {
		return result;
	}

	public void Evaluate(String[] output, Stack<String> stack) {
		if (stack.empty()) {
			index = 1;
		}
		if (index < output.length) {
			try {
				if (output[index].matches("\\d+(\\.\\d+)?")) {
					stack.push(output[index]);
				} else {
					Double op1 = Double.parseDouble(stack.pop());
					Double op2 = Double.parseDouble(stack.pop());
					Double result = 0.0;

					if (output[index].matches("\\+")) {
						result = op2 + op1;
					} else if (output[index].matches("\\-")) {
						result = op2 - op1;
					} else if (output[index].matches("\\*")) {
						result = op2 * op1;
					} else if (output[index].matches("\\/")) {
						result = op2 / op1;
					}

					stack.push("" + result);
				}
				index++;
				Evaluate(output, stack);
			} catch (Exception e) {
				result = "Invalid input";
				System.out.println(result);
			}

		} else
			result = stack.peek();
	}
}
