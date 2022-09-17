public class Converter {

    private final static double ONE_STEP_IN_KILOMETER = 0.00075;
    private final static double ONE_STEP_IN_KILOCALORIES = 50.0 / 1000.0;

    double convertStepsToKilometer(double steps) {
        return steps * ONE_STEP_IN_KILOMETER;
    }

    double convertStepsToKilocalories(double steps) {
        return steps * ONE_STEP_IN_KILOCALORIES;
    }
}
