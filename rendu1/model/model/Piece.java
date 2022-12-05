package model;

import controller.ObserverPiece;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    List<ObserverPiece> listObservers;

    public Piece()
    {
        this.listObservers = new ArrayList<ObserverPiece>();
    }

    public abstract List<Tile> getLegalMoves(Tile[][] tiles, int posX, int posY);

    public void addObservers(ObserverPiece obsPiece)
    {
        listObservers.add(obsPiece);
    }

    public void notifyObservers()
    {
        for (ObserverPiece obs : listObservers)
        {
            obs.update(this);
        }
    }
}
