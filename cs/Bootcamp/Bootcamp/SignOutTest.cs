using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Bootcamp
{
    [TestClass]
    public class SignOutTest
    {
        [TestMethod]
        public void TestMethod1()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/");
            driver.Manage().Window.Maximize();
            driver.FindElement(By.ClassName("login")).Click(); 
            driver.FindElement(By.Id("email")).SendKeys("andy.leenders@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("azerty789+"); 
            driver.FindElement(By.Id("SubmitLogin")).Click(); 

            Boolean assertBoolean = driver.FindElement(By.ClassName("addresses-lists")).Displayed;
            Assert.IsTrue(assertBoolean);

            driver.FindElement(By.ClassName("logout")).Click();
            String assertUitgelogd = driver.FindElement(By.ClassName("login")).Text;
            Assert.AreEqual("Sign in", assertUitgelogd);
            driver.Close();
        }
    }
}
