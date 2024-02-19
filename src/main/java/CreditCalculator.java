public class CreditCalculator {
    public static void main(String[] args) {
        calculateCreditDetails("Мария Илиева ", 17, 99999, 12, 99999);
        calculateCreditDetails("Мария Илиева ", 18, 999, 13, 100);
        calculateCreditDetails("Мария Илиева ", 18, 999, 12, 100);
        calculateCreditDetails("Мария Илиева ", 18, 50001, 12, 5001);
        calculateCreditDetails("Мария Илиева ", 18, 50001, 12, 2001);
        calculateCreditDetails("Мария Илиева ", 18, 50000, 12, 2000);
    }

    private static void calculateCreditDetails(String fullName, int age, int amount, int months, double monthlyIncome) {
        if (age < 18) {
            System.out.println("Трябва да имате навършени 18 години");
        } else {
            if (amount < 1000) {
                if (months > 12) {
                    System.out.println("Не може да изтеглите сума под 1000 лева за период до-дълъг от 12 месеца");
                } else {
                    double monthlyPayment = (double) amount / months;
                    System.out.println("Месечната вноска е равна на " + monthlyPayment);
                }
            } else if (amount > 50000) {
                if (monthlyIncome > 5000 && amount < 100000) {
                    System.out.println("С такъв доход можем да ви предложим 100 000 лева");
                } else if (monthlyIncome > 2000) {
                    double interestRate = getInterestRate(amount);
                    double totalAmount = amount + (amount * interestRate * months / 12);
                    double monthlyPayment = totalAmount / months;
                    System.out.printf("Отлично! В тази ситуация месечната вноска за сума от %d лева за %d месеца с лихва " +
                            "%.2f%% ще бъде %.2f лева.%n", amount, months, interestRate * 100, monthlyPayment);
                } else {
                    System.out.println("Съжаляваме, но максимума за такъв доход е 20000 лева");
                }

            } else {
                double interestRate = getInterestRate(amount);
                double totalAmount = amount + (amount * interestRate * months / 12);
                double monthlyPayment = totalAmount / months;
                System.out.printf("Месечна вноска за сума от %d лева за %d месеца с лихва " +
                        "%.2f%% е %.2f лева.%n", amount, months, interestRate * 100, monthlyPayment);
            }
        }
    }

    private static double getInterestRate(int amount) {
        if (amount <= 5000) {
            return 0.05; // 5% лихва за суми до 5000 лева
        } else if (amount <= 10000) {
            return 0.04; // 4% лихва за суми до 10000 лева
        } else {
            return 0.03;
        }
    }

}