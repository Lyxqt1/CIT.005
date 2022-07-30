**inputs: 2			5		1		5		5**

declares int array with a size of 5
 			
input x0
**for loop**

**Loop 1**
input x1
x[i] < x[(i + 1)] ->true 
x[i] > x[(i + 1)] ->false
skip other conditions
increment i

**Loop 2**
input x1
x[i] < x[(i + 1)] ->false
x[i] > x[(i + 1)] ->true
skip other conditions
increment i

**Loop 3**
input x1
x[i] < x[(i + 1)] ->true 
x[i] > x[(i + 1)] ->false
skip other conditions
increment i

**loop 4**
input x1
x[i] < x[(i + 1)] ->false
x[i] > x[(i + 1)] ->false
x0 == x1 ->true
increment i

for loop is satified and ended

**output**
the current number is greater than the previous number
the current number is less than the previous number 
the current number is greater than the previous number 
the current number is equal to the previous number



