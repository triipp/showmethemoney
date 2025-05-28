# ✨ Automation - ShowMeTheMoney

## Exercise

> Select 3 test cases developed in the first step and generate a set of automated tests that include them, using Cypress/Selenium or any framework in which you feel comfortable.
>
> Since the app is deployed on Heroku, the timeout times may be longer than the default. To change that, we suggest you refer to https://docs.cypress.io/guides/references/configuration#Runner-Specific-Overrides, which ultimately aims to modify the 'cypress.json' file generated in the root of your directory and expose something similar to the JSON shown on the site (the longer it is, the less chance of timeout you have).

---

## 🛠 Tools Used

- <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/d/d5/Selenium_Logo.png/1200px-Selenium_Logo.png" alt="SeleniumLogo" width="15"/> Selenium
- <img src="https://1000marcas.net/wp-content/uploads/2020/11/Java-logo.png" alt="JavaLogo" width="40"/> Java
- <img src="https://upload.wikimedia.org/wikipedia/commons/thumb/5/52/Apache_Maven_logo.svg/1200px-Apache_Maven_logo.svg.png" alt="MavenLogo" width="40"/> Maven
- <img src="https://extentreports.com/wp-content/uploads/2018/09/Extent_logomark_transparentbg.png" alt="ExtentReportLogo" width="15"/> ExtentReports

---

## 📂 Project Structure

```
Automation/
└── showmethemoney/
    ├── pom.xml
    ├── src/
    │   ├── main/java/smtm/pages/     ← Page Object Model
    │   └── test/java/testSmtm.java   ← Main test class with 3 scenarios
    └── target/...
```

---

## Automated Test Scenarios

The following **3 key scenarios** were automated:

1. **Purchase from "My Investments"**
   - Asset with previous holdings
   - Validations: notifications, updated balance, increased holdings, present in pie chart

2. **Sell from "My Investments"**
   - Partial sale of an asset
   - Validations: notification, balance update, decreased holdings, item remains in pie chart

3. **Purchase from "Other Investments"**
   - Asset without previous holdings
   - Validations: appears in "My Investments", new holding added, new asset added to the pie chart

---

## ▶️ Execution

Before running the tests, make sure to execute the specific test class by running:

```bash
mvn -Dtest=testSmtm test
```

The generated HTML reports can be found at:
```
target/Report_smtm.html
```

---

## Notes

All tests are executed against the application:  
[https://sea-lion-app-7celq.ondigitalocean.app/](https://sea-lion-app-7celq.ondigitalocean.app/)

For any issues or doubt, contact me at: **walter.rodriguez.dasilva@gmail.com**

---