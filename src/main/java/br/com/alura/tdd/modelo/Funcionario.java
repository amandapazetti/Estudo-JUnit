package br.com.alura.tdd.modelo;
/*
Este  código  define uma classe chamada
"Funcionario" com três atributos (nome, data de admissão
 e salário) e um método para reajustar o salário do
 funcionário.
 */
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class Funcionario {

	private String nome;
	private LocalDate dataAdmissao;
	private BigDecimal salario;

	//construtor
	public Funcionario(String nome, LocalDate dataAdmissao, BigDecimal salario) {
		this.nome = nome;
		this.dataAdmissao = dataAdmissao;
		this.salario = salario;
	}
   //método getters
	public String getNome() {
		return nome;
	}

	public LocalDate getDataAdmissao() {
		return dataAdmissao;
	}

	public BigDecimal getSalario() {
		return salario;
	}

/*Método de reajuste de salário: por fim, é definido um
método público "reajustarSalario()" que recebe como
parâmetro um BigDecimal chamado "reajuste". Esse
método atualiza o salário do funcionário adicionando
o valor do parâmetro "reajuste" ao salário atual e
arredondando o resultado para duas casas decimais
com o modo HALF_UP.
O método "setScale(2, RoundingMode.HALF_UP)" define
o número de casas decimais e o modo de arredondamento
para duas casas decimais com arredondamento para
cima. O método "add()" é usado para somar o valor
do parâmetro "reajuste" ao salário atual.
O resultado é então atribuído ao atributo "salario"
da classe.*/
	public void reajustarSalario(BigDecimal reajuste) {
		this.salario = this.salario.add(reajuste).setScale(2, RoundingMode.HALF_UP);
	}
}
