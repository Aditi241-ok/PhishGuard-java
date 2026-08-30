# 📚 PhishGuard - Learning Log

This document contains the programming, Spring Boot, Git, and
cybersecurity concepts I learned while developing PhishGuard.

---

# ☕ Java Concepts

## 1. Classes and Objects

I learned that a class acts as a blueprint for creating objects.

For example:

```java
Email email = new Email(
    sender,
    subject,
    body,
    url,
    attachment
);
```

This creates an Email object.

---

# 2. Encapsulation

I learned that encapsulation means protecting data inside a class.

For example:

```java
private String sender;
private String subject;
```

The variables are private.

Getter methods can be used to access their values.

```java
public String getSender() {
    return sender;
}
```

This prevents direct access to the variables from outside the class.

---

# 3. Constructors

I learned how constructors are used to initialize objects.

Example:

```java
public Email(
    String sender,
    String subject,
    String body,
    String url,
    String attachment
) {
    this.sender = sender;
    this.subject = subject;
    this.body = body;
    this.url = url;
    this.attachment = attachment;
}
```

The `this` keyword refers to the current object.

---

# 4. Arrays

I used a String array to store suspicious words.

```java
String[] suspiciousWords = {
    "urgent",
    "verify",
    "password",
    "otp"
};
```

I learned that arrays store multiple values of the same type.

---

# 5. Enhanced For Loop

I used an enhanced for loop to examine every suspicious word.

```java
for (String word : suspiciousWords) {
    if (text.contains(word)) {
        score += 5;
    }
}
```

This made it easier to process each item in the array.

---

# 6. Strings

I learned how to use several String methods.

Examples:

```java
toLowerCase()
contains()
startsWith()
endsWith()
length()
isEmpty()
```

These methods are useful for analyzing email text and URLs.

---

# 7. List and ArrayList

I used a List to store the reasons why an email was considered
suspicious.

```java
List<String> reasons = new ArrayList<>();
```

I learned that:

- `List` is an interface.
- `ArrayList` is an implementation of List.

I used:

```java
reasons.add(...)
```

to add detection reasons.

---

# 8. Conditional Statements

The analyzer uses `if` and `else if` statements to make decisions.

Example:

```java
if (score >= 60) {
    result = "HIGH RISK";
} else if (score >= 30) {
    result = "MEDIUM RISK";
} else {
    result = "LOW RISK";
}
```

---

# 9. Logical Operators

I used logical OR:

```java
||
```

to check multiple conditions.

Example:

```java
if (text.contains("share otp")
        || text.contains("enter otp")) {
```

---

# 10. Regular Expressions

I learned that regular expressions can be used to detect patterns
inside text.

The project uses a regular expression to identify IP addresses in
URLs.

This introduced me to:

- Pattern matching
- Special characters
- Backslash escaping
- Java regex syntax

---

# 🌱 Spring Boot Concepts

## 11. Spring Boot

I learned that Spring Boot can be used to create Java web
applications.

It reduces the amount of configuration required to start a Spring
application.

---

# 12. Controller

I learned that a controller handles web requests.

Example:

```java
@GetMapping("/")
public String home() {
    return "index";
}
```

This maps the root URL to the home page.

---

# 13. GET Request

The home page uses:

```java
@GetMapping("/")
```

GET is used to request a resource from the server.

---

# 14. POST Request

The analysis form uses:

```java
@PostMapping("/analyze")
```

POST is used to send data to the server.

In this project, the email information is sent to the backend using
POST.

---

# 15. Request Parameters

The controller receives values from the HTML form using:

```java
@RequestParam
```

For example:

```java
@RequestParam String subject
```

This allows the controller to receive the subject submitted by the
user.

---

# 16. Model

I learned how Spring's `Model` can be used to send data from the
controller to the HTML page.

Example:

```java
model.addAttribute("score", score);
```

The score can then be displayed in the HTML template.

---

# 17. MVC Architecture

I learned the basic idea of MVC.

```text
Model
  ↓
Email.java

Controller
  ↓
PhishingController.java

View
  ↓
HTML / Thymeleaf
```

MVC helps separate data, application logic, and presentation.

---

# 🌐 Web Development

## 18. HTML Forms

I learned how HTML forms collect information from users.

The PhishGuard form collects:

```text
Sender
Subject
Body
URL
Attachment
```

---

# 19. HTTP

I learned the basic difference between:

```text
GET
POST
```

I also learned why HTTPS is preferable to HTTP for secure
communication.

---

# 📦 Maven

## 20. Maven

I learned that Maven is a build and dependency management tool.

It helps with:

- Dependencies
- Compilation
- Running the application
- Project structure

Commands I used include:

```text
mvn clean compile
```

and:

```text
mvn spring-boot:run
```

---

# 🔧 Git and GitHub

## 21. Git

I learned that Git is a version control system.

It allows me to track changes made to the project.

Basic workflow:

```text
Change code
    ↓
git add
    ↓
git commit
    ↓
git push
```

---

# 22. GitHub

I learned how GitHub can be used to store and share a project
repository.

I am also using GitHub to document the development process of
PhishGuard.

---

# 🛡️ Cybersecurity Concepts

## 23. Phishing

I learned that phishing involves attempts to trick users into
revealing information or performing actions through deceptive
messages.

---

# 24. Social Engineering

I learned that phishing often relies on psychological techniques.

Examples include:

- Urgency
- Fear
- Authority
- Rewards
- Account threats

---

# 25. Credential Theft

I learned that phishing emails may attempt to collect:

- Usernames
- Passwords
- Login information

The project therefore detects password-request phrases.

---

# 26. OTP Theft

I learned that attackers may also attempt to trick users into sharing
one-time passwords.

The project detects phrases such as:

```text
share OTP
send OTP
enter OTP
```

---

# 27. Suspicious URLs

I learned that URLs can contain indicators that deserve additional
investigation.

The project currently checks:

- HTTP instead of HTTPS
- IP addresses
- Suspicious words
- Long URLs
- `@` symbols

---

# 28. Suspicious Attachments

I learned that certain executable or script file types can be risky
when received unexpectedly.

The project checks extensions such as:

```text
.exe
.bat
.cmd
.scr
.js
```

These are treated as warning indicators rather than proof of
malicious activity.

---

# 🧠 Problem Solving

One of the most important things I learned was debugging.

During development I encountered:

- Compilation errors
- Typographical errors
- Missing imports
- Regular expression problems
- Controller mapping problems
- Spring Boot Whitelabel errors

Instead of treating errors as failures, I used them to understand
how the application works.

---

# 🎯 What I Want to Learn Next

My next learning goals are:

- Java OOP in more depth
- Spring Boot
- Networking
- Linux
- Web security
- Secure coding
- URL analysis
- Domain analysis
- Digital forensics
- Malware analysis concepts
- Machine learning for cybersecurity

---

# 🚀 Future Learning

I eventually want to explore how machine learning can be used to
classify phishing emails.

Before doing that, I want to understand the rule-based system properly
and learn how to evaluate a detection system using:

```text
Accuracy
Precision
Recall
F1 Score
```

---

# 💡 Final Learning Goal

The long-term goal of this project is not just to create a phishing
detector.

I want to become better at combining:

```text
Java
+
Cybersecurity
+
Problem Solving
+
Web Development
+
Linux
+
Networking
+
Git/GitHub
```

PhishGuard is my starting point for building practical cybersecurity
projects.
