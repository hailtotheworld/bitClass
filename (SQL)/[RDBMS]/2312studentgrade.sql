insert into tb_schoolgrade values (1, '1학년');
insert into tb_schoolgrade values (2, '2학년');
insert into tb_schoolgrade values (3, '3학년');

insert into tb_teacher(teacherName) values('선생1');
insert into tb_teacher(teacherName) values('선생2');
insert into tb_teacher(teacherName) values('선생3');

insert into tb_schoolclass(SchoolGradeId,SchoolClassId,SchoolClassName,TeacherId,AssignedDate)
values(1,1,'1반',1,'2013-03-01');

insert into tb_schoolclass(SchoolGradeId,SchoolClassId,SchoolClassName,TeacherId,AssignedDate)
values(1,2,'2반',2,'2013-03-01');

insert into tb_student(StudentName,SchoolGradeId,EntranceDate)
values('학생1',1,'2013-03-06');
insert into tb_student(StudentName,SchoolGradeId,EntranceDate)
values('학생1',1,'2013-03-06');

insert into tb_student(StudentName,SchoolGradeId,SchoolClassId,StudentSeqNo,EntranceDate)
values('학생1',1,1,1,'2013-03-06');
insert into tb_student(StudentName,SchoolGradeId,SchoolClassId,StudentSeqNo,EntranceDate)
values('학생1',1,1,2,'2013-03-06');
insert into tb_student(StudentName,SchoolGradeId,StudentSeqNo,EntranceDate)
values('학생1',1,2,'2013-03-06');




select * from tb_schoolgrade;
select * from tb_teacher;
select * from tb_schoolclass;
select * from tb_student;