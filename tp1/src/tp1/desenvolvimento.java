package tp1;
import java.util.Scanner;
import java.util.ArrayList;

//Arthur taylor de Jesus Popov - 190084642
//Trabalho Pratico 1 - OO - 2021.1

public class desenvolvimento {
		
	//array list das informações dos clientes
	static ArrayList<String> nomeCliente = new ArrayList<String>();
	static ArrayList<String> telefoneCliente = new ArrayList<String>();
	static ArrayList<String> enderecoCliente = new ArrayList<String>();
	
	//array list das informações do produto
	static ArrayList<String> nomeDoProduto = new ArrayList<String>();
	static ArrayList<String> descricaoDoProduto = new ArrayList<String>();	
	static ArrayList<Integer> quantidadeNoEstoque = new ArrayList<Integer>();
	static ArrayList<Float> lucroNoProduto = new ArrayList<Float>();
	static ArrayList<Float> precoDoProduto = new ArrayList<Float>();
	  
	
	
	public static void main(String[] args) {
		
		menuMaker();//para deixar a main mais enxuta possivel deixei apenas a chamada de outro metodo
		
	}
	
	
	public static void menuMaker(){//este metodo printa o menu ate a condição de parada, e tambem chama os outros metodos que farao as outras partes do programa
		
		int opcao;
		
			preCadastramento();//Função para gerar as 10 informações genericas sobre clientes e produtos, se quiser usar o codigo sem os pre cadastramentos basta comenta-la!
		
			do {
			
			
				System.out.println("======= Bem Vindo ao sistema de gerenciamento =======");
				System.out.println("* Por favor entre com a opção desejada! *");
				System.out.println("1 - Cadastro de novo cliente");
				System.out.println("2 - Busca por cliente");
				System.out.println("3 - Cadastro de novo produto");
				System.out.println("4 - Busca por produto");
				System.out.println("5 - Cadastro de venda");
				System.out.println("6 - Mostrar itens em estoque");
				System.out.println("7 - Sair");
			
				Scanner lerOpcao = new Scanner (System.in);
			
				opcao = lerOpcao.nextInt();
			
				switch(opcao) {
			
				case 1:
					cadastraCliente();
					break;
				
				case 2:
					buscaCliente();
					break;
			
				case 3:
					cadastraProduto();
					break;
				
				case 4:
					pesquisaProduto();
					break;
			
				case 5:
					cadastraVenda();
					break;
				
				case 6:
					mostraProdutos();
					break;
				
				case 7:
					System.out.println("Obrigado por utilizar o programa de gerenciamento!");
					System.exit(0);
					break;
				
				default:
					System.out.println("Opção inválida, por favor entre com uma das opções listadas");
					lerOpcao.nextLine();//buffer
					lerOpcao.nextLine();//Parando o console para que o usuario possa ler
					break;
								
			} 
		} while(opcao != 7);
	}

	
	public static void cadastraCliente() {
		
		int quantidadeCliente,i = 0;
		String endereco;
		String telefone;
		String nome;
		
		Scanner lerCadastro = new Scanner (System.in);
		
		System.out.println("Digite a quantidade de clientes a serem cadastrados!");
		quantidadeCliente = lerCadastro.nextInt();//recebe a quantidade de clientes a serem cadastrados
					
		lerCadastro.nextLine();
		
		for(i = 0; i<quantidadeCliente;i++) {
			
			//recebendo e armazenando os dados sobre os clientes
			
			System.out.println("Digite o nome a ser cadastrado. ");
			nome = lerCadastro.nextLine();
			nomeCliente.add(nome);
			System.out.println("Digite o endereço a ser cadastrado. ");
			endereco = lerCadastro.nextLine();
			enderecoCliente.add(endereco);
			System.out.println("Digite o telefone a ser cadastrado. ");
			telefone = lerCadastro.nextLine();
			telefoneCliente.add(telefone);			
			
		}
	}
	
