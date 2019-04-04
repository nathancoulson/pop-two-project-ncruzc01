import fraction.*;

public class Main {

    public static void main(String args[]) {

//        method addition test

        Fraction instance1 = new FractionImpl("   5/4    ");
        Fraction instance2 = new FractionImpl("   2/-4    ");

        Fraction result = instance1.add(instance2);


        System.out.println(instance1);
        System.out.println(instance2);

        System.out.println(result);


    }
}
