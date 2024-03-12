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

WebUI.callTestCase(findTestCase('Login/TC_Login_001 (Manual)'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.selectOptionByValue(findTestObject('Object Spy/dropdown_facility'), GlobalVariable.facility, false)

//Kondisi jika readmission true -> check
if(GlobalVariable.readmission == true) {
	WebUI.check(findTestObject('Object Spy/cb_readmission'))
}

if(GlobalVariable.program == "Medicare") {
	WebUI.check(findTestObject('Object Repository/Object Spy/input_Medicare_programs'))
} else if(GlobalVariable.program == "Medicaid") {
	WebUI.check(findTestObject('Object Spy/input_Medicaid_programs'))
} else {
	WebUI.check(findTestObject('Object Repository/Object Spy/input_None_programs'))
}

WebUI.setText(findTestObject('Object Spy/input_visitdate'), GlobalVariable.visit_date)

WebUI.setText(findTestObject('Object Spy/textarea_comment'), GlobalVariable.comment)

WebUI.click(findTestObject('Object Spy/button_Book Appointment'))

WebUI.verifyElementText(findTestObject('Object Spy/output_facility'), GlobalVariable.facility)

String hospital_readmission = "No"
if(GlobalVariable.readmission == true) {
	hospital_readmission = "Yes"
}

WebUI.verifyElementText(findTestObject('Object Repository/Object Spy/output_hospital_readmission'), hospital_readmission)

WebUI.verifyElementText(findTestObject('Object Spy/output_healthcare_program'), GlobalVariable.program)

WebUI.verifyElementText(findTestObject('Object Spy/output_visit_date'), GlobalVariable.visit_date)

WebUI.verifyElementText(findTestObject('Object Spy/output_comment'), GlobalVariable.comment)

