# Software Security - Exam Preparation



## Checklist for Exam

* Buffer overflows
	* Spot a simple buffer overflow. Explain how buffer overflows work, and explain some cause for them.

	* Explain/discuss any of the countermeasures against buffer overflows, (**canaries, non-executable data segments, ASLR, CFI, execution-aware memory protection**),
	  incl. static analysis of SAL-annoted code with
	  PREfast and sample coding guidelines for C(++) on constructs to
	  avoid.  (BUT NOT pointer encryption, as that technique was not 
	  treated this year)

	* Have another look at the PREfast exercise.

	* For simple pieces of code like this you should be able to explain
	  how they could be annotated with SAL and what kind of flaws PREfast
	  might then be able to detect. (You're not expected to be able to
	  produce syntactically correct SAL annotations; you just have to 
	  explain the essence of what annotations would say).

* Similar for other security flaws: Explain what 

	* **format string attack**,
	* **integer overflow**
	* **command injection**
	* **PHP injection**
	* **SQL injection (normal, blind or 2nd order )**
	* **XSS**
	* **CSRF**
	* **TOCTOU aka race conditions**
	* more generally: (lack of) input validation, output validation 
      is; spot/explain them in simple examples; explain/discuss 
      the countermeasures against them.

* Explain the notion of **TCB (Trusted Computing Base)** or 
  say what the TCB is in a given scenario.

* Comment on (some aspects of using) the **ASVS**.

* Language-based Security

	* Explain/discuss/motivate the security guarantees a "safe" language like
      Java or C# can make, such as
	* memory safety
	* type safety
	* code-based access control/sandboxing
      using typing, byte-code verification, visibility, stack walking, etc.

	* Explain how/why these guarantees can be useful.  

	* For a piece of Java code that code-based access control, say whether 
	  the stackwalking algorithm will throw exceptions due to missing
	  permissions or not for the stacks that this code produces, and 
	  be able to motivate why.

	* Explain the notions of memory-safety, type-safety, stackwalking.  

	* Explain/motivate some of the coding guidelines for Java.  

	* Explain some example problems in Java security discussed in lecture
	  slides.

	* Explain why immutability of data can be important for security.

* Explain/compare/discuss possibilities, limitations, pros and cons
  of any of the techniques treated in the course (various forms of typing,
  coding guidelines, static analysis, program verification, etc.) or 
  of any of the tools we used in the projects (PREfast, RIPS, ESC/Java.)
  Say something intelligent about the use of such tools.

* Information Flow

	* Explain what information flow is, formally or informally, what
	  without implicit and explicit flows are, what termination-senstivity is.

	* Spot information flow problems in simple examples.

	* Explain/motivate/give some of the typing rules for information flow,
	  for termination/timing-sensitive or insensitive versions.

	* Explain/motivate/give the formal definition of non-interference,
	  for termination/timing-sensitive or insenstive versions.

	* NB I expect you to be able to produce the definition of non-interference
	  and to come up with typing rules for information flows as discussed
	  in the lecture notes. (Once you understand the ideas behind the definition
	  and these rules you should be able to reproduce them.)

	* Explain/comment on the way that static analysis tools like RIPS
	  and PREfast do information flow for unvalidated inputs (aka
	  tainting).

	* Explain/motivate the idea behind the SPARTA system & approach, how
	  it works, what the limitations are, and how the approach copes with
	  implicit flows. Explain which parts of the SPARTA validation scheme
	  are manual and which are automated.

* Security Testing and Fuzzing

	* Explain what a **test oracle** is, what fuzzing is & how it works.
  
	* Explain what **mutation-based fuzzing**, **generational fuzzing whitebox
	  fuzzing using symbolic execution**, and **evolutionary fuzzing** are.
	  Explain advantages and limitations of these approaches, and pros &
	  cons of and between the variants.

	* David Wheeler's Apple iOS goto bug paper: given some claim about
	  about how this (type of) bug could be prevented, argue for or
	  against this claim.

