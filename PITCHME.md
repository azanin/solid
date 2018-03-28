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

Try to print out its content as a string to the console.

+++

What if we want to print the post's content as a json string to the console?

Hint: Separation of business logic and data presentation is important!
<!-- Mixing business logic with presentation is bad because it is against the Single Responsibility Principle (SRP)-->

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

### (D)ependency Inversion

*One should depend upon abstractions, not concretions*

+++

### Problem: WeatherAggregator

```java
import com.tidyjava.weather.api1.WeatherApi1;
import com.tidyjava.weather.api2.WeatherApi2;

public class WeatherAggregator {
    private WeatherApi1 weatherApi1 = new WeatherApi1();
    private WeatherApi2 weatherApi2 = new WeatherApi2();

    public double getTemperature() {
        return (weatherApi1.getTemperatureCelcius() + toCelcius(weatherApi2.getTemperatureFahrenheit())) / 2;
    }

    private double toCelcius(double temperatureFahrenheit) {
        return (temperatureFahrenheit - 32) / 1.8f;
    }
}
```

+++

Do you see any problems?

+++

Solving the creation problem

```java
public WeatherAggregator(WeatherApi1 weatherApi1, WeatherApi2 weatherApi2) {
        this.weatherApi1 = weatherApi1;
        this.weatherApi2 = weatherApi2;
    }
```
+++

Inverting the control... Abstract over concrete implementation

+++

```java
public interface WeatherSource {
    float getTemperatureCelcius();
}
```
+++

```java
public double getTemperature() {
        return weatherSources
            .stream()
            .mapToDouble(WeatherSource::getTemperatureCelcius)
            .average()
            .getAsDouble();
    }
```

+++

### (D)ependency Inversion
#### Thoughts

Inversion of control is sometimes facetiously referred to as the "Hollywood Principle: Don't call us, we'll call you".

Dependency inversion is critically important for the construction of code that is resilient to change.
And, since the abstractions and details are all isolated from each other, the code is much easier to test and maintain.

---

### A Complete Exercise

We'd like to extract some useful information from github.com about all the repositories belonging to ekmett user.

The goal is to create two different reports:

+++

Plain text report containing the most starred repo's summary.

Json file report containing all the repos belonging to ekmett.

+++

You can query for repos at *https://api.github.com/users/ekmett/repos*

A response example is available in project's resources folder.

+++
Plain text file

This reports must be in the following form:

``` ${user} owns ${num} repos.
  His most starred one is ${repo_name} with ${num_stars} stars.
  Here is a brief description: ${description}
  Here's the last ${n} commit(s) of it available at ${https://api.github.com/repos/ekmett/${repo}/commits }
  ${list of commit messages}
  Here's ${contributors_url} you can find all the contributors.
```

Plus: the commit messages' number should be configurable.

+++
Json file report must be in the following format

```json
{
	"user": "ekmett",
	"repos": [{
		"id": 85458673,
		"name": "compiler",
		"stargazers": 10,
		"description": "description",
		"commits": ["commit message1","commit message2"]
	}]
}
```
---

### Functional Programming

+++

Let's starting from WHAT IS NOT...

---

### Imperative Programming Style

Programs are composed by statements that "do" something:

> *Do this and then Do that*

+++

### State Mutations, here we are!

```
int y = 1;
...
public void do(int x) {
    y++;
    System.out.println("doing something with "+x);
}
...
do(y);
++y;
```

This imply an initial state, transitions, and an end state.

---

### Introducing Functional Programming (FP) Style

Functional programs are composed by expressions "evaluating" something
```
public int do(int x) {
    return ++x;
}
int y = do(1);
int z = do(y);
```

+++

### Introducing Functional Programming (FP) Style

Major difference between imperative and functional programming:  *No (Observable) Side Effects*
- No mutation of variables
- No printing to the console or to any device
- No writing to files, databases, networks, or whatever
- No exception throwing

+++

### Introducing Functional Programming (FP) Style

In other words, programs are composed by functions having no observable effects on the program's execution other than compute results given its inputs.

---

### So... What about this code?

```java
public static int add(int a, int b) {
    while (b > 0) {
        a++;
        b--;
    }
    return a;
}
```

+++

### Pure Functions

- returns a value and do nothing else.
- don't mutate any element of the outside world
- don’t mutate their arguments
- don’t explode if an error occurs
    - can return an exception or anything else
    - must return it, not throw it, nor log it, nor print it

+++

### (Im)Pure Functions

```java
Set<Integer> s = new HashSet<>();

public static boolean foo(int x) {
    return s.contains(Integer.valueOf(x))
}

s.add(Integer.valueOf(1));
foo(1); //true
s.remove(Integer.valueOf(1))
foo(1) //false
```

---

### How to make programs safer

```
int x = add(1, 0)
int y = add(x, 1)
int z = add(x, y)
int w = 3
assert z == w //true
```
Expressions can be replaced by theirs results without changing the meaning of the program if **Referential Transparency Principle** hold.

---

### Can you write useful programs without side effects?

In practise obviously, you can’t.

In the end, also functional programs have to have an observable effect, such as displaying the result on a screen, or sending it over a network.

+++

### Can you write useful programs without side effects?

This interaction with the outside world won’t occur in the middle of a
computation, but only when you finish the computation.

In other words, side effects will be delayed and applied separately.

---

### Try yourself

```java
public static int div(int a, int b) {
    return a / b;
}
```

+++

### Try yourself

Hint: wrapping effects is the key...