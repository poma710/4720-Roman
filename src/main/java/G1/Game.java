package G1;

public interface Game {
    void start(Integer sizeWord, Integer maxTry);

    Answer inputValue();

    GameStatus getGameStatus();

}
