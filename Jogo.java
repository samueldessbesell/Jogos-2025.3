import java.util.Scanner;
import java.util.Random;

public class Jogo {
    private Scanner sc = new Scanner(System.in);
    private Random random = new Random();
    private int pontosRestantes = 15;
    private Jogador jogador = new Jogador();
    private Adversario adversarioF1;
    private Adversario adversarioF2;
    private Adversario adversarioF3;

    Arma armaInicial1 = new Arma("Espada Longa", 2, "armaPesada");
    Arma armaInicial2 = new Arma("Maça", 2, "armaPesada");
    Arma armaInicial3 = new Arma("Rapieira", 2, "armaLeve");

    public void criarAdversarioFase1(){
        int aleatorio = random.nextInt(3);
        switch(aleatorio){
            case 0:
                Arma armaAdversario1 = new Arma("Foice ceifadora", 2, "armaLeve");
                Adversario adversario1 = new Adversario("Vampiro", 12, 2, 6, 3, 4, armaAdversario1, null, 10);
                adversarioF1 = adversario1;
                adversarioF1.getArma().setCategoria("armaLeve");
                break;
                
            case 1:
                Arma armaAdversario2 = new Arma("Martelo Quebra crânio", 3, "armaPesada");
                Adversario adversario2 = new Adversario("Ogro", 20, 7, 1, 1, 6, armaAdversario2, null, 8);
                adversarioF1 = adversario2;
                adversarioF1.getArma().setCategoria("armaPesada");
                break;
                
            case 2:
                Arma armaAdversario3 = new Arma("Shurikens", 1, "armaLeve");
                Adversario adversario3 = new Adversario("Ninja", 15, 1, 7, 6, 1, armaAdversario3, null, 12);
                adversarioF1 = adversario3;
                adversarioF1.getArma().setCategoria("armaLeve");
                break;
            
            default:
                break;
        }
    }

    public void criarAdversarioFase2(){
        int aleatorio = random.nextInt(2);
        switch(aleatorio){
            case 0:
                Arma armaAdversario1 = new Arma("Nunchakos", 2, "armaLeve");
                Adversario adversario1 = new Adversario("Michelangelo", 20, 4, 4, 4, 3, armaAdversario1, null, 13);
                adversarioF2 = adversario1;
                adversarioF2.getArma().setCategoria("armaLeve");
                break;
                
            case 1:
                Arma armaAdversario2 = new Arma("Lança Mágica", 3, "armaPesada");
                Adversario adversario2 = new Adversario("Mágico", 25, 5, 5, 5, 0, armaAdversario2, null, 13);
                adversarioF2 = adversario2;
                adversarioF2.getArma().setCategoria("armaPesada");
                break;
            
            default:
                break;
        }
    }

    public void criarAdversarioFase3(){
        Arma armaBoss = new Arma("Cetro", 5, "armaPesada");
        Adversario adversario = new Adversario("Lich", 30, 2, 2, 5, 5, armaBoss, null, 15);
        adversarioF3 = adversario;
        adversarioF3.getArma().setCategoria("armaPesada");
    }

    public void mostrarPontosRestantes(){
        System.out.println("\nPontos de Atributo Disponíveis: " + pontosRestantes);
    }
    public void calcularVidaInicial(){
        for(int i = 0; i < 3; i++) {
            jogador.setHp(jogador.getHp()+jogador.rolarDados(6));
        }
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
                    pontosRestantes = 15;
                    jogador.setForca(0);
                    jogador.setDestreza(0);
                    jogador.setConstituicao(0);
                    jogador.setAgilidade(0);

                    limparTela();
                    System.out.println("\n=== Criação do Personagem ===");
                    System.out.print("Digite o nome do seu herói: ");
                    String nome = sc.nextLine();
                    jogador.setNome(nome);
                    limparTela();
                
                    calcularVidaInicial();

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
                    double vidaBase = jogador.getHp();
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
                
                    System.out.println("Escolha uma arma inicial:");
                    System.out.println("1 - Espada Longa (armaPesada)");
                    System.out.println("2 - Maça (armaPesada)");
                    System.out.println("3 - Rapieira (armaLeve)");
                    System.out.print("Escolha: ");
                    int escolhaArma = sc.nextInt(); sc.nextLine();

                    switch (escolhaArma) {
                        case 1 -> jogador.setArma(armaInicial1);
                        case 2 -> jogador.setArma(armaInicial2);
                        case 3 -> jogador.setArma(armaInicial3);
                        default -> jogador.setArma(armaInicial1);
                    }

                    System.out.println("O herói " + nome + " foi criado com sucesso!");
                    sc.nextLine();
                    limparTela();
                    
                    //Fase 1
                    criarAdversarioFase1(); 
                    System.out.println("O adversário "+adversarioF1.getNome()+" surge.");
                    Combate combate1 = new Combate(jogador, adversarioF1);
                    combate1.iniciarCombate(jogador, adversarioF1);
                    sc.nextLine();

                    //Fase 2
                    if(jogador.getHp() > 0){
                        jogador.setHp(vidaBase);
                        criarAdversarioFase2();
                        System.out.println("O adversário "+adversarioF2.getNome()+" surge.");
                        Combate combate2 = new Combate(jogador, adversarioF2);
                        combate1.iniciarCombate(jogador, adversarioF2);
                        sc.nextLine();
                    }

                    //Fase 2
                    if(jogador.getHp() > 0){
                        jogador.setHp(vidaBase);
                        criarAdversarioFase3();
                        System.out.println("O adversário "+adversarioF3.getNome()+" surge.");
                        Combate combate3 = new Combate(jogador, adversarioF3);
                        combate1.iniciarCombate(jogador, adversarioF3);
                        sc.nextLine();
                    }

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