	public static void buscaCliente() {
		
		String nomePesquisado,nome,endereco,telefone;
		int i = 0,flag = 2,opcao,j=0;
		
		Scanner lerBusca = new Scanner (System.in);
		
		//Recebendo o nome que deve ser comparado
		System.out.println("Digite o nome a ser pesquisado");
		nomePesquisado = lerBusca.nextLine();
		
		for(i = 0; i < nomeCliente.size();i++) {
				
			if(nomePesquisado.equals(nomeCliente.get(i))) {
				
				//Imprimindo os dados do cliente caso seja cadastrado
				System.out.println("Localizado! Os dados do cliente são os seguintes: ");
				System.out.printf("%s\n", nomeCliente.get(i));
				System.out.printf("%s\n", enderecoCliente.get(i));
				System.out.printf("%s\n", telefoneCliente.get(i));
						
				flag = 1;
				j=i;
				lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
			} else if(flag != 1){
					flag = 0;//caso não seja cadastrado imprime a mensagem somente uma vez
					}
				
		}
		
		if(flag == 1) {//nesta opção é possivel redefinir os dados do cliente pesquisado
			
			do {
			System.out.println("Gostaria de mudar os dados do cadastro?");
			System.out.println("1 - Sim   ||| 2 - Não");
			opcao = lerBusca.nextInt();
			if(opcao == 1) {
				System.out.println("Entre com os dados que deseja que sejam salvos!");
				
				System.out.println("Digite o nome a ser recadastrado. ");
				lerBusca.nextLine();
				nome = lerBusca.nextLine();
				nomeCliente.set(j,nome);
				System.out.println("Digite o endereço a ser recadastrado. ");
				endereco = lerBusca.nextLine();
				enderecoCliente.set(j,endereco);
				System.out.println("Digite o telefone a ser recadastrado. ");
				telefone = lerBusca.nextLine();
				telefoneCliente.set(j,telefone);
				
				
			}else if(opcao == 2) {
				System.out.println("Os dados do cliente permanecerão da forma que estão. Voltando para o menu!");//nesta opção os dados se mantem
				lerBusca.nextLine();//buffer
				lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
			}else {
			System.out.println("Entrada Iválida! Por favor entre com uma opção válida");//esta opção pede que o ususario entre com uma entrada esperada
			lerBusca.nextLine();//buffer
			lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
			}
			}while(opcao != 1 && opcao != 2);//mantem o print até uma condição valida.
			
		}
		
		if(flag == 0) {
				System.out.println("Cliente não encontrado");//imprime a mensagem de nao encontrado caso o cliente nao seja cadastrado
				lerBusca.nextLine();//buffer
				lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
		}
	}
	
	public static void cadastraProduto(){
		
	        int quantidadeProduto,i=0,quantidadeEstoque; 
	        float lucro,precoProduto;
	        String nomeProduto;
	        String descricaoProduto;
	        
	        Scanner ler = new Scanner(System.in);
	        
	        //Pedindo as informaçoes do novo produto.
	        System.out.println("Digite a quantidade de produtos a serem cadastrados:");
	        
	        quantidadeProduto = ler.nextInt();
	       
		 
	        ler.nextLine();//buffer
	        
	        for(i = 0; i < quantidadeProduto; i++) {
	        
	        	//recebendo e armazenando as entradas dos produtos
	        	
	        	System.out.println("Digite o nome do produto:");
	        	nomeProduto = ler.nextLine();    
	        	nomeDoProduto.add(nomeProduto);
	        	System.out.println("Digite a descrição do produto:");
	        	descricaoProduto = ler.nextLine();   
	        	descricaoDoProduto.add(descricaoProduto);
	        	System.out.println("Digite o valor de compra do produto:");	        
	        	precoProduto = ler.nextFloat();
	        	precoDoProduto.add(precoProduto);
	        	System.out.println("Digite a porcentagem de lucro do produto:");	        
	        	lucro = ler.nextFloat();
	        	lucroNoProduto.add(lucro);
	        	System.out.println("Digite a quantidade de estoque desejada para o produto:");	        
	        	quantidadeEstoque = ler.nextInt();
	        	quantidadeNoEstoque.add(quantidadeEstoque);
	        	
	        	ler.nextLine();//buffer
	        	ler.nextLine();//parando o console para o usuario conseguir vizualizar
	        
	        }	   	 	
	 }
	
