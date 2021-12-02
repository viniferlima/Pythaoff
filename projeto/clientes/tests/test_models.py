from django.test import TestCase

from django.shortcuts import render
from selenium import webdriver
import cgi
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import *
from selenium.webdriver.common.action_chains import *
from selenium.webdriver.common.keys import *
from selenium.webdriver.common.desired_capabilities import *
import os
import time
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities

from selenium.webdriver.chrome.service import Service


class TestSelenium(TestCase):

    @classmethod
    def test_release(self):
        options = webdriver.ChromeOptions()

        self.driver = webdriver.Chrome(executable_path='$CHROMEDRIVER_DIR:$PATH',
                                       options=options,
                                       service_log_path='NUL')
        self.vars = {}
        self.driver.get("https://powerbi.microsoft.com/pt-br/")
        self.driver.set_window_size(1280, 680)
        self.vars["window_handles"] = self.driver.window_handles
        self.driver.find_element(By.ID, "power-bi-portal-link-desktop").click()
        self.vars["win6785"] = None
        time.sleep(round(30))
        wh_now = self.driver.window_handles
        wh_then = self.vars["window_handles"]
        if len(wh_now) > len(wh_then):
            self.vars["win6785"] = set(wh_now).difference(set(wh_then)).pop()
        self.driver.switch_to.window(self.vars["win6785"])
        self.driver.find_element(By.ID, "i0116").send_keys(
            "gustavo.santos184@fatec.sp.gov.br")
        self.driver.find_element(By.ID, "idSIButton9").click()
        time.sleep(round(30))
        self.driver.find_element(By.ID, "i0118").click()
        self.driver.find_element(By.ID, "i0118").send_keys("Gu22092012!")
        self.driver.find_element(By.ID, "idSIButton9").click()

        print("A")
        self.driver.get(
            "https://app.powerbi.com/groups/me/reports/24143107-8adf-4df3-a700-dab5cec680bd/ReportSection?ctid=cf72e2bd-7a2b-4783-bdeb-39d57b07f76f")

        time.sleep(round(120))
        element = []
        element = self.driver.find_elements_by_tag_name('tspan')

        for result in element:
            print(result.text)

        self.driver.quit()

        return print("TEST COMPLETED")
