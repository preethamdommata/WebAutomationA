package common;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ITestListenerClass extends BaseSpec implements ITestListener{

    @Override
    public void onTestFailure(ITestResult result){
        String nameOfScreenShot = result.getMethod().getMethodName();
        takeScreenShot(nameOfScreenShot);
    }
    
}
