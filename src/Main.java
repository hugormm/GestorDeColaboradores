import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    //Variaveis Globais
    public static Scanner input = new Scanner(System.in);
    public static ArrayList<Colaborador> lista = new ArrayList<Colaborador>();
    public static double despesas = 0;


    public static void main(String[] args) {

        //Variaveis Locais
        int opcao;

        //Executar
        do {
            System.out.println();
            exibirMenu();
            System.out.print("\nOpcao: ");
            opcao = input.nextInt();
            input.nextLine();
            limpa();
            switch (opcao) {
                case 1:
                    registarColaborador();
                    break;
                case 2:
                    if (lista.size() == 0) {
                        System.out.println("Nao ha colaboradores registados");
                    } else {
                        editarColaborador();
                    }
                    break;
                case 3:
                    if (lista.size() == 0) {
                        System.out.println("Nao ha colaboradores registados");
                    } else {
                        buscarColaborador();
                    }
                    break;
                case 4:
                    if (lista.size() == 0) {
                        System.out.println("Nao ha colaboradores registados");
                    } else {
                        despedirColaborador();
                    }
                    break;
                case 5:
                    if (lista.size() == 0) {
                        System.out.println("Nao ha colaboradores registados");
                    } else {
                        listarColaboradores();
                    }
                    break;
                case 6:
                    if (lista.size() == 0){
                        System.out.println("Nao ha colaboradores registados");
                    }
                    else {
                        sortearColaboradores();
                    }
                    break;
                case 7:
                    if (lista.size() == 0) {
                        System.out.println("Nao ha colaboradores registados");
                    } else {
                        buscarBalizaColaboradores();
                    }
                    break;
                case 8:
                    if (lista.size() == 0) {
                        System.out.println("Nao ha colaboradores registados");
                    } else {
                        despesasColaboradores();
                    }
                    break;
                case 0:
                    System.out.println("A Sair...");
                    break;
                default:
                    System.out.println("Opcao Invalida!");
                    break;
            }
            System.out.println();
            enter();
            limpa();
        } while (opcao != 0);
    }

    //Funcoes
    public static void exibirMenu() {
        System.out.println("===== Gestor de Colaboradores =====");
        System.out.println();
        System.out.println("1 - Registar novo colaborador.");
        System.out.println("2 - Editar colaborador.");
        System.out.println("3 - Buscar colaborador por nome.");
        System.out.println("4 - Despedir colaborador.");
        System.out.println("5 - Lista de colaboradores.");
        System.out.println();
        System.out.println("6 - Lista de colaboradores por ordem salarial.");
        System.out.println();
        System.out.println("7 - Buscar colaboradores por baliza de salario.");
        System.out.println("8 - Despesas dos colaboradores.");
        System.out.println();
        System.out.println("0 - Logout.");

    }

    public static void registarColaborador() {
        String nome, cargo;
        int idade;
        double salario;

        System.out.println("--- Registar Colaborador ---");
        System.out.print("\nNome: ");
        nome = input.nextLine();
        System.out.print("Idade: ");
        idade = input.nextInt();
        input.nextLine();
        System.out.print("Cargo: ");
        cargo = input.nextLine();
        System.out.print("Salario: ");
        salario = input.nextDouble();
        input.nextLine();
        despesas += salario;
        lista.add(new Colaborador(nome, idade, cargo, salario));
        System.out.println("\nSUCESSO!\n");
    }

    public static void editarColaborador() {
        int id, opcao, nova_idade;
        String novo_nome, novo_cargo;
        double novo_salario;

        System.out.println("--- Editar Colaborador ---");
        System.out.println();

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + 1 + ") ");
            lista.get(i).getficha();
        }

        System.out.print("\nDigite o id do colaborador a ser editado: ");
        id = input.nextInt();
        input.nextLine();
        if (id < 0 || id > lista.size()) {
            System.out.println("\nId Invalido!");
        } else {
            System.out.println();
            System.out.println("=== " +lista.get(id - 1).nome+ " (" +lista.get(id - 1).idade+ " anos) - [" +lista.get(id - 1).cargo+ "] {" +lista.get(id - 1).salario+ "} ===");
            exibirSubmenu();
            System.out.print("\nSelecione o que sera editado neste colaborador: ");
            opcao = input.nextInt();
            input.nextLine();
            switch (opcao) {
                case 1:
                    System.out.print("\nDigite o que ira substituir (" + lista.get(id - 1).nome + ") : ");
                    novo_nome = input.nextLine();
                    lista.get(id - 1).setNome(novo_nome);
                    break;
                case 2:
                    System.out.print("\nDigite o que ira substituir (" + lista.get(id - 1).idade + ") : ");
                    nova_idade = input.nextInt();
                    input.nextLine();
                    lista.get(id - 1).setIdade(nova_idade);
                    break;
                case 3:
                    System.out.print("\nDigite o que ira substituir (" + lista.get(id - 1).cargo + ") : ");
                    novo_cargo = input.nextLine();
                    lista.get(id - 1).setCargo(novo_cargo);
                    break;
                case 4:
                    System.out.print("\nDigite o que ira substituir (" + lista.get(id - 1).salario + ") : ");
                    novo_salario = input.nextDouble();
                    input.nextLine();
                    despesas -= lista.get(id - 1).salario;
                    lista.get(id - 1).setSalario(novo_salario);
                    despesas += lista.get(id - 1).salario;
                    break;
                default:
                    System.out.println("\nOpcao Invalida");
                    break;
            }
            System.out.println();
            System.out.println("=== " +lista.get(id - 1).nome+ " (" +lista.get(id - 1).idade+ " anos) - [" +lista.get(id - 1).cargo+ "] {" +lista.get(id - 1).salario+ "} ===");
            System.out.println("\nSucesso");
        }
    }

    public static void buscarColaborador() {
        String nome_digitado;
        boolean encontrado = false;

        System.out.println("--- Buscar Colaborador por nome ---");
        System.out.print("\nDigite o nome a ser buscado: ");
        nome_digitado = input.nextLine();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).nome.equalsIgnoreCase(nome_digitado)) {
                System.out.println();
                System.out.println("=== " +lista.get(i).nome+ " (" +lista.get(i).idade+ " anos) - [" +lista.get(i).cargo+ "] {" +lista.get(i).salario+ "} ===");
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("\nColaborador nao encontrado.");
        }
    }

    public static void despedirColaborador() {
        int id;
        String escolha;

        System.out.println("--- Despedir Colaborador ---");
        System.out.println();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + 1 + ") ");
            lista.get(i).getficha();
        }
        System.out.print("\nDigite o codigo do colaborador a ser despedido: ");
        id = input.nextInt();
        input.nextLine();
        if (id < 0 || id > lista.size()) {
            System.out.println("\nId Invalido!");
        }
        else {
            do {
                System.out.print("\nTens a certeza desta operacao? (sim/nao) ");
                escolha = input.nextLine();
                if (escolha.equalsIgnoreCase("sim")) {
                    despesas -= lista.get(id - 1).salario;
                    lista.remove(id - 1);
                    System.out.println();
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.print(i + 1 + ") ");
                        lista.get(i).getficha();
                    }
                    System.out.println("\nSucesso!");
                } else if (escolha.equalsIgnoreCase("nao")) {
                    System.out.println("\nOperacao Cancelada.");
                } else {
                    System.out.println("\nEscolha invalida!");
                }
            } while (!escolha.equalsIgnoreCase("sim") && !escolha.equalsIgnoreCase("nao"));
        }
    }

    public static void listarColaboradores() {

        System.out.println("--- Lista de Colaboradores ---");
        System.out.println();
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + 1 + ") ");
            lista.get(i).getficha();
        }
    }

    public static void sortearColaboradores() {
        ArrayList<Colaborador> lista_clone = new ArrayList<>();
        lista_clone = (ArrayList<Colaborador>)lista.clone();
        lista_clone.sort(Comparator.comparing(Colaborador::getSalario));
        System.out.println("--- Lista de Colaboradores por Ordem Salarial ---\n");
        for (int i = 0; i < lista_clone.size(); i++){
            System.out.print(i + 1 + ") ");
            lista_clone.get(i).getficha();
        }
    }

    public static void buscarBalizaColaboradores() {
        double valor_max, valor_min;
        boolean encontrado = false;

        System.out.println("--- Buscar Colaborador por baliza de salario ---");
        System.out.print("\nDigite o valor minimo de salario a ser buscado: ");
        valor_min = input.nextDouble();
        input.nextLine();
        do {
            System.out.print("Digite o valor maximo de salario a ser buscado: ");
            valor_max = input.nextDouble();
            input.nextLine();
            System.out.println();
            if (valor_max < valor_min) {
                System.out.println("O valor introduzido e menor que o valor minimo.\n");
            }
        } while (valor_max < valor_min);

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).salario >= valor_min && lista.get(i).salario <= valor_max) {
                lista.get(i).getficha();
                encontrado = true;
            }
        }
        if(!encontrado){
            System.out.println("Nao ha colaboradores a mostrar.");
        }
    }

    public static void despesasColaboradores() {
        System.out.println("--- Lista de Colaboradores registados ---\n");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + 1 + ") ");
            lista.get(i).getficha();
        }

        System.out.println("\n--- TOTAL: (" + despesas + ") ---\n");

    }

    public static void exibirSubmenu() {
        System.out.println();
        System.out.println("1 - Nome.");
        System.out.println("2 - Idade.");
        System.out.println("3 - Cargo.");
        System.out.println("4 - Salario.");
    }

    public static void enter() {
        String enter;

        System.out.println("Pressione ENTER para continuar...");
        enter = input.nextLine();
    }

    public static void aguarde(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException erro) {
            erro.printStackTrace();
        }
    }

    public static void limpa() {
        for (int i = 0; i < 15; i++) {
            System.out.println();
        }
    }

}