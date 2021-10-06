slidenumbers: true
slidecount: true
autoscale: true
slide-transition: true

# Welcome to CS2030S Lab 5!
## 8 October 2021 [16A]

[.autoscale: false]
[.text: alignment(center)]

Please login to your pe node once it's 4pm.

![inline](https://c.tenor.com/AtKPpo2MXFEAAAAC/dog-burning.gif)

------

# PA1

- Please submit your final changes by **Sunday 2359**.
- A sample solution will be uploaded onto LumiNUS for your reference **after** the submission deadline.

------

# PA2

- In lieu of the current COVID-19 situation, PA2 may be conducted online.
- We will need everyone to test their screen recording software to ensure that it’s working well.

------

# PA2 Admin - Screen Recording

- We recommend using FFMPEG
- You may find instructions on installing and using FFMPEG here: [https://mysoc.nus.edu.sg/academic/e-exam-sop-for-students/](https://mysoc.nus.edu.sg/academic/e-exam-sop-for-students/)
- You may also use any other screen recording of your choice
  Please upload a sample recording onto LumiNUS after your lab for us to verify that your screen recording software is working as intendedYou should upload the recording under Multimedia -> Lab 5 (\<Your lab group\>) 

------

# Submission Statistics

| Labs     | Submitted | Not Submitted | A    |
| -------- | --------- | ------------- | ---- |
| 1🟢       | 17        | 0             | 17🤩  |
| 2🟡       | 17        | 0             | 16   |
| 3🟡       | 16        | 1             | 12   |
| 4🟡       | 17        | 0             | 15   |
| PA1🔴     | 17        | 0             | 6    |
| Project😂 | 1         | 16            | 0    |

------

# Java Generics

Generics enable you to detect errors at compile time rather than at runtime.

```java
public class Box<T> {
    private T item;
    public Box(T item) {
        this.item = item;
    }
}
```

`T` is a generic type.

Declaring `Box<Integer>` replaces all instances of `T` in your code with `Integer`.

------

# Java Generics

- Every instance of `Box` can have a different type that is assigned to `T`.
- Therefore, T belongs to an **instance** of `Box`.
- How do we insert a generic type into a static method or variable?

------

# Java Generics

```java
public class Box<T> {
    private T item;
    public static <T> Box<T> empty() {
        // Pink T replaces all the Ts in this method
    }
}
```

- Solution: Declare `<T>` in front of a static method.
- Pink `T` is different from red `T`, even though we use the same letter for both of them.
- Pink `T` only exists within the scope of the static method; red `T` exists in all other instance attributes of `Box`.

------

# Map

- A map is a data structure which maps a key to a value.
- One key can only be mapped to one value.
- Mapping a an existing key to another value will replace the current mapping in the map.
- Think of it as a dictionary (for students familiar with Python/JavaScript).

------

# HashMap

- HashMaps are Maps which are backed by a hash table (you will learn more about this in CS2040/C/S).

- They require the use of two generic types (one for the key and one for the value).

- To declare a HashMap with keys of type A and values of type B:

  - ```java
    HashMap<A, B> map = new HashMap<A, B>();
    ```

------

| Method                               | Description                                                  |
| ------------------------------------ | ------------------------------------------------------------ |
| .put(YourClass key, YourClass value) | Adds *key* to the HashMap with the value *value*             |
| .clear()                             | Clears the HashMap                                           |
| .containsKey(Object o)               | Checks if key *o* is in the HashMap, based off the object’s equals() method |
| .containsValue(Object o)             | Checks if value *o* is in the HashMap, based off the object’s equals() method |
| .get(Object o)                       | Gets the value corresponding to the key *o*                  |
| .isEmpty()                           | Checks if the HashMap is empty                               |

------

| Method            | Description                                                  |
| ----------------- | ------------------------------------------------------------ |
| .remove(Object o) | Removes the entry with key *o* if it is in the HashMap, based off the object’s equals() method |
| .size()           | Returns the number of elements in the HashMap                |
| .entrySet()       | Returns a set of all entries in the HashMap                  |
| .keySet()         | Returns a set of all keys in the HashMap                     |
| .values()         | Returns a collection of all values in the HashMap            |

