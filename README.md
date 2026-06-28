# ContactService

**How can I ensure that my code, program, or software is functional and secure?**
I ensure functionality and security by validating input before storing it. The Contact class rejects null values and enforces limits (10-character ID and names, exactly 10 digits for the number, 30-character address), throwing exceptions when rules are broken. JUnit tests confirm both valid creation and expected exceptions, and high coverage gives me confidence that bad data can't slip through.



**How do I interpret user needs and incorporate them into a program?**
I translate each requirement directly into a validation rule and a matching test. Unique IDs, non-updatable identifiers, and field limits each become a specific check that a test proves. For example, the Contact ID has no setter because it must not be updatable, and a test verifies it stays fixed.



**How do I approach designing software?**
I keep responsibilities separated and the structure simple. Each feature has a data class (Contact, Task, Appointment) that owns validation and a service class that manages objects in a HashMap keyed by ID. This makes the code easy to test and extend, and designing with testing in mind from the start helps me avoid technical debt.
