[[CIT.005]] #activity 

Problem 1
	Create a parent class named "Point". 
	Override the toString() and the equals() methods of the Point class.
	

Problem 2  (Rectangle.java)

a)	Create a class that uses the Point class to implement a Rectangle. The Rectangle class has two data members 

	private MyPoint upperLeft - to represent upper left coordinate 
	private MyPoint lowerRight - to represent the lower right coordinate. 

b)	Implement the correct constructor for the Rectangle class
	-- See MyLine for guidance--.

c)	Implement the necessary get and set methods for the class 

d)	Implement the following methods: 

	public double length() 
		- that returns the length of the rectangle 

	public double width() 
		- that returns the width of the rectangle

	public double area() 
		- that returns the area of the rectangle by calling the length() and width() 

	double perimeter() 
		- that returns the perimeter of the rectangle by calling the length() and width()

Problem 3  (Circle.java)

a)  Implement a class called Circle for representing a circle. The circle has two data members, 
a Point object representing the center of the circle and a float value representing the 
radius. 
�	Include appropriate constructors for your Circle class and the necessary getter and 
	setter methods.
�	Also include methods for finding the area and circumference of the circle. 
		area = pi * radius * radius and circumference = 2 * pi * radius. 
		(You may use the static constant pi in the Math class)
�	Override the toString method of the Object class to give a string representation of your
	 object
�	Override the equals method of the Object class. Two circle objects are equal if they 
	have the same center and the same radius.
�	Write a simple main method that creates Circle objects and tests each of the methods that
	 you have defined.

Problem 4  (Cylinder.java)

a)  After you have completed Problem 2, Implement a class called Cylinder.
�	A cylinder has one additional data member for representing the height (type float).
�	Create appropriate constructors for your Cylinder class
�	Include the necessary getters and setter for your additional attributes
�	Include methods for finding the volume and area of your Cylinder.
		area = 2 * (area of the circle in this cylinder) + 2 * pi * radius + height
		volume = (area of the circle in this cylinder) * height
�	Override the toString method of the Object class. Try to use the toString of the Circle 
	class and then just concatenate the remaining values
�	Override the equals method of the Object class. Two Cylinder objects are equal if they 
	have the same center and the same radius and the same height. 
�	Write a simple main method that creates Cylinder objects and tests each of the methods 
	that you have defined.