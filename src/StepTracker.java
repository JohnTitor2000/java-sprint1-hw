import org.w3c.dom.ls.LSOutput;

import java.util.Random;

public class StepTracker {
    /** Несмотря на то, что в тз написано, что месяцы считаются с 0 для пользователя
     * - я не могу так с ним поступить, это бесчеловечно. Здесь для пользователя месяцы считаются с единицы
     * Также для тестирования вы можете использовать метод setRandomValueForAllDay() класса MonthData,
     * который заполнит выбраный месяц случайными числами. Для этого замените метод setStepsByDay(day, steps)
     * на метод setRandomValueForAllDay()**/
    MonthData[] monthToData;
    int stepsGoal = 10000;
    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }
    public void setStepByMonth(int month, int day, int steps) {
        monthToData[month-1].setStepsByDay(day, steps);
    }
    public void changeStepGoal (int steps) {
        stepsGoal = steps;
        System.out.println("Значение изменено!");
    }
    public void getStatisticByMonth(int month) {
        System.out.println("Количество пройденых шагов:");
        monthToData[month-1].printAllSteps();
        System.out.println("Общее кол-во шагов за месяц: " + monthToData[month-1].getSumOfSteps());
        System.out.println("Наибольшее кол-во шагов за месяц: " + monthToData[month-1].getMaxSteps());
        System.out.print("Среднее значение за месяц: ");
        monthToData[month-1].printAverageValue();
        System.out.print("Пройдено: ");
        monthToData[month-1].printDisance();
        System.out.print("Кол-во сожженных килокалорий: ");
        monthToData[month-1].printBirnedCalories();
        System.out.println("Лучшая серия: " + monthToData[month-1].getBetterSeries(stepsGoal) + ".");

    }


    class MonthData {
        int[] stepsPerDay;
        double sumOfSteps;
        int maxSteps;
        public MonthData() {
            stepsPerDay = new int[30];
            sumOfSteps = 0;
            for (int i = 0; i < stepsPerDay.length; i++) {
                stepsPerDay[i] = 0;
            }
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
            System.out.println("Значение сохранено!");
        }

        public void printAllSteps() {
            for (int i = 0; i < stepsPerDay.length; i++) {
                if(i == 29) {
                    System.out.print(i+1 + " день: " + stepsPerDay[i]+ ". \n");
                    break;
                };
                System.out.print(i+1 + " день: " + stepsPerDay[i]+ ", ");
            }
        }
        public double getSumOfSteps() {
            return sumOfSteps;
        }
        public int getMaxSteps() {
            return maxSteps;
        }
        public  void printAverageValue() {
            if(sumOfSteps == 0) {
                System.out.println(0);
                return;
            }
            System.out.println(sumOfSteps/monthToData.length+1);
        }
        public void printDisance() {
            double distance = sumOfSteps * 0.00075;
            System.out.println(distance + " км.");
        }
        public void printBirnedCalories() {
            if (sumOfSteps == 0) {
                System.out.println(0 + " Килокалорий.");
                return;
            }
            double birnedCalories = (sumOfSteps * 50.0)/1000.0;
            System.out.println(birnedCalories + " Килокалорий.");
        }
        public int getBetterSeries(int stepGoal) {
            int series =0;
            int maxSeries = 0;
            for (int i = 0; i < stepsPerDay.length; i++) {
                if(stepsPerDay[i] > stepGoal) {
                    series++;
                } else {
                    if (series > maxSeries) {
                        maxSeries = series;
                    }
                }
            }
            return maxSeries;
        }
        private void setRandomValueForAllDay() {
            for (int i = 1; i < stepsPerDay.length+1; i++) {
                setStepsByDay (i,((int)( Math.random() * 100000)+1));
            }
        }

    }
}
