package fraction;

public class FractionImpl implements Fraction {
    /**
     * Parameters are the <em>numerator</em> and the <em>denominator</em>.
     * Normalize the fraction as you create it.
     * For instance, if the parameters are <pre>(8, -12)</pre>, create a <pre>Fraction</pre> with numerator
     * <pre>-2</pre> and denominator <pre>3</pre>.
     *
     * The constructor should throw an <pre>ArithmeticException</pre> if the denominator is zero.
     *
     * @param numerator
     * @param denominator
     */

    private int numerator;
    private int denominator;

    //implement recursive function to find the Greatest Common Divisor following Euclid's algorithm

    private int gcd(int p, int q) {
        if (q == 0) {
            return p;
        }
        return gcd(q, p % q);
    }

    //implement normalise function using the gcd function

    private int[] normalise(int n, int d) {

        //throw exception is denominator is zero

        if (d == 0) {
            throw new ArithmeticException("Divide by zero");
        }

        int gcd_val = gcd(n, d);
        int values[] = new int[2];
        n = n/gcd_val;
        d = d/gcd_val;

        //transform so a negative fraction always has a negative numerator, not a negative denominator

        if (d < 0) {
            n *= -1;
            d *= -1;
        }

        values[0] = n;
        values[1] = d;
        return values;
    }

    public FractionImpl(int numerator, int denominator) {

        //use the normalise function to set the object private member variables

        this.numerator = normalise(numerator, denominator)[0];
        this.denominator =  normalise(numerator, denominator)[1];
    }

    /**
     * The parameter is the numerator and <pre>1</pre> is the implicit denominator.
     *
     * @param wholeNumber representing the numerator
     */
    public FractionImpl(int wholeNumber) {

        //set implicit denominator to 1, handle printing with the toString method

        this.numerator = wholeNumber;
        this.denominator = 1;
    }

    /**
     * The parameter is a <pre>String</pre> containing either a whole number, such as `5` or `-3`, or a fraction,
     * such as "8/-12".
     * Allow blanks around (but not within) integers.
     * The constructor should throw an <pre>ArithmeticException</pre>
     * if given a string representing a fraction whose denominator is zero.
     * <p>
     * You may find it helpful to look at the available String API methods in the Java API.
     *
     * @param fraction the string representation of the fraction
     */
    public FractionImpl(String fraction) {

        //use the trim String method to remove white space before and after the fraction characters

        String trimmed = fraction.trim();

        //whole number procedure - if no "/" is present

        if (!trimmed.contains("/")) {
            this.numerator = Integer.parseInt(trimmed);
            this.denominator = 1;
        }

        //fraction procedure - split on "/" then convert string numbers to int and pass to the normalise function

        else {
            String[] bits = trimmed.split("/");

            this.numerator = normalise(Integer.parseInt(bits[0]), Integer.parseInt(bits[1]))[0];
            this.denominator = normalise(Integer.parseInt(bits[0]), Integer.parseInt(bits[1]))[1];
        }


    }

