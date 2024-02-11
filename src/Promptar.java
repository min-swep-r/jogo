import Suplement.Suply;
import java.util.Scanner;

public class Promptar {

    //Novas ultilidades, vou colocar os I/O do console aqui...

    //primeiro Get
    public static boolean check(char var, Jogo jg) {

        // essa vem sendo a chamda principal, dentro do loop
        //vou coloar aqui, ou antes da chamda daqui, o print da matriz

        if (var == 'a') {
            // Lógica para a tecla 'a'
            System.out.println("Tecla 'a' pressionada. o get do user é: " + jg.usuarioObj.getNome()); //ToDo ->  + Jogo.user.getNome;
            //System.out.println(jg.User.getNome); //quero usar o get aqui
            Suply.pause(3.882f);
            return true;
        } else if (var == 's') {
            System.out.println("saindo.");

            //false pra terminar o loop. no arquivo.class fica read-only o que será usado
            Suply.pause(1);
            return false;
        } else if (var == 'i') {
            System.out.println("input - mudando celula.");
            //método de fazer celula virar mina
            colocaMina(jg);
            Suply.pause(1);
            return true;
        } else if (var == 'e') {
            System.out.println("escavando...");
            //método de escavar
            escava(jg);
            Suply.pause(1);
            return true;
        } else if (var == 'b') {
            System.out.println("Changing bandeira");
            //método de escavar
            scouting(jg);
            Suply.pause(1);
            return true;
        } else {
            // Lógica para outras teclas, se necessário
            System.out.println("Tecla não reconhecida.");
            Suply.pause(1);
            return true;
        }
    }

    public static void escava(Jogo jg) {
        System.out.print("Digite a linha: ");
        Scanner scanner = new Scanner(System.in);
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna: ");
        int coluna = scanner.nextInt();

        // Acessa a célula específica e chama o método revelaCelula()
        Celula celula = jg.tableObj.getMinaFull(linha, coluna);

        // Verifica se a célula está marcada com uma bandeira
        if (celula.getBaneira()) {
            System.out.println("Po, com bandeira não vale escavar!!!");
            Suply.pause(1); // Pausa para repensar nos atos
        } else {
            // Verifica se a célula é uma instância de Bomba e se está revelada
            if (celula instanceof Bomba) {
                if (((Bomba) celula).getRevelado()) {
                    System.out.println("Você cavou em uma bomba! Game over.");
                    Suply.pause(5.1); // Pausa para repensar nos atos
                }
            } else if (celula instanceof Celula) {
                // Verifica se a célula já está revelada
                if (((Celula) celula).celRevelado()) {
                    System.out.println("Você já cavou nessa célula. Tente novamente.");
                    Suply.pause(1); // Pausa para repensar nos atos
                } else {
                    // Caso contrário, revela a célula
                    celula.revelaCelula();
                    System.out.println("Célula escavada!");
                }
            } else {
                System.out.println("Erro ao acessar a célula.");
            }
        }
    }


    public static void scouting(Jogo jg) {
        //--------------------------------------------obtem a célula e "clona"------
        System.out.print("Digite a linha: ");
        Scanner scanner = new Scanner(System.in);
        int linha = scanner.nextInt();
        System.out.print("Digite a coluna: ");
        int coluna = scanner.nextInt();
        // Acessa a célula específica e chama o método revelaCelula()
        Celula celula = jg.tableObj.getMinaFull(linha, coluna);
        //----------------------------------------------------------------------------

        //Aqui, a msm coisa. vou colocar todo funcionamento entro de uma condicional
        //se a celula já tiver escavada, tbm nem adianta
        if (celula.celRevelado()) {
            System.out.println("Oxi, pra que bandeira aqui se tu já escavou?");
            Suply.pause(1); //pra repensar nos atos
        } else { //aqui é o funcionamento padrão
            if (celula != null) {
                celula.mudaBandeira();
                System.out.println("Terreno (des)marcado!");
            } else {
                System.out.println("Erro ao acessar a célula.");
            }
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
        System.out.println("\n'.' = escavado, '\u25A1' = escavável, 'X' = Bomba, 'P' = Bandeira");
        System.out.println("\n\nPara jogar");
        System.out.println("\t marcar");
        System.out.println("\t(e)scavar");
        System.out.println("\t(b)andeiar / dedsbandeirar");
        System.out.println("\t(s)air - do game");
        System.out.println("\n\nPara Debug");
        System.out.println("\t(a)ss - get assinatura User");
        System.out.println("\t(i)nput - set mina");
    }
    // Vou começar a mexer na exibição aqui. 1º - tudo tem que ser quadrado, a não ser que eu tenha escavado
    public static void printMina(Jogo jg) {
        System.out.println("Imprimindo minas reveladas:");

        // Itera sobre todas as células do tabuleiro
        for (int i = 0; i < jg.getTamXObj(); i++) {
            for (int j = 0; j < jg.getTamYObj(); j++) {
                // Acessa a célula atual
                Celula celula = jg.tableObj.getMinaFull(i, j);

                // Verifica se a célula foi revelada
                if (celula.getBaneira()) {
                    System.out.print("P "); // P se a célula está marcada com uma bandeira
                } else if (celula.celRevelado()) {
                    // Se a célula foi revelada
                    if (celula instanceof Bomba) {
                        // Verifica se a célula é uma bomba
                        if (((Bomba) celula).getRevelado()) {
                            System.out.print("X "); // X se a célula é uma bomba e foi revelada
                        } else {
                            System.out.print(". "); // Ponto se a célula não é uma bomba e foi revelada
                        }
                    } else {
                        System.out.print(". "); // Ponto se a célula não é uma bomba e foi revelada
                    }
                } else {
                    System.out.print("\u25A1 "); // Quadrado se a célula não foi revelada
                }
            }
            System.out.println(); // Nova linha para a próxima linha do tabuleiro
        }
    }

}
