public abstract class Cuenta {
    protected double saldo;
    protected int numeroCuenta;
    protected int operaciones;

    public abstract double getSaldo();
    public abstract int getOperaciones();
    public abstract boolean agregarSaldo(double monto);
    public abstract boolean quitarSaldo(double monto);

    public int getNumeroCuenta(){
        return numeroCuenta;
    }

}
