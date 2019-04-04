import fraction.*;

public class Main {

    public static void main(String args[]) {

//        method addition test

        Fraction instance1 = new FractionImpl("   1/8    ");
        Fraction instance2 = new FractionImpl("   1/8    ");

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

        //        method abs test

        Fraction instance3 = new FractionImpl("   2    ");

        Fraction absResult = instance3.abs();

        System.out.println(absResult);

        //        method negate test

        Fraction negateResult = instance3.negate();

        System.out.println(negateResult);

        //        method equals test

        boolean bolResult = instance1.equals("String object");

        System.out.println(bolResult);

        //        method inverse test

        Fraction invResult = instance3.inverse();

        System.out.println(invResult);

        //        method compare test

        int intResult = instance1.compareTo(instance2);

        System.out.println(intResult);




    }
}
