package one;

import lombok.Getter;

public class Test {
    public static void main(String[] args) {
        Dog aDog = new Dog("Max");
        Dog oldDog = aDog;

        // we pass the object to foo
        foo(aDog);
        // aDog variable is still pointing to the "Max" dog when foo(...) returns
        System.out.println(aDog.getName().equals("Max")); // true
        System.out.println(aDog.getName().equals("Fifi")); // false
        System.out.println(aDog == oldDog); // true
        reverse("sd");


    }

    public static void foo(Dog d) {
        System.out.println(d.getName().equals("Max")); // true
        // change d inside of foo() to point to a new Dog instance "Fifi"
        d = new Dog("Fifi");
        System.out.println(d.getName().equals("Fifi")); // true
    }


    public static void reverse(String s) {
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        System.out.println(sb.toString());

        StringBuilder sb1 = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            sb1.append(s.charAt(i));
        }
        System.out.println(sb1.toString());


    }


}


@Getter
class Dog {
    String name;

    Dog() {

    }

    Dog(String name) {
        this.name = name;
    }
}