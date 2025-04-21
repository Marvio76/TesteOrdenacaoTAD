public class Pessoa implements Comparable<Pessoa> {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    @Override
    public int compareTo(Pessoa outra) {
        return Integer.compare(this.idade, outra.idade);
    }
}
