public class MonthData {

    private final int[] stepsPerDay;
    private double sumOfSteps;
    private int maxSteps;
    Converter converter = new Converter();

    public MonthData() {
        stepsPerDay = new int[30];
    }

    public int getStepsByDay(int day) {
        return stepsPerDay[day-1];
    }

    public void setStepsByDay (int day, int steps) {
        stepsPerDay[day-1] = steps;
        sumOfSteps += steps;
        if (steps > maxSteps) {
            maxSteps=steps;
        }
    }

    public String getAllSteps() {
       String formedSteps = "";
        for (int i = 0; i < stepsPerDay.length; i++) {
            if(i == 29) {
                formedSteps += (i + 1) + " день: " + stepsPerDay[i]+ ".";
            } else {
                formedSteps += (i + 1) + " день: " + stepsPerDay[i] + ", ";
            }
        }
        return formedSteps;
    }

    public double getSumOfSteps() {
        return sumOfSteps;
    }
    public int getMaxSteps() {
        return maxSteps;
    }

    public double getAverageValue() {
        double averageValue = sumOfSteps / 30;
        return averageValue;
    }

    public double getDistance() {
        return  converter.convertStepsToKM(sumOfSteps);
    }

    public double getBurntCalories() {
        return converter.convertStepsToKCAL(sumOfSteps);
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
            setStepsByDay (i,((int)( Math.random() * 100000)+1));
        }
    }

}

