import java.util.Scanner;

public class Jogo {
    private Scanner sc = new Scanner(System.in);
    private int pontosRestantes = 15;
    
    Jogador jogador = new Jogador();

    public void mostrarPontosRestantes(){
        System.out.println("\nPontos de Atributo Disponíveis: " + pontosRestantes);
    }
    public void calclarVidaInicial(){
        System.out.println("Rolagem de Dados para definir o HP: " + jogador.getHp() + " (3d6: " + jogador.getRolagem() + " + " +
                                                                    jogador.getRolagem() + " + " + jogador.getRolagem() + ")\n");
    }
    public void mostrarDistribuição(){
        System.out.println("Nome: " + jogador.getNome());
        System.out.println("HP: " + jogador.getHp());
        System.out.println("Força: " + jogador.getForca());
        System.out.println("Destreza: " + jogador.getDestreza());
        System.out.println("Constituição: " + jogador.getConstituicao());
        System.out.println("Agilidade: " + jogador.getAgilidade());
    }
    public void calcularPontosRestantes(double atributo){
        pontosRestantes -= atributo;
    }

    public void exibirMenu() {
        boolean rodando = true;

        while (rodando) {
            limparTela();
            System.out.println("====================================================================================================");
            System.out.println("                                        JRPG - PUKE ADVENTURE  ");
            System.out.println("====================================================================================================");
            System.out.println("1. Começar Jogo");
            System.out.println("2. História");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");

            int opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {
                case 1:
                    limparTela();
                    System.out.println("\n=== Criação do Personagem ===");
                    System.out.print("Digite o nome do seu herói: ");
                    String nome = sc.nextLine();
                    jogador.setNome(nome);
                    limparTela();
                    
                    for(int i = 0; i < 3; i++){
                        jogador.setHp(jogador.getHp()+jogador.rolarDados(6));
                    }
                    calclarVidaInicial();

                    mostrarDistribuição();
                    mostrarPontosRestantes();
                    System.out.print("Digite a força do herói: ");
                    double forca = sc.nextDouble(); sc.nextLine();
                    jogador.setForca(forca);
                    calcularPontosRestantes(forca);
                    limparTela();
                    
                    mostrarDistribuição();
                    mostrarPontosRestantes();
                    System.out.print("Digite a destreza do herói: ");
                    int destreza = sc.nextInt(); sc.nextLine();
                    jogador.setDestreza(destreza);
                    calcularPontosRestantes(destreza);
                    limparTela();

                    mostrarDistribuição();
                    mostrarPontosRestantes();
                    System.out.print("Digite a constituicão do herói: ");
                    int constituicao = sc.nextInt(); sc.nextLine();
                    jogador.setConstituicao(constituicao);
                    calcularPontosRestantes(constituicao);
                    limparTela();
                    
                    mostrarDistribuição();
                    mostrarPontosRestantes();
                    System.out.print("Digite a agilidade do herói: ");
                    int agilidade = sc.nextInt(); sc.nextLine();
                    jogador.setAgilidade(agilidade);
                    calcularPontosRestantes(agilidade);
                    sc.nextLine();
                    limparTela();
                
                    System.out.println("O herói " + nome + " foi criado com sucesso!");
                    break;


                    
                case 2:
                    limparTela();
                    Historia.mostrar(sc);
                    break;

                case 3:
                    limparTela();
                    System.out.println("Saindo do jogo... Até a próxima!");
                    rodando = false;
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }

    public void limparTela(){
        for(int i = 0; i < 40; i++){
            System.out.println();
        }
    }
    public void limparTela(int linhas){
        for(int i = 0; i < linhas; i++){
            System.out.println();
        }
    }
}
