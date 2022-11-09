package LULA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class LULASistemaTest {
	
	private LULASistema sistema;
	
	@BeforeEach
	public void sistemaBase() {
		sistema = new LULASistema();
		sistema.cadastraLocal("CN", "Bloco de humanas", 1162);
		sistema.cadastraComitiva(1, "Alunos da UEPB", 10, "9595-9595");
	}

	@Test
	void testCadastraLocalJaExistente() {
		boolean aprovado;
		try {
			sistema.cadastraLocal("CN", "Bloco", 5689);
			aprovado = true;
		} catch (RuntimeException e) {
			aprovado = false;
		}
		assertFalse(aprovado);
	}

	@Test
	void testCadastraComitivaForaDoRange() {
		boolean aprovado;
		
		try {
			sistema.cadastraComitiva(100, "teste", 15, "3454");
			aprovado = true;
		} catch (IndexOutOfBoundsException e) {
			aprovado = false;
		}
		assertFalse(aprovado);
	}
	
	@Test
	void testCadastraComitivaJaCadastrada() {
		boolean aprovado;		
		try {
			sistema.cadastraComitiva(1, "teste", 15, "3454");
			aprovado = true;
		} catch (IllegalArgumentException e) {
			aprovado = false;
		}
		assertFalse(aprovado);
	}

	@Test
	void testListaVisitas() {
		sistema.cadastraVisita("CN", 1);
		assertEquals(sistema.listaVisitas("CN"), "\nID: 1\nComitiva: Alunos da UEPB\nIntegrantes: 10\nContato: 9595-9595");
	}

	@Test
	void testContaVisitas() {
		sistema.cadastraVisita("CN", 1);
		assertEquals(sistema.contaVisitas("CN"), 10);
	}

	@Test
	void testExibeLocal() {
		assertEquals(sistema.exibeLocal("CN"), "\nCN - Bloco de humanas - 1162");
	}

	@Test
	void testExibeComitiva() {
		assertEquals(sistema.exibeComitiva(1), "\nID: 1\nComitiva: Alunos da UEPB\nIntegrantes: 10\nContato: 9595-9595");
	}

	@Test
	void testListaLocais() {
		sistema.cadastraLocal("CD", "Bloco exatas", 8978);
		assertEquals(sistema.listaLocais(), "\nCN - Bloco de humanas - 1162\nCD - Bloco exatas - 8978");
	}

	@Test
	void testListaComitivas() {
		sistema.cadastraComitiva(4, "Alunos motiva", 23, "1233-4567");
		assertEquals(sistema.listaComitivas(), "\nID: 1\nComitiva: Alunos da UEPB\nIntegrantes: 10\nContato: 9595-9595\nID: 4\nComitiva: Alunos motiva\nIntegrantes: 23\nContato: 1233-4567");
	}

}
