class AccessLog {
    private String cardType;
    private String accessTime;
    private String areaAccessed;

    public AccessLog(String cardType, String accessTime, String areaAccessed) {
        this.cardType = cardType;
        this.accessTime = accessTime;
        this.areaAccessed = areaAccessed;
    }

    public void printLog() {
        System.out.println("Card Type: " + cardType + ", Time: " + accessTime + ", Area: " + areaAccessed);
    }
}
