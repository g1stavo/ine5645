#include <iostream>

void sect_example() {
	#pragma omp parallel sections {
		#pragma omp section
			std::cout << "Section 1!\n";

		#pragma omp section
			std::cout << "Section 2!\n";

		#pragma omp section
			std::cout << "Section 3!\n";
	}
}

int main() {
	sect_example();
}