package dominio_urbanxp;

import java.time.LocalDateTime;

public class Show extends Experiencia {
    private String artistaNome;

    public Show(int id, String titulo, String descricao, LocalDateTime dataHora, int capacityMax, double precoBase, String artistaNome) {
        super(id, titulo, descricao, dataHora, capacityMax, precoBase);
        this.artistaNome = artistaNome;
    }

    @Override
    public void mostrarExperiencia() {
        System.out.println(String.format("[SHOW] ID: %d | %s | Artista: %s | Data: %s | Preço Base: R$ %.2f | Patrocinador: %s",
                getID(), getTitulo(), artistaNome, getDataHora(), getPrecoBase(), getPatrocinador()));
    }
}
