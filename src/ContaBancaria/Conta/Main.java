package Conta;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner (System.in);

        Conta minhaConta = null;
        boolean executando = true;

        try {
            System.out.println("Criação da Conta Bancária.");
            System.out.println("Digite o Valor do Depósito Inicial para criar a conta.");
            double depositoInicial = scanner.nextDouble();
            minhaConta = new Conta(depositoInicial);
        
            scanner.nextLine();

            System.out.println("\nBem-vindo(a) ao nosso Banco, selecione uma opção:");
        

while (executando) {

        System.out.println("Bem-vindo ao nosso Banco, selecione uma opção:");
        System.out.println("\\n");
        System.out.println("1 - Consultar Saldo da Conta.");
        System.out.println("2 - Consultar Cheque Especial");
        System.out.println("3 - Depositar dinheiro na conta");
        System.out.println("4 - Sacar Dinheiro da conta");
        System.out.println("5 - Pagar um Boleto");
        System.out.println("6 - Verificar se a conta está usando cheque especial");
        System.out.println("0 - Sair");
        

        int option = -1;



 try {
                    option = scanner.nextInt(); // LÊ A OPÇÃO DO USUÁRIO AQUI!
                    scanner.nextLine(); // Consome a quebra de linha após nextInt()
                } catch (InputMismatchException e) {
                    System.out.println("Entrada inválida. Por favor, digite um NÚMERO de 0 a 6.");
                    scanner.nextLine(); // Limpa o buffer do scanner para evitar loop infinito
                    continue; // Volta para o início do loop 'while' para exibir o menu novamente
                }






        switch (option) {
            case 1: 
                System.out.println("Seu saldo é de R$ " + String.format("%.2f", minhaConta.consultarSaldo()));
                break;

            case 2:
               System.out.println("Limite do Cheque Especial: R$" + String.format("%.2f", minhaConta.consultarCheque()));
                break;

            case 3: 
               System.out.print("Digite o valor para depositar: R$");
                double depositar = scanner.nextDouble();
                minhaConta.depositarDinheiro(depositar);
                scanner.nextLine();
                break;

            case 4:
                System.out.print("Digite o valor para sacar: R$");
                double valorSaque = scanner.nextDouble();
                minhaConta.saqueDinheiro(valorSaque);
                scanner.nextLine();
                System.out.println("Saque Realizado. Seu novo saldo é de R$ " + String.format("%.2f", minhaConta.consultarSaldo()));
                break;

            case 5:
                System.out.print("Digite o valor do boleto a pagar: R$");
                double boleto = scanner.nextDouble();
                minhaConta.pagarBoleto(boleto);
                scanner.nextLine();
                break;

            case 6:
                 System.out.println("Está usando Cheque Especial? " + (minhaConta.verificarCheque()) != null ? "Sim" : "Não");

            case 0: 
                System.out.println("Saindo do programa. Obrigado por usar nossos serviços!");
                 executando = false; 
                break;
            }}




 } catch (InputMismatchException e) {
            // Este catch é para o erro na leitura do DEPÓSITO INICIAL, caso não seja um número
            System.out.println("Erro: Entrada inicial para o depósito inválida. Por favor, digite um valor numérico válido e reinicie o programa.");
        } catch (Exception e) {
            // Captura outras exceções inesperadas que possam ocorrer
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
            e.printStackTrace(); // Imprime o rastreamento completo do erro para depuração
        }finally {
            scanner.close();
            System.out.println("Scanner fechado. Fim da execução do programa.");
        }
        
}}
