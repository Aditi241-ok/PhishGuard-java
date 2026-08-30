package com.phishingdetector.phishing_email_detector;

public class Email {//creating Email object
    //Encapsulation means wrapping data and methods together in a class and restricting direct access to the data.
    private String sender;
    private String subject;
    private String body;
    private String url;
    private String attachment;
    //Constructor
    public Email(String sender,String subject,String body,String url,
        String attachment
    ){
      this.sender=sender;
      this.subject=subject;
      this.body=body;
      this.url=url;
      this.attachment=attachment;
    }
    //getter methods
    public String getSender(){
        return sender;
    }public String getSubject(){
        return subject;
    }public String getBody(){
        return body;
    }public String getUrl(){
        return url;
    }public String getAttachment(){
        return attachment;
    }
}
