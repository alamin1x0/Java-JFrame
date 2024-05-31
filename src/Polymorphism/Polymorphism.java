package Polymorphism;

public class Polymorphism {

    public void makeMoney() {
        System.out.println("Make Money");
    }
}

class bKash extends Polymorphism {
    @Override
    public void makeMoney() {
        System.out.println("Make Money For bKash");
    }
}

class nagad extends Polymorphism {
    @Override
    public void makeMoney() {
        System.out.println("Make Money For nagad");
    }
}

class Output {
    public static void main(String[] args) {
        Polymorphism bKash = new bKash();
        bKash.makeMoney();

        Polymorphism nagad = new nagad();
        nagad.makeMoney();
    }
}