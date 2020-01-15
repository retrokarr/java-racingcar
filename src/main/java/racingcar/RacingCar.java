package racingcar;

public class RacingCar {
    private Cars cars;
    private StringBuilder raceHistory;
    private int round;
    private int currentRound;

    public RacingCar(int numberOfCar, int round) {
        this(new Cars(numberOfCar), round);
    }

    public RacingCar(Cars cars, int round) {
        this.cars = cars;
        this.round = round;
        this.currentRound = 0;
        this.raceHistory = new StringBuilder();
    }

    public void race() {
        for( ; currentRound < round ; ++currentRound) {
            cars.moveCars();

            registerHistory(cars.showCurrentState());
        }
    }

    private void registerHistory(String state) {
        raceHistory.append(state)
                .append('n');
    }

    public String raceHistory() {
        return raceHistory.toString();
    }

    public String showCurrentState() {
        return cars.showCurrentState();
    }
}
