import fraction.*;

public class Main {

    public static void main(String args[]) {



        Fraction instance1 = new FractionImpl("   1/4    ");
        Fraction instance2 = new FractionImpl("   2/4    ");

        Fraction result = instance1.add(instance2);


        System.out.println(instance1);
        System.out.println(instance2);

        System.out.println(result);


    }
}
