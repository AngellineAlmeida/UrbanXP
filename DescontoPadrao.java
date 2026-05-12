public class DescontoPadrao implements Desconto {
    @Override
    public double calcularPrecoFinal(double precoBase) {
        return precoBase;
    }
}
