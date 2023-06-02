package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReport {
    static ExtentReports extentReport;

    public static ExtentReports getExtentReport() {

        String extentReportPath = System.getProperty("user.dir") + "/reports/extentreport.html";
        ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
        reporter.config().setReportName("TutorialsNinja Automation Results");
        reporter.config().setDocumentTitle("Test Results");

        extentReport = new ExtentReports();
        extentReport.attachReporter(reporter);
        extentReport.setSystemInfo("Operating System", "macOS Ventura");
        extentReport.setSystemInfo("Tested By", "Krupa");

        return extentReport;

    }
}
