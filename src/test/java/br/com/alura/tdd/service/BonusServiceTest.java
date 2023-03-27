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
            BigDecimal bonus =  service.calcularBonus (new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));

            /* O método abaixo compara dois valores e verifica se eles são iguais,
             lançando uma exceção se eles não forem iguais.
             */

                 assertEquals(BigDecimal.ZERO, bonus);
         }

     }



