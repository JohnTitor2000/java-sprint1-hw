import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();
        printMenu();
        int userInput = scanner.nextInt();
        if (userInput > 4 || userInput < 1) {
            System.out.println("Данной команды не существует, попробуйте снова.");
        }
        while (userInput != 4) {
            if (userInput == 1) {
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
                stepTracker.setStepByMonth(month,day,steps);
            } else if (userInput == 2) {
                int month;
                while (true) {
                    System.out.println("Введите месяц по которому хотите получить статистику:");
                    month = scanner.nextInt();
                    if (month > 12 || month < 1) {
                        System.out.println("Выберите месяц от 1 до 12.");
                        continue;
                    }
                    stepTracker.getStatisticByMonth(month);
                    break;
                }
            } else if (userInput == 3) {
                while (true) {
                    System.out.println("Введите желаемую цель по количеству шагов в день:");
                    int steps = scanner.nextInt();
                    if (steps >= 0) {
                        stepTracker.changeStepGoal(steps);
                        break;
                    } else {
                        System.out.println("Введенное значение не может быть отрицательным!\nВведите положительное значение.\n");
                    }
                }
            }
            printMenu();
            userInput = scanner.nextInt();
            if (userInput > 4 || userInput < 1) {
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
