public class Complex {
    private double real;
    private double imag;

    public Complex() {
        real = 0;
        imag = 0;
    }

    public Complex(double real, double imag) {
        this.real = real;
        this.imag = imag;
    }

    public double getReal() {
        return real;
    }

    public double getImag() {
        return imag;
    }

    public Complex add(Complex masik) {
        return new Complex(real + masik.real, imag + masik.imag);
    }

    public Complex mul(Complex masik) {
        return new Complex(real * masik.real - imag * masik.imag,
                           real * masik.imag + imag * masik.real);
    }

    public Complex conjugate() {
        return new Complex(real, -imag);
    }

    public String toString() {
        if (imag == 0)
            return real + "";
        return real + ((imag > 0) ? "+" : "") + imag + "i";
    }

}
