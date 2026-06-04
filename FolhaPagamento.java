import java.util.ArrayList;
import java.util.Scanner;

public class FolhaPagamento {
        
        private static final double SALARIO_BASE = 2000.00;
        private String funcionario;
        private int matricula;
        private double percentualComissao; // Apenas para comissionados
        private int quantidadeProduzida; // Apenas para por produção
        private double vendasRealizadas; // Apenas para comissionados puros
        private double valorPorPeca; // Apenas para por produção   
        private int opçãoMenu;
        public FolhaPagamento(String funcionario, int matricula, double percentualComissao, int quantidadeProduzida, int opçãoMenu, double valorPorPeca, 
        double vendasRealizadas) {// Construtor para inicializar os atributos
        this.funcionario = funcionario;
        this.matricula = matricula;
        this.percentualComissao = percentualComissao;
        this.quantidadeProduzida = quantidadeProduzida;
        this.valorPorPeca = valorPorPeca;
        this.vendasRealizadas = vendasRealizadas;
        this.opçãoMenu = opçãoMenu;
    }
public double calcularSalarioFinal() {
            switch (opçãoMenu) {
                case 2 -> {
                    return SALARIO_BASE + (vendasRealizadas * (percentualComissao/100));
                }
                case 3 -> {
                    return SALARIO_BASE + (valorPorPeca * quantidadeProduzida);
                }
                case 1 -> {
                    return SALARIO_BASE;
                }
                default -> {
                    return 0;
                }
            }
            
        }
        public static void main(String[] args) {
                  System.out.println("---- A3 Folha de Pagamento -----");
                  ArrayList<FolhaPagamento> ListaColaboradores = new ArrayList<>();
            Scanner teclado = new Scanner(System.in);
            int opcao = -1;
            while (opcao != 0) {
            System.out.println("1 - Cadastrar Funcionario Padrão");
            System.out.println("2 - Cadastrar Funcionario Comissionado");
            System.out.println("3 - Cadastrar Funcionario Por Produção");
            System.out.println("4 - Calcular Folha de Pagamento");
            System.out.println("0 - Sair do Programa");
            System.out.print("Escolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); // Limpar o buffer
           
            if (opcao== 1) {
                System.out.println("Cadastro de Funcionário Padrão");
                System.out.println("Digite a matricula do funcionario: ");
                int matricula = teclado.nextInt();
                teclado.nextLine(); // Limpar o buffer
                System.out.println("Digite o nome do funcionario: ");
                String nome = teclado.nextLine();
                
                //Construtor para criar um colaborador do tipo padrão, com salário fixo
                FolhaPagamento novoColaborador = new FolhaPagamento(nome, matricula, 0, 0, 1, 0, 0);
                ListaColaboradores.add(novoColaborador);
                System.out.println("Colaborador Cadastrado com Sucesso!");
                System.out.println("Pressione Enter para voltar ao menu inicial...");
                teclado.nextLine(); 
            
            } else if (opcao == 2) {
                System.out.println("Cadastrar Funcionario Comissionado");
                System.out.println("Digite a matricula do funcionario: ");
                int matricula = teclado.nextInt();
                teclado.nextLine(); // Limpar o buffer
                System.out.println("Digite o nome do funcionario: ");
                String nome = teclado.nextLine();
                System.out.println("Digite o percentual de comissão: ");
                double percentualComissao = teclado.nextDouble();
                System.out.println("Digite a quantidade de vendas realizadas: ");
                double vendasRealizadas = teclado.nextDouble();
                teclado.nextLine(); // Limpar o buffer
                FolhaPagamento novoColaborador = new FolhaPagamento(nome, matricula, percentualComissao, 0, 2, 
                    0, vendasRealizadas);
                ListaColaboradores.add(novoColaborador);
                System.out.println("Colaborador Cadastrado com Sucesso!");
                System.out.println("Pressione Enter para voltar ao menu inicial...");
                teclado.nextLine(); 
            }
                else if (opcao == 3) {
                    System.out.println("Cadastrar Funcionario Por Produção");
                    System.out.println("Digite a matricula do funcionario: ");
                    int matricula = teclado.nextInt();
                    teclado.nextLine(); // Limpar o buffer
                    System.out.println("Digite o nome do funcionario: ");
                    String nome = teclado.nextLine();
                    System.out.println("Digite a quantidade produzida: ");
                    int quantidadeProduzida = teclado.nextInt();
                    System.out.println("Digite o valor por peça: ");
                    double valorPorPeca = teclado.nextDouble();
                    teclado.nextLine(); // Limpar o buffer
                    FolhaPagamento novoColaborador = new FolhaPagamento(nome, matricula, 0, quantidadeProduzida, 3, valorPorPeca, 0);
                    ListaColaboradores.add(novoColaborador);
                    System.out.println("Colaborador Cadastrado com Sucesso!");
                    System.out.println("Pressione Enter para voltar ao menu inicial...");
                    teclado.nextLine(); 
                }
                else if (opcao == 4) {
                    
                    System.out.println("Calculando Folha de Pagamento...");
                     if (ListaColaboradores.isEmpty()) {
                    System.out.println("Nenhum colaborador encontrado. Retorne ao Menu Inicial para cadastrar um colaborador.");
                    System.out.println("Pressione Enter para voltar ao menu inicial...");
                    teclado.nextLine();
                     }
                    else{
                        System.out.println("-----------------------------------");
                        System.out.println("Total de Funcionários cadastrados: " + ListaColaboradores.size());
                        System.out.println("-----------------------------------");
                      for (FolhaPagamento colaborador: ListaColaboradores){
                        double salarioBase= SALARIO_BASE;
                        double extras = 0.0;
                        String tipofuncionario = "";
                        switch (colaborador.opçãoMenu) {
                            case 1 -> tipofuncionario = "Padrão";
                            case 2 -> {
                                tipofuncionario = "Comissionado";
                                extras = colaborador.vendasRealizadas * (colaborador.percentualComissao/100);
                            }
                            case 3 -> {
                                tipofuncionario = "Por Produção";
                                extras = colaborador.valorPorPeca * colaborador.quantidadeProduzida;
                            }
                        }
                      double salarioFinal = colaborador.calcularSalarioFinal();
                      
                      System.out.printf("Funcionário: %s | Matrícula: %d %n Tipo: %s %n Salário Base: R$ %.2f %n Extras: R$ %.2f %n Salário Final: R$ %.2f%n",
                      colaborador.funcionario, colaborador.matricula, tipofuncionario, salarioBase, extras, salarioFinal);
                        System.out.println("-----------------------------------");
                        
                    }   
                        System.out.println("Pressione Enter para voltar ao menu inicial...");
                        teclado.nextLine();             
                }   
                }
            }
                 if (opcao == 0) {
                    System.out.println("Saindo do Programa. Obrigado!");
                    teclado.nextLine();
                 }

            }             
                }
            
        






    
    
    
           

            
        