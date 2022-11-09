package LULA;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;

class ComitivaTest {
	private LULASistema sistema;
	
	@BeforeEach
	public void sistemaBase() {
		sistema = new LULASistema();
		sistema.cadastraLocal("CN", "Bloco de humanas", 1162);
		sistema.cadastraComitiva(1, "Alunos da UEPB", 10, "9595-9595");
	}
	

	@Test
	void testToString() {
		assertEquals(sistema.exibeComitiva(1), "\nID: 1\nComitiva: Alunos da UEPB\nIntegrantes: 10\nContato: 9595-9595");
	}

}
