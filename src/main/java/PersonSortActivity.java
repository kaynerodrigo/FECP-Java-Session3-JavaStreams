class Person {
    public String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // getter methods
    public String getName() {
        return this.name;
    }

    public Integer getAge() {
        return this.age;
    }

    // A toString method for clean printing
    @Override
    public String toString() {
        String printOutput = this.name + " - " + this.age;
        return printOutput ;
    }
}