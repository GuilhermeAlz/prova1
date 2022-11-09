package LULA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class LocalTest {
	private LULASistema sistema;
	
	@BeforeEach
	public void sistemaBase() {
		sistema = new LULASistema();
		sistema.cadastraLocal("CN", "Bloco de humanas", 1162);
		sistema.cadastraComitiva(1, "Alunos da UEPB", 10, "9595-9595");
		sistema.cadastraComitiva(3, "Estudantes", 26, "1213213212");
	}

	@Test
	void testAdicionaVisita() {
		boolean aprovado;
		
		try {
			sistema.cadastraVisita("CN", 1);
			aprovado = true;
		} catch (RuntimeException e) {
			aprovado = false;
		}
		assertTrue(aprovado);
	}

	@Test
	void testContaVisitas() {
		sistema.cadastraVisita("CN", 1);
		sistema.cadastraVisita("CN", 3);
		assertEquals(sistema.contaVisitas("CN"), 36);
	}

	@Test
	void testListaVisitas() {
		sistema.cadastraVisita("CN", 1);
		assertEquals(sistema.listaVisitas("CN"), "\nID: 1\nComitiva: Alunos da UEPB\nIntegrantes: 10\nContato: 9595-9595");
	}

	@Test
	void testToString() {
		assertEquals(sistema.exibeLocal("CN"), "\nCN - Bloco de humanas - 1162");
	}
}
