package top.yf.requestservice.entity;

public class ShareVO {
    private Integer id;
    private String avatarUrl;

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public TShare gettShare() {
        return tShare;
    }

    public void settShare(TShare tShare) {
        this.tShare = tShare;
    }

    private String userName;

    private TShare tShare;
}
