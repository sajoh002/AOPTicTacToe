
public aspect Referee {
	pointcut checkGameOver(): call(static String checkWin());
	
	after() returning(Object obj): checkGameOver() {
		if ((String) obj == "X") {
			System.out.println("X is the winner!");
		} else if ((String) obj == "O") {
			System.out.println("O is the winner!");
		} else if ((String) obj == "draw") {
			System.out.println("It's a draw");
		}
	}

}
