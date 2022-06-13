# Supplementary Specification (FURPS+)

## Functionality

_Specifies functionalities that:_

- _are common across several US/UC;_
- _are not related to US/UC, namely: Audit, Reporting and Security._



Security:
 - Every user must authenticate with a password holding seven alphanumeric characters, including three capital letters and two digits.
 - Only nurses are allowed to access all user's health data.

Localization:
- Application must support Portuguese and English languages.

Email:
- Service to notify via e-mail when the recovery period is over.

Report:
- Service to compare data from Vaccination Centers and generate Reports to the Center Coordinator.
 
System Management:
- FIFO queue to manage vaccination centers.


## Usability 

_Evaluates the user interface. It has several subcategories,
among them: error prevention; interface aesthetics and design; help and
documentation; consistency and standards._


(fill in here )

## Reliability
_Refers to the integrity, compliance and interoperability of the software. The requirements to be considered are: frequency and severity of failure, possibility of recovery, possibility of prediction, accuracy, average time between failures._


(fill in here )

## Performance
_Evaluates the performance requirements of the software, namely: response time, start-up time, recovery time, memory consumption, CPU usage, load capacity and application availability._


(fill in here )

## Supportability
_The supportability requirements gathers several characteristics, such as:
testability, adaptability, maintainability, compatibility,
configurability, installability, scalability and more._ 



Testability:
- Use Junit5 and use JaCoCo plugin to track mutation and test coverage.


## +

### Design Constraints

_Specifies or constraints the system design process. Examples may include: programming languages, software process, mandatory standards/patterns, use of development tools, class library, etc._

Design:
- Object-Oriented design




### Implementation Constraints

_Specifies or constraints the code or construction of a system such
such as: mandatory standards/patterns, implementation languages,
database integrity, resource limits, operating system._

Coding Standard:
- Using CamelCase

Mandatory standard:
- Use svg format for all images and figures

Implementation Language:
- Java
- JavaFX11





### Interface Constraints
_Specifies or constraints the features inherent to the interaction of the
system being developed with other external systems._


(fill in here )

### Physical Constraints

_Specifies a limitation or physical requirement regarding the hardware used to house the system, as for example: material, shape, size or weight._

(fill in here )