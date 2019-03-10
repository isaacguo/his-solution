create table company_entity (id bigint not null auto_increment, company_location varchar(255), company_name varchar(255), uuid binary(255), primary key (id)) ENGINE=InnoDB
create table contact_address_entity (id bigint not null auto_increment, address varchar(255), city varchar(255), country varchar(255), district varchar(255), home_phone varchar(255), mobile_phone varchar(255), personal_email varchar(255), post varchar(255), work_phone varchar(255), employee_entity_id bigint, primary key (id)) ENGINE=InnoDB
create table department_entity (id bigint not null auto_increment, name varchar(255), company_id bigint, parent_id bigint, primary key (id)) ENGINE=InnoDB
create table employee_entity (id bigint not null auto_increment, date_of_birth tinyblob, driver_license_number varchar(255), email varchar(255), emergency_contact varchar(255), emergency_phone_number varchar(255), employee_number varchar(255), employment_status integer, ethnic varchar(255), full_name varchar(255), full_name_han_yu_pin_yin varchar(255), gender varchar(255), given_name varchar(255), id_number varchar(255), job_title varchar(255), joined_date tinyblob, login_account varchar(255), marital_status varchar(255), nationality varchar(255), password varchar(255), surname varchar(255), uuid varchar(255), work_phone_number varchar(255), contact_address_id bigint, department_id bigint, department_in_charge_id bigint, direct_report_to_id bigint, primary key (id)) ENGINE=InnoDB
create table leave_info_entity (id bigint not null auto_increment, anuual_leave bigint not null, sick_leave bigint not null, employee_id bigint, primary key (id)) ENGINE=InnoDB
create table leave_record_entity (id bigint not null auto_increment, employee_id bigint, primary key (id)) ENGINE=InnoDB
create table salary_entity (id bigint not null auto_increment, base_salary bigint not null, bonus bigint not null, employee_id bigint, primary key (id)) ENGINE=InnoDB
alter table contact_address_entity add constraint FKmuf71mo60bod44xtkyk1wr7x3 foreign key (employee_entity_id) references employee_entity (id)
alter table department_entity add constraint FKdwmtmcbga6hn8ot4o4ganx8ja foreign key (company_id) references company_entity (id)
alter table department_entity add constraint FKhtcfnm96ilhdpffmvfq2mp3ws foreign key (parent_id) references department_entity (id)
alter table employee_entity add constraint FK91a25f68b163h0p91o17ut57r foreign key (contact_address_id) references contact_address_entity (id)
alter table employee_entity add constraint FKrj4v5xw1jix23uajsogqdy0a0 foreign key (department_id) references department_entity (id)
alter table employee_entity add constraint FKriqcxekv2a3cb8ps3ir1jopx7 foreign key (department_in_charge_id) references department_entity (id)
alter table employee_entity add constraint FKjel8v2v84txlhtn56ei07xt31 foreign key (direct_report_to_id) references employee_entity (id)
alter table leave_info_entity add constraint FK67mq3j43u3i2nt419r0ffh3n2 foreign key (employee_id) references employee_entity (id)
alter table leave_record_entity add constraint FKt14fbq2i1ak86y4jj42yhw1ns foreign key (employee_id) references employee_entity (id)
alter table salary_entity add constraint FKsdneb77ynkwqy92qpdgtodw27 foreign key (employee_id) references employee_entity (id)
