# ChainOfResponsibilityDesignPattern
BPI Atm Dispenser
Problem
We will design an ATM system for BPI (Bank of the Philippine Islands) that dispenses cash in denominations of 1000 pesos, 500 pesos, and 100 pesos bills. The system should follow the Chain of Responsibility design pattern to handle the dispensing of cash requests efficiently.


public class BPI_Atm {
    public static void main(String[] args) {
        ATMDispenseChain atmDispenser = new ATMDispenseChain();
        int amount = 2970; // Amount to be dispensed, 270, 250
        if (amount % 10 != 0) {
            System.out.println("Amount should be in multiples of 100s.");
            
        } else
        atmDispenser.dispense(new Currency(amount));
    }
}


public class Currency {
    private int amount;


    public Currency(int amt) {
        this.amount = amt;
    }


    public int getAmount() {
        return this.amount;
    }
}


public interface DispenseChain {
    void setNextChain(DispenseChain nextChain);
    void dispense(Currency currency);
}


public class ATMDispenseChain implements DispenseChain {
    private DispenseChain nextChain;


    public ATMDispenseChain() {
        // Initialize the chain
        this.nextChain = new Peso1000Dispenser();
        DispenseChain c2 = new Peso500Dispenser();
	//200-peso
        DispenseChain c3 = new Peso100Dispenser();
	//50-peso dispenser
	//20-peso dispenser


        // Set the chain of responsibility
        nextChain.setNextChain(c2);
        c2.setNextChain(c3);
    }


    public void dispense(Currency currency) {
        nextChain.dispense(currency);
    }


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }
}


public class Peso100Dispenser implements DispenseChain {
    private DispenseChain chain;


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }


    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 100) {
            int num = cur.getAmount() / 100;
            int remainder = cur.getAmount() % 100;
            System.out.println("Dispensing " + num + " 100 bills");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}


public class Peso500Dispenser implements DispenseChain {
    private DispenseChain chain;


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }


    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 500) {
            int num = cur.getAmount() / 500; // 1
            int remainder = cur.getAmount() % 500; //300
            System.out.println("Dispensing " + num + " 500 bills");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}


public class Peso1000Dispenser implements DispenseChain {
    private DispenseChain chain;


    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }


    @Override
    public void dispense(Currency cur) {
        if (cur.getAmount() >= 1000) {
            int num = cur.getAmount() / 1000;
            int remainder = cur.getAmount() % 1000; //800
            System.out.println("Dispensing " + num + " 1000 bills");
            if (remainder != 0) {
                this.chain.dispense(new Currency(remainder));
            }
        } else {
            this.chain.dispense(cur);
        }
    }
}


In this implementation, ATMDispenseChain class handles the dispensing logic for BPI's ATM system with denominations of 1000, 500, and 100 peso bills. The BPI_Atm class allows users to adjust (hard-coded) an amount and initiates the dispensing process using the Chain of Responsibility pattern.
