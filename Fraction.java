public class Fraction {
    private int num;
    private int den;

    // Constructor to initialize a fraction with a given numerator and denominator
    public Fraction(int top, int bottom) {
        // Checking for invalid fractions
        if (bottom == 0) {
            throw new IllegalArgumentException("Fraction is undefined/indeterminate");
        }
        // Ensuring the denominator is always positive
        if (bottom < 0) {
            top *= -1;
            bottom *= -1;
        }
        // reduce the fraction to its simplest form
        int commonDen = gcd(top, bottom);
        this.num = top / commonDen;
        this.den = bottom / commonDen;
    }
    // returns the fraction in the common "fraction" format (num/den)
    @Override
    public String toString() {
        return num + "/" + den;
    }

    // Adds fraction to another fraction
    public Fraction add(Fraction fraction2) {
        int newNum = this.num * fraction2.den + fraction2.num * this.den;
        int newDen = this.den * fraction2.den;
        return new Fraction(newNum, newDen);
    }

    // subtracting given fraction to current fraction
    public Fraction subtract(Fraction fraction2) {
        int newNum = this.num * fraction2.den - fraction2.num * this.den;
        int newDen = this.den * fraction2.den;
        return new Fraction(newNum, newDen);
    }

    // multiplies current fraction with a given fraction
    public Fraction multiply(Fraction fraction2) {
        int newNum = this.num * fraction2.num;
        int newDen = this.den * fraction2.den;
        return new Fraction(newNum, newDen);
    }

    // divides the current fraction by another fraction
    public Fraction divide(Fraction fraction2) {
        if (fraction2.num == 0) {
            throw new ArithmeticException("Cannot divide by zero fraction");
        }
        int newNum = this.num * fraction2.den;
        int newDen = this.den * fraction2.num;
        return new Fraction(newNum, newDen);
    }

    // checks if two fractions are equal
    public boolean equals(Fraction fraction2) {
        return this.num * fraction2.den == fraction2.num * this.den;
    }

    // checks if the current fraction is greater than given fraction
    public boolean greaterThan(Fraction fraction2) {
        return this.num * fraction2.den > fraction2.num * this.den;
    }

    // checks if the current fraction is greater than or equal to given fraction
    public boolean greaterThanOrEqual(Fraction fraction2) {
        return this.num * fraction2.den >= fraction2.num * this.den;
    }

    // checks if the current fraction is less than given fraction
    public boolean lessThan(Fraction fraction2) {
        return this.num * fraction2.den < fraction2.num * this.den;
    }

    // checks if the current fraction is less than or equal to given fraction
    public boolean lessThanOrEqual(Fraction fraction2) {
        return this.num * fraction2.den <= fraction2.num * this.den;
    }

    // checks if the current fraction is not equal to given fraction
    public boolean notEqual(Fraction fraction2) {
        return this.num * fraction2.den != fraction2.num * this.den;
    }

    // Converts to a double
    public double toDouble() {
        return (double) this.num / this.den;
    }

    // Getter for numerator
    public int getNum() {
        return this.num;
    }

    // Getter for denominator
    public int getDen() {
        return this.den;
    }

    // Helper method to calcuate the gcd using recursion
    private static int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Fraction f1 = new Fraction(2, 5);
        Fraction f2 = new Fraction(3, 4);

        Fraction sum = f1.add(f2);
        Fraction product = f1.multiply(f2);

        System.out.println("Fraction 1: " + f1);
        System.out.println("Fraction 2: " + f2);
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
    }
}


