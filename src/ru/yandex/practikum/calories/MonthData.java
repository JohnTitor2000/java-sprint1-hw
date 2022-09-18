package ru.yandex.practikum.calories;

public class MonthData {
    private final static double NUMBER_OF_DAYS = 30;
    private final int[] stepsPerDay;
    private final Converter converter;

    public MonthData() {
        stepsPerDay = new int[30];
        converter = new Converter();
    }

    public void setStepsByDay(int day, int steps) {
        stepsPerDay[day - 1] = steps;
    }

    public double getSumOfSteps() {
        double sumOfSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            sumOfSteps += stepsPerDay[i];
        }
        return sumOfSteps;
    }

    public double getMaxSteps() {
        int maxSteps = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            maxSteps = Math.max(maxSteps, stepsPerDay[i]);
        }
        return maxSteps;
    }

    public String getAllSteps() {
       StringBuilder formedSteps = new StringBuilder();
        for (int i = 0; i < stepsPerDay.length; i++) {
            if (i == stepsPerDay.length - 1) {
                formedSteps.append((i + 1) + " день: " + stepsPerDay[i]+ ".");
            } else {
                formedSteps.append ((i + 1) + " день: " + stepsPerDay[i] + ", ");
            }
        }
        return formedSteps.toString();
    }

    public double getAverageValue() {
        return getSumOfSteps() / NUMBER_OF_DAYS;
    }

    public double getDistance() {
        return  converter.convertStepsToKilometer(getSumOfSteps());
    }

    public double getBurntCalories() {
        return converter.convertStepsToKilocalories(getSumOfSteps());
    }

    public int getBestSeries(int stepGoal) {
        int series = 0;
        int maxSeries = 0;
        for (int i = 0; i < stepsPerDay.length; i++) {
            if (stepsPerDay[i] >= stepGoal) {
                series++;
            } else if (series > maxSeries) {
                maxSeries = series;
            } else {
                series = 0;
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

