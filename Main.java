import java.util.LinkedHashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    void main(String[] args){
        LinkedHashMap<Integer, Experiencia> listaEventos = new LinkedHashMap<>();
        boolean ativo = true;
        Scanner scan = new Scanner(System.in);
        Experiencia nExperiencia = null;
        Ingresso nIngresso = null;
        int id;
        do{
            System.out.println("Bem vindos ao sistemas da UrbanXP o que deseja fazer:\n1) Realizar uma reserva\n2) Relatórios Gerenciais\n3) Gerenciar eventos\n4) Sair");
            var opcao = scan.nextInt();
            switch(opcao){
                case 1:
                    System.out.println("Nome do participante: ");
                    String nome = scan.nextLine();
                    System.out.println("Digite o CPF do participante: ");
                    long cpf = scan.nextLong();
                    System.out.println("Digite o ID do evento: ");
                    id = scan.nextInt();
                    nIngresso.criarIngresso(nome, cpf, listaEventos.get(id));
                    nIngresso.mostrarIngresso();
                    System.out.println("O participante se encaixa em qual grupo: 1) Regular 2) Estudando 3) Premium: ");
                    int grupo = scan.nextInt();
                    // ALGUEM FAZ A PARTE DO CÁLCULO DO PREÇO AQUI FAZ FAVOR
                    System.out.println("Preço final do ingresso é ");
                    System.out.println("Confirmar esse ingresso? Sim/Não");
                    String resposta = scan.nextLine();
                    if(Objects.equals(resposta, "Sim")){
                        nIngresso.setEstado(Estado.Pago);
                        System.out.println("Ingresso feito com sucesso");
                    }
                    else if(Objects.equals(resposta, "Não")) {
                        nIngresso.setEstado(Estado.Cancelado);
                        System.out.println("Ingresso cancelado");
                    }
                    else{
                        System.out.println("Algo de errado ocorreu, por favor tente novamente");
                    }
                    break;
                case 2:
                    System.out.println("Qual ordem você deseja ver os eventos:\n1) Data de realização\n2) Preço Base\n3) Ordem alfabética");
                    switch(opcao){
                        // NÃO CONSEGUI FAZER A IMPRESSÃO POR ORDENAÇÕES DIFERENTES
                        case 1:

                        case 2:

                            break;
                        case 3:

                            break;
                        default:
                            System.out.println("Algo de errado ocorreu, por favor tente novamente");
                            break;
                    }
                    break;
                case 3:
                    System.out.println("Escolha uma opção:\n1) Adicionar evento\n2) Remover evento");
                    opcao = scan.nextInt();
                    switch(opcao){
                        case 1:
                            System.out.println("Qual o tipo de evento que deseja adicionar:\n1) Passeio Turístico\n2) Show\n3) Workshop");
                            opcao = scan.nextInt();
                            switch(opcao){
                                case 1:
                                    nExperiencia = new PasseioTuristico();
                                    System.out.println("--Criação de Evento--\nPrimeiro digite o número de identificação do evento: ");
                                    id = scan.nextInt();
                                    listaEventos.put(id, nExperiencia);
                                    nExperiencia.criarExperiencia(id);
                                    break;
                                case 2:
                                    nExperiencia = new Show();
                                    System.out.println("--Criação de Evento--\nPrimeiro digite o número de identificação do evento: ");
                                    id = scan.nextInt();
                                    listaEventos.put(id, nExperiencia);
                                    nExperiencia.criarExperiencia(id);
                                    break;
                                case 3:
                                    nExperiencia = new Workshop();
                                    System.out.println("--Criação de Evento--\nPrimeiro digite o número de identificação do evento: ");
                                    id = scan.nextInt();
                                    listaEventos.put(id, nExperiencia);
                                    nExperiencia.criarExperiencia(id);
                                    break;
                                default:
                                    System.out.println("Algo de errado ocorreu, por favor tente novamente");
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("Digite o ID do evento que deseja remover");
                            id = scan.nextInt();
                            listaEventos.remove(id);
                            break;
                        default:
                            System.out.println("Algo de errado ocorreu, por favor tente novamente");
                            break;
                    }
                    break;
                case 4:
                    ativo = false;
                    break;
                default:
                    System.out.println("Algo de errado ocorreu, por favor tente novamente");
                    break;
            }
        }while(ativo);
    }
}