	public static void pesquisaProduto() {
		
		String produtoPesquisado,nome,descricao;
		int i = 0,flag = 2,opcao,j=0,quantidade;
		float preco,lucro;
		
		Scanner lerBusca = new Scanner (System.in);
		
		//Recebendo o nome do produto que deve ser pesquisado
		System.out.println("Digite o nome a ser pesquisado");
		produtoPesquisado = lerBusca.nextLine();
		
		for(i = 0; i < nomeDoProduto.size();i++) {
				
			if(produtoPesquisado.equals(nomeDoProduto.get(i))) {
				
				//Imprimindo os dados do cliente caso seja cadastrado
				System.out.println("Localizado! Os dados do produto são os seguintes: ");
				System.out.printf("%s\n", descricaoDoProduto.get(i));
				System.out.printf("%s\n", precoDoProduto.get(i));
				System.out.printf("%s\n", lucroNoProduto.get(i));
				System.out.printf("%s\n", quantidadeNoEstoque.get(i));
						
				flag = 1;
				j=i;
				lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
			} else if(flag != 1){
					flag = 0;//caso não seja cadastrado imprime a mensagem somente uma vez
					}
				
		}
		
		if(flag == 1) {//nesta opção é possivel redefinir os dados do produto pesquisado
			
			do {
			System.out.println("Gostaria de mudar os dados do cadastro?");
			System.out.println("1 - Sim   ||| 2 - Não");
			opcao = lerBusca.nextInt();
			if(opcao == 1) {
				System.out.println("Entre com os dados que deseja que sejam salvos!");
				
				System.out.println("Digite o nome a ser recadastrado. ");
				lerBusca.nextLine();
				nome = lerBusca.nextLine();
				nomeDoProduto.set(j,nome);
				System.out.println("Digite a descrição a ser recadastrada. ");
				descricao = lerBusca.nextLine();
				descricaoDoProduto.set(j,descricao);
				System.out.println("Digite o preço a ser recadastrado. ");
				preco = lerBusca.nextFloat();
				precoDoProduto.set(j,preco);
				System.out.println("Digite o lucro a ser recadastrada. ");
				lucro = lerBusca.nextFloat();
				lucroNoProduto.set(j,lucro);
				System.out.println("Digite a nova quantidade de produtos. ");
				quantidade = lerBusca.nextInt();
				quantidadeNoEstoque.set(j,quantidade);
				
			}else if(opcao == 2) {
				System.out.println("Os dados do produto permanecerão da forma que estão");//nesta opção os dados se mantem
				lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
			}else {
			System.out.println("Entrada Iválida! Por favor entre com uma opção válida");//esta opção pede que o ususario entre com uma entrada esperada
			lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
			}
			}while(opcao != 1 && opcao != 2);//mantem o print até uma condição valida.
			
		}
		
		if(flag == 0) {
				System.out.println("Produto não encontrado");//imprime a mensagem de nao encontrado caso o cliente nao seja cadastrado
				lerBusca.nextLine();//parando o console para o usuario conseguir vizualizar
				
		}
	}
	
