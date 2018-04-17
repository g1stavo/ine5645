#include <omp.h>
#include <stdio.h>
#include <iostream>
#include <unistd.h>

int main() 
{
	double start = omp_get_wtime();
	std::cout << "Start time: " << start << "\n";

	omp_set_num_threads(4);
	std::cout << "Number of threads: " << omp_get_num_threads() << "\n";

	#pragma omp parallel 
	{
		std::cout << "Thread number: " << omp_get_thread_num() << "\n";
	}

	sleep(1);
	double end = omp_get_wtime();
	std::cout << "End time: " << end << "\n";
}