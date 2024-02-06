import java.util.Scanner;

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
        //legenda();

        if (var == 'a') {
            // Lógica para a tecla 'a'
            System.out.println("Tecla 'a' pressionada. o get do user é: " + jg.usuarioObj.getNome()); //ToDo ->  + Jogo.user.getNome;
            //System.out.println(jg.User.getNome); //quero usar o get aqui
            return true;
        } else if (var == 's') {
            System.out.println("saindo.");

            //false pra terminar o loop. no arquivo.class fica read-only o que será usado
            return false;
        } else if (var == 'i') {
            System.out.println("input - mudando celula.");
            //método de fazer celula virar mina
            colocaMina(jg);
            return true;
        } else if (var == 'o') {
            System.out.println("out - printando celulas");
            //método de printar
            checkCoord(jg);
            return true;
        } else if (var == 'p') {
            System.out.println("print - exibindo célula.");
            //método de exibir
            printMina(jg);
            return true;
        } else {
            // Lógica para outras teclas, se necessário
            System.out.println("Tecla não reconhecida.");
            return true;
        }
    }

    //Blz, acho que sei como dar um get. vamos tentar...

    // Método para verificar se existe uma célula nas coordenadas fornecidas
    public static boolean checkCoord(Jogo jg) {
        System.out.print("Digite a linha: ");

        Scanner scanner = new Scanner(System.in);
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna: ");
        int coluna = scanner.nextInt();

        // Acessa a célula específica
        boolean temMina; //boolean temMina = false;
        try {
            temMina = jg.tableObj.getMina(linha, coluna); //Jogo.tableDojog.minaDaTable(coordYAltura, CoordXColuna)
        } catch (NullPointerException e) {
            System.out.println("Tá null");
            scanner.close();
            return true;
        }

        // Exibe se há uma mina na célula
        if (temMina) {
            System.out.println("Tem mina");
            return true;
        } else {
            System.out.println("Not have");
            return true;
        }

    }

    public static boolean colocaMina(Jogo jg) {
        System.out.print("Digite a linha: ");

        Scanner scanner = new Scanner(System.in);
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna: ");
        int coluna = scanner.nextInt();

        // Acessa a célula específica
        boolean temMina = false;
        try {
            temMina = jg.tableObj.setMina(linha, coluna); //Jogo.tableDojog.minaDaTable(coordYAltura, CoordXColuna)
        } catch (NullPointerException e) {
            System.out.println("Tá null");
            scanner.close();
            return true;
        }

        // Exibe se há uma mina na célula
        if (temMina) {
            System.out.println("Tem mina");
            return true;
        } else {
            System.out.println("Not have");
            return true;
        }

    }

    public static void legenda(){
        System.out.println("ass - get assinatura User");
        System.out.println("print - printa matriz de mina - troca estado da celula (ativa / desativa)");
        System.out.println("out -  get mina");
        System.out.println("input - set mina");
        System.out.println("s - sair");
    }

    public static void printMina(Jogo jg) {
        System.out.println("Imprimindo minas reveladas:");

        for (int i = 0; i < jg.getTamXObj(); i++) {
            for (int j = 0; j < jg.getTamYObj(); j++) {
                if (jg.tableObj.getMina(i, j) /*&& jg.tableObj.getMina(i, j).getRevelado()*/) {
                    System.out.print("X "); // Caractere para minas reveladas
                } else {
                    System.out.print(". "); // Caractere para células não reveladas ou sem mina
                }
            }
            System.out.println(); // Nova linha para a próxima linha do tabuleiro
        }
    }


}
