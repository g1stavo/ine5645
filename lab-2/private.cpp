#include <iostream>

int main() 
{
	int x = 1;
	#pragma omp parallel for private(x)
		for (int i = 0; i < 25; i++) {
			x += 1;
		}
	std::cout << x << "\n";
}