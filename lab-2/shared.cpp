#include <iostream>

int main() 
{
	int x;
	#pragma omp parallel for shared(x)
		for (int i = 0; i < 25; i++) {
			x += 1;
		}
	std::cout << x << "\n";
}