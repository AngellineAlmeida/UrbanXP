import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Show extends Experiencia {
    private String artistaNome;

    public String getArtistaNome() {
        return artistaNome;
    }

    public void setArtistaNome(String artistaNome) {
        this.artistaNome = artistaNome;
    }

    @Override
    public void criarExperiencia(int id){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do evento: ");
        String titulo = scan.nextLine();
        System.out.println("Digite uma breve descrição do evento: ");
        String descricao = scan.nextLine();
        System.out.println("Digite a data e hora do evento: (dd-MM-yyyy HH:mm)");
        String stringDataHora = scan.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        LocalDateTime dataHora = LocalDateTime.parse(stringDataHora, formatador);
        System.out.println("Digite a capacidade máxima de pessoas do evento: ");
        int capacidadeMax = scan.nextInt();
        System.out.println("Digite o preço base da entrada: ");
        float preco = scan.nextFloat();
        System.out.println("Digite o nome do artista principal: ");
        String artista = scan.nextLine();
        setID(id);
        setTitulo(titulo);
        setDescricao(descricao);
        setDataHora(dataHora);
        setCapacidadeMax(capacidadeMax);
        setPrecoBase(preco);
        setArtistaNome(artista);
    }

    public void mostrarExperiencia(){
        System.out.println("--Dados do evento--\nID: " + getID() + "\nTitulo: " + getTitulo() + "\nDescrição: " + getDescricao() + "\nData e hora: " + getDataHora()
                + "\nCapacidade: " + getCapacidadeMax() + "\nPreço base: " + getPrecoBase() + "\nArtista principal: " + getArtistaNome());
    }
}
