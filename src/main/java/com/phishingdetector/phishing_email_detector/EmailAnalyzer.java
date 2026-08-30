package com.phishingdetector.phishing_email_detector;

import java.util.List;

public class EmailAnalyzer {

    /*
     * This method analyzes an email and calculates
     * a phishing risk score.
     *
     * Score range:
     * 0   = low risk
     * 100 = high risk
     *
     * The reasons list stores explanations
     * for every suspicious feature detected.
     */
    public int calculateScore(Email email, List<String> reasons) {

        // Start the risk score at zero
        int score = 0;


        // ------------------------------------------
        // 1. COMBINE SUBJECT AND BODY
        // ------------------------------------------

        /*
         * We combine the subject and body so that
         * we can search both of them together.
         *
         * toLowerCase() makes detection
         * case-insensitive.
         */
        String text = (
                email.getSubject()
                + " "
                + email.getBody()
        ).toLowerCase();


        // ------------------------------------------
        // 2. SUSPICIOUS KEYWORD DETECTION
        // ------------------------------------------

        String[] suspiciousWords = {

                "urgent",
                "verify",
                "password",
                "otp",
                "login",
                "suspended",
                "winner",
                "prize",
                "click here",
                "immediately",
                "bank account",
                "confirm your identity",
                "security alert"
        };


        /*
         * Check every word in the array.
         */
        for (String word : suspiciousWords) {

            /*
             * contains() checks whether
             * the email contains this word.
             */
            if (text.contains(word)) {

                // Add 5 points for each suspicious word
                score += 5;

                // Store the reason
                reasons.add(
                        "Suspicious keyword detected: " + word
                );
            }
        }


        // ------------------------------------------
        // 3. CREDENTIAL REQUEST DETECTION
        // ------------------------------------------

        /*
         * Detect emails asking users
         * to provide their password.
         */
        if (text.contains("enter your password")
                || text.contains("enter password")
                || text.contains("provide your password")) {

            score += 15;

            reasons.add(
                    "Email requests sensitive password information"
            );
        }


        // ------------------------------------------
        // 4. OTP REQUEST DETECTION
        // ------------------------------------------

        /*
         * Detect requests for OTP.
         */
        if (text.contains("share otp")
                || text.contains("enter otp")
                || text.contains("send otp")) {

            score += 15;

            reasons.add(
                    "Email requests an OTP"
            );
        }


        // ------------------------------------------
        // 5. THREAT / URGENCY DETECTION
        // ------------------------------------------

        /*
         * Phishing emails often use fear or urgency
         * to make users act quickly.
         */
        if (text.contains("account will be closed")
                || text.contains("account will be blocked")
                || text.contains("action required")
                || text.contains("act now")) {

            score += 10;

            reasons.add(
                    "Urgent or threatening language detected"
            );
        }


        // ------------------------------------------
        // 6. URL ANALYSIS
        // ------------------------------------------

        String url = email.getUrl().toLowerCase();


        /*
         * Only analyze the URL if the user
         * actually entered one.
         */
        if (!url.isEmpty()) {


            // Check for HTTP instead of HTTPS
            if (url.startsWith("http://")) {

                score += 15;

                reasons.add(
                        "URL does not use HTTPS"
                );
            }


            // Check for suspicious @ symbol
            if (url.contains("@")) {

                score += 15;

                reasons.add(
                        "Suspicious @ symbol found in URL"
                );
            }


            // Check for suspicious words in URL
            if (url.contains("login")
                    || url.contains("verify")
                    || url.contains("secure")
                    || url.contains("account")
                    || url.contains("update")) {

                score += 10;

                reasons.add(
                        "Suspicious words found in URL"
                );
            }


            // Check if URL is unusually long
            if (url.length() > 75) {

                score += 10;

                reasons.add(
                        "Unusually long URL detected"
                );
            }


            // --------------------------------------
            // IP ADDRESS DETECTION
            // --------------------------------------

            /*
             * Detect URLs such as:
             *
             * http://192.168.1.10/login
             *
             * instead of:
             *
             * https://example.com/login
             */
            if (url.matches(".*https?://\\d+\\.\\d+\\.\\d+\\.\\d+.*")) {

                score += 20;

                reasons.add(
                        "URL uses an IP address instead of a domain"
                );
            }
        }


        // ------------------------------------------
        // 7. ATTACHMENT ANALYSIS
        // ------------------------------------------

        String attachment =
                email.getAttachment().toLowerCase();


        /*
         * Check whether an attachment exists.
         */
        if (!attachment.isEmpty()) {


            /*
             * Check for potentially dangerous
             * executable/script file extensions.
             */
            if (attachment.endsWith(".exe")
                    || attachment.endsWith(".bat")
                    || attachment.endsWith(".cmd")
                    || attachment.endsWith(".scr")
                    || attachment.endsWith(".js")) {

                score += 20;

                reasons.add(
                        "Potentially dangerous attachment type: "
                        + attachment
                );
            }
        }


        // ------------------------------------------
        // 8. LIMIT SCORE TO 100
        // ------------------------------------------

        if (score > 100) {

            score = 100;
        }


        // Return final risk score
        return score;
    }
}