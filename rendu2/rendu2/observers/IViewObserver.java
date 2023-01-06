package rendu2.observers;

import rendu2.model.Color;

public interface IViewObserver {
    void tileClicked(int posX, int posY);

    void upgradePawn(String type, Color color, int x, int y);
}
