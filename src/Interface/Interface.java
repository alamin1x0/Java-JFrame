package Interface;

public interface Interface {

     void display();
}

interface Test extends Interface {
     void display2();
}

interface Test3 extends Interface, Test {

}

class Test4 implements Test3 {


    public void display2() {
        System.out.println("display2");
    }

    public void display() {
        System.out.println("display");
    }

}

class demo {
    public static void main(String[] args) {
        Test4 test4 = new Test4();
        test4.display();
        test4.display2();
    }
}


