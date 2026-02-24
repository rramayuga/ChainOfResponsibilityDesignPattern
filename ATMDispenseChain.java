public class ATMDispenseChain implements DispenseChain {

    private DispenseChain nextChain;

    public ATMDispenseChain() {

        // Create all dispensers
        DispenseChain c1 = new Peso1000Dispenser();
        DispenseChain c2 = new Peso500Dispenser();
        DispenseChain c3 = new Peso200Dispenser();
        DispenseChain c4 = new Peso100Dispenser();
        DispenseChain c5 = new Peso50Dispenser();
        DispenseChain c6 = new Peso20Dispenser();
        DispenseChain c7 = new Peso10Dispenser();

        // Set chain (largest to smallest)
        c1.setNextChain(c2);
        c2.setNextChain(c3);
        c3.setNextChain(c4);
        c4.setNextChain(c5);
        c5.setNextChain(c6);
        c6.setNextChain(c7);

        this.nextChain = c1;
    }

    @Override
    public void dispense(Currency currency) {
        nextChain.dispense(currency);
    }

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }
}