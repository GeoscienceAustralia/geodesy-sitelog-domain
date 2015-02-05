## geodesy-sitelog-domain

In 2014, Geoscience Australia developed a prototype system to manage
persistence and remote management of IGS site log XML files via OGC Web
Services. This project is part of the codebase, and it deals with marshalling and
unmarshalling of site log XML files and persistence of site metadata into a
relational database.

XML marshalling is handled by the EclipseLink/MOXy implementation of JAXB (Java
Architecture for XML Binding), and data persistence is handled by the Hibernate
implementation of JPA (Java Persistence API).

