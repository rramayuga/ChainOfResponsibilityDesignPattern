public class Peso10Dispenser implements DispenseChain {

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency cur) {

        if (cur.getAmount() >= 10) {
            int num = cur.getAmount() / 10;
            int remainder = cur.getAmount() % 10;

            System.out.println("Dispensing " + num + " 10 coins");

            if (remainder != 0) {
                System.out.println("Cannot dispense remaining amount: " + remainder);
            }
        } else {
            System.out.println("Cannot dispense amount: " + cur.getAmount());
        }
    }
}