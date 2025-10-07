import java.util.Random;

public class Pocao {

    private int usosRestantes;
    private Random random;
    private float vida;
    private float vidaMaxima;

    public Pocao() {
        this.usosRestantes = 3; // pode ser usada 3 vezes
        this.random = new Random();
    }

    // Rola 3 dados de 6 lados e soma o resultado
    private int rolar3d6() {
        int total = 0;
        for (int i = 0; i < 3; i++) {
            total += random.nextInt(6) + 1; // 1 a 6
        }
        return total;
    }

    public void recuperarVida(int quantidade) {
        this.vida += quantidade;
        if (this.vida > this.vidaMaxima) this.vida = this.vidaMaxima;
        System.out.println("Sua vida atual é: " + this.vida + "/" + this.vidaMaxima);
    }

    public void usar() {
        if (usosRestantes > 0) {
            int cura = rolar3d6();
            recuperarVida(cura);
            usosRestantes--;
            System.out.println("Você usou uma poção e recuperou " + cura + " de vida!");
            System.out.println("Usos restantes da poção: " + usosRestantes);
        } else {
            System.out.println("A poção está vazia e não pode mais ser usada!");
        }
    }

    public int getUsosRestantes() {
        return usosRestantes;
    }
    public void setUsosRestantes(int usosRestantes){
        this.usosRestantes = usosRestantes;
    }
    public boolean estaVazia() {
        return usosRestantes == 0;
    }
}
