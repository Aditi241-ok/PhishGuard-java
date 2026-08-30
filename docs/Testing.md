# 🧪 PhishGuard - Testing

## Testing Objective

The purpose of testing is to check whether PhishGuard can identify
common phishing indicators and calculate an appropriate risk score.

The current version uses a rule-based detection system.

Testing is therefore performed using different email scenarios.

---

# Test Case 1 - Normal Email

## Input

### Sender

```text
friend@example.com
```

### Subject

```text
Meeting Tomorrow
```

### Body

```text
Hi,

Just reminding you that we have a meeting tomorrow at 10 AM.

See you there.
```

### URL

```text
https://example.com
```

### Attachment

```text
None
```

## Expected Result

```text
LOW RISK
```

## Expected Behavior

The email should not trigger major phishing indicators.

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case 2 - Multiple Phishing Indicators

## Input

### Sender

```text
security@example.com
```

### Subject

```text
URGENT: Verify your account
```

### Body

```text
URGENT!

Your account will be closed immediately.

Click here to verify your account.

Enter your password and share OTP.
```

### URL

```text
http://192.168.1.10/login
```

### Attachment

```text
account_update.exe
```

## Expected Result

```text
HIGH RISK
```

## Expected Detection

The system should detect:

- Suspicious keywords
- Password request
- OTP request
- Threatening language
- HTTP URL
- Suspicious URL word
- IP address
- Dangerous attachment

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case 3 - Prize Scam

## Input

### Sender

```text
winner@example.com
```

### Subject

```text
Congratulations! You won a prize
```

### Body

```text
Congratulations!

You are the winner of our prize.

Click here to claim your prize immediately.
```

### URL

```text
https://example.com
```

### Attachment

```text
None
```

## Expected Result

```text
MEDIUM RISK
```

## Expected Detection

The system should detect suspicious words such as:

- winner
- prize
- click here
- immediately

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case 4 - Password Request

## Input

### Sender

```text
support@example.com
```

### Subject

```text
Password verification required
```

### Body

```text
Your account requires verification.

Please enter your password to continue.
```

### URL

```text
https://example.com/login
```

### Attachment

```text
None
```

## Expected Result

```text
MEDIUM / HIGH RISK
```

## Expected Detection

The system should detect:

- Password keyword
- Verify keyword
- Login keyword
- Password request
- Suspicious URL word

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case 5 - Dangerous Attachment

## Input

### Sender

```text
unknown@example.com
```

### Subject

```text
Monthly Invoice
```

### Body

```text
Please check the attached invoice.
```

### URL

```text
None
```

### Attachment

```text
invoice.scr
```

## Expected Result

The risk score should increase because `.scr` is considered a
potentially dangerous attachment type.

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case 6 - Suspicious URL

## Input

### Sender

```text
support@example.com
```

### Subject

```text
Account Verification
```

### Body

```text
Please verify your account.
```

### URL

```text
http://example.com/verify/login
```

### Attachment

```text
None
```

## Expected Detection

The system should detect:

- HTTP URL
- Suspicious URL words
- Suspicious keyword in the email

## Expected Result

The risk score should increase.

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case 7 - IP Address URL

## Input

### Sender

```text
support@example.com
```

### Subject

```text
Security Verification
```

### Body

```text
Please verify your account.
```

### URL

```text
http://192.168.1.10/login
```

### Attachment

```text
None
```

## Expected Detection

The system should detect:

- HTTP URL
- IP address instead of a domain
- Suspicious URL word
- Suspicious email keywords

## Status

- [ ] PASS
- [ ] FAIL

---

# Test Case Summary

| Test Case | Scenario | Expected Result |
|---|---|---|
| TC-01 | Normal email | Low Risk |
| TC-02 | Multiple phishing indicators | High Risk |
| TC-03 | Prize scam | Medium Risk |
| TC-04 | Password request | Medium/High Risk |
| TC-05 | Dangerous attachment | Increased Risk |
| TC-06 | Suspicious URL | Increased Risk |
| TC-07 | IP address URL | Increased Risk |

---

# Manual Testing

The application is currently tested manually through the web
interface.

The process is:

```text
Start Spring Boot
       |
       v
Open localhost
       |
       v
Enter email information
       |
       v
Click Analyze
       |
       v
Check risk score
       |
       v
Check detection reasons
```

---

# Testing Notes

The current detector is rule-based.

Therefore, a high score does not automatically prove that an email is
malicious.

Similarly, a low score does not guarantee that an email is completely
safe.

The system is an educational prototype designed to identify suspicious
indicators.

---

# Future Testing

Future versions will include automated tests.

Planned testing includes:

- JUnit unit tests
- Controller tests
- Analyzer tests
- Edge case testing
- False positive testing
- False negative testing
- Dataset-based evaluation

Eventually, the system can be evaluated using:

```text
Accuracy
Precision
Recall
F1 Score
```
