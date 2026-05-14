package visao_urbanxp;

import dominio_urbanxp.*;
import servico_urbanxp.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Map<Integer, Experiencia> listaEventos = new LinkedHashMap<>();
    List<Ingresso> listaIngressos = new ArrayList<>();
    Scanner scan = new Scanner(System.in);
    DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
    boolean ativo = true;
    
    listaEventos.put(1, new Show(1, "Rock na Praça", "Show de rock urbano", LocalDateTime.of(2026, 6, 20, 21, 0), 500, 100.0, "Banda POO"));
    listaEventos.put(2, new PasseioTuristico(2, "Tour Grafite", "Passeio pelas artes", LocalDateTime.of(2026, 6, 21, 14, 0), 30, 50.0, "Praça Central", "Carlos"));
    listaEventos.put(3, new Workshop(3, "MasterChef Urbano", "Oficina de culinária", LocalDateTime.of(2026, 6, 22, 19, 0), 15, 120.0, "Avental e Faca de Chef"));21

    do {
      System.out.println("\n=== SISTEMA URBANXP ===");
      System.out.println("1) Realizar uma reserva / Emitir Ingresso");
      System.out.println("2) Relatórios Gerenciais (Ordenação)");
      System.out.println("3) Gerenciar eventos (Cadastrar/Remover)");
      System.out.println("4) Sair");
      System.out.print("Escolha uma opção: ");

      int opcao = scan.nextInt();
      scan.nextLine();

      switch (opcao) {
        case 1:
          if (listaEventos.isEmpty()) {
            System.out.println("Nenhum evento cadastrado no sistema!");
            break;
          }
          System.out.print("Nome do participante: ");
          String nomeCli = scan.nextLine();

          System.out.println("Selecione o perfil de desconto:");
          System.out.println("1) Padrão (Sem desconto)\n2) Estudante (50% de desconto)\n3) Premium (R$ 30,00 de desconto fixo)");
          int perfil = scan.nextInt();

          Desconto desconto;
          if (perfil == 2) desconto = new Desconto50Porcento();
          else if (perfil == 3) desconto = new DescontoPremium();
          else desconto = new DescontoPadrao();

          Cliente cliente = new Cliente(nomeCli, desconto);

          System.out.println("\nEventos disponíveis:");
          for (Experiencia e : listaEventos.values()) {
            e.mostrarExperiencia();
          }

          System.out.print("Digite o ID do evento desejado: ");
          int idEv = scan.nextInt();
          scan.nextLine();

          if (!listaEventos.containsKey(idEv)) {
            System.out.println("ID do evento inválido!");
            break;
          }

          Experiencia eventoSelecionado = listaEventos.get(idEv);
          Ingresso nIngresso = new Ingresso(cliente, eventoSelecionado);

          double precoCalculado = cliente.calcularValorFinal(eventoSelecionado.getPrecoBase());
          System.out.printf("Preço final calculado do ingresso: R$ %.2f\n", precoCalculado);

          System.out.print("Confirmar e pagar esse ingresso agora? (Sim/Não): ");
          String resposta = scan.nextLine();

          if (resposta.equalsIgnoreCase("Sim")) {
            nIngresso.setEstado(Estado.PAGO);
            System.out.println("Ingresso EMITIDO e PAGO com sucesso!");
          } else {
            nIngresso.setEstado(Estado.CANCELADO);
            System.out.println("Operação cancelada. Ingresso movido para o estado CANCELADO.");
          }

          nIngresso.mostrarIngresso();
          listaIngressos.add(nIngresso);
          break;

        case 2:
          if (listaEventos.isEmpty()) {
            System.out.println("Não há eventos para gerar relatórios.");
            break;
          }
          System.out.println("Escolha o critério de ordenação:");
          System.out.println("1) Data de realização\n2) Preço Base\n3) Ordem alfabética do título");
          int criterio = scan.nextInt();

          List<Experiencia> listaParaOrdenar = new ArrayList<>(listaEventos.values());

          if (criterio == 1) {
            listaParaOrdenar.sort(new Comparator<Experiencia>() {
              @Override
              public int compare(Experiencia e1, Experiencia e2) {
                return e1.getDataHora().compareTo(e2.getDataHora());
              }
            });
          } else if (criterio == 2) {
            listaParaOrdenar.sort(new Comparator<Experiencia>() {
              @Override
              public int compare(Experiencia e1, Experiencia e2) {
                return Double.compare(e1.getPrecoBase(), e2.getPrecoBase());
              }
            });
          } else if (criterio == 3) {
            listaParaOrdenar.sort(new Comparator<Experiencia>() {
              @Override
              public int compare(Experiencia e1, Experiencia e2) {
                return e1.getTitulo().compareToIgnoreCase(e2.getTitulo());
              }
            });
          }

          System.out.println("\n--- RELATÓRIO DE EVENTOS ORDENADO ---");
          for (Experiencia e : listaParaOrdenar) {
            e.mostrarExperiencia();
          }
          break;

        case 3:
          System.out.println("1) Adicionar evento\n2) Remover evento");
          int subOpcao = scan.nextInt();
          if (subOpcao == 1) {
            System.out.print("Digite um ID numérico único para o evento: ");
            int novoId = scan.nextInt();
            scan.nextLine();

            System.out.print("Título do evento: ");
            String tit = scan.nextLine();
            System.out.print("Descrição breve: ");
            String desc = scan.nextLine();
            System.out.print("Data e hora (no formato dd-MM-yyyy HH:mm): ");
            String dataStr = scan.nextLine();

            LocalDateTime dataHora = LocalDateTime.parse(dataStr, formatador);

            System.out.print("Capacidade máxima: ");
            int cap = scan.nextInt();
            System.out.print("Preço base: ");
            double preco = scan.nextDouble();
            scan.nextLine();

            System.out.println("Qual a categoria:\n1) Show\n2) Passeio Turístico\n3) Workshop");
            int cat = scan.nextInt();
            scan.nextLine();

            Experiencia novaExp = null;
            if (cat == 1) {
              System.out.print("Nome do artista principal: ");
              String artista = scan.nextLine();
              novaExp = new Show(novoId, tit, desc, dataHora, cap, preco, artista);

              System.out.print("Deseja adicionar Patrocinador opcional? (vazio para pular): ");
              String pat = scan.nextLine();
              if(!pat.trim().isEmpty()) novaExp.comPatrocinador(pat);

            } else if (cat == 2) {
              System.out.print("Ponto de encontro: ");
              String ponto = scan.nextLine();
              System.out.print("Nome do guia: ");
              String guia = scan.nextLine();
              novaExp = new PasseioTuristico(novoId, tit, desc, dataHora, cap, preco, ponto, guia);
            } else if (cat == 3) {
              System.out.print("Materiais/Ingredientes necessários: ");
              String mat = scan.nextLine();
              novaExp = new Workshop(novoId, tit, desc, dataHora, cap, preco, mat);
            }

            if (novaExp != null) {
              listaEventos.put(novoId, novaExp);
              System.out.println("Evento cadastrado com sucesso!");
            }
          } else if (subOpcao == 2) {
            System.out.print("Digite o ID do evento que deseja remover: ");
            int idRemover = scan.nextInt();
            listaEventos.remove(idRemover);
            System.out.println("Evento removido.");
          }
          break;

        case 4:
          ativo = false;
          System.out.println("Encerrando o sistema...");
          break;
        default:
          System.out.println("Opção inválida.");
          break;
      }
    } while (ativo);
    scan.close();
  }
}
