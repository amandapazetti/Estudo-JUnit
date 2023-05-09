package br.com.alura.tdd.service;
/*A classe BonusService possui um método calcularBonus que recebe um objeto Funcionario como parâmetro e retorna um valor BigDecimal que
representa o bônus a ser pago para esse funcionário.*/

import java.math.BigDecimal;
import java.math.RoundingMode;

import br.com.alura.tdd.modelo.Funcionario;

public class BonusService {

	public BigDecimal calcularBonus(Funcionario funcionario) {
		BigDecimal valor = funcionario.getSalario().multiply(new BigDecimal("0.1"));
		if (valor.compareTo(new BigDecimal("1000")) > 0) {
			throw new IllegalArgumentException("Funcionário com salário maior do que R$10000 nao pode receber bonus!");

		}
		return valor.setScale(2, RoundingMode.HALF_UP);
	}

}
