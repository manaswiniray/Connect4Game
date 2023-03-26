  import java.util.*;
public class Connect4 {
	
	
	static Scanner sc=new Scanner(System.in);
	static char board[][]=new char[6][7];
	
	public static void display() {
		int i,j;
		
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				System.out.print(board[i][j]+"|");
			}
			System.out.println();
		}
	}
	
	public static void empty() {
		int i,j;
		
		for(i=0;i<6;i++) {
			for(j=0;j<7;j++) {
				board[i][j]=' ';
			}
		}
	}
	
	public static int input() {
		int col;
		
		do{
			System.out.println("Enter the column no.(1-7): ");
			col=sc.nextInt();
		}while(col<1 || col>8 || board[0][col-1]!=' ');
		
		return col;
		
	}
	
	public static int inputComp() {
		int max=7,min=1;
		Random random = new Random();
		int rand=0;

		do {
		    rand=(int) random.nextInt(max - min) + min;
		}while((board[0][rand]!=' '));
		
		return rand;
		
	}
	
	public static boolean decide() {
		int i,j;
		
		for(i=0;i<3;i++) {										//vertical	
			for(j=0;j<7;j++) {
				if( board[i][j]!=' ' && board[i][j]==board[i+1][j] && board[i+1][j]==board[i+2][j] && board[i+2][j]==board[i+3][j] ) {
					char c=board[i][j];
					whoWin(c);
					return true;
				}
			}
		}
		
		for(i=0;i<6;i++) {										//horizontal
			for(j=0;j<4;j++) {
				if( board[i][j]!=' ' && board[i][j]==board[i][j+1] && board[i][j+1]==board[i][j+2] && board[i][j+2]==board[i][j+3] ) {
					char c=board[i][j];
					whoWin(c);
					return true;
				}
			}
		}
		
		for(i=0;i<3;i++) {										//diagonal top left to right bottom
			for(j=0;j<4;j++) {
				if( board[i][j]!=' ' && board[i][j]==board[i+1][j+1] && board[i+1][j+1]==board[i+2][j+2] && board[i+2][j+2]==board[i+3][j+3] ) {
					char c=board[i][j];
					whoWin(c);
					return true;
				}
			}
		}
		
		for(i=0;i<3;i++) {										//diagonal top right to left bottom
			for(j=3;j<7;j++) {
				if( board[i][j]!=' ' && board[i][j]==board[i+1][j-1] && board[i+1][j-1]==board[i+2][j-2] && board[i+2][j-2]==board[i+3][j-3] ) {
					char c=board[i][j];
					whoWin(c);
					return true;
				}
			}
		}
		
		boolean check=tie();
		
		
		
		
		return false || check;
	}
	
	public static void whoWin(char c) {
		
		if(c=='X') {
			System.out.println("You Win");
		}
		else {
			System.out.println("Computer Wins");
		}
	}
	
	public static boolean tie() {
		int i;
		for(i=0;i<7;i++) {										//if the board is full
			if(board[0][i]==' ') {
				
				return false;
			}
		}
		System.out.println("It's a tie.");
		return true;
	}

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		empty();
		display();
		
		boolean gameOver=false;
		
		while(!gameOver) {
			int user=input();
			for(int i=5;i>=0;i--) {
				if(board[i][user-1]==' ') {
					board[i][user-1]='X';
					break;
				}
				
			}
			
			int comp=inputComp();
			for(int i=5;i>=0;i--) {
				if(board[i][comp]==' ') {
					board[i][comp]='O';
					break;
				}
				
			}
			
			display();
		
			gameOver=decide();
			
		}
		
		
		
		
		
		

	}

}
