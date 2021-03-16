package testes;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import source.NodePositionList;
import source.Position;

class NodePositionListTest {

	@Test
	void Ex11_Test() {
		//Método reverse() criado para inverter a lista de nodos de forma não-recursiva
		
		NodePositionList<Integer> R = new NodePositionList<Integer>();
		assertEquals("[]", R.toString(), "[]");
		
		R.addFirst(5);
		Position<Integer> p1 = R.first();
		R.addAfter(p1, 4);
		Position<Integer> p2 = R.next(p1);
		assertEquals("[5, 4]", R.toString(), "[5, 4]");
		
		R.reverse();
		assertEquals("[4, 5]", R.toString(), "[4, 5]");
		
		assertEquals(5, p1.element(), "5");
		assertEquals(4, p2.element(), "4");
		
		R.addBefore(p2, 3);
		R.addFirst(2);
		assertEquals("[2, 3, 4, 5]", R.toString(), "[2, 3, 4, 5]");
		
		R.reverse();
		R.addLast(1);
		assertEquals("[5, 4, 3, 2, 1]", R.toString(), "[5, 4, 3, 2, 1]");
		
		R.reverse();
		assertEquals("[1, 2, 3, 4, 5]", R.toString(), "[1, 2, 3, 4, 5]");
	}
	
	@Test
	void Ex12_Test() {
		// Método makeFirst() criado para colocar px elemento na primeira posição da lista
		NodePositionList<Integer> M = new NodePositionList<Integer>();
		assertEquals("[]", M.toString(), "[]");
		
		M.addFirst(4);
		Position<Integer> p1 = M.first();
		M.addLast(5);
		Position<Integer> p2 = M.next(p1);
		
		M.addAfter(p2, 3);
		Position<Integer> p3 = M.next(p2);
		assertEquals("[4, 5, 3]", M.toString(), "[4, 5, 3]");
		
		M.makeFirst(p3);
		assertEquals("[3, 4, 5]", M.toString(), "[3, 4, 5]");
		
		M.reverse();
		assertEquals("[5, 4, 3]", M.toString(), "[5, 4, 3]");
		
		M.makeFirst(p1); // p1 = 4
		assertEquals("[4, 5, 3]", M.toString(), "[4, 5, 3]");
		
		M.makeFirst(p3); // p3 = 3
		assertEquals("[3, 4, 5]", M.toString(), "[3, 4, 5]");
	}
	
	@Test
	void slideTest() {
		NodePositionList<Integer> l = new NodePositionList<Integer>();
		assertEquals("[]", l.toString(), "[]");
		
		l.addFirst(8);
		assertEquals("[8]", l.toString(), "[8]");
		
		Position<Integer> p1 = l.first();
		assertEquals(8, p1.element(), "8");
		assertEquals("[8]", l.toString(), "[8]");
		
		l.addAfter(p1, 5);
		assertEquals("[8, 5]", l.toString(), "[8, 5]");
		
		Position<Integer> p2 = l.next(p1);
		assertEquals(5, p2.element(), "5");
		assertEquals("[8, 5]", l.toString(), "[8, 5]");
		
		l.addBefore(p2, 3);
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		Position<Integer> p3 = l.prev(p2);
		assertEquals(3, p3.element(), "3");
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		l.addFirst(9);
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
		
		p2 = l.last();
		assertEquals(5, p2.element(), "5");
		assertEquals("[9, 8, 3, 5]", l.toString(), "[9, 8, 3, 5]");
		
		assertEquals(9, l.remove(l.first()), "9");
		assertEquals("[8, 3, 5]", l.toString(), "[8, 3, 5]");
		
		assertEquals(3, l.set(p3, 7), "3");
		assertEquals("[8, 7, 5]", l.toString(), "[8, 7, 5]");
		
		l.addAfter(l.first(), 2);
		assertEquals("[8, 2, 7, 5]", l.toString(), "[8, 2, 7, 5]");
	}
}

	