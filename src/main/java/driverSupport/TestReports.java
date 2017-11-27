package driverSupport;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Screenshot.Screenshot.takeScreenshot;

/**
 * Created by Дмитрий on 09.10.2017.
 */
public class TestReports implements ITestListener {

    SimpleDateFormat df = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
    Date dateobj = new Date();

    @Override
    public void onTestStart(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getName()+" started at : "+df.format(dateobj));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getName()+" passed.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // TODO Auto-generated method stub

        System.out.println(result.getName()+" failed.");
        try{
            takeScreenshot(result.getName());
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getName()+" skipped.");
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // TODO Auto-generated method stub
        System.out.println(result.getName()+" failed partially.");
    }

    @Override
    public void onStart(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println(context.getName()+" Tests started at : "+df.format(dateobj));
    }

    @Override
    public void onFinish(ITestContext context) {
        // TODO Auto-generated method stub
        System.out.println("Tests passed are \n"+context.getPassedTests());
        System.out.println("Tests failed are \n"+context.getFailedTests());
    }

}
