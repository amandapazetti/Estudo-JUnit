package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

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

    @Test
    public void reajusteDeveraSerDeTresPorCentoQuandoDesempenhoForADesejar() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Amanda", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());


    }
@Test
    public void reajusteDeveraSerDeTresPorCentoQuandoDesempenhoForBom() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Norton", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());

    }
@Test
    public void reajusteDeveraSerDeTresPorCentoQuandoDesempenhoForOtimo() {
        ReajusteService service = new ReajusteService();
        Funcionario funcionario = new Funcionario("Eduardo", LocalDate.now(), new BigDecimal("1000"));

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());


    }
}
