/**
 * An bytecode compiler and interpreter for FOOL+ language in Java/ANTLR
 * 
 * Course project for COMPILATORI E INTERPRETI (ANALISI STATICA DI PROGRAMMI)
 * Copyright(R) 2017  Chun Tian, University of Bologna
 */

package it.unibo.FOOL.test.plus;

/*
 * Method Test #2: single method in message-passing grammar (visitMethodExp())
 */

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import it.unibo.FOOL.test.*;

public final class MethodTest2 extends UnitTest {
    @Test
    public void testMethod2() {
	prog = "   class C = object int x = 1; end;					\n"
		+ "let int f(C a, int y) a.x + y;					\n"
		+ "    C c = new C;							\n"
		+ "in c.f(1);								\n";
	result = 2;
	assertEquals(run(), result);
    }
}

/** @formatter:off
3. Symbol Analysis:
base ID of class C is 1
defined variable x in class C(standard_object):{x}
defined class: class C(standard_object):{x}
defined init function: <global.C_init():class C(standard_object):{x}>
base ID of <f():int> is 0
defined variable a in <f(C):int>
defined variable y in <f(C,int):int>
defined function: <f(C,int):int>
defined variable c in [c]
locals: [c]
created new generic function: f
added new method f(C,int) into gf
 done.
4. Type Analysis:
type of prog is: int
5. Emit Bytecode:
defining function f(C,int) [nargs: 2(0 + 2), nlocals: 0]
nlocals for top-level LET: 1
 done.
6. Disassemble Bytecode:
Disassembly:
.global 0
0000:	br         41
0005:	iconst     1
0010:	load       0
0015:	fstore     1
0020:	iconst     1001
0025:	load       0
0030:	fstore     0
0035:	load       0
0040:	ret          
0041:	br         63
0046:	load       0
0051:	fload      1
0056:	load       1
0061:	iadd         
0062:	ret          
0063:	struct     2
0068:	call       #0:C_init()@5
0073:	store      0
0078:	load       0
0083:	iconst     1
0088:	call       #1:f(C,int)@46
0093:	halt         

7. Run Bytecode:
2
 */
