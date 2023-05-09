package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class BonusServiceTest {
         @Test
         void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
             //Estanciando e criando um novo objeto
             BonusService service = new BonusService();

             /*O objetivo do teste abaixo é verificar se o método
              calcularBonus() do service lança uma exceção do
               tipo IllegalArgumentException quando um
               funcionário com salário anual superior a um
               determinado limite tenta receber um bônus.
               Se a exceção for lançada corretamente, o teste passa.
                Caso contrário, ele falha e indica que o comportamento
                 do método não está de acordo com o esperado
              */
             assertThrows(IllegalArgumentException.class,
                     () -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));
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




