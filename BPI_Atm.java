public class BPI_Atm {

    public static void main(String[] args) {

        ATMDispenseChain atmDispenser = new ATMDispenseChain();

        int amount = 2970;
        System.out.println("Amount: " + amount);
        if (amount % 10 != 0) {
            System.out.println("Amount should be in multiples of 10.");
        } else {
            atmDispenser.dispense(new Currency(amount));
        }
    }
}