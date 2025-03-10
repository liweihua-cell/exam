package JDBC;

/**
 * @author liweihua
 * @classname BaseInfo
 * @description TODO
 * @date 2023/9/4 9:48
 */
public class Student {
    private int sid;
    private String sname;
    private int sage;
    private int classid;

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public int getSage() {
        return sage;
    }

    public void setSage(int sage) {
        this.sage = sage;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }
}
