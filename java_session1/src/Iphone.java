public class Iphone {
    public String name;
    public String color;
    private String memory;

    public void setMemory(String memory){
        this.memory = memory;
    }
    public String getMemory(){
        return memory;
    }
    public void colorChange(String newColor){
        color = newColor;
    }
}
