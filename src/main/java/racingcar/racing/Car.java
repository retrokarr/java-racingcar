package racingcar.racing;

import racingcar.history.CarSnapshot;
import racingcar.strategy.MoveStrategy;
import racingcar.strategy.RandomMoveStrategy;

import java.util.List;
import java.util.Random;

public class Car {
    public static final String DASH_MARK = "-";

    private String name;
    private Integer position = 0;
    private MoveStrategy moveStrategy;

    public Car(String name) {
        this(name, new RandomMoveStrategy(new Random()));
    }

    public Car(String name, MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.name = name;
    }

    public void move() {
        if(moveStrategy.isMovable()) {
            position++;
        }
    }

    public int currentPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public void checkWinner(List<Car> winners, int winnerPosition) {
        if(position == winnerPosition) {
            winners.add(this);
        }
    }

    public CarSnapshot snapshot() {
        return new CarSnapshot(this);
    }
}
