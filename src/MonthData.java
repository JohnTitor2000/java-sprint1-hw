public class MonthData {

    private final int[] stepsPerDay;
    private double sumOfSteps;
    private int maxSteps;
    private final Converter converter = new Converter();

    public MonthData() {
        stepsPerDay = new int[30];
    }

    public void setStepsByDay (int day, int steps) { stepsPerDay[day - 1] = steps; }

    public double getSumOfSteps() {
        sumOfSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            sumOfSteps += stepsPerDay[i];
        }
        return sumOfSteps;
    }

    public double getMaxSteps() {
        maxSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            maxSteps = Math.max(maxSteps, stepsPerDay[i]);
        }
        return maxSteps;
    }

    public StringBuilder getAllSteps() {
       StringBuilder formedSteps = new StringBuilder("");
        for (int i = 0; i < stepsPerDay.length; i++) {
            if (i == stepsPerDay.length - 1) {
                formedSteps.append((i + 1) + " день: " + stepsPerDay[i]+ ".");
            } else {
                formedSteps.append ((i + 1) + " день: " + stepsPerDay[i] + ", ");
            }
        }
        return formedSteps;
    }

    public double getAverageValue() { return sumOfSteps / 30; }

    public double getDistance() { return  converter.convertStepsToKilometer(sumOfSteps); }

    public double getBurntCalories() {
        return converter.convertStepsToKilocalories(sumOfSteps);
    }

    public int getBetterSeries(int stepGoal) {
        int series =0;
        int maxSeries = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            if(stepsPerDay[i] >= stepGoal) {
                series++;
            } else {
                if (series > maxSeries) {
                    maxSeries = series;
                }
            }
        }
        return maxSeries;
    }

    /* for test purporses */
    public void setRandomValueForAllDay() {
        for (int i = 1; i < stepsPerDay.length+1; i++) {
            setStepsByDay(i, ((int)( Math.random() * 100000)+1));
        }
    }

}

