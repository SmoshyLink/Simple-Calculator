
/*
 * 
 *  Code by Nizar Masri 
 *  
*/

package cmps252.hw5_1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class SimpleCalculator extends JFrame {
	private JTextField display;
	static String input = "";
	double memoryNumber = 0.0;
	boolean isCalculated = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SimpleCalculator frame = new SimpleCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SimpleCalculator() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 375, 389);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.black);

		JButton btnMC = new JButton("MC");
		btnMC.setFont(new Font("Raleway", Font.BOLD, 14));
		btnMC.setBounds(10, 60, 60, 38);
		btnMC.setFocusPainted(false);
		btnMC.setBorder(null);
		btnMC.setForeground(Color.white);
		btnMC.setBackground(Color.decode("#464646"));
		getContentPane().add(btnMC);

		btnMC.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				memoryNumber = 0;
			}
		});

		JButton btnMR = new JButton("MR");
		btnMR.setFont(new Font("Raleway", Font.BOLD, 14));
		btnMR.setBounds(80, 60, 60, 38);
		btnMR.setFocusPainted(false);
		btnMR.setBorder(null);
		btnMR.setForeground(Color.white);
		btnMR.setBackground(Color.decode("#464646"));
		getContentPane().add(btnMR);

		btnMR.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				display.setText("" + memoryNumber);
			}
		});

		JButton btnMS = new JButton("MS");
		btnMS.setFont(new Font("Raleway", Font.BOLD, 14));
		btnMS.setBounds(150, 60, 60, 38);
		btnMS.setFocusPainted(false);
		btnMS.setBorder(null);
		btnMS.setForeground(Color.white);
		btnMS.setBackground(Color.decode("#464646"));
		getContentPane().add(btnMS);

		btnMS.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isCalculated)
					memoryNumber = Double.parseDouble(display.getText());
			}
		});

		JButton btnM_Plus = new JButton("M+");
		btnM_Plus.setFont(new Font("Raleway", Font.BOLD, 14));
		btnM_Plus.setBounds(220, 60, 60, 38);
		btnM_Plus.setFocusPainted(false);
		btnM_Plus.setBorder(null);
		btnM_Plus.setForeground(Color.white);
		btnM_Plus.setBackground(Color.decode("#464646"));
		getContentPane().add(btnM_Plus);

		btnM_Plus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isCalculated)
					memoryNumber += Double.parseDouble(display.getText());
			}
		});

		JButton btnM_Minus = new JButton("M-");
		btnM_Minus.setFont(new Font("Raleway", Font.BOLD, 14));
		btnM_Minus.setBounds(290, 60, 60, 38);
		btnM_Minus.setFocusPainted(false);
		btnM_Minus.setBorder(null);
		btnM_Minus.setForeground(Color.white);
		btnM_Minus.setBackground(Color.decode("#464646"));
		getContentPane().add(btnM_Minus);

		btnM_Minus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (isCalculated)
					memoryNumber -= Double.parseDouble(display.getText());
			}
		});

		display = new JTextField();
		display.setFont(new Font("Open Sans", Font.BOLD, 17));
		display.setEditable(false);
		display.setBounds(10, 10, 340, 40);
		display.setBackground(Color.black);
		display.setBorder(null);
		display.setHorizontalAlignment(SwingConstants.RIGHT);
		display.setForeground(Color.white);
		getContentPane().add(display);
		display.setColumns(10);
		display.setText("0");

		JButton btnDelete = new JButton("DEL");
		btnDelete.setFont(new Font("Raleway", Font.BOLD, 14));
		btnDelete.setBounds(10, 108, 130, 38);
		btnDelete.setFocusPainted(false);
		btnDelete.setBorder(null);
		btnDelete.setForeground(Color.white);
		btnDelete.setBackground(Color.decode("#464646"));
		getContentPane().add(btnDelete);

		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (input != "") {
					int length = input.length();
					if (length - 1 < 0) {
						input = "";
					} else {
						input = input.substring(0, length - 1);
						display.setText(input);
					}
					if (length - 1 <= 0)
						display.setText("0");
				}

				isCalculated = false;
			}
		});

		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Raleway", Font.BOLD, 14));
		btnClear.setBounds(150, 108, 60, 38);
		btnClear.setFocusPainted(false);
		btnClear.setBorder(null);
		btnClear.setForeground(Color.white);
		btnClear.setBackground(Color.decode("#464646"));
		getContentPane().add(btnClear);

		btnClear.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input = "";
				display.setText("0");
				isCalculated = false;
			}
		});

		JButton btnLeftBracket = new JButton("(");
		btnLeftBracket.setFont(new Font("Raleway", Font.BOLD, 14));
		btnLeftBracket.setBounds(220, 108, 60, 38);
		btnLeftBracket.setFocusPainted(false);
		btnLeftBracket.setBorder(null);
		btnLeftBracket.setForeground(Color.white);
		btnLeftBracket.setBackground(Color.decode("#464646"));
		getContentPane().add(btnLeftBracket);

		btnLeftBracket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "(";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnRightBracket = new JButton(")");
		btnRightBracket.setFont(new Font("Raleway", Font.BOLD, 14));
		btnRightBracket.setBounds(290, 108, 60, 38);
		btnRightBracket.setFocusPainted(false);
		btnRightBracket.setBorder(null);
		btnRightBracket.setForeground(Color.white);
		btnRightBracket.setBackground(Color.decode("#464646"));
		getContentPane().add(btnRightBracket);

		btnRightBracket.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += ")";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Raleway", Font.BOLD, 16));
		btn7.setBounds(10, 156, 60, 38);
		btn7.setFocusPainted(false);
		btn7.setBorder(null);
		btn7.setForeground(Color.white);
		btn7.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn7);

		btn7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "7";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Raleway", Font.BOLD, 16));
		btn8.setBounds(80, 156, 60, 38);
		btn8.setFocusPainted(false);
		btn8.setBorder(null);
		btn8.setForeground(Color.white);
		btn8.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn8);

		btn8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "8";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Raleway", Font.BOLD, 16));
		btn9.setBounds(150, 156, 60, 38);
		btn9.setFocusPainted(false);
		btn9.setBorder(null);
		btn9.setForeground(Color.white);
		btn9.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn9);

		btn9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "9";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Raleway", Font.BOLD, 16));
		btn4.setBounds(10, 204, 60, 38);
		btn4.setFocusPainted(false);
		btn4.setBorder(null);
		btn4.setForeground(Color.white);
		btn4.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn4);

		btn4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "4";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Raleway", Font.BOLD, 16));
		btn5.setBounds(80, 204, 60, 38);
		btn5.setFocusPainted(false);
		btn5.setBorder(null);
		btn5.setForeground(Color.white);
		btn5.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn5);

		btn5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "5";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Raleway", Font.BOLD, 16));
		btn6.setBounds(150, 204, 60, 38);
		btn6.setFocusPainted(false);
		btn6.setBorder(null);
		btn6.setForeground(Color.white);
		btn6.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn6);

		btn6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "6";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Raleway", Font.BOLD, 16));
		btn1.setBounds(10, 252, 60, 38);
		btn1.setFocusPainted(false);
		btn1.setBorder(null);
		btn1.setForeground(Color.white);
		btn1.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn1);

		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "1";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Raleway", Font.BOLD, 16));
		btn2.setBounds(80, 252, 60, 38);
		btn2.setFocusPainted(false);
		btn2.setBorder(null);
		btn2.setForeground(Color.white);
		btn2.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn2);

		btn2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "2";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Raleway", Font.BOLD, 16));
		btn3.setBounds(150, 252, 60, 38);
		btn3.setFocusPainted(false);
		btn3.setBorder(null);
		btn3.setForeground(Color.white);
		btn3.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn3);

		btn3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "3";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Raleway", Font.BOLD, 16));
		btn0.setBounds(10, 300, 130, 38);
		btn0.setFocusPainted(false);
		btn0.setBorder(null);
		btn0.setForeground(Color.white);
		btn0.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btn0);

		btn0.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "0";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Raleway", Font.BOLD, 20));
		btnDot.setBounds(150, 300, 60, 38);
		btnDot.setFocusPainted(false);
		btnDot.setBorder(null);
		btnDot.setForeground(Color.white);
		btnDot.setBackground(Color.decode("#FF3333"));
		getContentPane().add(btnDot);

		btnDot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += ".";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnDivide = new JButton("/");
		btnDivide.setFont(new Font("Raleway", Font.BOLD, 14));
		btnDivide.setBounds(220, 156, 60, 38);
		btnDivide.setFocusPainted(false);
		btnDivide.setBorder(null);
		btnDivide.setForeground(Color.white);
		btnDivide.setBackground(Color.decode("#464646"));
		getContentPane().add(btnDivide);

		btnDivide.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "/";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnMultiply = new JButton("x");
		btnMultiply.setFont(new Font("Raleway", Font.BOLD, 14));
		btnMultiply.setBounds(220, 204, 60, 38);
		btnMultiply.setFocusPainted(false);
		btnMultiply.setBorder(null);
		btnMultiply.setForeground(Color.white);
		btnMultiply.setBackground(Color.decode("#464646"));
		getContentPane().add(btnMultiply);

		btnMultiply.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "*";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnSubtract = new JButton("-");
		btnSubtract.setFont(new Font("Raleway", Font.BOLD, 14));
		btnSubtract.setBounds(220, 252, 60, 38);
		btnSubtract.setFocusPainted(false);
		btnSubtract.setBorder(null);
		btnSubtract.setForeground(Color.white);
		btnSubtract.setBackground(Color.decode("#464646"));
		getContentPane().add(btnSubtract);

		btnSubtract.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "-";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnAdd = new JButton("+");
		btnAdd.setFont(new Font("Raleway", Font.BOLD, 17));
		btnAdd.setBounds(220, 300, 60, 38);
		btnAdd.setFocusPainted(false);
		btnAdd.setBorder(null);
		btnAdd.setForeground(Color.white);
		btnAdd.setBackground(Color.decode("#464646"));
		getContentPane().add(btnAdd);

		btnAdd.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				input += "+";
				display.setText(input);
				isCalculated = false;
			}
		});

		JButton btnEquals = new JButton("=");
		btnEquals.setFont(new Font("Raleway", Font.BOLD, 25));
		btnEquals.setBounds(290, 156, 60, 182);
		btnEquals.setFocusPainted(false);
		btnEquals.setBorder(null);
		btnEquals.setForeground(Color.white);
		btnEquals.setBackground(Color.decode("#009900"));
		getContentPane().add(btnEquals);

		btnEquals.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InfixToPostfix infix = new InfixToPostfix(input);
				String postfix = infix.Parse();
				PostfixEval eval = new PostfixEval(postfix);
				String result = eval.Result();
				display.setText(result);
				isCalculated = true;
			}
		});

	}
}
