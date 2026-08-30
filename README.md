# 🛡️ PhishGuard

## Phishing Email Detection System using Java

PhishGuard is a cybersecurity project built using Java and Spring Boot
to analyze emails and identify potential phishing indicators.

The project uses a rule-based detection system to calculate a risk score
based on suspicious email content, URLs, and attachments.

---

## 🚀 Project Status

🟡 Currently in development

### Current Features

- Suspicious keyword detection
- Password request detection
- OTP request detection
- Urgency/threat detection
- URL analysis
- HTTP vs HTTPS detection
- Suspicious URL keyword detection
- IP address URL detection
- Long URL detection
- Suspicious attachment detection
- Risk score from 0–100
- Explanation of detection reasons

---

## 🧰 Technologies Used

- Java
- Spring Boot
- Maven
- Thymeleaf
- HTML
- Git & GitHub

---

## 🏗️ Current Architecture

```text
User
 │
 ▼
HTML Form
 │
 ▼
PhishingController
 │
 ▼
Email Object
 │
 ▼
EmailAnalyzer
 │
 ├── Keyword Analysis
 ├── Credential Detection
 ├── OTP Detection
 ├── URL Analysis
 ├── Threat Detection
 └── Attachment Analysis
 │
 ▼
Risk Score
 │
 ▼
Result Page
