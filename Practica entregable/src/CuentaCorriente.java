public class CuentaCorriente extends Cuenta {
    private double giroDescubierto;

    public CuentaCorriente(CuentaCorrienteBuilder.Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
        this.giroDescubierto = builder.giroResultado;
    }
    @Override
    public synchronized boolean agregarSaldo(double monto) {
        saldo += monto;
        operaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (saldo - monto >= -giroDescubierto) {
            saldo -= monto;
            operaciones++;
            return true;
        }
        return false;
    }

    @Override
    public double getSaldo() {
        return saldo;
    }

    @Override
    public int getOperaciones() {
        return operaciones;
    }
}
