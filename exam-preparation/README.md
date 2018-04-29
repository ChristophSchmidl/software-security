# Software Security - Exam Preparation



## Checklist for Exam

* Buffer overflows
	* Spot a simple buffer overflow. Explain how buffer overflows work, and explain some cause for them.

	* Explain/discuss any of the countermeasures against buffer overflows, (canaries, non-executable data segments, ASLR, CFI, execution-aware memory protection),
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

	* format string attack,
	* integer overflow
	* command injection
	* PHP injection 
	* SQL injection (normal, blind or 2nd order )
	* XSS
	* CSRF
	* TOCTOU aka race conditions
	* more generally: (lack of) input validation, output validation 
      is; spot/explain them in simple examples; explain/discuss 
      the countermeasures against them.

* Explain the notion of TCB (Trusted Computing Base) or 
  say what the TCB is in a given scenario.

* Comment on (some aspects of using) the ASVS.

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

	* Explain what a test oracle is, what fuzzing is & how it works.
  
	* Explain what mutation-based fuzzing, generational fuzzing whitebox
	  fuzzing using symbolic execution, and evolutionary fuzzing are.
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


### Lecture 4 - Language-based Security: 'Safe' programming languages - Sept 29

* Literature:
	* Chapters 2 & 3 of lecture notes


### Lecture 5 - Discussion PREfast project, Intro group project, Input Problems - Oct 6

* Literature:
	* Nothing



### Lecture 6 - Input problems: root causes and defenses - Oct 13

* Literature:
	* [Wyvern: Impacting Software Security via Programming Language Design](../literature/Wyvern_Impacting_Software_Security_via_Programming_Language_Design.pdf)


### Lecture 7 - Sandboxing - Oct 20

* Literature:
	* Chapter 4 of lecture notes



### Lecture 8 - Java secure programming guidelines, TOCTOU attacks - Oct 27

* Literature:
	* [Statically Scanning Java Code: Finding Security Vulnerabilities](../literature/Statically_Scanning_Java_Code.pdf)



### Lecture 9 - Information Flow - Nov 17

* Literature:
	* Chapter 5 of lecture notes


### Lecture 10 - Information Flow for Android Apps - Nov 24

* Literature:
	* [Collaborative Verification of Information Flow for a High-Assurance App Store](../literature/Collaborative_Verification_of_Information_Flow_for_a_High-Assurance_App_Store.pdf)


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

