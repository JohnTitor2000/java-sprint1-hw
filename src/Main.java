import java.util.Scanner;

public class Main {
    private static final int SET_STEPS_ACTION = 1;
    private static final int SHOW_STATISTICS_ACTION = 2;
    private static final int SET_GOAL_ACTION = 3;
    private static final int TERMINATION_PROGRAM_ACTION = 4;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != TERMINATION_PROGRAM_ACTION) {
            if (userInput == SET_STEPS_ACTION) {
                int month;
                while (true) {
                    System.out.println("За какой месяц хотите ввести колличество шагов?");
                    month = scanner.nextInt();
                    if (month > 12 || month < 1) {
                        System.out.println("Выберите месяц от 1 до 12.");
                        continue;
                    }
                    break;
                }
                int day;
                while (true) {
                    System.out.println("За какой день хотите ввести колличество шагов?");
                    day = scanner.nextInt();
                    if (day > 30 || day < 1) {
                        System.out.println("Выберите день от 1 до 30.");
                        continue;
                    }
                    break;
                }
                int steps;
                while (true) {
                    System.out.println("Сколько шагов вы прошли?");
                    steps = scanner.nextInt();
                    if (steps < 0) {
                        System.out.println("Выберите неотрицательное значение.");
                        continue;
                    }
                    break;
                }
                stepTracker.setStepByMonth(month, day, steps);
                System.out.println("Значение сохранено!");
            } else if (userInput == SHOW_STATISTICS_ACTION) {
                int month;
                while (true) {
                    System.out.println("Введите месяц по которому хотите получить статистику:");
                    month = scanner.nextInt();
                    if (month > 12 || month < 1) {
                        System.out.println("Выберите месяц от 1 до 12.");
                        continue;
                    }
                    System.out.println(stepTracker.getStatisticByMonth(month));
                    break;
                }
            } else if (userInput == SET_GOAL_ACTION) {
                while (true) {
                    System.out.println("Введите желаемую цель по количеству шагов в день:");
                    int steps = scanner.nextInt();
                    if (steps >= 0) {
                        stepTracker.setStepsGoal(steps);
                        System.out.println("Значение изменено!");
                        break;
                    } else {
                        System.out.println("Введенное значение не может быть отрицательным!\nВведите положительное значение.\n");
                    }
                }
            } else {
                System.out.println("Данной команды не существует, попробуйте снова.");
            }
            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("Завершение программы.");
    }

    private static void printMenu() {
            System.out.println("Добрый день! Выберите команду: \n" +
                               "1. Ввести количество шагов за определённый день; \n" +
                               "2. Напечатать статистику за определённый месяц; \n" +
                               "3. Изменить цель по количеству шагов в день; \n" +
                               "4. Выйти из приложения.");
    }
}
