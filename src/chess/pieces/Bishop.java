package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Bishop extends ChessPiece {

	public Bishop(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "B";
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		// nw
		p.setValues(position.getRow() - 1, position.getColumn()-1);// position.get row é a linha acima da peça 
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // equanto a posição (p) existir e não
			mat[p.getRow()][p.getColumn()] = true; // tiver peça a lógica é verdadeira
			p.setValues(p.getRow() -1, p.getColumn() -1); // anda menos uma casa
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // quando houver peça do oponente seguir uma
																		// linha a frente
			mat[p.getRow()][p.getColumn()] = true;
		}

		// ne
		p.setValues(position.getRow() -1, position.getColumn() +1);
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
			mat[p.getRow()][p.getColumn()] = true;
			p.setValues(p.getRow() -1, p.getColumn() +1);
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {

			mat[p.getRow()][p.getColumn()] = true;
		}
		// se
		p.setValues(position.getRow() +1 , position.getColumn() + 1);// verificando a cima da peça linha -1
		while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // equanto a posição (p) existir e não
			mat[p.getRow()][p.getColumn()] = true; // tiver peça a lógica é verdadeira
			p.setValues(p.getRow() +1, p.getColumn() +1);; // anda menos uma casa
		}
		if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // quando houver peça do oponente seguir uma
																		// linha a frente
			mat[p.getRow()][p.getColumn()] = true;
		}
		// sw
				p.setValues(position.getRow() + 1, position.getColumn()-1);// verificando a cima da peça linha -1
				while (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // equanto a posição (p) existir e não
					mat[p.getRow()][p.getColumn()] = true; // tiver peça a lógica é verdadeira
					p.setValues(p.getRow() +1 , p.getColumn()-1); // anda menos uma casa
				}
				if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // quando houver peça do oponente seguir uma
																				// linha a frente
					mat[p.getRow()][p.getColumn()] = true;
				}

		return mat;
	}
}