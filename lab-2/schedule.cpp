#include <iostream>

int main() 
{
	int x = 1;
	#pragma omp parallel for schedule(static, 2)
	for (int i = 0; i < 25; i++) {
		x += 1;
		#pragma omp critical
		{
			std::cout << x << "\n";
		}			
	}	
}