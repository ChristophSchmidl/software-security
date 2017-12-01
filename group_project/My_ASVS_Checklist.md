# Software Security - ASVS Checklist

## Authentication

- [ ] V2.4: Verify all authentication controls are enforced on the server side.
- [ ] V2.16: Verify that credentials are transported using a suitable encrypted link and that all pages/functions that require a user to enter credentials are done so using an encrypted link.
- [ ] V2.22: Verify that forgotten password and other recovery paths use a TOTP or other soft token, mobile push, or other offline recovery mechanism. Use of a random value in an e-mail or SMS should be a last resort and is known weak
- [ ] V2.33: Browser autocomplete, and integration with password managers are permitted unless prohibited by risk based policy.

## Session Management

- [ ] V3.6: Verify that the session id is never disclosed in URLs, error messages, or logs. This includes verifying that the application does not support URL rewriting of session cookies.
- [ ] V3.17: Verify that an active session list is displayed in the account profile or similar of each user. The user should be able to terminate any active session.

## Access Control

- [ ] V4.8: Verify that access controls fail securely.

## Malicious Input Control

- [ ] V5.3: Verify that server side input validation failures result in request rejection and are logged.
- [ ] V5.13: Verify that the application is not susceptible to Remote File Inclusion (RFI) or Local File Inclusion (LFI) when content is used that is a path to a file.

## Error Handling and Logging

- [ ] V8.13: Time sources should be synchronized to ensure logs have the correct time 

## Data protection

- [ ] V9.4: "Verify that the application sets appropriate anti-caching headers as per the risk of the application, such as the following:
Expires: Tue, 03 Jul 2001 06:00:00 GMT
Last-Modified: {now} GMT
Cache-Control: no-store, no-cache, must-revalidate, max-age=0 Cache-Control: post-check=0, pre-check=0
Pragma: no-cache"

## Http security configuration

- [ ] V11.6: Verify that all API responses contain X-Content-Type-Options: nosniff and Content-Disposition: attachment; filename="api.json" (or other appropriate filename for the content type).

