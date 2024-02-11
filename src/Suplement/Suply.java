package Suplement;

public class Suply {

    public static void pause(int seg) {
        //solução do chat gpt pra pausar 1sec
        int miliseg = 1000*seg;
        long startTime = System.currentTimeMillis();
        long elapsedTime;
        do {
            elapsedTime = System.currentTimeMillis() - startTime;
        } while (elapsedTime < miliseg); // Espera até 1 segundo ter passado
    }

    ///Vou tentar dar um over aqui
    public static void pause(double seg) {
        //solução do chat gpt pra pausar 1sec
        double miliseg = 1000.2 * seg;
        long startTime = System.currentTimeMillis();
        long elapsedTime;
        do {
            elapsedTime = System.currentTimeMillis() - startTime;
        } while (elapsedTime < miliseg); // Espera até 1 segundo ter passado
    }

    public static void cls() {
        // Verifica se o sistema operacional é Windows
        if (System.getProperty("os.name").contains("Windows")) {
            limparConsoleWindows();
        } else {
            // Caso contrário, assume-se que é um sistema operacional baseado em Unix
            limparConsoleUnix();
        }
    }

    private static void limparConsoleWindows() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (Exception e) {
            // Lidar com exceções, se necessário
            e.printStackTrace();
        }
    }

    private static void limparConsoleUnix() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
