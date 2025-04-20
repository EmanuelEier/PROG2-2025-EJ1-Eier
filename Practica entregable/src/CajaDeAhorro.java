public class CajaDeAhorro extends Cuenta implements IGestionSaldo {

    public CajaDeAhorro(CajaDeAhorroDTO dto) {
        this.numeroCuenta = dto.getNumeroCuenta();
        this.saldo = dto.getSaldo();
    }

    @Override
    public synchronized boolean agregarSaldo(double monto) {
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