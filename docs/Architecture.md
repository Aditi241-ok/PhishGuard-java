# 🏗️ PhishGuard - System Architecture

## Overview

PhishGuard is a Java Spring Boot web application designed to analyze
email information and calculate a phishing risk score.

The application currently follows a simple MVC-style architecture.

---

# System Architecture

```text
                         USER
                           |
                           v
                  +----------------+
                  |   index.html   |
                  |   Email Form   |
                  +-------+--------+
                          |
                          |
                    POST /analyze
                          |
                          v
              +-----------------------+
              |  PhishingController   |
              +-----------+-----------+
                          |
                          v
                  +---------------+
                  |   Email.java  |
                  |     Model     |
                  +-------+-------+
                          |
                          v
                +-------------------+
                |   EmailAnalyzer   |
                +---------+---------+
                          |
          +---------------+---------------+
          |               |               |
          v               v               v
     Keywords           URLs        Attachments
          |               |               |
          +---------------+---------------+
                          |
                          v
                    Risk Score
                          |
                          v
                  +---------------+
                  |   result.html |
                  +---------------+
                          |
                          v
                         USER
```

---

# 📦 Main Components

## 1. Email.java

`Email.java` is the model class.

It represents the email that is being analyzed.

It stores:

```text
Sender
Subject
Body
URL
Attachment
```

The variables are private and getter methods are used to access them.

This demonstrates the Java concept of encapsulation.

---

# 2. EmailAnalyzer.java

`EmailAnalyzer.java` contains the phishing detection logic.

It receives an Email object and a list of reasons.

```java
Email email
List<String> reasons
```

It returns an integer risk score.

```java
int score
```

The analyzer checks several phishing indicators.

---

# 3. PhishingController.java

`PhishingController.java` connects the web interface to the backend.

It handles two main requests.

## GET /

```java
@GetMapping("/")
```

This opens the home page.

---

## POST /analyze

```java
@PostMapping("/analyze")
```

This receives the information submitted by the user.

The controller then:

1. Receives the form data.
2. Creates an Email object.
3. Creates an EmailAnalyzer object.
4. Calculates the risk score.
5. Determines the risk level.
6. Sends the result to the HTML page.

---

# 4. index.html

`index.html` is the main input page.

The user enters:

```text
Sender
Subject
Email Body
URL
Attachment
```

The form sends the information to:

```text
/analyze
```

using a POST request.

---

# 5. result.html

`result.html` displays the result of the analysis.

The result page displays:

- Risk score
- Risk level
- Reasons for detection

---

# 🔄 Complete Data Flow

```text
User enters email
        |
        v
HTML Form
        |
        v
POST /analyze
        |
        v
PhishingController
        |
        v
Create Email object
        |
        v
EmailAnalyzer
        |
        v
Check phishing indicators
        |
        v
Calculate score
        |
        v
Determine risk level
        |
        v
Send data to result.html
        |
        v
Display result
```

---

# 🔍 Detection Flow

The EmailAnalyzer checks:

```text
                 EMAIL
                   |
        +----------+----------+
        |          |          |
        v          v          v
      Text        URL      Attachment
        |          |          |
        v          v          v
   Keywords     URL Rules   File Rules
        |          |          |
        +----------+----------+
                   |
                   v
              Risk Score
                   |
                   v
             Risk Category
```

---

# 📊 Risk Calculation

The current system uses rule-based scoring.

Examples:

```text
Suspicious keyword       +5
Password request        +15
OTP request             +15
Threatening language   +10
HTTP URL               +15
Suspicious @ symbol    +15
Suspicious URL words   +10
Long URL               +10
IP address URL         +20
Dangerous attachment   +20
```

The final score cannot exceed 100.

---

# 🚦 Risk Levels

```text
+----------------+----------------+
| Score          | Risk Level     |
+----------------+----------------+
| 0 - 29         | LOW RISK       |
| 30 - 59        | MEDIUM RISK    |
| 60 - 100       | HIGH RISK      |
+----------------+----------------+
```

---

# 🧩 Technologies

## Java

Used for the backend logic and phishing detection system.

## Spring Boot

Used to create the web application and handle HTTP requests.

## Maven

Used for dependency management and project building.

## Thymeleaf

Used to display backend results dynamically in HTML.

## HTML

Used to create the user interface.

---

# 🔮 Future Architecture

As the project develops, the architecture may become:

```text
                    USER
                      |
                      v
                Web Interface
                      |
                      v
                 Controller
                      |
                      v
               Detection Engine
                      |
          +-----------+-----------+
          |           |           |
          v           v           v
       Email       URL         Sender
       Analysis    Analysis    Analysis
          |           |           |
          +-----------+-----------+
                      |
                      v
                Risk Engine
                      |
                      v
                   Result
                      |
                      v
                  Database
                      |
                      v
                 Dashboard
```

Machine learning may also be added as a future component.
