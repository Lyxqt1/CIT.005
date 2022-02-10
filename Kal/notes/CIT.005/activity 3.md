[[CIT.005]] #activity   
(Package Inheritance Hierarchy) Package-delivery services, such as FedEx®, DHL® and UPS®, offer a number of different shipping options, each with specific costs associated. Create an inheritance hierarchy to represent various types of packages.

Use Package as the base class of the hierarchy, then include classes TwoDayPackage and OvernightPackage that derive from Package. Base class Package should include data members representing the 
name, 
address, 
city, 
state and 
ZIP 
code for both the sender and the recipient of the package, 

in addition to data members that store the 
weight (in ounces) and 
cost per ounce to ship the package.

Package's constructor should initialize these data members. Ensure that the weight and cost per ounce contain positive values.

Package should provide a public member function calculateCost that returns a double indicating the cost associated with shipping the package. Package's calculateCost function should determine the cost by multiplying the weight by the cost per ounce.

Derived class TwoDayPackage should inherit the functionality of base class Package, but also include a data member that represents a flat fee that the shipping company charges for two-day-delivery service.

TwoDayPackage's constructor should receive a value to initialize this data member.

TwoDayPackage should redefine member function calculateCost so that it computes the shipping cost by adding the flat fee to the weight-based cost calculated by base class Package's calculateCost function.

Class OvernightPackage should inherit directly from class Package and contain an additional data member representing an additional fee per ounce charged for overnight-delivery service.

OvernightPackage should redefine member function calculateCost so that it adds the additional fee per ounce to the standard cost per ounce before calculating the shipping cost. Write a test program that creates objects of each type of Package and tests member function calculateCost.

Use the Package Inheritance Hierarchy created above. Create a program that displays the address information and calculates the shipping costs for several Packages. For each Package, invoke get functions to obtain the address information of the sender and the recipient, then print the two addresses as they would appear on mailing labels. Also, call each Package's calculateCost member function and print the result. Keep track of the total shipping cost for all Packages in the vector, and display this total when the loop terminates.

Note: Allow the user to select what type of package he wants to avail. Also, you may apply the concept on polymorphism.

Other data:

TwoDay Package:

 FlatFee is 200

 Overnight Package:

 Additional Fee for Overnight is 100

Note: You are expected to create a class PERSON also for the sender and receiver of the package.

Expected JAVA files: 5

File name format: familyname_package.zip