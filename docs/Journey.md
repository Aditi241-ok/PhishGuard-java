# 🛡️ PhishGuard - Development Journey

## Introduction

PhishGuard is a phishing email detection project that I am building
using Java and Spring Boot.

The purpose of this project is to understand how cybersecurity concepts
can be implemented using programming.

Instead of building the complete application at once, I am developing
it step-by-step and documenting the concepts I learn, the problems I
face, and the improvements I make.

---

# Phase 1 - Project Setup

I started the project by creating a Spring Boot Maven project.

## Technologies Used

- Java
- Spring Boot
- Maven
- HTML
- Thymeleaf
- Git
- GitHub

The first goal was to create a working Spring Boot application.

## What I Learned

I learned that Maven helps with:

- Managing project dependencies
- Compiling Java code
- Running the application
- Maintaining project structure

---

# Phase 2 - Creating the Email Model

The next step was creating an `Email` class.

The Email class represents the email that will be analyzed.

It currently contains:

- Sender
- Subject
- Body
- URL
- Attachment

The class uses private variables and getter methods.

Example:

```java
private String sender;
private String subject;
private String body;
private String url;
private String attachment;
```

## Concept Learned - Encapsulation

I learned that encapsulation means keeping data protected inside a
class and controlling access to it using methods.

For example:

```java
private String subject;

public String getSubject() {
    return subject;
}
```

The variables are private, so they cannot be directly accessed from
outside the class.

---

# Phase 3 - Creating EmailAnalyzer

After creating the Email class, I created:

`EmailAnalyzer.java`

The purpose of this class is to analyze an email and calculate a
phishing risk score.

The analyzer starts with a score of zero.

Different suspicious characteristics increase the score.

---

# Phase 4 - Suspicious Keyword Detection

The first detection feature was suspicious keyword detection.

The system checks for words and phrases such as:

- urgent
- verify
- password
- OTP
- login
- suspended
- winner
- prize
- click here
- immediately
- bank account
- confirm your identity
- security alert

Each detected keyword increases the risk score.

I used a String array to store the suspicious words.

```java
String[] suspiciousWords = {
    "urgent",
    "verify",
    "password",
    "otp"
};
```

I then used an enhanced for loop to check each word.

```java
for (String word : suspiciousWords) {
    if (text.contains(word)) {
        score += 5;
    }
}
```

## Concepts Learned

- Arrays
- Strings
- `contains()`
- Enhanced for loop
- `if` statements

---

# Phase 5 - Credential Request Detection

I added a rule to detect emails asking users for passwords.

Examples include:

```text
enter your password
enter password
provide your password
```

If one of these phrases is detected, the risk score increases.

This feature represents a common phishing technique where attackers
try to steal login credentials.

---

# Phase 6 - OTP Request Detection

I added another rule for detecting OTP requests.

Examples include:

```text
share OTP
enter OTP
send OTP
```

The system increases the risk score when these phrases are found.

This was added because phishing attacks can attempt to trick users into
sharing one-time passwords.

---

# Phase 7 - Threat and Urgency Detection

Phishing emails often try to create fear or urgency.

I added detection for phrases such as:

```text
account will be closed
account will be blocked
action required
act now
```

If these phrases are detected, the system increases the risk score.

This helped me understand how social engineering can be represented
using simple detection rules.

---

# Phase 8 - URL Analysis

I then added URL analysis.

The system checks for several suspicious URL characteristics.

These include:

- HTTP instead of HTTPS
- Suspicious `@` symbol
- Suspicious words
- Unusually long URLs
- IP addresses instead of domains

For example:

```text
http://192.168.1.10/login
```

can be treated as suspicious because it uses an IP address instead of
a normal domain name.

---

# Phase 9 - Regular Expressions

While implementing IP address detection, I learned about regular
expressions.

Regular expressions can be used to search for patterns in text.

The project uses a regular expression to identify IP addresses inside
URLs.

This introduced me to:

- Pattern matching
- Special characters
- Backslash escaping
- Java regular expression syntax

---

# Phase 10 - Attachment Analysis

I added attachment analysis.

The system checks the attachment name for potentially dangerous
extensions such as:

```text
.exe
.bat
.cmd
.scr
.js
```

If one of these extensions is detected, the risk score increases.

