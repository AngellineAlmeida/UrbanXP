package servico_urbanxp;

public class Desconto50Porcento implements Desconto {
    @Override
    public double calcularPrecoFinal(double precoBase) {
        return precoBase * 0.5;
    }
}
