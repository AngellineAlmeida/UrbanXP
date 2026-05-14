package dominio_urbanxp;

import java.time.LocalDateTime;

public class Workshop extends Experiencia {
    private String ingredientesEMateriais;

    public Workshop(int id, String titulo, String descricao, LocalDateTime dataHora, int capacityMax, double precoBase, String ingredientesEMateriais) {
        super(id, titulo, descricao, dataHora, capacityMax, precoBase);
        this.ingredientesEMateriais = ingredientesEMateriais;
    }

    @Override
    public void mostrarExperiencia() {
        System.out.println(String.format("[WORKSHOP] ID: %d | %s | Materiais: %s | Data: %s | Preço Base: R$ %.2f",
                getID(), getTitulo(), ingredientesEMateriais, getDataHora(), getPrecoBase()));
    }
}
