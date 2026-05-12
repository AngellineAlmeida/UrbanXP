import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;

public class Workshop extends Experiencia {
    private String ingredientesEMateriais;

    public String getIngredientesEMateriais() {
        return ingredientesEMateriais;
    }

    public void setIngredientesEMateriais(String ingredientesEMateriais) {
        this.ingredientesEMateriais = ingredientesEMateriais;
    }

    @Override
    public void criarExperiencia(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do evento: ");
        String titulo = scan.nextLine();
        System.out.println("Digite uma breve descrição do evento: ");
        String descricao = scan.nextLine();
        System.out.println("Digite a data e hora do evento: ");
        String stringDataHora = scan.nextLine();
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        Date dataHora = (Date) formatador.parse(stringDataHora);
        System.out.println("Digite a capacidade máxima de pessoas do evento: ");
        int capacidadeMax = scan.nextInt();
        System.out.println("Digite o preço base da entrada: ");
        int preco = scan.nextInt();
        System.out.println("Digite os ingredientes e materiais que são necessários serem levados: ");
        String ingredientesEMateriais = scan.nextLine();
        setTitulo(titulo);
        setDescricao(descricao);
        setDataHora(dataHora);
        setCapacidadeMax(capacidadeMax);
        setPrecoBase(preco);
        setIngredientesEMateriais(ingredientesEMateriais);
    }
}
