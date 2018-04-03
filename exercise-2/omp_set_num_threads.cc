#include <omp.h>
#include <iostream>
int main() 
{
	omp_set_num_threads(500);
	#pragma omp parallel 
	{	
		std::cout << "Hello World!\n";
	}
}