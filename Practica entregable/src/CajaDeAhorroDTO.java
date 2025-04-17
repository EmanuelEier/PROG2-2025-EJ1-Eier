public class CajaDeAhorroDTO {
    private final int numeroCuenta;
    private final double saldo;

    private CajaDeAhorroDTO(Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
    }

    public static class Builder {
        public int numeroCuenta;
        public double saldo;

        public Builder setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
            return this;
        }

        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public CajaDeAhorro build() {
            return new CajaDeAhorro(this);
        }
    }
}