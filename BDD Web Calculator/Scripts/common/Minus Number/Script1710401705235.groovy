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

def clickNumber(String number) {//bisa 1 digit, bisa 2 digit
	
	def digits = number.toCharArray()
	for(def digit : digits) {
		println "digit" + digit
		switch (digit) {
			case '0':
			WebUI.click(findTestObject('Object Repository/button_0'))
			break
			case '1':
			WebUI.click(findTestObject('Object Repository/button_1'))
			break
			case '2':
			WebUI.click(findTestObject('Object Repository/button_2'))
			break
			case '3':
			WebUI.click(findTestObject('Object Repository/button_3'))
			break
			case '4':
			WebUI.click(findTestObject('Object Repository/button_4'))
			break
			case '5':
			WebUI.click(findTestObject('Object Repository/button_5'))
			break
			case '6':
			WebUI.click(findTestObject('Object Repository/button_6'))
			break
			case '7':
			WebUI.click(findTestObject('Object Repository/button_7'))
			break
			case '8':
			WebUI.click(findTestObject('Object Repository/button_8'))
			break
			case '9':
			WebUI.click(findTestObject('Object Repository/button_9'))
			break
		}
	}
}

clickNumber(number1.toString())

WebUI.click(findTestObject('Object Repository/button_-'))

clickNumber(number2.toString())

WebUI.click(findTestObject('Object Repository/button_equal'))
