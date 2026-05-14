package dominio_urbanxp;

import java.time.LocalDateTime;

public abstract class Experiencia {
    private int id;
    private String titulo;
    private String descricao;
    private LocalDateTime dataHora;
    private int capacityMax;
    private double precoBase;

    private String patrocinador = "Nenhum";
    private String brinde = "Nenhum";

    public Experiencia(int id, String titulo, String descricao, LocalDateTime dataHora, int capacityMax, double precoBase) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.dataHora = dataHora;
        this.capacityMax = capacityMax;
        this.precoBase = precoBase;
    }

    public Experiencia comPatrocinador(String patrocinador) {
        this.patrocinador = patrocinador;
        return this;
    }

    public Experiencia comBrinde(String brinde) {
        this.brinde = brinde;
        return this;
    }

    public abstract void mostrarExperiencia();

    public int getID() { return id; }
    public String getTitulo() { return titulo; }
    public double getPrecoBase() { return precoBase; }
    public LocalDateTime getDataHora() { return dataHora; }
    public String getDescricao() { return descricao; }
    public int getCapacidadeMax() { return capacityMax; }
    public String getPatrocinador() { return patrocinador; }
    public String getBrinde() { return brinde; }
}
