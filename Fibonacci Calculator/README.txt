This program is designed to calculate the Fibonacci sequence of numbers
using a linear (O(n)) time complexity algorithm.

To run the program, execute the following commands in the command line:

	./asn1_a.sh
	./asn1_b.sh

This program comes with two shell scripts in order to illustrate the
difference in performance between the linear time algorithm and the
recursive approach.

asn1_a.sh uses the recursive approach to calculate the first 50 Fibonacci
numbers while asn1_b.sh uses the linear time algorithm to calculate the
first 500 numbers.

The program also contains a BigInt class to overcome integer
size limitation in order to calculate the 500th Fibonacci number.

A capture of the output after running the program is provided in
"typescript.nice" which can be viewed in notepad.