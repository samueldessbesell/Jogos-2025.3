public class App {
    public static void main(String[] args) throws Exception {
        //Menu menu = new Menu();
        //menu.exibirMenu();

        Jogador player1 = new Jogador("Pukeman", 15, 4, 2, 1, 3);
        Arma arma1 = new Arma("Quebra crânio", 2, "armaPesada");

        Adversario adversario1 = new Adversario("Vampiro", 25, 2, 5, 3, 4);
        Arma arma2 = new Arma("Foice ceifadora", 2, "armaLeve");

        do{
            player1.atacar(adversario1, arma1);
            adversario1.atacar(player1, arma2);
        } while(player1.getHp() > 0 && adversario1.getHp() > 0);
    }
}
