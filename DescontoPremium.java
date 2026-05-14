package servico_urbanxp;

public class DescontoPremium implements Desconto {
    @Override
    public double calcularPrecoFinal(double precoBase) {
        double valorFinal = precoBase - 30.0;
        return (valorFinal > 0) ? valorFinal : 0;
    }
}
