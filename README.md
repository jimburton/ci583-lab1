# CI583 Lab 1

Get a copy of this code by downloading the zip file from github.com or
using git to create a clone of the repository. Open the project in
your favourite IDE. If you aren't used to using an IDE, rather than a
simpler kind of editor, I can help with that in the labs.

Solutions to these problems are stored in a branch of the repository
called `solution`. You can view it on the github website or by
checking out the branch.

This problem is about managing and searching collections of
objects. The objects are instances of the `Person` class, a simple
class that stores two strings (`firstName` and `lastName`) and an int
(`age`). 

You will implement two types of collection: *unordered* and *ordered*.
It is easy to insert a new object to the unordered collection as you 
can just put it anywhere. However, when you search for an item you may
beed to loop through the whole collection. It is trickier to insert a
new item into an ordered collection, as you have to put it in the
right place. On the other hand, you can use smarter strategies when
searching for data.

Read the source code of the classes in the project. The project
provides two collections which are intended to store `Person`
objects. The `PeopleArray` class is the *superclass* of
`UnorderedPeopleArray` and `OrderedPeopleArray`.

The code comes with *unit tests* in the `test` package, which you can
run to check your work. The way that you run these depends on the IDE
that you're using. The first thing you need to do is to add the JUnit
library to the project. After that it is usually as simple as
right-clicking on the test and selecting the option to run it -- ask
for help with this in the labs or google the procedure for your
IDE.

`PeopleArray` has two fields, `arr` and `nElems`, both of which are
inherited by its subclasses. `arr` is a Java array, and this is where
we will store the `Person` objects. `nElems` is a counter for the
number of objects currently in the array. `PeopleArray` also contains
methods that are common to both of its subclasses (for example,
whether the collection is ordered or unordered, clearing the
collection will work in the same way) and the signatures of several
*abstract* methods. Each subclass will need to provide an
implementation of those abstract methods, since it is to be expected
that the implementations will differ from each other (e.g. inserting a
new item to a sorted collection is more complicated than inserting to
an unsorted collection, because the new item has to go in the right
place).

1. Implement the `clear` method in `PeopleArray`. This has to remove
   all items in the array. You could loop through `arr` and set every
   element to `null`, but this is rather inefficient. As you know how
   many items are in the array (`nElems`), you only need to loop that
   far.

2. Implement the `insert` method in the `UnorderedPeopleArray` class,
   using the comment above the method as a guide. If the array is
   already full (compare the counter `nElems` to the length of the
   array) return false straight away.  Otherwise, inserting to an
   unordered collection is easy -- just make a new `Person` object
   using the parameters of the method and put it in the "last"
   position. You know which is the last position because you have
   `nElems`. Don't forget to increment the counter after inserting. If
   everything went well, the method should
   end by returning `true`.
   
3. Implement the `delete` method in `PeopleArray`. This has to remove
   the item with the same last name as the argument to the method. You
   will need to loop through the array, comparing the last name of
   each item in the array to the string you have been given. If you
   get to the end of the data without finding what you were looking
   for, return `false`. If you do find the item to be removed, you
   need to overwrite it. The best way to do that is to start a new
   loop at the index where you found the item, say `j`, and loop from
   `j` to the end of the data setting each element `arr[j]` to
   `arr[j+1]`. The will have the effect of "shuffling" everything one
   place to the left. You must decrement the counter after deleting an
   item.
    
Now you can test your work by running the unit tests in the class
`ci583.lab1.test.TestUPeopleArray`. How to do this depends on the IDE
you are using -- ask for help in the labs. Most tests will fail, but
the one that tests the `insert` method should pass. As you continue
the problems below, keep running the tests.
    
4. Implement the `find` method in the `UnorderedPeopleArray`
   class. Again, use the comment above the method as a guide. Finding
   an object in an unordered collection is easy (but costly, because
   you may have to search the whole collection) -- just loop through
   the array comparing the last name of each object
   to the string you are given as a parameter to the method.
      
5. Implement the `insert` method in the `OrderedPeopleArray`
   class. Again, return `false` if the array is full. Otherwise, you
   need to find the right place to store the new `Person` object, so
   you will need to loop through the array to do that. For each
   element in the array, compare its last name to the one you have
   been given using the `compareTo` method which every string has. 
   
   If you have two strings, `s1` and `s2`, calling `s1.compareTo(s2)`
   will return a number less than 0 if `s1` is (lexicographically)
   less than `s2`, 0 if they are equal, and a number greater than 0 if
   `s1` is greater than `s2`. If the strings are equal or the last
   name of the object in the array is greater than the one you want to
   insert, you have found the right place to put the new object.  You
   then need to "shuffle" everything to the right to make space for
   it, so you will need an inner loop similar to the one in the
   `delete`. However, this one should start at the end of the data
   setting each item, say `arr[j]`, to `arr[j-1]`. If, in the outer
   loop, you loop all the way to the end of the data without finding
   the right place to put the new item, the new item is greater than
   anything else in the list so it should go at the end.
   
6. Implement the `find` method in the `OrderedPeopleArray` using
   the Binary Search algorithm. Refer to the slides from Week 1 to
   implement the algorithm. As with the previous problem, you can use
   `compareTo` to see if one string is "less than", equal to or
   "greater than" another.
   
7. Returning to the `clear` method, if your implementation loops
   through the array then there's a much more efficient way to do it,
   which has constant time complexity (O(1)). Hint: think about how
   the various loops you have written use `nElems`. 
