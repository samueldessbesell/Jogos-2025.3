import java.util.Scanner;

public class Jogo {
    private Scanner sc;
    private Scanner forca;
    private Scanner destreza;
    private Scanner constituicao;
    private Scanner agilidade;

    public Jogo(Scanner sc) {
        this.sc = sc;
    }

    public Scanner getForca() {
        return forca;
    }

    public void setForca(Scanner forca) {
        this.forca = forca;
    }

    public Scanner getDestreza() {
        return destreza;
    }

    public void setDestreza(Scanner destreza) {
        this.destreza = destreza;
    }

    public Scanner getConstituicao() {
        return constituicao;
    }

    public void setConstituicao(Scanner constituicao) {
        this.constituicao = constituicao;
    }

    public Scanner getAgilidade() {
        return agilidade;
    }

    public void setAgilidade(Scanner agilidade) {
        this.agilidade = agilidade;
    }

    public void comecar() {
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

        System.out.println("O herói " + nome + " foi criado com sucesso!");
    }
}