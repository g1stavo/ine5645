#include <iostream>
#include <iterator>

void simple(int n, float *a, float *b) 
{
	int i;

#pragma omp parallel for	
	for (i = 0; i < n; i++) {
		b[i] = a[i];
	}
}

int main()
{
	float a[3] = {1.0, 2.0, 3.0};
	float b[3] = {4.0, 5.0, 6.0};
	simple(3, a, b);
	std::copy(b,	// begin
          b+3,		// end
          std::ostream_iterator<int>(std::cout, "\n"));
}