package Topinfo;

public class setTopinfo {
    private int height = 0; // 길이
    private int shoulderwidth = 0; // 어깨 너비
    private String name = "";
    private String size = "";
    private String path = "";

    public void setHeight(int height){
        this.height = height;
    }
    public void setShoulderwidth(int shoulderwidth){
        this.shoulderwidth = shoulderwidth;
    }
    public void setName(String name){this.name = name;}
    public void setSize(String size){this.size = size;}
    public void setPath(String path){this.path = path;}

    public int getHeight(){
        return height;
    }
    public int getShoulderwidth(){
        return shoulderwidth;
    }
    public String getName(){
        return name;
    }
    public String getSize(){return size;}
    public String getPath(){return path;}
}