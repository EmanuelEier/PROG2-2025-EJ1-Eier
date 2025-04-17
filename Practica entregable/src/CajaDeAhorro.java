public class CajaDeAhorro extends Cuenta implements IGestionSaldo {

    public CajaDeAhorro(CajaDeAhorroDTO.Builder builder) {
        this.numeroCuenta = builder.numeroCuenta;
        this.saldo = builder.saldo;
    }

    @Override
    public boolean agregarSaldo(double monto) {
        saldo += monto;
        operaciones++;
        return true;
    }

    @Override
    public synchronized boolean quitarSaldo(double monto) {
        if (monto <= saldo) {
            saldo -= monto;
            operaciones++;
            return true;
        }
        return false;
    }

    @Override
    public synchronized double getSaldo() {
        return saldo;
    }

    @Override
    public int getOperaciones() {
        return operaciones;
    }

}