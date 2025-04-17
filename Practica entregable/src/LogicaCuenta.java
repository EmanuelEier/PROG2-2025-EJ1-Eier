import java.util.ArrayList;
import java.util.List;
public class LogicaCuenta {
    private static volatile LogicaCuenta instancia;
    private final List<Cuenta> cuentas;

    private LogicaCuenta() {
        cuentas = new ArrayList<>();
    }

    public static LogicaCuenta getInstancia() {
        if (instancia == null) {
                    instancia = new LogicaCuenta();
            }
        return instancia;
    }

    public boolean agregarCuenta(Cuenta cuenta) {
        Cuenta cuentaCreada = cuentas.stream()
                .filter(x -> x.getNumeroCuenta() == cuenta.getNumeroCuenta())
                .findFirst()
                .orElse(null);

        if (cuentaCreada != null) return false;

        cuentas.add(cuenta);
        return true;
    }

    public boolean agregarSaldo(int nroCuenta, double monto) {
        Cuenta cuenta = cuentas.stream()
                .filter(x -> x.getNumeroCuenta() == nroCuenta)
                .findFirst()
                .orElse(null);

        if (cuenta == null) return false;
        else cuenta.agregarSaldo(monto);
        return true;
    }

    public boolean quitarSaldo(int nroCuenta, double monto) {
        Cuenta cuenta = cuentas.stream()
                .filter(x -> x.getNumeroCuenta() == nroCuenta)
                .findFirst()
                .orElse(null);

        if (cuenta == null) return false;
        else cuenta.quitarSaldo(monto);
        return true;
    }

    public double consultarSaldo(int nroCuenta) {
        Cuenta cuenta = cuentas.stream()
                .filter(x -> x.getNumeroCuenta() == nroCuenta)
                .findFirst()
                .orElse(null);

        if (cuenta == null) return 0;
        else return cuenta.getSaldo();
    }

    public Cuenta getCuenta(int indice) {
        return cuentas.get(indice);
    }

    public int getOperaciones(int nroCuenta) {
        Cuenta cuenta = cuentas.stream()
                .filter(x -> x.getNumeroCuenta() == nroCuenta)
                .findFirst()
                .orElse(null);

        if (cuenta == null) return 0;
        else return cuenta.getOperaciones();
    }
}
