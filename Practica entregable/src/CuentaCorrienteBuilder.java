public class CuentaCorrienteBuilder {
    private final int numeroCuenta;
    private final double saldo;
    private final double giroResultado;

    private CuentaCorrienteBuilder(Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
        this.giroResultado = builder.giroResultado;
    }

    public static class Builder {
        public int numeroCuenta;
        public double saldo;
        public double giroResultado;

        public Builder setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
            return this;
        }

        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder conGiroResultado(double giroResultado) {
            this.giroResultado = giroResultado;
            return this;
        }

        public CuentaCorriente build() {
            return new CuentaCorriente(this);
        }
    }
}