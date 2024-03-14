import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import org.openqa.selenium.WebElement 

def getNumberFromSpan(String text) {
	String result = text.replaceAll(".*?</span>", "")
	result = text.replace("</span>","")
	return result
}

WebUI.openBrowser(GlobalVariable.base_url)
//WebUI.scrollToElement(findTestObject('Object Repository/box_list'), 10)

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/box_list'),10)
List<WebElement> parentList = WebUI.findWebElements(findTestObject('Object Repository/box_parent_list'),10)


def lastCount = 1
def i = 0
for(;i < dataList.size(); i++) {
	text = getNumberFromSpan(parentList.get(i).text)
	println text
	println lastCount
	if(text.toString().trim() == lastCount.toString().trim()) {
		WebUI.switchToDefaultContent()
		dataList[i].click()
		dataList = WebUI.findWebElements(findTestObject('Object Repository/box_list'),10)
		parentList = WebUI.findWebElements(findTestObject('Object Repository/box_parent_list'),10)
		lastCount++
		i = 0
	}
}

WebUI.closeBrowser()