	public static void cadastraVenda() {
		
		int i = 0, opcao, quantidadeVendida, opcaoProduto,opcaoCadastro = 0,flag = 0;
		
		Scanner lerOpcao = new Scanner (System.in);
		
		//Tratando da parte dos clientes
		
		do {
		for (i = 0; i< nomeCliente.size(); i++) {
			
			System.out.printf("%d. %s \n",i+1,nomeCliente.get(i));		
			
		}
		
		System.out.println("Estes são os clientes cadastrados, por favor entre o numero do cliente que deseja efetuar a venda!");
		opcao = lerOpcao.nextInt() -1;//lê a opção entrada, mas decesce 1 a posição visto que foi acrescido quando foi informado os clientes para o usuario
		
		if(opcao > nomeCliente.size() || opcao < 0) {//Verifica se a opção entrada é valida
			System.out.println("Cliente não cadastrado, por favor entre com um cliente cadastrado.");
			lerOpcao.nextLine();//buffer
			lerOpcao.nextLine();//parando o console para o usuario conseguir vizualizar
			flag = 1;
		}else {
			flag = 0;
		}
		}while(flag == 1);
		
		//Tratando da parte dos produtos
		
		
		do {
			do {
				for (i = 0; i< quantidadeNoEstoque.size(); i++) {
			
					System.out.printf("%d. %s  - quantidade disponivel: %d\n",i+1,nomeDoProduto.get(i),quantidadeNoEstoque.get(i));
				}
		
					System.out.println("Estes são os produtos cadastrados, por favor entre o numero de qual produto esta sendo negociado");
					opcaoProduto = lerOpcao.nextInt() -1;//lê a opção entrada, mas decesce 1 a posição visto que foi acrescido quando foi informado os clientes para o usuario
		
				if(opcaoProduto > quantidadeNoEstoque.size() || opcaoProduto < 0) {//Verifica se a opção entrada é valida
					System.out.println("Produto não cadastrado, por favor entre com um produto cadastrado.");
					lerOpcao.nextLine();//buffer
					lerOpcao.nextLine();//parando o console para o usuario conseguir vizualizar
					flag = 1;
				}else {
					flag = 0;
				}
			}while(flag == 1);//garantindo que o produto esta cadastrado
			
			System.out.println("Quantas unidades foram vendidas ao cliente?");
			quantidadeVendida = lerOpcao.nextInt();
			
			if(quantidadeVendida > quantidadeNoEstoque.get(opcaoProduto)) {
				System.out.println("Desculpe, mas nao temos esta quantidade em estoque, por favor verifique as informações do produto e tente novamente");
				lerOpcao.nextLine();//buffer
				lerOpcao.nextLine();//parando o console para o usuario conseguir vizualizar
			}
		
			quantidadeNoEstoque.set(opcaoProduto,quantidadeNoEstoque.get(opcaoProduto) -quantidadeVendida);//decrementando a quantidade que foi vendida do estoque
			
			System.out.println("Deseja cadastrar a venda de mais produtos a este cliente?");
			System.out.println("1 - Sim   |||   2 - Não");
			opcaoCadastro = lerOpcao.nextInt();
			
			if(opcaoCadastro == 1) {
				System.out.println("Certo, listarei de novo os produtos!");
				lerOpcao.nextLine();//parando o console para o usuario conseguir vizualizar
			}else if(opcaoCadastro == 2) {
				System.out.println("Venda cadastrada, retornando ao menu!");
				lerOpcao.nextLine();//parando o console para o usuario conseguir vizualizar
			}else {
				lerOpcao.nextLine();//parando o console para o usuario conseguir vizualizar
				System.out.println("Opção inválida, por favor entre com uma opção válida.");
			}
			
			
		}while(opcaoCadastro == 1 || opcaoCadastro != 2);
	}
	
	public static void mostraProdutos() {
		
		int i = 0;
	
		Scanner stop = new Scanner(System.in);
		
		System.out.println("------ A seguir ocorrerá a listagem dos produtos cadastrados ------");
		
		for (i = 0; i< quantidadeNoEstoque.size(); i++) {
		
			System.out.printf("%d. %s\n ",i+1,nomeDoProduto.get(i));
			System.out.printf("    A quantidade em estoque desse produto é: %s \n",quantidadeNoEstoque.get(i));
		}
		stop.nextLine();		
		}
	
	public static void preCadastramento() {
		
		int i = 0,j=1,preCadastroQuantidadeProduto;
		float preCadastroPrecoProduto,preCadastroLucroProduto;
		String preCadastroNomeCliente, preCadastroendercoCliente, preCadastroTelCliente;
		String preCadastroNomeProduto, preCadastroDescricao;
		
		for (i = 0; i < 10; i++) {
			
			//gera informações genericas (Cliente 1, Cliente 2.....)
			preCadastroNomeCliente = "Cliente " + j;
			preCadastroendercoCliente = "Endereço do Cliente " + j;
			preCadastroTelCliente = "Telefone do Cliente " + j;
			//Armazena os nomes gerados genericamente pela função no arrayList 
			nomeCliente.add(preCadastroNomeCliente);
			telefoneCliente.add(preCadastroTelCliente);
			enderecoCliente.add(preCadastroendercoCliente);
			
			
			//gera informações genericas para o produto(Produto 1, Produto2....)
			preCadastroNomeProduto = "Produto " +  j;
			preCadastroDescricao = "Descrição do Produto " + j;
			preCadastroPrecoProduto = 10 + 5*i;
			preCadastroLucroProduto = 1 + i;
			preCadastroQuantidadeProduto = 10 + 2*i;
			//Armazena as informações genericas gerada pela função no arrayList
			nomeDoProduto.add(preCadastroNomeProduto);
			descricaoDoProduto.add(preCadastroDescricao);
			quantidadeNoEstoque.add(preCadastroQuantidadeProduto);
			lucroNoProduto.add(preCadastroLucroProduto);
			precoDoProduto.add(preCadastroPrecoProduto);

			j++;
		}
				
	}
	
}