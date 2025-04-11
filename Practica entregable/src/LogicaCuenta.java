import java.util.ArrayList;
import java.util.List;
public class LogicaCuenta {
    private static volatile LogicaCuenta instancia;
    private final List<IGestionSaldo> cuentas;

    private LogicaCuenta() {
        cuentas = new ArrayList<>();
    }

    public static LogicaCuenta getInstancia() {
        if (instancia == null) {
            synchronized (LogicaCuenta.class) {
                if (instancia == null) {
                    instancia = new LogicaCuenta();
                }
            }
        }
        return instancia;
    }


    public boolean agregarSaldo(int nroCuenta, double monto) {
        IGestionSaldo cuenta = cuentas.get(nroCuenta);
        return cuenta.agregarSaldo(monto);
    }

    public boolean quitarSaldo(int nroCuenta, double monto) {
        IGestionSaldo cuenta = cuentas.get(nroCuenta);
        return cuenta.quitarSaldo(monto);
    }

    public double consultarSaldo(int nroCuenta) {
        IGestionSaldo cuenta = cuentas.get(nroCuenta);
        return cuenta.getSaldo();
    }

    public IGestionSaldo getCuenta(int index) {
        return cuentas.get(index);
    }
}
