package dominio_urbanxp;

public class Ingresso {
    private Estado estado;
    private Cliente cliente;
    private Experiencia evento;

    public Ingresso(Cliente cliente, Experiencia evento) {
        this.cliente = cliente;
        this.evento = evento;
        this.estado = Estado.RESERVADO;
    }

    public void mostrarIngresso() {
        double valorFinal = cliente.calcularValorFinal(evento.getPrecoBase());
        System.out.println("\n-------------------------------------------");
        System.out.println("            INGRESSO URBANXP               ");
        System.out.println("-------------------------------------------");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("Evento: " + evento.getTitulo());
        System.out.println("Data/Hora: " + evento.getDataHora());
        System.out.println("Status Atual: " + estado);
        System.out.println(String.format("Preço Pago: R$ %.2f", valorFinal));
        System.out.println("-------------------------------------------\n");
    }

    public Estado getEstado() { return estado; }
    public void setEstado(Estado estado) { this.estado = estado; }
    public Cliente getCliente() { return cliente; }
    public Experiencia getEvento() { return evento; }
}
