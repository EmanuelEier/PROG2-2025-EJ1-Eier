import java.util.Random;
import java.util.concurrent.*;


public class Main {
    public static void main(String[] args) {
            Random random = new Random();
            LogicaCuenta logica = LogicaCuenta.getInstancia();


        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0) {
                CajaDeAhorroDTO cajaDeAhorroDto = new CajaDeAhorroDTO.Builder()
                        .setNumeroCuenta(x)
                        .setSaldo(0)
                        .build();

                CajaDeAhorro cajaDeAhorro = new CajaDeAhorro(cajaDeAhorroDto);
                logica.agregarCuenta(cajaDeAhorro);

            } else {
                CuentaCorrienteDTO cuentaCorrienteDto = new CuentaCorrienteDTO.Builder()
                        .setNumeroCuenta(x)
                        .setGiroDescubierto(random.nextDouble(1000, 5000))
                        .build();

                CuentaCorriente cuentaCorriente = new CuentaCorriente(cuentaCorrienteDto);
                logica.agregarCuenta(cuentaCorriente);

            }
        }

        ExecutorService executor = Executors.newFixedThreadPool(10);
        for (int x = 0; x < 5000; x++) {
            executor.submit(() -> logica.agregarSaldo(random.nextInt(10), 200));
            executor.submit(() -> logica.quitarSaldo(random.nextInt(10), 50));
        }
        executor.shutdown();

        int totalOperaciones = 0;
        for (int x = 0; x < 10; x++) {
                System.out.println("Saldo cuenta n° " + (x + 1) + ": " + logica.consultarSaldo(x));
                System.out.println("Cantidad moovimientos cuenta n°" + (x + 1) + ": " + logica.getOperaciones(x));
                System.out.println("");
                totalOperaciones = totalOperaciones + logica.getOperaciones(x);
            }

            System.out.println("El número total de operaciones fue: " + totalOperaciones);

        }


}