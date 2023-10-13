
// package lab03; // you may change this package

public interface JGaloInterface {
	public char getActualPlayer(); // 'O' or 'X'
	public boolean setJogada(int lin, int col);
	public boolean isFinished();   // someone wons, or no empty positions
	public char checkResult();	// who wons?
}

class JogoGalo implements JGaloInterface{
	char[][] grid;
	int n_jogadas;
	char winner;
	char actualplayer;	

	public JogoGalo(char player){
		this.grid=new char[3][3];
		this.n_jogadas=0;
		this.winner=' ';
		this.actualplayer=player;
	}

	public char getActualPlayer() { // 'O' or 'X'
		return actualplayer;

	}

	public boolean setJogada(int lin, int col) {
        grid[lin-1][col-1]=actualplayer;
        if (actualplayer=='X'){
            actualplayer='O';
        }else{
            actualplayer='X';
        }
        n_jogadas++;
        return true;
    }

	public boolean isFinished() { // someone wons, or no empty positions
		for (int i=0; i<3; i++){
			if (grid[i][0] ==  grid[i][1] && grid[i][0] ==  grid[i][2]){
				if (grid[i][0]=='X' || grid[i][0] =='O'){
					winner=grid[i][0];
					return true;
				}

			}
			if (grid[0][i] ==  grid[1][i] && grid[0][i] ==  grid[2][i]){
				if (grid[0][i]=='X' || grid[0][i] =='O'){
					winner=grid[0][i];
					return true;
				}
			}
		}

		if (grid[0][0] ==  grid[1][1] && grid[0][0] ==  grid[2][2]){
			if (grid[0][0]=='X' || grid[0][0] =='O'){
				winner=grid[0][0];
				return true;
			}
	}
		if (grid[0][2] ==  grid[1][1] && grid[0][2] ==  grid[2][0]){
			if (grid[0][2]=='X' || grid[0][2] =='O'){
				winner=grid[0][2];
				return true;
			}
	}

		if (n_jogadas==9){
			return true;
		}
		return false;
	}

	public char checkResult() { 	// who wons?
		return winner;
	}
}