package smtm.resources;

public class Data {
    private String url;
    private String reports;
    private String screenshot;
    private TestData test1data;
    private TestData test2data;
    private TestData test3data;

    public Data(String url, String reports, String screenshot, TestData test1data, TestData test2data,
            TestData test3data) {
        this.url = url;
        this.reports = reports;
        this.screenshot = screenshot;
        this.test1data = test1data;
        this.test2data = test2data;
        this.test3data = test3data;
    }

    public String getUrl() {
        return url;
    }

    public String getReports() {
        return reports;
    }

    public String getScreenshot() {
        return screenshot;
    }

    public TestData getTest1data() {
        return test1data;
    }

    public TestData getTest2data() {
        return test2data;
    }

    public TestData getTest3data() {
        return test3data;
    }
}
