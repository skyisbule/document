package cn.zdnfjx.wd.domain;


public class doc {
    private int id;
    private String name;
    private String content;
    private int isfolder;
    private int father;
    private int belongto;

    public void setId(int id){
        this.id=id;
    }
    public int getId(){return id;}
    public void setName(String name){this.name=name;}
    public String getName(){return name;}
    public void setContent(String conent){this.content=conent;}
    public String getContent(){return content;}
    public void setIsfolder(int is){this.isfolder=is;}
    public int getIsfolder(){return isfolder;}
    public void setFather(int f){this.father=f;}
    public int getFather(){return father;}
    public void setBelongto(int b){this.belongto=b;}
    public int getBelongto(){return belongto;}
}
