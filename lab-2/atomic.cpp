#include <iostream>

int main() 
{
	int i = 1;

	#pragma omp parallel
		while (i < 250) 
		{
			#pragma omp atomic 
			i++;
		}

	std::cout << i << "\n";
}