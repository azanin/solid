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

- Hint: try to separate the business logic from the presentation.
- Mixing business logic with presentation is bad because it is against the Single Responsibility Principle (SRP)

+++

### What if you have to print its content on a file?

---
# S => Single Responsability
### Thoughts

*Definition * A class should have only one reason to change
--


???
* For most of its development the Game class was handling two separate responsibilities.
It was keeping track of the current frame, and
it was calculating the score. In the end, RCM and RSK separated these two responsibilities
into two classes. The Game kept the responsibility to keep track of frames, and the Scorer
got the responsibility to calculate the score. (see page 83.)

* Why was it important to separate these two responsibilities into separate classes?
Because each responsibility is an axis of change. When the requirements change, that
change will be manifest through a change in responsibility amongst the classes. If a class
assumes more than one responsibility, then there will be more than one reason for it to
change.

--

* **If a class has more than one responsibility, then the responsibilities become coupled**.
Changes to one responsibility may impair or inhibit the class’ ability to meet the others.
This kind of coupling leads to fragile designs that break in unexpected ways when
changed.

---

# SRP Violation: Books That Can "Print" or "Save" Themselves
---

# O => Open | Closed

---

# Link


# S

1. Introduction
2. Deep-dive
3. ...

---