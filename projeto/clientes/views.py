from django.shortcuts import render
from selenium import webdriver
import cgi
from selenium.webdriver.chrome.options import Options
from selenium.webdriver.common.by import *
from selenium.webdriver.common.action_chains import *
from selenium.webdriver.common.keys import *
from selenium.webdriver.common.desired_capabilities import *

import time
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities


def home(request):
    return render(request, 'paginicial.html')


def pesq(scraper):
    options = Options()
    browser = webdriver.Chrome(executable_path="C:\\Users\\GustaX\\Downloads\\proj (1)\\proj\\chromedriver.exe",
                               options=options,
                               service_log_path='NUL')


def teardown_method(self, method):
    self.driver.quit()


def wait_for_window(self, timeout=2):
    time.sleep(round(timeout / 1000))
    wh_now = self.driver.window_handles
    wh_then = self.vars["window_handles"]
    if len(wh_now) > len(wh_then):
        return set(wh_now).difference(set(wh_then)).pop()


def test_testeagain(self):
    options = Options()
    self.driver = webdriver.Chrome(executable_path="C:\\Users\\GustaX\\Downloads\\proj (1)\\proj\\chromedriver.exe",
                                   options=options,
                                   service_log_path='NUL')
    self.vars = {}
    self.driver.get("https://powerbi.microsoft.com/pt-br/")
    self.driver.set_window_size(1280, 680)
    self.vars["window_handles"] = self.driver.window_handles
    self.driver.find_element(By.ID, "power-bi-portal-link-desktop").click()
    self.vars["win6785"] = None
    time.sleep(round(60))
    wh_now = self.driver.window_handles
    wh_then = self.vars["window_handles"]
    if len(wh_now) > len(wh_then):
        self.vars["win6785"] = set(wh_now).difference(set(wh_then)).pop()
    #self.vars["win6785"] = self.wait_for_window(2000)
    self.driver.switch_to.window(self.vars["win6785"])
    self.driver.find_element(By.ID, "i0116").send_keys(
        "gustavo.santos184@fatec.sp.gov.br")
    self.driver.find_element(By.ID, "idSIButton9").click()
    time.sleep(round(60))
    self.driver.find_element(By.ID, "i0118").click()
    self.driver.find_element(By.ID, "i0118").send_keys("Gu22092012!")
    self.driver.find_element(By.ID, "idSIButton9").click()

    self.driver.get(
        "https://app.powerbi.com/groups/me/reports/24143107-8adf-4df3-a700-dab5cec680bd/ReportSection?ctid=cf72e2bd-7a2b-4783-bdeb-39d57b07f76f")

    time.sleep(round(120))
    self.driver.find_element(
        By.CSS_SELECTOR, ".visualContent:nth-child(5) tspan")

    return render(scraper, 'scrap.html')

# Create your views here.
