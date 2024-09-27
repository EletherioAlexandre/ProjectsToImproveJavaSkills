package Calculadora;

import java.util.Scanner;

public class MainCalculadora {

    public static void main(String[] args) {

        System.out.println("************* CALCULADORA *************");
        Scanner scanner = new Scanner(System.in);

        int option;

        do {
            System.out.print("""
                    Qual operação matemática deseja fazer?
                    [1] - Adição
                    [2] - Subtração
                    [3] - Multiplicação
                    [4] - Divisão
                    [5] - Potenciação
                    [6] - Sair
                    R:\s""");
            option = scanner.nextInt();

            while (option < 1 || option > 6) {
                System.out.print("Opção inválida. Por favor, escolha novamente: ");
                option = scanner.nextInt();
            }

            switch (option) {
                case 1:
                    performOperation('+', scanner);
                    break;
                case 2:
                    performOperation('-', scanner);
                    break;
                case 3:
                    performOperation('*', scanner);
                    break;
                case 4:
                    performOperation('/', scanner);
                    break;
                case 5:
                    performOperation('^', scanner);
                    break;
                case 6:
                    System.out.println("Fim do programa.");
                    scanner.close();
                    return;
            }
        } while (true);


    }

    /*
     * Implementa todo o comportamento da operação
     *
     * @param operation    Símbolo representando o valor do substantivo
     * @return               void
     */
    private static void performOperation(char operation, Scanner scanner) {

        System.out.print("Insira o primeiro valor: ");
        double value1 = scanner.nextDouble();

        System.out.print("Insira o segundo valor: ");
        double value2 = scanner.nextDouble();

        double result = calculate(value1, value2, operation);

        if (Double.isNaN(result)) {
            System.err.println("Erro na operação. Por favor, tente novamente.");
        } else  {
            System.out.println("O resultado da " + getOperationName(operation) + " é: " + result);
        }
    }


    /*
     * Realiza o cálculo baseado na operação selecionada
     *
     * @param firstValue     O primeiro valor para realização do cálculo
     * @param secondValue    O segundo valor para realização do cálculo
     * @param operation      O caractere representando a operação (+, -, *, /, ^)
     * @return               O Resultado do cálculo
     */
    public static double calculate(double firstValue, double secondValue, char operation) {
        return switch (operation) {
            case '+' -> firstValue + secondValue;
            case '-' -> firstValue - secondValue;
            case '*' -> firstValue * secondValue;
            case '/' -> {
                if (secondValue == (double) 0) {
                    yield Double.NaN;
                }
                yield firstValue / secondValue;
            }
            case '^' -> Math.pow(firstValue, secondValue);
            default -> 0.0;
        };
    }

    /*
     * Busca o substantivo da operação
     *
     * @param operation     Símbolo representando o valor do substantivo
     * @return              Nome da operação
     */
    public static String getOperationName(char operation) {
        return switch (operation) {
            case '+' -> "soma";
            case '-' -> "subtração";
            case '*' -> "multiplicação";
            case '/' -> "divisão";
            case '^' -> "potenciação";
            default -> "sair do programa";
        };
    }
}
