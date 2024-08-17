# Automation and Manual Testing Assignment

This repository contains automation and manual testing tasks assigned as part of a testing assessment. Below is an overview of the tasks and how to execute them.

## Table of Contents

- [Automation Testing](#automation-testing)
  - [Task 1: Drag and Drop and ToolTip Test](#task-1-drag-and-drop-and-tooltip-test)
  - [Task 2: Google Search Assertion Test](#task-2-google-search-assertion-test)
  - [Task 3: OrangeHRM Recruitment Test](#task-3-orangehrm-recruitment-test)
- [Manual Testing](#manual-testing)
  - [Task 1: Exploratory Testing](#task-1-exploratory-testing)
  - [Task 2: Test Case Writing](#task-2-test-case-writing)
- [Setup Instructions](#setup-instructions)
- [How to Run](#how-to-run)
- [Contact](#contact)

## Automation Testing

### Task 1: Drag and Drop and ToolTip Test

This test performs the following steps:
1. Navigate to `google.com` and search for `demoqa.com`.
2. Click on the first result and navigate to the `Droppable` element in the `Interactions` section.
3. Perform a drag-and-drop action from the “Drag me” box to the “Drop here” box.
4. Print out the text from the “Drop here” box and take a screenshot.
5. Navigate to the `ToolTips` link in the `Widgets` section.
6. Hover over the "Hover me to see" button and print out the text from the tooltip.

### Task 2: Google Search Assertion Test

This test performs the following steps:
1. Navigate to `google.com` and search for `cheese`.
2. Use a JUnit assertion to compare the number of results to `777`.
3. The test is designed to fail with the message: "There is too much cheese on the internet".

### Task 3: OrangeHRM Recruitment Test

This test performs the following steps:
1. Navigate to `https://orangehrm-demo-7x.orangehrmlive.com/` and log in using prefilled admin credentials.
2. Wait for the dashboard page to load and then navigate to the `Recruitment` page.
3. Open the left side panel, click on `Candidates`, and print out the number of candidates.
4. Click the green `Add` button, fill in the mandatory fields (including resume), and save the candidate.
5. Use a JUnit assertion to verify that the number of candidates has increased by 1.
6. Select the newly created candidate, click on the three dots, and delete the candidate.
7. Use a JUnit assertion to verify that the number of candidates has decreased by 1.
8. Logout of the application.
9. An error is being happened while trying to click on button addCandidates. So adding new candidate, deleting them and logout doesn't happening, but code for that is provided.

## Manual Testing

### Task 1: Exploratory Testing

For this task:
- Perform manual exploratory testing on the following two websites:
  - [Gates N Fences](http://www.gatesnfences.com/index.html)
  - [Liberty Van](http://www.libertyvan.com/)

**Instructions:**
- Use the latest version of Chrome, Firefox, or Edge.
- Report any found issues in a text document (e.g., MS Word).
- Each issue should be reported on a separate page with a screenshot or screencast.
- Clearly describe the issue, list the browser used, and provide detailed steps to reproduce.

**Pictures:**
-Pictures for exploratory test are provided; 
### Task 2: Test Case Writing

For this task:
- Create test cases for the [Walmart Contacts Eureka Monthly](https://www.walmartcontacts.com/lens/eureka-monthly) page.

**Instructions:**
- Create the test cases in a spreadsheet (e.g., MS Excel).
- Cover all relevant scenarios that you think should be tested on this page.

## Setup Instructions

To run the automated tests locally, follow these steps:
### Installation

1. **Clone the repository**


### Author
- Jovan Golic

# Contributing

Contributions are welcome! Please fork the repository and create a pull request with your changes.

# License

This project is licensed under the MIT License. See the LICENSE file for details.   
