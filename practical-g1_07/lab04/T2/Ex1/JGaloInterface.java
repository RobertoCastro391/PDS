
package lab03.Ex1; // you may change this package

public interface JGaloInterface {
	public char getActualPlayer(); // 'O' or 'X'
	public boolean setJogada(int lin, int col); // set the jogada
	public boolean isFinished();   // someone wons, or no empty positions
	public char checkResult();	// who wons?
}