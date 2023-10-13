package lab03.Ex1;

public class Galo implements JGaloInterface {

    private char[][] board = new char[3][3];
    private char actualPlayer = ' ';
    private int jogadas = 0;
    private boolean end = false;
    private char result = 'F';
    

    public Galo(String[] args) {
        if(args[0].equals("O")) {
            actualPlayer = 'O';
        } else {
            actualPlayer = 'X';
        }
    }


    public Galo() {
        actualPlayer = 'X';
    }


    @Override
    public char getActualPlayer() {
        return actualPlayer;

    }

    @Override
    public boolean setJogada(int lin, int col) {
        lin--;
        col--;
            if(board[lin][col] == ' ' || end == false){
                board[lin][col] = getActualPlayer();
                jogadas++;
                
                if(board[0][0] == board[0][1] && board[0][1] == board[0][2] && board[0][0] == actualPlayer ||
                board[0][1] == board[1][1] && board[1][1] == board[2][1] && board[0][1] == actualPlayer ||
                board[0][2] == board[1][2] && board[1][2] == board[2][2] && board[0][2] == actualPlayer ||
                board[1][0] == board[1][1] && board[1][1] == board[1][2] && board[1][0] == actualPlayer ||
                board[2][0] == board[2][1] && board[2][1] == board[2][2] && board[2][0] == actualPlayer ||
                board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] == actualPlayer ||
                board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] == actualPlayer ||
                board[0][0] == board[1][0] && board[1][0] == board[2][0] && board[0][0] == actualPlayer){
                    end = true;
                    result = actualPlayer;
                }

                if (jogadas == 9){
                    end = true;
                    result = ' ';
                }

                if(end == false){
                    if(actualPlayer == 'X'){
                        actualPlayer = 'O';
                    }
                    else{
                        actualPlayer = 'X';
                    }
                }

                return true;
            }
            else{
                return false;
            }
    }

    @Override
    public boolean isFinished() {
        return end;
    }

    @Override
    public char checkResult() {
        return result;
    }
    
}
