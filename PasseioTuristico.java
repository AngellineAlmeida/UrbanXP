package dominio_urbanxp;

import java.time.LocalDateTime;

public class PasseioTuristico extends Experiencia {
    private String pontoEncontro;
    private String nomeGuia;

    public PasseioTuristico(int id, String titulo, String descricao, LocalDateTime dataHora, int capacityMax, double precoBase, String pontoEncontro, String nomeGuia) {
        super(id, titulo, descricao, dataHora, capacityMax, precoBase);
        this.pontoEncontro = pontoEncontro;
        this.nomeGuia = nomeGuia;
    }

    @Override
    public void mostrarExperiencia() {
        System.out.println(String.format("[PASSEIO] ID: %d | %s | Guia: %s | Ponto de Encontro: %s | Data: %s | Preço Base: R$ %.2f",
                getID(), getTitulo(), nomeGuia, pontoEncontro, getDataHora(), getPrecoBase()));
    }
}
