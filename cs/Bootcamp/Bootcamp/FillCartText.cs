﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Bootcamp
{
    [TestClass]
    public class FillCartText
    {
        [TestMethod]
        public void TestMethod1()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/");
            driver.Manage().Window.Maximize();
            driver.FindElement(By.CssSelector("#header > div:nth-child(2) > div > div > div:nth-child(4) > div > a")).Click();
            Boolean assertCart = driver.FindElement(By.ClassName("alert-warning")).Displayed;
            Assert.IsTrue(assertCart);
            
            driver.FindElement(By.CssSelector("#block_top_menu > ul > li:nth-child(2) > a")).Click();
            //driver.FindElement(By.XPath("//*[@id=\"product_list\"]/li[2]/div/div[2]/h5/a[text()='iPod shuffle']")).Click();
            driver.FindElement(By.XPath("//*[@id=\"product_list\"]/li[2]/div/div[2]/h5/a[text()[contains('iPod shuffle')]]")).Click();
        }
    }
}