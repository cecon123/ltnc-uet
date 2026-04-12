public class Config implements Cloneable {

    private String appName;
    private String theme;

    public Config(String appName, String theme) {
        this.appName = appName;
        this.theme = theme;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public Config clone() {
        try {
            return (Config) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone thất bại", e);
        }
    }

    public void printConfig() {
        System.out.println("appName = " + appName + ", theme = " + theme);
    }
}
