# Software Security - ASVS Checklist

* [ASVS version 3](https://www.owasp.org/images/3/33/OWASP_Application_Security_Verification_Standard_3.0.1.pdf)

## Authentication

**Control objective**

Authentication is the act of establishing, or confirming, something (or someone) as
authentic, that is, that claims made by or about the thing are true. Ensure that a verified
application satisfies the following high level requirements:

* Verifies the digital identity of the sender of a communication.
* Ensures that only those authorised are able to authenticate and credentials are
transported in a secure manner.

**Helpful References for Authentication**

* [OWASP Testing Guide 4.0: Testing for Authentication](https://www.owasp.org/index.php/Testing_for_authentication)
* [Password storage cheat sheet](https://www.owasp.org/index.php/Password_Storage_Cheat_Sheet)
* [Forgot password cheat sheet ](https://www.owasp.org/index.php/Forgot_Password_Cheat_Sheet)
* [Choosing and Using Security Questions at ](https://www.owasp.org/index.php/Choosing_and_Using_Security_Questions_Cheat_Sheet)

**TODO**

- [ ] V2.4: Verify all authentication controls are enforced on the server side.
- [ ] V2.16: Verify that credentials are transported using a suitable encrypted link and that all pages/functions that require a user to enter credentials are done so using an encrypted link.
- [ ] V2.22: Verify that forgotten password and other recovery paths use a TOTP or other soft token, mobile push, or other offline recovery mechanism. Use of a random value in an e-mail or SMS should be a last resort and is known weak
- [ ] V2.33: Browser autocomplete, and integration with password managers are permitted unless prohibited by risk based policy.

## Session Management


**Control objective**

One of the core components of any web-based application is the mechanism by which it
controls and maintains the state for a user interacting with it. This is referred to this as
Session Management and is defined as the set of all controls governing state-full interaction
between a user and the web-based application.
Ensure that a verified application satisfies the following high level session management
requirements:

* Sessions are unique to each individual and cannot be guessed or shared
* Sessions are invalidated when no longer required and timed out during periods of
inactivity.

**Helpful References for Session Management**

* [OWASP Testing Guide 4.0: Session Management Testing](https://www.owasp.org/index.php/Testing_for_Session_Management)
* [OWASP Session Management Cheat Sheet](https://www.owasp.org/index.php/Session_Management_Cheat_Sheet)

**TODO**

- [ ] V3.6: Verify that the session id is never disclosed in URLs, error messages, or logs. This includes verifying that the application does not support URL rewriting of session cookies.
- [ ] V3.17: Verify that an active session list is displayed in the account profile or similar of each user. The user should be able to terminate any active session.

## Access Control

**Control objective**

Authorization is the concept of allowing access to resources only to those permitted to use
them. Ensure that a verified application satisfies the following high level requirements:

* Persons accessing resources holds valid credentials to do so.
* Users are associated with a well-defined set of roles and privileges.
* Role and permission metadata is protected from replay or tampering.

**Helpful References for Access Control**

* [OWASP Testing Guide 4.0: Authorization](https://www.owasp.org/index.php/Testing_for_Authorization)
* [OWASP Cheat Sheet: Access Control](https://www.owasp.org/index.php/Access_Control_Cheat_Sheet)

**TODO**

- [ ] V4.8: Verify that access controls fail securely.

## Malicious Input Control

**Control objective**

The most common web application security weakness is the failure to properly validate
input coming from the client or from the environment before using it. This weakness leads
to almost all of the major vulnerabilities in web applications, such as cross site scripting, SQL
injection, interpreter injection, locale/Unicode attacks, file system attacks, and buffer
overflows. 

Ensure that a verified application satisfies the following high level requirements:

* All input is validated to be correct and fit for the intended purpose.
* Data from an external entity or client should never be trusted and should be handled
accordingly.

**Helpful References for Malicious Input Control**

* [OWASP Testing Guide 4.0: Input Validation Testing](https://www.owasp.org/index.php/Testing_for_Input_Validation)
* [OWASP Cheat Sheet: Input Validation ](https://www.owasp.org/index.php/Input_Validation_Cheat_Sheet)
* [OWASP Testing Guide 4.0: Testing for HTTP Parameter Pollution ](https://www.owasp.org/index.php/Testing_for_HTTP_Parameter_pollution_%28OTG-INPVAL-004%29)
* [OWASP LDAP Injection Cheat Sheet](https://www.owasp.org/index.php/LDAP_Injection_Prevention_Cheat_Sheet)
* [OWASP Testing Guide 4.0: Client Side Testing ](https://www.owasp.org/index.php/Client_Side_Testing)
* [OWASP Cross Site Scripting Prevention Cheat Sheet ](https://www.owasp.org/index.php/XSS_%28Cross_Site_Scripting%29_Prevention_Cheat_Sheet)
* [OWASP Java Encoding Project](https://www.owasp.org/index.php/OWASP_Java_Encoder_Project)

For more information on auto-escaping, please see

* [Reducing XSS by way of Automatic Context-Aware Escaping in Template Systems](http://googleonlinesecurity.blogspot.com/2009/03/reducing-xss-by-way-of-automatic.html)
* [AngularJS Strict Contextual Escaping](https://docs.angularjs.org/api/ng/service/$sce)
* [https://cwe.mitre.org/data/definitions/915.html](https://cwe.mitre.org/data/definitions/915.html)


**TODO**


- [ ] V5.3: Verify that server side input validation failures result in request rejection and are logged.
- [ ] V5.13: Verify that the application is not susceptible to Remote File Inclusion (RFI) or Local File Inclusion (LFI) when content is used that is a path to a file.

## Error Handling and Logging

**Control objective**


**Helpful References for Authentication**


**TODO**

- [ ] V8.13: Time sources should be synchronized to ensure logs have the correct time 

## Data protection

**Control objective**


**Helpful References for Authentication**


**TODO**

- [ ] V9.4: "Verify that the application sets appropriate anti-caching headers as per the risk of the application, such as the following:
Expires: Tue, 03 Jul 2001 06:00:00 GMT
Last-Modified: {now} GMT
Cache-Control: no-store, no-cache, must-revalidate, max-age=0 Cache-Control: post-check=0, pre-check=0
Pragma: no-cache"

## Http security configuration

**Control objective**


**Helpful References for Authentication**


**TODO**

- [ ] V11.6: Verify that all API responses contain X-Content-Type-Options: nosniff and Content-Disposition: attachment; filename="api.json" (or other appropriate filename for the content type).

