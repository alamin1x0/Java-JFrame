package Inheritance;

public class InheritanceMain extends App {

    private int cpga ;

    public InheritanceMain(String name, int cpga) {
        super(name);
        this.cpga = cpga;
    }

    public int getCpga(){
        return cpga;
    }

    public static void main(String[] args) {

        InheritanceMain inheritanceMain = new InheritanceMain("Inheritance", 2);
        inheritanceMain.getName();
        inheritanceMain.getName();
        inheritanceMain.setName("");
    }

}
