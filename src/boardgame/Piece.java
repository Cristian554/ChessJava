package boardgame;

public abstract class Piece {

	protected Position position;
	private Board board;

	public Piece(Board board) {
		this.board = board;
		position = null;
	}

	protected Board getBoard() {
		return board;
	}

	public abstract boolean[][] possibleMoves();

	public boolean possibleMove(Position position) { // verificando se a peça pode se mover
		return possibleMoves()[position.getRow()][position.getColumn()]; // metodo concreto em conjunto do método
																			// abstrato

	}

	public boolean isThereAnyPossibleMove() { // metodo de teste para verificação de linhas e colunas para movimentar as
												// peças
		boolean[][] mat = possibleMoves();
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; i < mat.length; i++) {
				if (mat[i][j]) {
					return true;
				}
			}
		}
		return false;
	}

}