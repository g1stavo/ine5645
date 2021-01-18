#include <iostream>

int main() {
	int val, sum = 0;
	#pragma omp parallel sections private(val) reduction(+:sum)
	{
		#pragma omp section
		{
			val = 5;
			sum += val;
		}
		
		#pragma omp section
		{
			val = 3;
			sum += val;
		}
	}
	std::cout << sum << "\n";
}