    /**
     * @inheritDoc
     * This Fraction method accepts a Fraction as a parameter and
     * returns the sum of the Fraction it is called on and the
     * Fraction that is passed to the method.
     */
    @Override
    public Fraction add(Fraction f) {

        //cast parameter f as class Fraction

        FractionImpl toAdd = (FractionImpl) f;

        //calculate numerator and denominator for the fraction sum

        int n = (this.numerator * toAdd.denominator) + (this.denominator * toAdd.numerator);
        int d = (this.denominator * toAdd.denominator);

        //construct a new instance of Fraction and return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     * This Fraction method accepts a Fraction as a parameter and
     * returns the difference of the Fraction it is called on and the
     * Fraction that is passed to the method.
     */
    @Override
    public Fraction subtract(Fraction f) {

        //cast parameter f as class Fraction

        FractionImpl toSub = (FractionImpl) f;

        //calculate numerator and denominator for the fraction difference

        int n = (this.numerator * toSub.denominator) - (this.denominator * toSub.numerator);
        int d = (this.denominator * toSub.denominator);

        //construct a new instance of Fraction and return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;

    }

    /**
     * @inheritDoc
     * This Fraction method accepts a Fraction as a parameter and
     * returns the product of the Fraction it is called on and the
     * Fraction that is passed to the method.
     */
    @Override
    public Fraction multiply(Fraction f) {

        //cast parameter f as class Fraction

        FractionImpl toMul = (FractionImpl) f;

        //calculate numerator and denominator for the fraction product

        int n = (this.numerator * toMul.numerator);
        int d = (this.denominator * toMul.denominator);

        //construct a new instance of Fraction and return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     * This Fraction method accepts a Fraction as a parameter and
     * returns the division of the Fraction it is called on and the
     * Fraction that is passed to the method.
     */
    @Override
    public Fraction divide(Fraction f) {

        //cast parameter f as class Fraction

        FractionImpl toDiv = (FractionImpl) f;

        //calculate numerator and denominator for the fraction division

        int n = (this.numerator * toDiv.denominator);
        int d = (this.denominator * toDiv.numerator);

        //construct a new instance of Fraction and return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     * This method takes no parameters. The method returns a new Fraction object
     * with the absolute value of the Fraction it was called upon.
     */
    @Override
    public Fraction abs() {

        //initialise numerator and denominator for new Fraction. Set d to the denominator
        //of the Fraction the method is called on (this will be the same)

        int n;
        int d = this.denominator;

        //check if the numerator of the called Fraction is negative, if so set n to the numerator * -1
        //else set n to the unchanged numerator

        if (this.numerator < 0) {n = this.numerator * -1;}
        else {n = this.numerator;}

        //create new Fraction object with the variables n and d, return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     * This method takes no parameters. The method returns a new Fraction object with the same value
     * as the Fraction the method was called on but with the opposite sign.
     */
    @Override
    public Fraction negate() {

        //initialise numerator and denominator for new Fraction. Multiply the numerator by -1 to negate the sign.

        int n = this.numerator * -1;
        int d = this.denominator;

        //create new Fraction object with the variables n and d, return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    /**
     * @inheritDoc
     * This method takes a Fraction as a parameter and returns a boolean value: true if the Fractions are equal
     * and false otherwise.
     */
    @Override
    public boolean equals(Object obj) {

        //check if object passed in as a parameter is an instance of Fraction

        if (!(obj instanceof Fraction)) {return false;}

        //cast obj as Fraction

        FractionImpl toEql = (FractionImpl) obj;

        //check if the numerator and denominator of the Fractions are equal, if so return boolean value true
        //, if not return boolean value false

        if (this.numerator == toEql.numerator && this.denominator == toEql.denominator) {return true;}
        else {return false;}
    }

    /**
     * @inheritDoc
     * Takes no parameters. Throws an exception as clone is not supported.
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     * Takes no parameters. Returns a new Fraction in which the numerator and denominator of
     * the Fraction the method was called on are switched.
     */
    @Override
    public Fraction inverse() {

        //initialise numerator and denominator for new Fraction as the denominator and numerator (respectively)
        //of the Fraction the method is called on.

        int n = this.denominator;
        int d = this.numerator;

        //create new Fraction object with the variables n and d, return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     * This takes a Fraction as a parameter. The method returns an int.
     */
    @Override
    public int compareTo(Fraction o) {

        //cast o as Fraction

        FractionImpl toCom = (FractionImpl) o;

        //calculate the value of both Fractions as doubles

        double thisVal = ((double) this.numerator) / this.denominator;
        double otherVal = ((double) toCom.numerator) / toCom.denominator;

        //return the output of the Double.compare method

        return Double.compare(thisVal, otherVal);
    }

    /**
     * @inheritDoc
     */
    @Override
    public String toString() {
        if (this.denominator == 1) {
            return Integer.toString(this.numerator);
        }
        return this.numerator + "/" + this.denominator;
    }
}