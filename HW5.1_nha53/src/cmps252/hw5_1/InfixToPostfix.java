
/*
 * 
 *  Code by Nizar Masri 
 *  
*/

package cmps252.hw5_1;

import java.util.Stack;

public class InfixToPostfix {

	String output = "";
	int index;
	int size;

	public InfixToPostfix(String input) {
		Stack<Character> operators = new Stack<>();
		Convert(input, operators);
		System.out.println(output);
	}

	public String Parse() {
		return output;
	}

	public void Convert(String input, Stack<Character> operators) {
		if (operators.empty()) {
			operators.push('$');
			index = 0;
			size = input.length();
		}

		if (index < size) {
			if (Character.isDigit(input.charAt(index))) {
				if (index + 1 == input.length()) {
					output += " " + input.charAt(index);
				} else if (!Character.isDigit(input.charAt(index + 1)) && input.charAt(index) == '.')
					output += " " + input.charAt(index);
				else {
					output += " ";
					while (index < size && (Character.isDigit(input.charAt(index)) || input.charAt(index) == '.')) {
						output += input.charAt(index);
						index++;
					}
					index--;
				}
				index++;
				Convert(input, operators);
			} else if ((input.charAt(index) == '(')) {
				operators.push(input.charAt(index));
				index++;
				Convert(input, operators);
			} else if ((input.charAt(index) == ')')) {
				if (operators.peek() == '$')
					output = "Invalid input";
				else {
					while (operators.peek() != '(') {
						if ((operators.peek() == '+') || (operators.peek() == '-') || (operators.peek() == '*')
								|| (operators.peek() == '/')) {
							output += " " + operators.peek();
							operators.pop();
						}
					}
					if (operators.peek() == '(') {
						operators.pop();
					}
					index++;
					Convert(input, operators);
				}

			} else if ((input.charAt(index) == '+') || (input.charAt(index) == '-')) {
				if ((operators.peek() == '+') || (operators.peek() == '-') || (operators.peek() == '*')
						|| (operators.peek() == '/')) {
					output += " " + operators.peek();
					operators.pop();
					Convert(input, operators);
				} else
					operators.push(input.charAt(index));
				index++;
				Convert(input, operators);
			} else if ((input.charAt(index) == '*') || (input.charAt(index) == '/')) {
				if ((operators.peek() == '*') || (operators.peek() == '/')) {
					output += " " + operators.peek();
					operators.pop();
					operators.push(input.charAt(index));
				} else
					operators.push(input.charAt(index));
				index++;
				Convert(input, operators);
			} else if(input.charAt(index) == '.') {
				output = "Invalid input";
			}
		} else {
			while ((operators.peek() == '+') || (operators.peek() == '-') || (operators.peek() == '*')
					|| (operators.peek() == '/')) {
				output += " " + operators.peek();
				operators.pop();
			}
			if (operators.peek() != '$')
				output = "Invalid input";
		}
	}
}