### Agenda

SOLID Principles

Functional Programming

---
### SOLID Principles

***Acronym for five fundamental principles in Object Oriented programming
coined in early 2000s by *Michael Feathers* and *Robert C. Martin (aka Uncle Bob)* ***

---
### (S)ingle Responsability

*A class should have only one reason to change.*

+++

### Problem: Blog Posts That Can "Print" Themselves
We have a Blog Post class representing a web post composed by a title, author and a content.

+++

Try to print out its content to the console.

+++

What if we want to print the post's content as json?

Hint: Separation of business logic and data presentation is important!
<!-- Mixing business logic with presentation is bad because it is against the Single Responsibility Principle (SRP)-->

+++

What if you have to print out its content to a file?

+++ 

### (S)ingle Responsability
##### Thoughts

Separate these two responsibilities into separate classes is so important because every responsibility is an axis of change.

+++

If a class has more than one responsibility, then there will be more than one reason for it to change.

+++

If the two responsibilities don't change at different times, then there is no need to separate them.

Separating them would lead to *Needless Complexity*, indeed.

---

### (O)pen Closed

*Software entities (classes, modules, functions, etc.) should be open for extension, but closed for modification.*

+++

### Problem: Calculating areas
<!-- http://joelabrahamsson.com/a-simple-example-of-the-openclosed-principle/ -->
We've defined a Rectangle class with its width and height.

+++

Build an application calculating the rectangles' collection total area.
Hint: keep in mind the SRP!

+++ 

Extend the application calculating circles' area as well.
Hint: abstraction is the key
+++

### (O)pen Closed
##### Thoughts

When a single change to a program results in a cascade of changes to dependent modules, that program becomes fragile, rigid, unpredictable and unreusable.

+++

We should strive to write code that doesn't have to be changed every time the requirements change.

+++

You should extend modules' behaviour adding new code, avoiding changes to the old working code.

---

### (L)iskov Substitution

*An object of type T may be substituted with any object of a subtype S*

*Child classes should never break the parent class type definitions*

+++

### Problem: Add a method to resize a Rectangle

+++

What if we want to resize a Square too?

+++

### (L)iskov Substitution
##### Thoughts

Think about the relation between LSP and OCP

---

### (I)nterface Segregation

*No client should be forced to depend on methods it does not use.*
*Instead of one fat interface many small interfaces are prefered based on groups of methods, each one serving one submodule.*

+++

### Problem: Given a Worker interface and a Person subtype, add a Robot worker
Hint: have you ever seen an eating robot?

---
