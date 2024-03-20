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

WebUI.callTestCase(findTestCase('Login/TC Login'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Product Page/dropdown_sorting'), 'za', false)

List<WebElement> dataList = WebUI.findWebElements(findTestObject('Object Repository/Product Page/product_list'), 0)

String[] arrOri = new String[dataList.size()] //deklarasi array kosong dgn panjang datalist.size
String[] arrSort = new String[dataList.size()] //deklarasi array kosong dgn panjang datalist.size


for(int i = 0; i < dataList.size(); i++) {
	def text = dataList.get(i).text
	
	arrOri[i] = text
	arrSort[i] = text
}

//Arrays.sort(arrSort) //Sort Ascending
Arrays.sort(arrSort,Collections.reverseOrder()) //Sort Descending

assert arrOri == arrSort

