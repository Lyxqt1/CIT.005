**inputs:   2			5		1		5		5**

int x0 was declared

input x0 

calls the function -> number(x0,1)

number function takes x0 and 1
declare int x1


**recursion 1**
input x1
x0 < x1 ->true 
x0 > x1 ->false
skip other conditions
x0 = x1

**recursion 2**
input x1
x0 < x1 ->false
x0 > x1 ->true
skip other conditions
x0 = x1

**recursion 3**
input x1
x0 < x1 ->true 
x0 > x1 ->false
skip other conditions
x0 = x1

**recursion 4**
input x1
x0 < x1 ->false
x0 > x1 ->false
x0 == x1 ->true
x0 = x1

output:
the current number is greater than the previous number
the current number is less than the previous number 
the current number is greater than the previous number 
the current number is equal to the previous number
