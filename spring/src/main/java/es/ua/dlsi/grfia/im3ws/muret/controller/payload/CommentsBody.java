package es.ua.dlsi.grfia.im3ws.muret.controller.payload;

public class CommentsBody {
    long id;
    String comments;

    public CommentsBody() {
    }

    public CommentsBody(long id, String comments) {
        this.id = id;
        this.comments = comments;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}
