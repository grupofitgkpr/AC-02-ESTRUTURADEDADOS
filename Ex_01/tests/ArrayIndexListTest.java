package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import source.ArrayIndexList;

class ArrayIndexListTest {
	ArrayIndexList<Integer> A = new ArrayIndexList<Integer>();
	
	@Test
	void exArrayIndexListTest() {
		assertEquals("()", A.toString(), "O array deve estar vazio");
		assertThrows(IndexOutOfBoundsException.class, () -> { A.get(0);});
		
		A.add(0, 5);
		assertEquals("(5)", A.toString(), "O array deve retornar (5)");
		
		A.remove(0);
		assertEquals("()", A.toString(), "O array deve estar vazio");
		assertThrows(IndexOutOfBoundsException.class, () -> { A.get(0);});
		
		A.add(0, 1);
		A.add(1, 2);
		A.add(2, 3);
		A.add(0, 0);
		assertEquals("(0, 1, 2, 3)", A.toString(), "O array deve retornar (0, 1, 2, 3)");
		
		
		A.set(0, 999);
		assertEquals("(999, 1, 2, 3)", A.toString(), "0 vira 999");
		A.set(1, 998);
		assertEquals("(999, 998, 2, 3)", A.toString(), "1 vira 998");
		A.set(2, 997);
		assertEquals("(999, 998, 997, 3)", A.toString(), "2 vira 997");
		A.set(3, 996);
		assertEquals("(999, 998, 997, 996)", A.toString(), "3 vira 996");
		
		assertEquals("999", A.get(0).toString(), "Tem que retornar 999");
		assertEquals("998", A.get(1).toString(), "Tem que retornar 998");
		assertEquals("997", A.get(2).toString(), "Tem que retornar 997");
		assertEquals("996", A.get(3).toString(), "Tem que retornar 996");
		
		A.remove(0);
		A.remove(0);
		A.remove(0);
		A.remove(0);
		assertEquals("()", A.toString(), "O array deve estar vazio");
		assertThrows(IndexOutOfBoundsException.class, () -> { A.get(0);});
	}
	
	//Teste igual o do slide
	@Test
	void enunciadoArrayIndexListText() {
		assertEquals("()", A.toString());
		
		A.add(0, 7);
		assertEquals("(7)", A.toString());
		
		A.add(0, 4);
		assertEquals("(4, 7)", A.toString());
		
		assertEquals(7, A.get(1));
		A.add(2, 2);
		assertEquals("(4, 7, 2)", A.toString());
		
		assertThrows(IndexOutOfBoundsException.class, () -> { A.get(3);});
		assertEquals(7, A.remove(1));
		assertEquals("(4, 2)", A.toString());
		
		A.add(1, 5);
		assertEquals("(4, 5, 2)", A.toString());
		
		A.add(1, 3);
		assertEquals("(4, 3, 5, 2)", A.toString());
		
		A.add(4, 9);
		assertEquals("(4, 3, 5, 2, 9)", A.toString());
		
		assertEquals(5, A.get(2));
		assertEquals("(4, 3, 5, 2, 9)", A.toString());
		
		assertEquals(2, A.set(3, 8));
		assertEquals("(4, 3, 5, 8, 9)", A.toString());
	}
}
