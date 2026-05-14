##  Autores
* **Angelline Almeida**
* **Eduardo Liscano**
* **Kauã Dias**
* **Murillo Roque**


---

##  Funcionalidades Implementadas
* **Gerenciamento de Eventos:** Cadastro e remoção dinâmica de Shows, Passeios Turísticos e Workshops gastronômicos.
* **Venda de Ingressos:** Fluxo completo de reserva com cálculo automático de descontos baseado no perfil do cliente (Padrão, Estudante ou Premium).
* **Módulo de Relatórios Gerenciais:** Listagem sob demanda com ordenação inteligente e enxuta por Data de Realização, Preço Base ou Ordem Alfabética do Título.
* **Trânsito de Estados:** Controle rígido de fluxo do ingresso através de Enums (RESERVADO, PAGO e CANCELADO).

---

##  Conceitos de POO Aplicados
* **Encapsulamento:** Todos os atributos são estritamente privados (`private`) e controlados por métodos modificadores de acesso públicos.
* **Herança e Abstração:** Classe mãe abstrata `Experiencia` servindo de base obrigatória para reutilização de lógica e herança das categorias filhas.
* **Polimorfismo:** Aplicação no cálculo flexível de políticas de desconto (via Interface) e exibição das categorias de eventos.
* **Uso da palavra-chave `super`:** Reaproveitamento do construtor base na inicialização de objetos complexos.
* **Classes Anônimas:** Implementação dinâmica dos relatórios através de instâncias pontuais de `Comparator`.
* **Construção Gradual e Fluida:** Uso de setters fluidos que retornam `this` para tratamento de dados opcionais como brindes e patrocinadores.
