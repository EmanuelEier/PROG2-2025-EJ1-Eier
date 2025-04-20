public class CuentaCorriente extends Cuenta {
    private double giroDescubierto;

    public CuentaCorriente(CuentaCorrienteDTO dto) {
        this.numeroCuenta = dto.getNumeroCuenta();
        this.saldo = dto.getSaldo();
        this.giroDescubierto = dto.getGiroDescubierto();
    }

    private void setGiroDescubierto(){
        giroDescubierto = this.giroDescubierto;
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
