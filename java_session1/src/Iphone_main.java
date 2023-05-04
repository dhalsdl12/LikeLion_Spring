public class Iphone_main {
    public static void main(String[] args) {
        Iphone iphone14;
        iphone14 = new Iphone();

        iphone14.name = "ohmin's iphone";
        iphone14.color = "black";
        iphone14.setMemory("512G");

        System.out.println("name : " + iphone14.name + "\n" +
                "color : " + iphone14.color + "\n" +
                "memory : " + iphone14.getMemory());
        System.out.println();

        iphone14.colorChange("white");
        System.out.println("name : " + iphone14.name + "\n" +
                "color : " + iphone14.color + "\n" +
                "memory : " + iphone14.getMemory());
    }
}