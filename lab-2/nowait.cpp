#include <iostream>

int main() 
{
	int a [5] = { 1, 2, 3, 4, 5};
	int b [5] = { 6, 7, 8, 9, 10};
	int y [5] = { 11, 12, 13, 14, 15};
	int z [5] = { 16, 17, 18, 19, 20};

	#pragma omp parallel  
	{  
	    #pragma omp for nowait  
		for (int i = 1; i < 5; i++) { 
			b[i] = (a[i] + a[i - 1]) / 2.0; 

			#pragma omp critical
			{ 
			std::cout << "b[" << i << "] = " << b[i] << "\n";
			}
		}

	    #pragma omp for nowait  
		for (int i = 0; i < 5; i++) {
			y[i] = z[i] * 2;  
			
			#pragma omp critical
			{
			std::cout << "y[" << i << "] = " << y[i] << "\n";
			}
		}
	}  
}