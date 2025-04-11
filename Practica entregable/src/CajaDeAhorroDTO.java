public class CajaDeAhorroDTO {
    private final int numeroCuenta;
    private final double saldo;
    private final double giroResultado;

    private CajaDeAhorroDTO(Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
        this.giroResultado = builder.giroResultado;
    }

    public static class Builder {
        private int numeroCuenta;
        private double saldo;
        private double giroResultado;

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