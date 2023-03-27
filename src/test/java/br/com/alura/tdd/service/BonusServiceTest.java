package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BonusServiceTest {
         @Test
         void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
             //Estanciando e criando um novo objeto
             BonusService service = new BonusService();
             /* criando um varialvel e atribuindo valores atraves de um metodo já criado que irá
             receber como argumento um objeto classe e dentro desse objeto será atribuido valores para os atributos.
              */
             BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));

            /* O método abaixo compara dois valores e verifica se eles são iguais,
             lançando uma exceção se eles não forem iguais.
             */

             assertEquals(new BigDecimal("0.00"), bonus);
         }

    @Test
    void bonusDeveriaSer10PorCentoParaSalario() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500.00")));

        assertEquals(new BigDecimal ("250.00"), bonus);
    }

    @Test
    /*Esse teste está verificando se o bônus calculado pelo método "calcularBonus" da classe "BonusService" para um funcionário com
     salário de exatamente 1000 reais é de 10% desse valor*/
    void bonusDeveriaSer10PorCentoParaSalarioDeExatamente1000() {
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("1000.00")));

        assertEquals(new BigDecimal ("100.00"), bonus);
    }

     }




