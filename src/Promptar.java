public class Promptar {

    public static void main(String[] args) {
        // Chama o método para limpar o console
        cls();
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

    //Novas ultilidades, vou colocar os I/O do console aqui...

    //primeiro Get
    public static boolean check(char var, Jogo jg) {
        if (var == 'a') {
            // Lógica para a tecla 'a'
            System.out.println("Tecla 'a' pressionada. o get do user é: " + jg.usuarioObj.getNome()); //ToDo ->  + Jogo.user.getNome;
            //System.out.println(jg.User.getNome); //quero usar o get aqui
            return true;
        } else if (var == 's') {
            System.out.println("saindo.");
            return false;
        } else {
            // Lógica para outras teclas, se necessário
            System.out.println("Tecla não reconhecida.");
            return true;
        }
    }

    //Blz, acho que sei como dar um get. vamos tentar...


}
