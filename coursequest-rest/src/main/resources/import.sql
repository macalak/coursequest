insert into USER_TBL (ID, USERNAME, ROLE) values (NEXTVAL('hibernate_sequence'),'Jano Student','STUDENT');
insert into USER_TBL (ID, USERNAME, ROLE) values (NEXTVAL('hibernate_sequence'),'Fero Student','STUDENT');
insert into USER_TBL (ID, USERNAME, ROLE) values (NEXTVAL('hibernate_sequence'),'Peter Vyucujuci','TEACHER');
insert into USER_TBL (ID, USERNAME, ROLE) values (NEXTVAL('hibernate_sequence'),'Martin Vyucujuci','TEACHER');
insert into USER_TBL (ID, USERNAME, ROLE) values (NEXTVAL('hibernate_sequence'),'Tomas Spravca','ADMIN');

insert into COURSE_TBL (ID, NAME) values (NEXTVAL('hibernate_sequence'),'Matematika');
insert into COURSE_TBL (ID, NAME) values (NEXTVAL('hibernate_sequence'),'Fyzika');

insert into USER_COURSE (COURSE_ID, USER_ID) values(6,1);
insert into USER_COURSE (COURSE_ID, USER_ID) values(7,1);
insert into USER_COURSE (COURSE_ID, USER_ID) values(7,2);
