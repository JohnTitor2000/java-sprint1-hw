public class StepTracker {
    /**For the user, months are counted from one**/
    private final MonthData[] monthToData;
    private int stepsGoal = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setStepByMonth(int month, int day, int steps) {
        monthToData[month - 1].setStepsByDay(day, steps);
    }

    public void setStepsGoal(int stepsGoal) {
        this.stepsGoal = stepsGoal;
    }

    public String getStatisticByMonth(int month) {
        String formattedStatistics = "Количество пройденых шагов: \n"
                                      + monthToData[month - 1].getAllSteps() + "\n"
                                      + "Общее кол-во шагов за месяц: " + monthToData[month - 1].getSumOfSteps() + "\n"
                                      + "Наибольшее кол-во шагов за месяц: " + monthToData[month - 1].getMaxSteps() + "\n"
                                      + "Среднее значение за месяц: " + monthToData[month - 1].getAverageValue() + "\n"
                                      + "Пройдено: " + monthToData[month - 1].getDistance() + "\n"
                                      + "Кол-во сожженных килокалорий: " + monthToData[month - 1].getBurntCalories() + "\n"
                                      + "Лучшая серия: " + monthToData[month - 1].getBetterSeries(stepsGoal) + ".";

        return formattedStatistics;
    }
}
