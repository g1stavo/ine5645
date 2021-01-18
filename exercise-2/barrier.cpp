#include <iostream>

int add(int a, int b) {
	return a + b;
}

int sub(int a, int b) {
	return a - b;
}

int main() {
	int c;
	#pragma omp parallel
	{
		int a = add(3, 2);
		int b = sub(10, 7);
		#pragma omp barrier
		c = a * b;
	}
	std::cout << c << "\n";
}