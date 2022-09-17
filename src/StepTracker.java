import org.w3c.dom.ls.LSOutput;

public class StepTracker {
    /**For the user, months are counted from one**/
    MonthData[] monthToData;
    int stepsGoal = 10000;

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    public void setStepByMonth(int month, int day, int steps) {
        monthToData[month - 1].setStepsByDay(day, steps);
    }

    public void changeStepGoal(int steps) {
        stepsGoal = steps;
    }

    public String getStatisticByMonth(int month) {
        String formedStatistics = "Количество пройденых шагов: \n" + monthToData[month - 1].getAllSteps();
        formedStatistics += "\n Общее кол-во шагов за месяц: " + monthToData[month - 1].getSumOfSteps() + "\n";
        formedStatistics += "Наибольшее кол-во шагов за месяц: " + monthToData[month - 1].getMaxSteps() + "\n";
        formedStatistics += "Среднее значение за месяц: " + monthToData[month - 1].getAverageValue() + "\n";
        formedStatistics += "Пройдено: " + monthToData[month - 1].getDistance() + "\n";
        formedStatistics += "Кол-во сожженных килокалорий: " + monthToData[month - 1].getBurntCalories() + "\n";
        formedStatistics += "Лучшая серия: " + monthToData[month - 1].getBetterSeries(stepsGoal) + ".";

        return formedStatistics;

    }
}




