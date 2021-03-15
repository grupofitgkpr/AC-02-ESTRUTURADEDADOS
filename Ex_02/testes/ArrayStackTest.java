package testes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import pilha.ArrayStack;
import pilha.Stack.EmptyStackException;
import pilha.Stack.FullStackException;

class ArrayStackTest {
	//Testes da Pilha de Strings
	static final ArrayStack<String> s = new ArrayStack<String>(3);
	
	@Test
	void pilhaStringTest() {
		s.push("Teste");
		assertEquals("[Teste]", s.toString(), "Deve imprimir [Teste]");
		
		s.pop();
		assertEquals("[]", s.toString(), "Deve imprimir []");
		Assertions.assertThrows(EmptyStackException.class, () -> { s.pop(); });
		
		s.push("AAA");
		s.push("BBB");
		s.push("CCC");
		assertEquals("[AAA, BBB, CCC]", s.toString(), "Deve imprimir [AAA, BBB, CCC]");
		
		Assertions.assertThrows(FullStackException.class, () -> { s.push("DDD"); });
		
		assertEquals("CCC", s.pop(), "Deve ter desempilhado CCC");
		assertEquals("[AAA, BBB]", s.toString(), "Deve imprimir [AAA, BBB]");
		
		assertEquals("BBB", s.pop(), "Deve ter desempilhado BBB");
		assertEquals("[AAA]", s.toString(), "Deve imprimir [AAA]");
		
		assertEquals("AAA", s.pop(), "Deve ter desempilhado AAA");
		assertEquals("[]", s.toString(), "Deve imprimir []");
		
		Assertions.assertThrows(EmptyStackException.class, () -> { s.pop(); });
	}
	
	//Testes da Pilha de Inteiros igual do slide
	static final ArrayStack<Integer> a = new ArrayStack<Integer>(3);
	
	@Test
	void pilhaInteiroTest() {
		a.push(7);
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");

		a.push(9);
		assertEquals("[7, 9]", a.toString(), "Deve imprimir [7, 9]");

		a.push(1);
		assertEquals("[7, 9, 1]", a.toString(), "Deve imprimir [7, 9, 1]");

		Assertions.assertThrows(FullStackException.class, () -> { a.push(2); });

		assertEquals(1, a.pop(), "Deve ter desempilhado 1");
		assertEquals("[7, 9]", a.toString(), "Deve imprimir [7, 9]");

		assertEquals(9, a.pop(), "Deve ter desempilhado 9");
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");

		assertEquals(7, a.pop(), "Deve ter desempilhado 7");
		assertEquals("[]", a.toString(), "Deve imprimir []");

		assertTrue(a.isEmpty());
		Assertions.assertThrows(EmptyStackException.class, () -> { a.pop(); });
	}
	
}
