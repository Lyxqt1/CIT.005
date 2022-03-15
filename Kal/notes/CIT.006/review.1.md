```c++
#include <iostream> using namespace std; int main() 
{ 
	int x0, x1, x2, x3, x4; 
	cout << "input a number: ";
	cin >> x0; 
	cout << "input a number: "; 
	cin >> x1; 
	if (x0 < x1) { 
		cout << "the current number is greater than the previous number\n"; 
	}
	if (x0 > x1) { 
		cout << "the current number is less than the previous number\n";
	} 
	else if (x0 == x1) { 
		cout << "the current number is equal to the previous number\n"; } cout << "input a number: "; 
	cin >> x2; 
	if (x1 < x2) { 
		cout << "the current number is greater than the previous number\n"; 
	}
	if (x1 > x2) { 
		cout << "the current number is less than the previous number\n"; } else if (x1 == x2) { 
		cout << "the current number is equal to the previous number\n"; 
	} 
	cout << "input a number: "; 
	cin >> x3; 
	if (x2 < x3) { cout << "the current number is greater than the previous number\n"; }if (x2 > x3) { cout << "the current number is less than the previous number\n"; } else if (x2 == x3) { cout << "the current number is equal to the previous number\n"; } cout << "input a number: "; cin >> x4; if (x3 < x4) { cout << "the current number is greater than the previous number\n"; }if (x3 > x4) { cout << "the current number is less than the previous number\n"; } else if (x3 == x4) { cout << "the current number is equal to the previous number\n"; } }
```

