package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.NodeStack;
import source.Stack.EmptyStackException;

class NodeStackTest {
	
	Object o;
	static final NodeStack<Integer> a = new NodeStack<Integer>();
	
	// Exercicio 3: Implementar os testes do TAD Pilha usando LSE
	@Test
	void pilhaInteiros() {
		a.push(7);
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
	
		a.push(9);
		assertEquals("[9, 7]", a.toString(), "Deve imprimir [9, 7]");
	
		a.push(1);
		assertEquals("[1, 9, 7]", a.toString(), "Deve imprimir [1, 9, 7]");
		
		assertEquals(1, a.top(), "O número 1 está no topo da pilha");
	
		assertEquals(1, a.pop(), "Deve ter desempilhado 1");
		assertEquals("[9, 7]", a.toString(), "Deve imprimir [9, 7]");
	
		assertEquals(9, a.pop(), "Deve ter desempilhado 9");
		assertEquals("[7]", a.toString(), "Deve imprimir [7]");
	
		assertEquals(7, a.pop(), "Deve ter desempilhado 7");
		assertEquals("[]", a.toString(), "Deve imprimir []");
	
		assertTrue(a.isEmpty());
		assertThrows(EmptyStackException.class, () -> { a.pop(); });
	}
	
	//----------------------------------------------------------------------------------
	
	//Exercicio 4-B:
	@Test
	void inverterArranjo() {
		NodeStack<Integer> b = new NodeStack<Integer>();
		int [] arranjo1 = {1, 2, 3};
		
		b.push(arranjo1[0]);
		b.push(arranjo1[1]);
		b.push(arranjo1[2]);
		assertEquals("[3, 2, 1]", b.toString(), "Deve retornar b invertido");
		
		//--------------------------------------------------------------------
		
		NodeStack<String> s = new NodeStack<String>();
		String[] arranjo2 = {"AAA", "BBB", "CCC", "DDD", "EEE", "FFF", "GGG"};
		
		for (int i = 0; i <= arranjo2.length - 1; i++) {
			s.push(arranjo2[i]);
		}
		assertEquals("[GGG, FFF, EEE, DDD, CCC, BBB, AAA]", s.toString(), "Deve retornar s invertido");
	}
	
	//----------------------------------------------------------------------------------
	
	// Exercicio 4-C:
	@Test
	void verificaExpressaoMatematica() {
		NodeStack<String> exp = new NodeStack<String>();
		
		//Testes corretos
		String c1 = "[(5 + x)/4 – 2*(y + z)]";
		String c2 = "((()(()){([()])}))";
		String c3 = "()(()){([()])}";
		String c4 = "{[({}[]{}[]{}[])]}";
		String c5 = "[()]";
		
		assertEquals("Correto", exp.verificaExpressao(c1.split("")));
		assertEquals("Correto", exp.verificaExpressao(c2.split("")));
		assertEquals("Correto", exp.verificaExpressao(c3.split("")));
		assertEquals("Correto", exp.verificaExpressao(c4.split("")));
		assertEquals("Correto", exp.verificaExpressao(c5.split("")));
		
		//Testes incorretos
		String i1 = ")(()){([()])}";
		String i2 = "({[])}";                    //errado só aqui
		String i3 = "(";                         //       v     
		String i4 = "{{{{{[()()()][()()()][()()()][()()()]][()()()]}}}}}";
		String i5 = "])([";
		
		assertEquals("Incorreto", exp.verificaExpressao(i1.split("")));
		assertEquals("Incorreto", exp.verificaExpressao(i2.split("")));
		assertEquals("Incorreto", exp.verificaExpressao(i3.split("")));
		assertEquals("Incorreto", exp.verificaExpressao(i4.split("")));
		assertEquals("Incorreto", exp.verificaExpressao(i5.split("")));
	}
	
	@Test
	void teste() {
		NodeStack<Integer> pqp = new NodeStack<Integer>();
		for (int x = 0; x <= 25; x++) {
			pqp.push(7);
		}
		for (int x = 0; x <= 12; x++) {
			pqp.top();
		}
		for (int x = 0; x <= 10; x++) {
			pqp.pop();
		}
		assertEquals("[]", pqp.toString(), "Deve imprimir []");
	}
}

