# 🛡️ PhishGuard — My Development Journey

## Introduction

I started this project to learn how cybersecurity concepts can be
implemented using Java.

The goal is to build a phishing email detection system that can
analyze different parts of an email and calculate a risk score.

I decided to build the project step-by-step instead of copying a
complete project from the beginning.

---

# Phase 1 — Project Setup

## What I Used

- Java
- Maven
- Spring Boot
- VS Code

I created a Spring Boot Maven project for the application.

The first goal was simply to get the Java project running.

---

# Phase 2 — Creating the Email Model

I created an `Email` class to represent the information contained
in an email.

The class currently stores:

- Sender
- Subject
- Body
- URL
- Attachment

Example:

```java
private String sender;
private String subject;
private String body;
private String url;
private String attachment;
