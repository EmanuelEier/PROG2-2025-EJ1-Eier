import java.util.Random;
import

public class Main {
    public static void main(String[] args) {
            Random random = new Random();
            LogicaCuenta logica = LogicaCuenta.getInstancia();


        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0) {
                CajaDeAhorroBuilder cajaDeAhorro = new CajaDeAhorroBuilder.Builder()
                        .setNumeroCuenta(x)
                        .build();
                CajaDeAhorro cajaDeAhorro = cajaDeAhorroBuilder.getCajaDeAhorro();
                logicaCuenta.agregarCuentas(cajaDeAhorro);

            } else {
                CuentaCorrienteBuilder cuentaCorrienteBuilder = new CuentaCorrienteBuilder();
                cuentaCorrienteBuilder.setId(x);
                cuentaCorrienteBuilder.setGiroDescubierto(random.nextDouble(7000, 90000));
                CuentaCorriente cuentaCorriente = cuentaCorrienteBuilder.getCuentaCorriente();
                logicaCuenta.agregarCuentas(cuentaCorriente);

            }
        }

            for (int i = 0; i < 5000; i++) {
                var res = LogicaCuenta.obtenerInstancia().agregarSaldo(random.nextInt(20), 200);
                var res1 = LogicaCuenta.obtenerInstancia().quitarSaldo(random.nextInt(20), 100);
            }

            int total = 0;

            for (int i = 0; i < 20; i++) {
                System.out.println("Saldo cuenta " + (i + 1 ) + " " + LogicaCuenta.obtenerInstancia().consultarSaldo(i));
                System.out.println("Movimientos cuenta " + (i + 1 ) + " " + LogicaCuenta.obtenerInstancia().getTransacciones(i));
                total += LogicaCuenta.obtenerInstancia().getTransacciones(i);
            }

            System.out.println("\n" + total);

        }


}