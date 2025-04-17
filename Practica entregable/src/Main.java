import java.util.Random;


public class Main {
    public static void main(String[] args) {
            Random random = new Random();
            LogicaCuenta logica = LogicaCuenta.getInstancia();


        for (int x = 0; x < 10; x++) {
            if (x % 2 == 0) {
                CajaDeAhorro cajaDeAhorro = new CajaDeAhorroDTO.Builder()
                        .setNumeroCuenta(x)
                        .build();
                logica.agregarCuenta(cajaDeAhorro);

            } else {
                CuentaCorriente cuentaCorriente = new CuentaCorrienteDTO.Builder()
                        .setNumeroCuenta(x)
                        .setGiroDescubierto(random.nextDouble(1000, 50000))
                        .build();
                logica.agregarCuenta(cuentaCorriente);

            }
        }

        for (int x = 0; x < 10000; x++) {
              var resultado1 = logica.agregarSaldo(random.nextInt(10), 200);
              var resultado2 = logica.quitarSaldo(random.nextInt(10), 50);
        }

        int total = 0;

        for (int x = 0; x < 10; x++) {
                System.out.println("Saldo cuenta n° " + (x + 1) + ": " + logica.consultarSaldo(x));
                System.out.println("Movimientos cuenta n°" + (x + 1) + ": " + logica.getOperaciones(x));
                System.out.println("");
                total += logica.getOperaciones(x);
            }

            System.out.println("El número total de operaciones fue:"+ "\n" + total);

        }


}