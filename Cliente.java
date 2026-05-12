public class Cliente {
    private String nome;
    private Desconto perfilDesconto;

    public Cliente(String nome, Desconto perfilDesconto) {
        this.nome = nome;
        this.perfilDesconto = perfilDesconto;
    }

    public double calcularValorFinal(double precoBase) {
        return perfilDesconto.calcularPrecoFinal(precoBase);
    }

    public String getNome() { 
        return nome; 
    }
}
