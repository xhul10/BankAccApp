package bank;

public class CheckingAccount extends Account{

    private static  double TRAMSACTIONFEE = 2.5;

    public CheckingAccount(){
        super();
    }

    public CheckingAccount(int accountNumber , double fee){
        super(accountNumber);
        TRAMSACTIONFEE = fee;
    }

    @Override
    public void deposit(double amount) {
        if (amount > 0){
            balance +=amount;
            System.out.printf("Amount %.2f deposited%n",amount);
            balance -=TRAMSACTIONFEE;
            System.out.printf("FEE %.2f applied%n",TRAMSACTIONFEE);
            System.out.printf("Curren balance is: %.2f%n",balance);
        }else {
            System.out.println("You have to have money then to deposit it!");
        }
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0){
            if ((amount+TRAMSACTIONFEE) <= balance){
                System.out.printf("Amount of %.2f withdrawn form Account%n", amount );
                balance -= amount;
                balance -= TRAMSACTIONFEE;
                System.out.printf("Fee of %.2f applied%n", TRAMSACTIONFEE);
                System.out.printf("Curren balance is: %.2f%n", balance );

            }
        }
    }
}

