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

import groovy.json.JsonSlurper
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

def response = WS.sendRequestAndVerify(findTestObject('POST USER JSON', [('age') : age,
	 ('gender') : gender, ('username') : username, ('password') : password]))

JsonSlurper jsonSlurper = new JsonSlurper()
def jsonResponse = jsonSlurper.parseText(response.getResponseText())

def id = jsonResponse.id
println id

WS.sendRequestAndVerify(findTestObject('GET USER BY ID', [('id') : id,
	 ('username') : username, ('password') : password, ('age') : age, ('gender') : gender]))

