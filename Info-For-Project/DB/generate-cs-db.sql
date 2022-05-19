create table students
(
    pk               int auto_increment
        primary key,
    first_name       varchar(30)   null,
    last_name        varchar(30)   null,
    year_in_uni      int           null,
    credits          int default 0 null,
    count_of_studies int default 0 null,
    constraint students_pk_uindex
        unique (pk)
)
    auto_increment = 11;

create table teachers
(
    pk               int auto_increment
        primary key,
    first_name       varchar(30)   null,
    last_name        varchar(30)   null,
    title            varchar(60)   null,
    discipline_count int default 0 null,
    students_count   int default 0 null,
    constraint teachers_pk_uindex
        unique (pk)
)
    auto_increment = 5;

create table disciplines
(
    pk              int auto_increment
        primary key,
    name            varchar(60)   null,
    credits         int default 0 null,
    teacher_pk      int           null,
    students_signed int default 0 null,
    constraint disciplines_name_uindex
        unique (name),
    constraint disciplines_pk_uindex
        unique (pk),
    constraint teacher_pk
        foreign key (teacher_pk) references teachers (pk)
)
    auto_increment = 14;

create table journal
(
    id            int auto_increment
        primary key,
    discipline_fk int null,
    student_fk    int null,
    constraint journal_id_uindex
        unique (id),
    constraint discipline_fk
        foreign key (discipline_fk) references disciplines (pk),
    constraint student_fk
        foreign key (student_fk) references students (pk)
);


