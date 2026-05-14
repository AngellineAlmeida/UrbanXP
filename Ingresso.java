enum Estado{
    Reservado,
    Pago,
    Cancelado
}

public class Ingresso {
    private Estado estado;
    private String nome;
    private long cpf;
    private Experiencia evento;

    public void criarIngresso(String nome, long cpf, Experiencia evento){
        setNome(nome);
        setCpf(cpf);
        setEvento(evento);
        setEstado(Estado.Reservado);
    }

    public void mostrarIngresso(){
        System.out.println("--Informações do ingresso--\nNome: " + getNome() + "\nCPF: " + getCpf() + "\nEvento: " + evento.getTitulo() + "\nEstado: " + getEstado());
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public Experiencia getEvento() {
        return evento;
    }

    public void setEvento(Experiencia evento) {
        this.evento = evento;
    }
}
