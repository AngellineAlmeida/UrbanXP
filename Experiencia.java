import java.util.Date;

public abstract class Experiencia {
    private String titulo;
    private String descricao;
    private Date dataHora;
    private int capacidadeMax;
    private int precoBase;

    public abstract void criarExperiencia();

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public int getCapacidadeMax() {
        return capacidadeMax;
    }

    public void setCapacidadeMax(int capacidadeMax) {
        this.capacidadeMax = capacidadeMax;
    }

    public int getPrecoBase() {
        return precoBase;
    }

    public void setPrecoBase(int precoBase) {
        this.precoBase = precoBase;
    }
}
