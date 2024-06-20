package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {

	public Pawn(Board board, Color color) {
		super(board, color);

	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];

		Position p = new Position(0, 0);

		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // regra de movimentação
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) { // regra de movimentação
				mat[p.getRow()][p.getColumn()] = true; // verificando as duas casas em frente
			}
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // verificando oponente na diagonal
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // verificando oponente na diagonal
				mat[p.getRow()][p.getColumn()] = true;
			}
		} else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) { // regra de movimentação
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());// alterou para + pois as peças pretas do peão estavam andando apenas 1 linha.
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p) && getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) { // regra de movimentação
				mat[p.getRow()][p.getColumn()] = true; // verificando as duas casas em frente
			}
			p.setValues(position.getRow() + 1, position.getColumn() - 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // verificando oponente na diagonal
				mat[p.getRow()][p.getColumn()] = true;

			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) { // verificando oponente na diagonal
				mat[p.getRow()][p.getColumn()] = true;
			}
		}

		return mat;
	}
	@Override
	public String toString() {
		return "P";
	}

}
