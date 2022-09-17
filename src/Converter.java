public class Converter {
    private final double ONE_STEP_IN_KM = 0.00075;
    private final double ONE_STEP_IN_KLCL = 50.0 / 1000.0;

    double convertStepsToKM(double steps) {
        return steps * ONE_STEP_IN_KM;
    }
    double convertStepsToKCAL(double steps) {
        return steps * ONE_STEP_IN_KLCL;
    }
}
