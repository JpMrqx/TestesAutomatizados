package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Desempenho;
import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    public void inicializar() {
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(),new BigDecimal("1000.00"));
    }

    @Test
    public void reajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {


        service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

        assertEquals(new BigDecimal("1030.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {

        service.concederReajuste(funcionario, Desempenho.BOM);

        assertEquals(new BigDecimal("1150.00"),funcionario.getSalario());
    }

    @Test
    public void reajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {

        service.concederReajuste(funcionario, Desempenho.OTIMO);

        assertEquals(new BigDecimal("1200.00"),funcionario.getSalario());
    }
/*

@AfterEach serve para fazer alguma ação após cada método ser chamado. A nível de exemplo, vamos incluir um System.out.printIn()

 @AfterEach
    public void finalizar() {
            System.out.printIn("fim");
    }


@BeforeEach para imprimir "inicializar" antes do início de cada teste e depois escrever um @AfterEach que imprima "fim" ao término dos mesmos.

@BeforeEach
    public void inicializar() {
        System.out.printIn("inicializar");
        this.service = new ReajusteService();
        this.funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000"));
    }

Ao executar o teste, o console vai exibir a seguinte lista de palavras:

inicializar fim inicializar fim inicializar fim

*************************************************

@BeforeAll Método estático que executa uma atividade uma única vez antes de qualquer teste.

@BeforeAll
public static void antesDeTodos() {
        System.out.printIn("ANTES DE TODOS");
}

@AfterAll Método estático que faz o mesmo depois que todos os testes foram finalizados.

@AfterAll
public static void depoisDeTodos() {
        System.out.printIn("DEPOIS DE TODOS");
}

Ao executar os testes, o console exibirá o seguinte:

ANTES DE TODOS inicializar fim inicializar fim inicializar fim DEPOIS DE TODOS

 */

}