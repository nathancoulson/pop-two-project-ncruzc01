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
     */
    @Override
    public Fraction add(Fraction f) {

        //cast parameter f as class FractionImpl

        FractionImpl frac = (FractionImpl) f;

        //calculate numerator and denominator for the fraction sum

        int n = (this.numerator * frac.denominator) + (this.denominator * frac.numerator);
        int d = (this.denominator * frac.denominator);

        //construct a new instance of FractionImpl and return the resulting object

        FractionImpl result = new FractionImpl(n, d);

        return result;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction subtract(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction multiply(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction divide(Fraction f) {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction abs() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction negate() {
        return null;
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
     */
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    /**
     * @inheritDoc
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * @inheritDoc
     */
    @Override
    public Fraction inverse() {
        return null;
    }

    /**
     * @inheritDoc
     */
    @Override
    public int compareTo(Fraction o) {
        return 0;
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