alter table cource add teacher_id int references teacher(teacher_id);

create table cource_student(cource_id int references cource(cource_id),
                            student_id int references student(student_id),
                            primary key(cource_id,student_id));

alter table exam add cource_id int references cource(cource_id)

create table teacher_student(teacher_id int references teacher(teacher_id),
                             student_id int references student(student_id),
                             primary key(teacher_id,student_id))

create table student_exam(student_exam_id serial
    ,student_id int references student(student_id),
                          exam_id int references exam(exam_id),
                          primary key (student_exam_id));
alter table cource add UNIQUE(cource_title);

alter table student add UNIQUE(national_code);

alter table teacher add UNIQUE(national_code);