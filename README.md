# Automation Exercise - QA Testing Project

A comprehensive QA testing project built on the [Automation Exercise](https://automationexercise.com) website — a practice e-commerce platform designed for testing purposes. This project demonstrates a complete testing lifecycle: manual test case design, UI automation, and API testing.

## 📋 Table of Contents

- [About the Project](#about-the-project)
- [Testing Scope](#testing-scope)
- [Tech Stack & Tools](#tech-stack--tools)
- [Project Structure](#project-structure)
- [Manual Testing](#manual-testing)
- [Automation Testing](#automation-testing)
- [API Testing](#api-testing)  
- [License](#license)

---

## 📖 About the Project

This project targets **[Automation Exercise](https://automationexercise.com)**, a demo e-commerce website built specifically for practicing and showcasing software testing skills. The goal is to validate the site's core functionalities — user registration, login, product browsing, cart operations, checkout flow, and backend APIs — through a mix of manual and automated testing approaches.


---

## 🎯 Testing Scope

- User Registration — sign-up form, fields validation, email validation
- User Login / Logout — correct & incorrect credentials, session management
- Account Deletion — delete flow and confirmations
- Home Page — navigation, recommended items, scroll, footer
- Products — View all, product detail, search, category & brand filters
- Product Review — submit review on product page
- Shopping Cart — add, view, update quantity, remove, totalsCheckout — 3 order scenarios (register during/before/login before       checkout), address & invoice
- Cart Persistence after Login — cart data retained post login
- Contact Us — form submission, file upload, success message
- Subscription — subscribe from home page and footer
- API Endpoints — all REST APIs (productsList, brandsList, searchProduct, verifyLogin, createAccount, getUserDetailByEmail, etc.)

---

## 🛠️ Tech Stack & Tools

| Category                | Tools |
| **Manual Testing**     | Excel Sheet  |
| **Automation Testing** | Selenium WebDriver, Java , OOP , TestNG , POM , DDT |
| **API Testing**        | Postman |
| **Version Control**    | Git & GitHub |


---

## 📁 Project Structure

```
├── Project Plannimg/
│   └── Testing Plan
├── Requirement Gathering
│   └── User Story 
├── manual-testing/
│   ├── test-cases/          # Test case documents
│   └── bug-reports/
├── Implementation       
|   ├──  automation-testing/
│         ├── src/                 # Automation scripts (Page Objects, Tests)
│          └── testng.xml           # Test suite configuration
├   ├── postman/
│         ├── AutomationExercise.postman_collection.json
└── README.md

---

## 🖱️ Manual Testing

Manual test cases cover the core user journeys on Automation Exercise, including:

- User signup, login, and account management
- Product browsing, search, and filtering
- Add to cart, update quantity, and remove items
- Checkout and order placement flow
- Form validations (Contact Us, Subscription)

---

## 🤖 Automation Testing

UI automation scripts simulate real user interactions to validate the website's functionality without manual intervention, following the **Page Object Model (POM)** design pattern for maintainability.

**Covered scenarios include:**
- Automated login/signup flow
- Automated cart and checkout process
- Automated Product browsing, search, and filtering
- Automated Add to cart, update quantity, and remove items 
- Automated Form validations (Contact Us, Subscription)

---

## 🔗 API Testing

API testing was performed using **Postman** against the Automation Exercise public API endpoints (e.g. product list, product details, user account APIs), validating:

- Response status codes
- Response schema/body structure
- Response time
- Positive & negative test scenarion

## 📄 License

This project is for educational and practice purposes using the public [Automation Exercise](https://automationexercise.com) demo website.

---

<p align="center">Made with 🧪 for QA practice</p>