* Code obfuscation

	* You do NOT have to memorise these obfuscations technology, or
	  to be able to reproduce how they work. Given a description
	  of one of these techniques, you should to be able explain what 
	  the idea behind this (ie. why is this obfuscation? though that
	  should be pretty obvious) and why you might want apply such
	  techniques.

* LangSec and state machine testing

	* For the principles that LangSec advocates, explain what these
      principles mean and explain the motivation behind them.  Similarly
      for the practices that LangSec abhors.

	* Explain what model based testing is, and how state machine
      learning can be used to reverse engineer applications and find
      potential security flaws

**FOR PEOPLE DOING THE 6 EC VARIANT:**

* Program Verification

	* Explain how & why one might use program verification.
	* Explain/apply basic JML annotations as used in the ESC/Java assignment.
	* Discuss pros and cons of these techniques.
	* Have another look at the JML exercises.







### Lecture 1 - Introduction & Security in the SDLC (Security Development Life Cyle?) - Sept 8


* Literature:
	* [Software Security by Gary McGraw](../literature/Software_Security_-_Gary_McGraw.pdf)
	* [Software Security in Practice by Brian Chess & Brad Arkin](../literature/Software_Security_in_Practice_-_Brian_Chess_and_Brad_Arkin.pdf)


### Lecture 2 - Buffer overflows & platform-level countermeasures - Sept 15


