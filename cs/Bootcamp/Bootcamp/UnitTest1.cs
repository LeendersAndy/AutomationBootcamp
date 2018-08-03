using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;

namespace Bootcamp
{
    [TestClass]
    public class UnitTest1
    {
        [TestMethod]
        public void TestMethod1()
        {
            IWebDriver driver = new ChromeDriver();
            driver.Navigate().GoToUrl("https://techblog.polteq.com/testshop/index.php"); Console.WriteLine("Navigated to page");
            driver.FindElement(By.ClassName("login")).Click();Console.WriteLine("Clicked on the login button");
            driver.FindElement(By.Id("email")).SendKeys("andy.leenders@polteq.com");
            driver.FindElement(By.Id("passwd")).SendKeys("azerty789+");Console.WriteLine("Filled in the user details");
            driver.FindElement(By.Id("SubmitLogin")).Click(); Console.WriteLine("Submitted the login");

            Boolean assertBoolean = driver.FindElement(By.ClassName("addresses-lists")).Displayed;
            Assert.IsTrue(assertBoolean);
            driver.Close(); Console.WriteLine("Succesfully pasted the test");
        }
    }
}
