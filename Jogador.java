public class Jogador extends Entidade{
    private int nivel;

    public Jogador(String nome, int hp, int forca, int destreza, int agilidade, int constituicao) {
        super(nome, hp, forca, destreza, agilidade, constituicao);
        this.nivel = 1;
    }

    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
}