* Literature:
	* [Sections 30.3 & 30.4 (on pages 645-656) of Low-level Software Security by Example by Ulfar Erlingsson et al.](../literature/low-level-security-by-example.pdf)
	* Sections 3.1 & 3.2 of the lecture notes
	* [Arstechnica article on BlueBorne bluetooth security bug](https://arstechnica.com/information-technology/2017/09/bluetooth-bugs-open-billions-of-devices-to-attacks-no-clicking-required/)


### Lecture 3 - More buffer overflow countermeasures and Static Analysis with PREfast & SAL - Sept 22


* Literature:
	* [C++ example used in PREfast demo](https://www.cs.ru.nl/E.Poll/ss/simple_demo_prefast.cpp)
	* [Video demo of static analysis in Visual Studio](https://www.youtube.com/watch?v=LW0GBbbjwLI)
		* Microsoft Security Development Lifecycle (see: www.microsoft.com/sdl)
		* Besides the ability of Static Analysis Tools to spot security vulnerabilities, they can also provide a just-in-time learning experience for the developer as he learns about bugs while he writes his code.
		* The narrator goes to a C/C++ code fragment and points out that although Visual Studio is set to the highest warning level (4) when building, the actual security flaws are not spotted by Visual Studio. After enabling (static) code analysis a whole bunch of flaws pop up.
		* They talk about the fact that security flaws while using custom functions are not spotted right out of the box. In order to give the static analysis tool information about custom functions and its contract, the Standard Annotation Language (SAL) is used (see FillString function).


### Lecture 4 - Language-based Security: 'Safe' programming languages - Sept 29

* Literature:
	* Chapters 2 & 3 of lecture notes


### Lecture 5 - Discussion PREfast project, Intro group project, Input Problems - Oct 6

* Literature:
	* Nothing



### Lecture 6 - Input problems: root causes and defenses - Oct 13

* Literature:
	* [Wyvern: Impacting Software Security via Programming Language Design](../literature/Wyvern_Impacting_Software_Security_via_Programming_Language_Design.pdf)
		* Some people argue that system safety and security is a completely programming language agnostic topic. The authors of the paper disagree with this opinion and say that programming language design can have direct influence on the security of software systems. They defend this opinion by showcasing their programming language "Wyvern" (web programming language) in the context of command injections/SQL Injections.
		* Wyvern incorporates SQL as part of its language and gives the developer an easy and secure way to write SQL queries in contrast to just using Strings in other programming languages. The authors state that the biggest hurdle in writing secure applications is the ease of use. It is easier to just write some SQL queries as Strings in comparison to construct secure Prepared Statements.
		* Wyvern is using some common principles like: secure defaults, principle of least privilege, keeping security simple, using open design
		* Simple idea which just describes the known fact that most developers write insecure code because they are lazy. If the programming language provides a way to get stuff done as easy as possible while being secure than that's one solution for sure.



### Lecture 7 - Sandboxing - Oct 20

* Literature:
	* Chapter 4 of lecture notes



### Lecture 8 - Java secure programming guidelines, TOCTOU attacks - Oct 27

* Literature:
	* [Statically Scanning Java Code: Finding Security Vulnerabilities](../literature/Statically_Scanning_Java_Code.pdf)
		* Authors present a Static Code Analysis Tool for Java called JsLint
		* The goal is to minimize the unfortunately pervasive "penetrate and patch" approach
		* Implementations of the Java Platform expose a user to 3 classes of risks:
			* A **JVM flaw** might allow a malicious Java program to breach the JVM's security enforcement: **Securing the Java platform can prevent this**
			* The user might mistakenly grant powerful privileges to code that turns out to be malicious: **A user's good judgement can prevent this** 
			* The user might grant powerful privileges to code that is well intentioned but contains bugs that other malicious code can exploit: **JsLint can help here**
		* 12 Rules for More Secure Java Code (**JsLint checks for violations of these rules**)
			* 1. Don't Depend on Initialization
			* 2. Limit Access to Your Classes, Methods, and Variables
			* 3. Make Everything Final by Default, Unless There Is a Good Reason Not to Do So
			* 4. Don't Depend on Package Scope
			* 5. Do Not Use Inner Classes (Java byte code has no concept of inner classes)
			* 6. Avoid Signing Your Code (Minimize the Amount of privilged Code)
			* 7. If You Must Sign Your Code, Put it All in One Archive File
			* 8. Make Your Classes Uncloneable
			* 9. Make Your Classes Unserializeable
			* 10. Make Your Classes Undeserializeable
			* 11. Don't Compare Classes by Name
			* 12. Secrets Stored in Your Code Won't Protect You
		* JsLint parses the source file into a syntax tree and then uses the visitor pattern to traverse the syntax tree looking for vulnerabilities	



### Lecture 9 - Information Flow - Nov 17

* Literature:
	* Chapter 5 of lecture notes


### Lecture 10 - Information Flow for Android Apps - Nov 24

* Literature:
	* [Collaborative Verification of Information Flow for a High-Assurance App Store](../literature/Collaborative_Verification_of_Information_Flow_for_a_High-Assurance_App_Store.pdf)
		* The author propose a verification model for app stores in order to assure that the apps are free of malicious code
		* Two parties involved: **The software vendor** and **the app store auditor** collaborate
		* The software vendor provides a behavioral specification of information flow and source code annoated with information-flow type qualifiers. A flow-sensitive, context-sensitive information-flow type system checks the information flow type qualifiers
		* The app store auditor uses the vendor-provided source code to manually verify declassifications
		* Tailored towards Android Apps written in Java
		* 4 factors in current app stores which make it hard to detect trojans
			* 1. Existing analysis tools require error-prone human effort
			* 2. The vendor provides only a very coarse description of application behavior in the form of permissions it will access (manifest)
			* 3. The binary executable lacks much semantic information that is available in source code
			* 4. The vendor has little motivation to make the application easy for the app store to analyze and understand


### Lecture 11 - Security Testing & Fuzzing - Dec 1

* Literature:
	* [SAGE: whitebox fuzzing for security testing](http://queue.acm.org/detail.cfm?id=2094081)
	* [The Apple goto fail vulnerability: lessons learned](http://www.dwheeler.com/essays/apple-goto-fail.html)


### Lecture 12 - Program Verification & Guest lecture by Wil Michiels (NXP/TUE) on Obfuscation - Dec 8

* Literature:
	* Nothing

### Lecture 13 - LangSec & State Machine Inference - Dec 15

* Literature:
	* [LangSec "manifesto"](../literature/langsec-manifesto.pdf)
	* [Protocol State Machines and session languages](../literature/Protocol_state_machines_and_session_languages.pdf)

### Lecture 14 - Discussion group project - Dec 22

* Literature:
	* Nothing

### Lecture 15 - Program Verficiation lab session - Jan 12

* Literature:
	* Nothing

