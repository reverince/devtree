package io.github.reverince.devtree.data;

public class Board {
    private String themeName;
    private String beginningDate;
    private int achievedTopic;
    private int remainingTopic;

    public Board(String themeName, String beginningDate, int achievedTopic, int remainingTopic) {
        this.themeName = themeName;
        this.beginningDate = beginningDate;
        this.achievedTopic = achievedTopic;
        this.remainingTopic = remainingTopic;
    }

    public String getThemeName() {
        return themeName;
    }

    public void setThemeName(String themeName) {
        this.themeName = themeName;
    }

    public String getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(String beginningDate) {
        this.beginningDate = beginningDate;
    }

    public int getAchievedTopic() {
        return achievedTopic;
    }

    public void setAchievedTopic(int achievedTopic) {
        this.achievedTopic = achievedTopic;
    }

    public int getRemainingTopic() {
        return remainingTopic;
    }

    public void setRemainingTopic(int remainingTopic) {
        this.remainingTopic = remainingTopic;
    }
}
