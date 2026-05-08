package pe.edu.upc.apirev.dtos;

public class RecyclingDTO {
    private int RecyclingId;
    private String RecyclingName;
    // private int idmaterial;
    private int Userid;

    public int getRecyclingId() {
        return RecyclingId;
    }

    public void setRecyclingId(int recyclingId) {
        RecyclingId = recyclingId;
    }

    public String getRecyclingName() {
        return RecyclingName;
    }

    public void setRecyclingName(String recyclingName) {
        RecyclingName = recyclingName;
    }

    public int getUserid() {
        return Userid;
    }

    public void setUserid(int userid) {
        Userid = userid;
    }
}
