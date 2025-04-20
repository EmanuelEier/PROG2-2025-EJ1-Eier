public class CuentaCorrienteDTO {
    private final int numeroCuenta;
    private final double saldo;
    private final double giroDescubierto;

    private CuentaCorrienteDTO(Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
        this.giroDescubierto = builder.giroDescubierto;
    }

    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getGiroDescubierto() {
        return giroDescubierto;
    }

    public static class Builder {
        private int numeroCuenta;
        private double saldo;
        private double giroDescubierto;

        public Builder setNumeroCuenta(int numeroCuenta) {
            this.numeroCuenta = numeroCuenta;
            return this;
        }

        public Builder setSaldo(double saldo) {
            this.saldo = saldo;
            return this;
        }

        public Builder setGiroDescubierto(double giroDescubierto) {
            this.giroDescubierto = giroDescubierto;
            return this;
        }

        public CuentaCorrienteDTO build() {
            return new CuentaCorrienteDTO(this);
        }
    }
}