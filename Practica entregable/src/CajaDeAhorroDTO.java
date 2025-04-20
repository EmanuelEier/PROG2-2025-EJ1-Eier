public class CajaDeAhorroDTO {
    private final int numeroCuenta;
    private final double saldo;

    private CajaDeAhorroDTO(Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public static class Builder {
        private int numeroCuenta;
        private double saldo;

        public Builder setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
            return this;
        }

        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public CajaDeAhorroDTO build() {
            return new CajaDeAhorroDTO(this);
        }
    }
}