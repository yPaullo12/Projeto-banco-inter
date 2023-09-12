package visualizacao;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import entidade.ClientePf;
import entidade.ClientePj;
import entidade.ContaBancaria;
import numeroConta.GeradorNumeroConta;
import servico.ClientePfServico;
import servico.ClientePjServico;
import servico.ContaBancariaServico;

public class aplicacao {
	public static ArrayList<ClientePf> listaClientePf = new ArrayList<ClientePf>();
	public static ArrayList<ClientePj> listaClientePj = new ArrayList<ClientePj>();
	public static ArrayList<ContaBancaria> listaContaBancaria = new ArrayList<ContaBancaria>();

	public static void main(String[] args) {
		ClientePfServico clientePfServico = new ClientePfServico(listaClientePf);
		ClientePjServico clientePjServico = new ClientePjServico(listaClientePj);
		ContaBancariaServico contaBancariaServico = new ContaBancariaServico(listaContaBancaria);
		GeradorNumeroConta gerador = new GeradorNumeroConta();
		ContaBancaria cb1 = new ContaBancaria();
		Locale.setDefault(Locale.US);
		int  numeroConta = gerador.gerarNumeroConta();
		Scanner sc = new Scanner(System.in);
		
		ClientePf c1 = new ClientePf();
		ClientePj j1 = new ClientePj();
		
		String acesso = "";
		String acesso2 = "";
		String acesso3 = "";
		String acesso4 = "";
		String acesso5 = "";
		String acesso6 = "";
		String acesso7 = "";
		
		while(!acesso.equals("5")) {
			System.out.println("Digite 1 Para Acessar Sua Conta Pessoa Fisica: ");
			System.out.println("Digite 2 Para Acessar Sua Conta Pessoa Juridica: ");
			System.out.println("Digite 3 Para Abrir Sua Conta Pessoa Fisica: ");
			System.out.println("Digite 4 Para Abrir Sua Conta Pessoa Juridica: ");
			System.out.println("Digite 5 Para Sair: ");
			
			acesso = sc.next();
			
			switch(acesso) {
			case "1":
				System.out.println("Digite Seu CPF: ");
				c1.setCpf(sc.next());
				System.out.println("Digite Sua Senha: ");
				c1.setCriarSenha(sc.next());	
				while(!acesso2.equals("8")) {
					System.out.println("Digite 1 Para Acessar Os Dados Da Sua Conta: ");
					System.out.println("Digite 2 Para Pix: ");
					System.out.println("Digite 3 Para Saldo: ");
					System.out.println("Digite 4 Para Emprestimo: ");
					System.out.println("Digite 5 Para Cartão De Crédito: ");
					System.out.println("Digite 6 Para Cartão De Débito: ");
					System.out.println("Digite 7 Para Deposito: ");
					System.out.println("Digite 8 Para Sair: ");
					
					acesso2 = sc.next();
					
					switch(acesso2) {
					case"1":
						System.out.println("Seus Dados: ");
						clientePfServico.imprimirClienteContaPf();
						while(!acesso3.equals("3")) {
							System.out.println("Digite 1 Para Alterar Os Dados Da Sua Conta: ");
							System.out.println("Digite 2 Para Encerrar Sua Conta: ");
							System.out.println("Digite 3 Para Voltar A Pagina Anterior: ");
							
							acesso3 = sc.next();
							
							switch(acesso3) {
							case "1":
								System.out.println("Digite Seu Novo Email: ");
								c1.setEmail(sc.next());
								System.out.println("Digite Seu Novo Numero De Telefone: ");
								c1.setTelefone(sc.next());
								System.out.println("Digite Sua Nova Senha: ");
								c1.setCriarSenha(sc.next());
								clientePfServico.atualizar(c1);
							    clientePfServico.imprimirClientePf();
								System.out.println("Seus Novos Dados: ");
								clientePfServico.imprimirClienteNovosDadosPf();	
								clientePfServico.imprimirClienteContaPf();
								break;
							case "2":
								clientePfServico.deletar(c1);
								clientePfServico.imprimirClientePf();
								break;
							case "3":
								break;
								default:
									System.out.println("COMANDO INVALIDO!DIGITE 1 OU 2 PARA AS OPÇÕES SELECIONADAS OU 3 PARA SAIR");
							}
						}
					case "2":
						System.out.println("Escolha As Opções De Pix: ");
						
						while(!acesso4.equals("3")) {
							System.out.println("Digite 1 Para Enviar: ");
							System.out.println("Digite 2 Para Receber: ");
							System.out.println("Digite 3 Para Voltar A Pagina Anterior: ");
							
							acesso4 = sc.next();
							
							switch(acesso4) {
							case "1":
								System.out.println("A Chave Do Seu Pix É Cpf!");
								System.out.println("Digite A Chave Do Pix: ");
								cb1.setChave(sc.next());
								System.out.println("Digite o Valor Que Deseja Enviar: ");
								cb1.setEnviar(sc.nextDouble());
								System.out.println("Seu Saldo Agora É: ");
								System.out.println(cb1.getSaldo() - cb1.getEnviar());
								break;
							case "2":
								System.out.println("Digite O valor A Ser Cobrado No Pix: ");
								cb1.setReceber(sc.nextDouble());
								System.out.println("Seu Saldo Agora É: ");
								System.out.println(cb1.getSaldo() + cb1.getReceber());
								break;
							case "3":
								break;
								default:
									System.out.println("COMANDO INVALIDO!DIGITE 1 OU 2 PARA AS OPÇÕES SELECIONADAS OU 3 PARA SAIR");
							}	
						}
						break;
					case "3":
						System.out.println("Seu Saldo É: ");
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "4":
						System.out.println("Seu Saldo Para Emprestimo É: " + cb1.getSaldo()* 150.0 / 100);			
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "5":
						System.out.println("Seu Cartão De Credito Tem Limite De: " + cb1.getSaldo() * 300.0 / 100);
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "6":
						System.out.println("Seu Saldo No Cartão De Debito É: ");
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "7":
						System.out.println("Digite O Valor Do Deposito: ");
						cb1.setSaldo(sc.nextDouble());
						System.out.println("Seu Saldo É: ");
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "8":
						break;
					default:
						System.out.println("COMANDO INVALIDO!DIGITE DE 1 A 6 PARA AS OPÇÕES SELECIONADAS OU 7 PARA SAIR");
						
					}		
				}
			break;
			
			case "2":
				System.out.println("Digite O Cnpj: ");
				j1.setCnpj(sc.next());
				System.out.println("Digite Sua Senha: ");
				j1.setCriarSenha(sc.next());
				while(!acesso.equals("8")) {
					System.out.println("Digite 1 Para Acessar Os Dados Da Sua Conta: ");
					System.out.println("Digite 2 Para Pix: ");
					System.out.println("Digite 3 Para Saldo: ");
					System.out.println("Digite 4 Para Emprestimo: ");
					System.out.println("Digite 5 Para Cartão De Crédito: ");
					System.out.println("Digite 6 Para Cartão De Débito: ");
					System.out.println("Digite 7 Para Deposito: ");
					System.out.println("Digite 8 Para Sair: ");
					
					acesso5 = sc.next();
					
					switch(acesso5) {
					case"1":
						System.out.println("Seus Dados: ");
						clientePjServico.imprimirClienteContaPj();
						while(!acesso6.equals("3")) {
							System.out.println("Digite 1 Para Alterar Os Dados Da Sua Conta: ");
							System.out.println("Digite 2 Para Encerrar Sua Conta: ");
							System.out.println("Digite 3 Para Voltar A Pagina Anterior: ");
							
							acesso6 = sc.next();
							
							switch(acesso6) {
							case "1":
								System.out.println("Digite Seu Novo Email: ");
								j1.setEmail(sc.next());
								System.out.println("Digite Seu Novo Numero De Telefone: ");
								j1.setTelefone(sc.next());
								System.out.println("Digite Sua Nova Senha: ");
								j1.setCriarSenha(sc.next());
								clientePjServico.atualizar(j1);
							    clientePjServico.imprimirClientePj();
								System.out.println("Seus Novos Dados: ");
								clientePjServico.imprimirClienteNovosDadosPj();	
								clientePjServico.imprimirClienteContaPj();
								break;
							case "2":
								clientePjServico.deletar(j1);
								clientePjServico.imprimirClientePj();
								break;
							case "3":
								break;
								default:
									System.out.println("COMANDO INVALIDO!DIGITE 1 OU 2 PARA AS OPÇÕES SELECIONADAS OU 3 PARA SAIR");
							}
						}
					case "2":
						System.out.println("Escolha As Opções De Pix: ");
						
						while(!acesso7.equals("3")) {
							System.out.println("Digite 1 Para Enviar: ");
							System.out.println("Digite 2 Para Receber: ");
							System.out.println("Digite 3 Para Voltar A Pagina Anterior: ");
							
							acesso7 = sc.next();
							
							switch(acesso7) {
							case "1":
								System.out.println("A Chave Do Seu Pix É Cnpj!");
								System.out.println("Digite A Chave Do Pix: ");
								cb1.setChave(sc.next());
								System.out.println("Digite o Valor Que Deseja Enviar: ");
								cb1.setEnviar(sc.nextDouble());
								System.out.println("Seu Saldo Agora É: ");
								System.out.println(cb1.getSaldo() - cb1.getEnviar());
								break;
							case "2":
								System.out.println("Digite O valor A Ser Cobrado No Pix: ");
								cb1.setReceber(sc.nextDouble());
								System.out.println("Seu Saldo Agora É: ");
								System.out.println(cb1.getSaldo() + cb1.getReceber());
								break;
							case "3":
								break;
								default:
									System.out.println("COMANDO INVALIDO!DIGITE 1 OU 2 PARA AS OPÇÕES SELECIONADAS OU 3 PARA SAIR");
							}	
						}
						break;
					case "3":
						System.out.println("Seu Saldo É: ");
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "4":
						System.out.println("Seu Saldo Para Emprestimo É: " + cb1.getSaldo()* 150.0 / 100);			
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "5":
						System.out.println("Seu Cartão De Credito Tem Limite De: " + cb1.getSaldo() * 300.0 / 100);
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "6":
						System.out.println("Seu Saldo No Cartão De Debito É: ");
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "7":
						System.out.println("Digite O Valor Do Deposito: ");
						cb1.setSaldo(sc.nextDouble());
						System.out.println("Seu Saldo É: ");
						contaBancariaServico.cadastrar(cb1);
						contaBancariaServico.imprimirContaBancariaSaldo();
						break;
					case "8":
						break;
					default:
						System.out.println("COMANDO INVALIDO!DIGITE DE 1 A 6 PARA AS OPÇÕES SELECIONADAS OU 7 PARA SAIR");
						
					}		
				}
			break;
				
			case "3":
				System.out.println("Digite Seu Nome Completo: ");
				c1.setNome(sc.next());
				System.out.println("Digite Seu CPF: ");
				c1.setCpf(sc.next());
				System.out.println("Digite Seu Email: ");
				c1.setEmail(sc.next());
				System.out.println("Digite Sua Data De Nascimento: ");
				c1.setDataNascimento(sc.next());
				System.out.println("Digite Seu Numero De Telefone: ");
				c1.setTelefone(sc.next());
				System.out.println("Crie Uma Senha: ");
				c1.setCriarSenha(sc.next());
				clientePfServico.cadastrar(c1);
				clientePfServico.imprimirClientePf();
				System.out.println("O NUMERO DA SUA CONTA É: ");
				System.out.println(numeroConta);
				break;
				
			case "4":
				System.out.println("Digite O Nome Da Sua Empresa: ");
				j1.setNomeEmpresarial(sc.next());
				System.out.println("Digite O CNPJ: ");
				j1.setCnpj(sc.next());
				System.out.println("Digite Seu Email: ");
				j1.setEmail(sc.next());
				System.out.println("Digite Seu Numero De Telefone: ");
				j1.setTelefone(sc.next());
				System.out.println("Crie Uma Senha: ");
				j1.setCriarSenha(sc.next());
				clientePjServico.cadastrar(j1);
				clientePjServico.imprimirClientePj();
				System.out.println("O NUMERO DA SUA CONTA É: ");
				System.out.println(numeroConta);
				break;
				
			case "5":
				System.out.println("FIM DO PROGAMA");
				break;
			default:
				System.out.println("COMANDO INVALIDO!DIGITE 1 OU 2 PARA AS OPÇÕES SELECIONADAS OU 3 PARA SAIR");		
			   } 
			}		
		sc.close();
	}

}
