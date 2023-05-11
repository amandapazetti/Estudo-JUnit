package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

/* O sistema deve permitir que os funcionários recebam um reajuste salarial anual baseado
em seu desempenho, obedecendo às seguintes regras:
Se o desempenho foi "A desejar", reajuste será de 3% do salário atual.
Se o desempenho for "Bom", o reajuste será de 15% do salário.
Se o desempenho dor "Ótimo", o reajusre será de 20% do salário.
 */
public class ReajusteServiceTest {
    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        System.out.println("inicializar");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }
    @AfterEach
    public void finalizar() {
        System.out.println("fim");
    }
    @BeforeAll
    public static void antesDeTodos() {
        System.out.println("ANTES DE TODOS");
    }
      @AfterAll
      public static void depoisDeTodos() {
          System.out.println("DEPOIS DE TODOS");
      }
    @Test
    public void reajusteDeveraSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    public void reajusteDeveraSerDeTresPorCentoQuandoDesempenhoForBom() {
        service.concederReajuste(funcionario, Desempenho.BOM);
        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());

    }

    @Test
    public void reajusteDeveraSerDeTresPorCentoQuandoDesempenhoForOtimo() {
        service.concederReajuste(funcionario, Desempenho.OTIMO);
        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());


    }
}
