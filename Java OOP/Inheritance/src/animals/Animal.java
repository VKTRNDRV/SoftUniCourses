package animals;

public class Animal {
    private String name;
    private int age;
    private String gender;

    public Animal(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }

    public String produceSound() {
        return "Animal sound";
    }

    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append(this.getName()).append(" ")
                .append(this.getAge()).append(" ")
                .append(this.getGender())
                .append(System.lineSeparator())
                .append(this.produceSound());
        return stringBuilder.toString().trim();
    }

}
