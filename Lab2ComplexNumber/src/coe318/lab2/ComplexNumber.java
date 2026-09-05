package coe318.lab2;

/**
 * ComplexNumber models a complex number expressed in rectangular form (real and
 * imaginary parts). It is an <em>immutable</em> object.
 *
 * @author Iqraa Wahid
 */
public class ComplexNumber {
    //Instance variable declarations
    double re, im;
    
    /**
     * Construct a ComplexNumber given its real and imaginary parts.
     *
     * @param re The real component
     * @param im The imaginary component
     */
    public ComplexNumber(double re, double im) {
        //Initialize the instance variables
        this.re = re;
        this.im = im;
    }

    /**
     * Returns the real component.
     *
     * @return the real
     */
    public double getReal() {
        return re; //return real value
    }

    /**
     * Returns the imaginary component.
     *
     * @return the imaginary
     */
    public double getImaginary() {
        return im; //return imaginary value
    }

    /**
     * Returns a new ComplexNumber number that is the negative of <em>this</em>.
     * Note: the original ComplexNumber is <b>NOT</b>
     * modified.
     *
     * @return -this
     */
    public ComplexNumber negate() {
        return new ComplexNumber (-this.re, -this.im);//creating object of class Complex Number, calling constructor as object is created with the parameters in the bracket, which are negated values of 'a'
    }

    /**
     * Returns a new ComplexNumber that is the sum of <em>this</em>	and
     * <em>z</em>. Note: the	original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this + z
     */
    public ComplexNumber add(ComplexNumber z) {
        return new ComplexNumber (this.re+z.re, this.im+z.im);//returns object created of class ComplexNumber
        //since I called this method using object a, to refer to object 'a' variables we can use the "this" keyword which will call variables of the object being looked at, and to refer to the parameters variables, since the paramter itself is an object, we can use the 'dot' syntax to refer to the parameters variables
    }

    /**
     * Returns a new ComplexNumber that is the difference of <em>this</em>	and
     * <em>z</em>. Note: the	original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this + z
     */
    public ComplexNumber subtract(ComplexNumber z) {
        return this.add(z.negate());
    }

    /**
     * Returns a new ComplexNumber that is the product of <em>this</em> and
     * <em>z</em>. Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this * z
     */
    public ComplexNumber multiply(ComplexNumber z) {
        return new ComplexNumber ((this.re*this.im) - (z.re*z.im), (this.re*z.im) + (this.im*z.re));
    }

    /**
     * Returns a new ComplexNumber that is the reciprocal of <em>this</em>.
     * Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @return 1.0 / this
     */
    public ComplexNumber reciprocal() {
        double denom = this.re*this.re+this.im*this.im;
        return new ComplexNumber (this.re/denom, -this.im/denom);
    }

    /**
     * Returns a new ComplexNumber that is
     * <em>this</em> divided by <em>z</em>. Note: the original ComplexNumber is
     * <b>NOT</b> modified.
     *
     * @param z
     * @return this / z
     */
    public ComplexNumber divide(ComplexNumber z) {
        return new ComplexNumber (((this.re*z.re)+(this.im*z.im))/((z.re*z.re)+(z.im*z.im)),((this.im*z.re)-(this.re*z.im))/((z.re*z.re)+(z.im*z.im)));
        //return this.multiply(z.reciprocal()); --> isnt't giving correct output
    }

    /**
     * Returns a String representation of
     * <em>this</em> in the format:
     * <pre>
     *	real +-(optional) i imaginary
     * </pre> If the imaginary part is zero, only the real part is converted to
     * a String. A "+" or "-" is placed between the real and imaginary parts
     * depending on the the sign of the imagrinary part.
     * <p>
     * Examples:
     * <pre>
     *	..println(new ComplexNumber(0,0); -> "0.0"
     *	..println(new ComplexNumber(1,1); -> "1.0 + i1.0"
     *	..println(new ComplexNumber(1,-1); -> "1.0 - i1.0"
     * </pre>
     *
     * @return the String representation.
     */
    @Override
    public String toString() {
        //DO NOT MODIFY THIS CODE!
        String str = "" + this.getReal();
        if (this.getImaginary() == 0.0) {
            return str;
        }
        if (this.getImaginary() > 0) {
            return str + " + i" + this.getImaginary();
        } else {
            return str + " - i" + -this.getImaginary();
        }
    }
}
