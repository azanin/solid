## Agenda

- SOLID Principles

- Testing

- Functional Programming

---
## SOLID Principles

***Acronym for five fundamental principles in O-O programming
coined in early 2000’s
by *Michael Feathers* and *Robert C. Martin (aka Uncle Bob)* ***

---
## S: Single Responsability

*A class should have only one reason to change.*

+++

### Problem: Blog Posts That Can "Print" Themselves
Let's say we have a Blog Post class encapsulating the concept of a web post and its functionalities.
It can provide its title, author and its content.

+++

### Try to print its content on the console.

+++

### What if it should be able to print its content as json?

Hint => try to separate the business logic from the presentation
<!-- Mixing business logic with presentation is bad because it is against the Single Responsibility Principle (SRP)-->

+++

### What if you have to print its content on a file?

+++ 

## S: Single Responsability
#### Thoughts

- Why was it important to separate these two responsibilities into separate classes? Because each responsibility is an axis of change.
- If a class assumes more than one responsibility, then there will be more than one reason for it to change.
- If, on the other hand, the application is not changing in ways that cause the the two responsibilities to change at differen times, then there is no need to separate them. Indeed, separating them would smell of Needless Complexity.

---

## O: Open | Closed

*Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.*

+++

### Problem: Calculating areas
<!-- http://joelabrahamsson.com/a-simple-example-of-the-openclosed-principle/ -->
Let’s say that we’ve got a Rectangle class.
It is capable of getting its width and height.   

### Try to build an application that can calculate the total area of a collection of rectangles.
Hint => mind the previous SRP!

+++ 

### We wonders if you couldn’t extend it so that it could calculate the area of not only rectangles but of circles as well.

+++

### We also wonders if you couldn’t extend it so that it could calculate the area of not only rectangles but of circles as well.
Hint => Abstraction is the key

+++ 



## S:  Open | Closed
#### Thoughts

- When a single change to a program results in a cascade of changes to dependent modules, that program becomes fragile, rigid, unpredictable and unreusable.
- Instead we should strive to write code that doesn’t have to be changed every time the requirements change.
- So, when requirements change, you extend the behavior of such modules by adding new code, not by changing old code that already works.