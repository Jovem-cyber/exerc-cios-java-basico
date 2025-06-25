package Conta;

import java.text.DecimalFormat;

   public class Conta {
        private double Saldo;
        private double limiteCheque;
        private double saldoCheque; // Rastreia o quanto está sendo usado/devido do cheque especial
        private boolean usoCheque; // Flag para controlar a cobrança da taxa (se usou no ciclo negativo)

        // double é usado para funções com valores e a boolean para valores pedentes a validação true ou false.

     
    //função da conta.

    public Conta(double valorDepositado) {

            // validador do deposito ínicial.
        if (valorDepositado < 0){
            System.out.println("O valor está negativo, repita a transação.");
            this.Saldo = 0;
        } else {
            this.Saldo = valorDepositado;
        }

            //criação do cheque especial.
        if (valorDepositado <= 500.00) { // se o valor depositado for maior que 500
            this.limiteCheque =  50.00; // terá 50 de cheque especial
        } else {
            this.limiteCheque = valorDepositado * 0.50; // 50% do valor depositado
        }
   
    //regularização do controle do cheque especial.
    this.saldoCheque = 0.0;
    this.usoCheque = false;

    System.out.println("Conta Criada com Sucesso!"); 
    System.out.println("Seu saldo inicial é de " + (this.Saldo) +   
                        " | Limite de Cheque Especial: R$ " + (this.limiteCheque));
    }

    //criação dos métodos de consultas.

    public double consultarSaldo(){
        return this.Saldo;
    }

    public double consultarCheque() {
        return this.limiteCheque;
    }

    public double consultarSaldoTotal() {
        return this.limiteCheque + this.Saldo;
    }

    public boolean verificarCheque() {
        return this.Saldo < 0;
    }

    //criação dos métodos de operação.

    public void depositarDinheiro(double depositado) {
        if (depositado <= 0) {
            System.out.println("Valor está negativo.");
        }

    //reconhecer saldo negativo.
    boolean saldoNegativo = this.Saldo < 0;
    
    //validação do deposito na conta.
    this.Saldo += depositado;
    System.out.println("Deposito no valor de R$ " + depositado +
                         " relizado. Seu novo saldo é de R$ " + (this.Saldo));

    //cobrança de taxa do cheque especial.
    if (saldoNegativo && this.Saldo >= 0 && this.usoCheque) {
        double taxa = 0.20 * this.saldoCheque;
        
    if (taxa > 0) {
        this.Saldo -= taxa; // aplicação da taxa
        System.out.println("O valor da sua taxa de uso do cheque especial é de R$ " + (taxa) + 
                                ". Seu novo saldo é de R$ " + (this.Saldo));
    
        this.saldoCheque = 0; //reset de dívida do cheque especial
        this.usoCheque = false; 
    }
    } else if (this.Saldo >= 0) {
        this.saldoCheque = 0; //validador de cobraça paga para zera o devedor.
        this.usoCheque = false;
    }
    }

    public boolean saqueDinheiro (double saque) {
        if (saque <= 0){ //se o valor de saque for menor que 0.
            System.out.println("O valor do saque deve ser positivo.");
            return false;
        }

        if (this.Saldo + this.limiteCheque < saque) { // se não tiver saldo suficiente.
            System.out.println("A sua solicitação de saque não foi realizada, saldo insuficiente. ");
            return false;
        }

        this.Saldo -= saque; //saque realizado
        System.out.println("Saque reliadado no valor de R$ " + (this.saqueDinheiro(saque)) + ". Seu novo saldo é de R$ " + (this.Saldo));

        if (this.Saldo < 0) { // se após o saque ficou negativo o saldo.
            this.usoCheque = true;
            this.saldoCheque = Math.abs(this.Saldo);
            System.out.println("Atenção: Você está usando o Cheque Especial! Valor atual utilizado: R$" + (this.saldoCheque));
        }

        return true;
    }

    public boolean pagarBoleto (double paga) {
        System.out.println("Tentando pagar o boleto de R$ " + paga + " ...");
        System.out.println("Seu boleto foi pago com sucesso.");
        return saqueDinheiro(Saldo);
    }
    
    private String formatarValor (double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(valor);
    }


} 