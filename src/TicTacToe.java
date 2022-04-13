import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends Frame {
	static String[] board;
	static String player;
	private Button[] displayBoard;

	
	private Label slot;
	private TextField enteredSlot;
	static Label winner;
	
	public TicTacToe() {
		Panel panelBoard = new Panel(new GridLayout(3, 3));
		displayBoard = new Button[9];
		for (int i = 0; i < 9; i++) {
			displayBoard[i] = new Button(board[i]);
			panelBoard.add(displayBoard[i]);
		}
		
		Panel panelMove = new Panel(new GridLayout(3, 1));
		slot = new Label("Player X: Enter slot number to place X in:");
		enteredSlot = new TextField();
		winner = new Label();
		panelMove.add(slot);
		panelMove.add(enteredSlot);
		panelMove.add(winner);
		
		enteredSlot.addActionListener(new SlotInputListener());
		
		setLayout(new BorderLayout());
		add(panelBoard, BorderLayout.CENTER);
		add(panelMove, BorderLayout.SOUTH);
		
		addWindowListener(new MyWindowListener());
		
		setTitle("Tic Tac Toe");
		setSize(500, 500);
		
		setVisible(true);
	}
	
	static String checkWin() {
		for (int i = 0; i < 8; i++) {
			String threeInRow = null;
			
			switch (i) {
			case 0:
				threeInRow = board[0] + board[1] + board[2];
				break;
			case 1:
				threeInRow = board[3] + board[4] + board[5];
				break;
			case 2:
				threeInRow = board[6] + board[7] + board[8];
				break;
			case 3:
				threeInRow = board[0] + board[3] + board[6];
				break;
			case 4:
				threeInRow = board[1] + board[4] + board[7];
				break;
			case 5:
				threeInRow = board[2] + board[5] + board[8];
				break;
			case 6:
				threeInRow = board[0] + board[4] + board[8];
				break;
			case 7:
				threeInRow = board[2] + board[4] + board[6];
				break;
			}
			
			if (threeInRow.equals("XXX")) {
				winner.setText("X is the Winner!");
				return "X";
			}
			if (threeInRow.equals("OOO")) {
				winner.setText("O is the Winner!");
				return "O";
			}
		}
			
			// checks if board is filled with Xs and Os
		for (int i = 0; i < 9; i++) {
			if (Arrays.asList(board).contains(String.valueOf(i + 1))) {
				break;
			} else if (i == 8){
				winner.setText("It's a draw!");
				return "draw";
			}
		}
		return null;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		//Scanner in = new Scanner(System.in);
		board = new String[9];
		player = "X";
		
		
		for (int i = 0; i < 9; i++) {
			board[i] = String.valueOf(i + 1);
		}
		
		TicTacToe game = new TicTacToe();
		
		//printBoard();
		
		//while (winningPlayer == null) {
		//	System.out.println("Player " + player + ": Enter slot number to place " + player
		//			+ " in:");
		//	int slotNum = in.nextInt();
			
			// check to make sure the entered number is between 1 and 9
			
			
	}
	private class SlotInputListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent evt) {
			int slotNum = Integer.parseInt(enteredSlot.getText());
			String winningPlayer = null;
			while (slotNum < 1 || slotNum > 9) {
				slot.setText("Invalid slot number. Please enter a number 1 - 9:");
				slotNum = Integer.parseInt(enteredSlot.getText());
			}
			
			// check to make sure the slot is open
			// if slot is open, change turn to next player
			// if slot taken, while loops repeats
			if (board[slotNum - 1].equals(String.valueOf(slotNum))) {
				board[slotNum - 1] = player;
				displayBoard[slotNum -1].setLabel(player);
				if (player.equals("X")) {
					player = "O";
					slot.setText("Player O: Enter slot number to place O in:");
				} else {
					player = "X";
					slot.setText("Player X: Enter slot number to place X in:");
				}
				
				
				winningPlayer = checkWin();
				
			} else {
				slot.setText("Slot is already taken, please enter a different slot number:");
			}
		}
	}
	private class MyWindowListener implements WindowListener {
		@Override
		public void windowClosing(WindowEvent evt) {
			System.exit(0);
		}

		@Override
		public void windowActivated(WindowEvent arg0) {
			// TODO Auto-generated method stub
			System.out.println("Window Activated");
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Window Deactivated");
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Window Deiconified");
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			System.out.println("Window Iconified");
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}
	}


}


