import fraction.*;

public class Main {

    public static void main(String args[]) {

//        method addition test

        Fraction instance1 = new FractionImpl("   1/3    ");
        Fraction instance2 = new FractionImpl("   1/9    ");

        Fraction result = instance1.add(instance2);


        System.out.println(instance1);
        System.out.println(instance2);

        System.out.println(result);

        //        method subtraction test

        Fraction subResult = instance1.subtract(instance2);

        System.out.println(subResult);

        //        method multiplication test

        Fraction mulResult = instance1.multiply(instance2);

        System.out.println(mulResult);

        //        method division test

        Fraction divResult = instance1.divide(instance2);

        System.out.println(divResult);


    }
}
