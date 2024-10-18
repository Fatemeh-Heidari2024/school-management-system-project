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

select s.first_name,s.last_name,c.cource_title,
       concat(t.first_name,' ',t.last_name) as teacher_name from student as s
                                                                     inner join public.enrollments e on s.student_id = e.student_id
                                                                     inner join cource  as c on e.cource_id = c.cource_id
                                                                     inner join teacher as t on c.teacher_id = t.teacher_id;

select s.first_name,s.last_name,c.cource_title,
       concat(t.first_name,' ',t.last_name) as teacher_name from student as s
                                                                     left join public.enrollments e on s.student_id = e.student_id
                                                                     left join cource  as c on e.cource_id = c.cource_id
                                                                     left join teacher as t on c.teacher_id = t.teacher_id;

select s.first_name,s.last_name,c.cource_title from student as s
                                                        join enrollments as e on s.student_id=e.student_id
                                                        join cource c on e.cource_id = c.cource_id;

select * from student where first_name=:'first_name' and gpu=:gpu;

select s.first_name,s.last_name,c.cource_title from school_management.public.student as s
                                                        join school_management.public.enrollments as e on s.student_id=e.student_id
                                                        join school_management.public.cource as c on e.cource_id = c.cource_id;