import java.util.Random;

public abstract class Entidade {
    private String nome;
    private int hp;
    private int forca;
    private int destreza;
    private int agilidade;
    private int constituicao;
    //private int classeArmadura;
    //private int dano;
    
    public Entidade(String nome, int hp, int forca, int destreza, int agilidade, int constituicao) {
        setNome(nome);
        setHp(hp);
        setForca(forca);
        setDestreza(destreza);
        setAgilidade(agilidade);
        setConstituicao(constituicao);
    }

    private Random r = new Random();

    public void atacar(Entidade oponente, Arma arma){
        double danoForca = arma.getConstanteDano() + this.forca*1.5 + r.nextInt(1, 12);
        double danoDestreza = arma.getConstanteDano() + this.destreza + 2*(r.nextInt(1, 6) + r.nextInt(1, 4));
        if (arma.getCategoria() == "armaPesada") {
            oponente.hp -= danoForca;
            System.out.println(this.nome + " ataca " + oponente.nome + " com " + arma.getNome() + " causando " + danoForca + " de dano!");
        }else if(arma.getCategoria() == "armaLeve") {
            oponente.hp -= danoDestreza;
            System.out.println(this.nome + " ataca " + oponente.nome + " com " + arma.getNome() + " causando " + danoDestreza + " de dano!");
        }else{
            System.out.println("Categoria de arma não encontrada. Não foi possível atacar.");
        }
        if(oponente.hp < 0) oponente.hp = 0;
        
        mostrarStatus();
        oponente.mostrarStatus();
        System.out.println();
    }

    public void mostrarStatus(){
        System.out.println(this.nome + ":       \t" + hp + " hp");
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getHp() {
        return hp;
    }
    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getForca() {
        return forca;
    }
    public void setForca(int forca) {
        this.forca = forca;
    }

    public int getDestreza() {
        return destreza;
    }
    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getAgilidade() {
        return agilidade;
    }
    public void setAgilidade(int agilidade) {
        this.agilidade = agilidade;
    }

    public int getConstituicao() {
        return constituicao;
    }
    public void setConstituicao(int constituicao) {
        this.constituicao = constituicao;
    }
}