This does not mean that every file with these extensions is malicious.

They are treated as warning indicators that require further analysis.

---

# Phase 11 - Risk Scoring

After adding multiple detection rules, I created a scoring system.

Examples:

| Detection | Score |
|---|---:|
| Suspicious keyword | +5 |
| Password request | +15 |
| OTP request | +15 |
| Threat/urgency | +10 |
| HTTP URL | +15 |
| Suspicious `@` symbol | +15 |
| Suspicious URL words | +10 |
| Long URL | +10 |
| IP address URL | +20 |
| Dangerous attachment | +20 |

The maximum score is limited to 100.

The application then categorizes the email.

```text
0 - 29     LOW RISK
30 - 59    MEDIUM RISK
60 - 100   HIGH RISK
```

---

# Phase 12 - Creating the Web Interface

After creating the detection logic, I connected it to a Spring Boot
web application.

The user can enter:

- Sender
- Subject
- Email body
- URL
- Attachment

The information is submitted through an HTML form.

---

# Phase 13 - Creating the Controller

I created:

`PhishingController.java`

The controller connects the HTML form with the Java backend.

The basic flow is:

```text
HTML Form
    ↓
PhishingController
    ↓
Email Object
    ↓
EmailAnalyzer
    ↓
Risk Score
    ↓
Result Page
```

The controller receives the form data, creates an Email object, sends
it to the analyzer, and then sends the results to the result page.

---

# Phase 14 - MVC Architecture

I learned about the basic MVC architecture.

## Model

```text
Email.java
```

The model stores email information.

## Controller

```text
PhishingController.java
```

The controller handles web requests.

## View

```text
index.html
result.html
```

The views provide the user interface.

---

# 🐛 Debugging Journey

Building the project also involved debugging several errors.

---

## Problem 1 - Incorrect Class Name

I initially had an incorrect analyzer class name.

### Lesson

Java public class names need to match their corresponding filenames.

---

## Problem 2 - Getter Method Typo

I accidentally used an incorrect getter method name.

For example:

```text
getAttchment()
```

instead of:

```text
getAttachment()
```

### Lesson

Java requires method names to match exactly.

Even a small spelling mistake can cause compilation errors.

---

## Problem 3 - Missing Imports

The controller used classes such as:

```java
List
ArrayList
PostMapping
```

without importing the required packages.

### Lesson

Java requires classes from other packages to be imported.

---

## Problem 4 - Regular Expression Error

The IP address detection regular expression initially had incorrect
escaping.

### Lesson

Java strings and regular expressions both use special characters,
so backslashes sometimes need to be escaped.

---

## Problem 5 - Whitelabel 404 Error

During development, Spring Boot displayed:

```text
Whitelabel Error Page
404 Not Found
```

### Lesson

A running Spring Boot application does not mean that every URL exists.

A URL needs a matching controller mapping.

For example:

```java
@GetMapping("/")
```

handles the home page.

While:

```java
@PostMapping("/analyze")
```

handles the email analysis request.

---

# 📈 Current Progress

## Completed

- [x] Maven project setup
- [x] Spring Boot setup
- [x] Email model
- [x] Encapsulation
- [x] Email analyzer
- [x] Suspicious keyword detection
- [x] Password request detection
- [x] OTP detection
- [x] Threat detection
- [x] URL analysis
- [x] IP address detection
- [x] Attachment analysis
- [x] Risk scoring
- [x] Spring Boot controller
- [x] HTML input form

## In Progress

- [ ] Complete application testing
- [ ] Improve user interface
- [ ] Sender analysis
- [ ] Domain analysis

## Future

- [ ] Database
- [ ] Scan history
- [ ] Dashboard
- [ ] Unit testing
- [ ] Advanced URL analysis
- [ ] Machine learning

---

# 🎯 Next Step

The next goal is to make the detector more advanced than simple
keyword matching.

I plan to add sender and domain analysis and improve the URL detection
system.

Eventually, I also want to explore machine learning approaches for
phishing detection.

---

# 💡 Main Lesson

This project has taught me that building a cybersecurity application
requires more than just writing security rules.

It requires understanding:

```text
Programming
     +
Web Development
     +
Cybersecurity
     +
Debugging
     +
Testing
     +
Version Control
```

This project is both a cybersecurity project and a record of my
learning journey.



