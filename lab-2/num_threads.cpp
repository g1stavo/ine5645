#include <iostream>

int main() {
	#pragma omp parallel num_threads(10) 
	{
		std::cout << "Hello World!\n";
	}	
}