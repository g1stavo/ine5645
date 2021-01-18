#include <omp.h>
#include <stdio.h>
#include <iostream>

int main() {
	int a[5], i;

	#pragma omp parallel
	{
		#pragma omp for
		for (i = 0; i < 5; i++)
			a[i] = i * 1;

		#pragma omp master
		for (i = 0; i < 5; i++) 
			std::cout << "a[" << i << "] = " << a[i] << "\n";

		#pragma omp barrier

		#pragma omp for
		for (i = 0; i < 5; i++)
			a[i] += i;
	}
}