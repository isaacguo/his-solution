create table chargeable_category_entity (id bigint not null auto_increment, name varchar(255), parent_id bigint, primary key (id)) ENGINE=InnoDB
create table chargeable_item_entity (id bigint not null auto_increment, amount decimal(19,2), chargeable_item_id varchar(255), name varchar(255), name_han_yu_pin_yin varchar(255), specification varchar(255), unit varchar(255), uuid varchar(255), category_id bigint, primary key (id)) ENGINE=InnoDB
create table comment_entity (id bigint not null auto_increment, comments varchar(255), created_date tinyblob, uuid varchar(255), uuid_of_comment_by varchar(255), treatment_case_id bigint, primary key (id)) ENGINE=InnoDB
create table department_entity (id bigint not null auto_increment, dep_id bigint, description varchar(255), expose_to_public bit not null, name varchar(255), open_to_front_desk bit not null, primary key (id)) ENGINE=InnoDB
create table employee_entity (id bigint not null auto_increment, can_be_registered bit not null, emp_id bigint, login_account varchar(255), name varchar(255), self_introduction varchar(255), uuid varchar(255), department_id bigint, employee_type_id bigint, primary key (id)) ENGINE=InnoDB
create table employee_type_entity (id bigint not null auto_increment, name varchar(255), primary key (id)) ENGINE=InnoDB
create table expense_entity (id bigint not null auto_increment, pet_owner_id bigint, primary key (id)) ENGINE=InnoDB
create table pet_entity (id bigint not null auto_increment, age integer not null, color integer, date_of_birth tinyblob, gender integer, name varchar(255), sterilized bit not null, uuid varchar(255), pet_owner_id bigint, pet_type_id bigint, primary key (id)) ENGINE=InnoDB
create table pet_owner_entity (id bigint not null auto_increment, address varchar(255), cell_phone varchar(255), date_of_birth tinyblob, email varchar(255), gender integer, home_phone varchar(255), member_number varchar(255), name varchar(255), uuid varchar(255), primary key (id)) ENGINE=InnoDB
create table pet_type_entity (id bigint not null auto_increment, is_root bit not null, name varchar(255), parent_id bigint, primary key (id)) ENGINE=InnoDB
create table prescription_entity (id bigint not null auto_increment, medicine_comment varchar(255), medicine_count bigint, medicine_group varchar(255), medicine_name varchar(255), medicine_number bigint, medicine_price bigint, medicine_specification varchar(255), medicine_unit varchar(255), medicine_usage varchar(255), treatment_case_id bigint, primary key (id)) ENGINE=InnoDB
create table registration_entity (id bigint not null auto_increment, book_date tinyblob, created_date tinyblob, index_of_day integer not null, price bigint, registration_status integer, doctor_id bigint, operator_id bigint, pet_id bigint, primary key (id)) ENGINE=InnoDB
create table registration_number_entity (id bigint not null auto_increment, date tinyblob, number integer, doctor_id bigint, primary key (id)) ENGINE=InnoDB
create table treatment_case_entity (id bigint not null auto_increment, clinic_situation varchar(255), created_date tinyblob, doctor_advice varchar(255), doctor_diagnose varchar(255), last_modified_date_time tinyblob, pet_owner_description varchar(255), treatment_case_status varchar(255), treatment_date tinyblob, uuid varchar(255), doctor_id bigint, pet_id bigint, primary key (id)) ENGINE=InnoDB
create table treatment_case_entity_medical_test_report_uuid_list (treatment_case_entity_id bigint not null, medical_test_report_uuid_list varchar(255)) ENGINE=InnoDB
create table treatment_case_entity_pharmacy_medicine_dispense_uuid_list (treatment_case_entity_id bigint not null, pharmacy_medicine_dispense_uuid_list varchar(255)) ENGINE=InnoDB
create table treatment_case_medicine_entity (id bigint not null auto_increment, amount decimal(19,2), inventory_item_id varchar(255), medicine_uuid varchar(255), name varchar(255), specification varchar(255), unit varchar(255), uuid varchar(255), treatment_case_id bigint, primary key (id)) ENGINE=InnoDB
alter table chargeable_category_entity add constraint FKt5qefbn9na8j93hhidbynq2y5 foreign key (parent_id) references chargeable_category_entity (id)
alter table chargeable_item_entity add constraint FKlnmcmwrimgs5tnmqcbr4v8xna foreign key (category_id) references chargeable_category_entity (id)
alter table comment_entity add constraint FKcxa1gpl8foawe48is83aksfxr foreign key (treatment_case_id) references treatment_case_entity (id)
alter table employee_entity add constraint FKrj4v5xw1jix23uajsogqdy0a0 foreign key (department_id) references department_entity (id)
alter table employee_entity add constraint FKkve3m2lulwm1xav7ik2bowhr6 foreign key (employee_type_id) references employee_type_entity (id)
alter table expense_entity add constraint FKt30kehjp5r3scxf5xt2l2lc99 foreign key (pet_owner_id) references pet_owner_entity (id)
alter table pet_entity add constraint FKhpcc8jomtw8h2hfqb247m0dq6 foreign key (pet_owner_id) references pet_owner_entity (id)
alter table pet_entity add constraint FKaof55hsdpkgy8n1o1bwi8v28t foreign key (pet_type_id) references pet_type_entity (id)
alter table pet_type_entity add constraint FKrfo06j1yysq5g1l9nywwa95a7 foreign key (parent_id) references pet_type_entity (id)
alter table prescription_entity add constraint FKrl7x4dcjq3gy1puuhac9rhi0q foreign key (treatment_case_id) references treatment_case_entity (id)
alter table registration_entity add constraint FK3dalsjnwcaaue8nysr0gd1gs7 foreign key (doctor_id) references employee_entity (id)
alter table registration_entity add constraint FKdcnt0v441e7q3s1b2psr4m7av foreign key (operator_id) references employee_entity (id)
alter table registration_entity add constraint FK6pfh5xcvgwluplcdh0ch1sivf foreign key (pet_id) references pet_entity (id)
alter table registration_number_entity add constraint FKo8r0g185lhfwqou89casipody foreign key (doctor_id) references employee_entity (id)
alter table treatment_case_entity add constraint FK66k2f9imb7mfetn3habawq81b foreign key (doctor_id) references employee_entity (id)
alter table treatment_case_entity add constraint FKp7mrx9givae5w86lcv6fty4cl foreign key (pet_id) references pet_entity (id)
alter table treatment_case_entity_medical_test_report_uuid_list add constraint FK7aecoo9npchmw3tklctpmowqm foreign key (treatment_case_entity_id) references treatment_case_entity (id)
alter table treatment_case_entity_pharmacy_medicine_dispense_uuid_list add constraint FK2g24hd2gpiuvhjx8i9ci96ry5 foreign key (treatment_case_entity_id) references treatment_case_entity (id)
alter table treatment_case_medicine_entity add constraint FKbky4xii23afc3pj3fn2xsxv6p foreign key (treatment_case_id) references treatment_case_entity (id)
