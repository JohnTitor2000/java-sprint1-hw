import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int SET_STEPS = 1;
        final int STATISTICS = 2;
        final int SET_GOAL = 3;
        final int TERMINATION = 4;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        while (userInput != TERMINATION) {
            if (userInput == SET_STEPS) {
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
            } else if (userInput == STATISTICS) {
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
            } else if (userInput == SET_GOAL) {
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
            }
            printMenu();
            userInput = scanner.nextInt();
            if (userInput > TERMINATION || userInput < SET_STEPS) {
                System.out.println("Данной команды не существует, попробуйте снова.");
            }
        }
        System.out.println("Завершение програмы.");

    }

    private static void printMenu() {
            System.out.println("Добрый день! Выберите команду: \n" +
                               "1. Ввести количество шагов за определённый день; \n" +
                               "2. Напечатать статистику за определённый месяц; \n" +
                               "3. Изменить цель по количеству шагов в день; \n" +
                               "4. Выйти из приложения.");


    }

}
