## What is Brainfuck ?
Brainfuck is an esoteric programming language created in 1993 by Urban Müller, and notable for its extreme minimalism.
The language consists of only eight simple commands and an instruction pointer.
The language's name is a reference to the slang term brainfuck, which refers to things so complicated or unusual
that they exceed the limits of one's understanding.

The Brainfuck Programming Language
http://www.muppetlabs.com/~breadbox/bf/

This is a Brainfuck interpreter written in Java, and implements some basic optimizations. 
The implementation is using 60K memory cells of 8bit
The primary focus is to simplify the main interpreter loop for efficient execution.

## Performance
On Intel i7 4790 Desktop CPU (Quad core with H/T) , Windows 7, Oracle JDK 64bit

    mandelbrot.b completes in 8.8 sec

    hanoi.b code will complete in 1.0 sec

    long.b code will complete in 6.0 sec

On Intel Pentium T3400 Laptop (Dual core 2.16Ghz), Windows 7, Oracle JDK 64bit

    mandelbrot.b will complete in 24.0 sec

    hanoi.b completes in 4.5 sec

    long.b code will complete in 16.5 sec


## Usage:
Create a new interpreter instance, by calling BrainInt.newProgram(String). 
Pass your code in a String parameter.

Call the method executeBf() on the interpreter object, to run the program. By default the input and output on the executed code is set to standard System.in and System.out streams 

Example:

	String brainFuckCode = ">++++[>++++++<-]>-[[<+++++>>+<-]>-]<<[<]>>>>--.<<<-.>>>-.<.<.>---.<<+++.>>>++.<<---.[>]<<.";

	BrainInt brainInterpreter = BrainInt.newProgram(brainFuckCode);
	try {
		brainInterpreter.executeBf();
	} catch (Exception e) { ... }
 

Various Brainfuck optimizations are found in this extensive work by Mats Linander:
http://calmerthanyouare.org/2015/01/07/optimizing-brainfuck.html

Github page: https://github.com/matslina

Optimizations here are heavily influenced on Daniel Cristofani's "quick and dirty interpreter": 
http://www.hevanet.com/cristofd/brainfuck/qdb.c

How to test a Brainfuck interpeter/compiler? 
Run Daniel's short test programs: http://www.hevanet.com/cristofd/brainfuck/tests.b


## Reference

* Brainfuck for Dummies - Document: 
https://docs.google.com/document/d/1M51AYmDR1Q9UBsoTrGysvuzar2_Hx69Hz14tsQXWV6M/edit

* "Some brainfuck fluff.." by Daniel Cristofani: 
http://www.hevanet.com/cristofd/brainfuck/

* Brainfuck Archive by Panu Kalliokoski: 
http://esoteric.sange.fi/brainfuck/

* Visual Brainfuck: 
http://kuashio.blogspot.gr/2011/08/visual-brainfuck.html

* Online Interpreter: 
https://sange.fi/esoteric/brainfuck/impl/interp/i.html

* Example programs: 
https://github.com/fabianishere/brainfuck/tree/master/examples

* A brainfuck CPU by Clifford Wolf: 
http://www.clifford.at/bfcpu/

* Interpreter by Fabian Mastenbroek: 
https://github.com/fabianishere/brainfuck


