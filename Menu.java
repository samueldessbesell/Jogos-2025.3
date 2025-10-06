import java.util.Scanner;

public class Menu {
    private static Scanner sc = new Scanner(System.in);

    public Scanner forca;
    public Scanner destreza;
    public Scanner constituicao;
    public Scanner agilidade;
    
    public static void exibirMenu() {
        boolean rodando = true;

        while (rodando) {
            System.out.println("=========================");
            System.out.println("  JRPG - PUKE ADVENTURE  ");
            System.out.println("=========================");
            System.out.println("1. Começar Jogo");
            System.out.println("2. História");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n=== Criação do Personagem ===");
                    System.out.print("Digite o nome do seu herói: ");
                    String nome = sc.nextLine();
                    System.out.print("Digite a força do herói : ");
                    int forca = sc.nextInt(); 
                    System.out.print("Digite a destreza do herói : ");
                    int destreza = sc.nextInt();
                    System.out.print("Digite a constituicão do herói : ");
                    int constituicao = sc.nextInt();
                    System.out.print("Digite a agilidade do herói : ");
                    int agilidade = sc.nextInt();
                    int vida;

                    //Jogador player1 = new Jogador(nome, vida, forca, destreza, agilidade, constituicao);
                

                    System.out.println("O herói " + nome + " foi criado com sucesso!")
                    break;
                case 2:
                    Historia.mostrar(sc);
                    break;
                case 3:
                    System.out.println("Saindo do jogo... Até a próxima!");
                    rodando = false;
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

}
