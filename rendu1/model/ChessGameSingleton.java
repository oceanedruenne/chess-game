
public class ChessGameSingleton {
        private static ChessGameSingleton chessGameSingletonInstance;

        private ChessGameSingleton()
        {

        }

        public static ChessGameSingleton getInstanceChessGame()
        {
            if (chessGameSingletonInstance == null)
            {
                chessGameSingletonInstance = new ChessGameSingleton();
            }
            return chessGameSingletonInstance;
        }
}
