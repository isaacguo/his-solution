create table authorization_assignment_entity (id bigint not null auto_increment, authorization_id bigint, topic_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authorization_assignment_entity_allowed_operations (authorization_assignment_entity_id bigint not null, allowed_operations_id bigint not null) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authorization_entity (id bigint not null auto_increment, uid bigint, user_account varchar(255), username varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authorization_topic_entity (id bigint not null auto_increment, name varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table common_configuration_entity (id bigint not null auto_increment, conf_key varchar(255), conf_value varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table department_entity (id bigint not null auto_increment, dep_id bigint, description varchar(255), enable bit not null, name varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_entity (id bigint not null auto_increment, created_date_time datetime, finished_date_time datetime, paid_date_time datetime, pet_owner_uuid varchar(255), pet_uuid varchar(255), report_name varchar(255), report_status integer, report_template_uuid varchar(255), treatment_case_uuid varchar(255), uuid varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_info_entity (id bigint not null auto_increment, report_key varchar(255), report_section varchar(255), report_value varchar(255), report_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_item_entity (id bigint not null auto_increment, comments varchar(255), item_name varchar(255), item_unit varchar(255), reference_high_limit_value varchar(255), reference_low_limit_value varchar(255), result varchar(255), report_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_template_category_entity (id bigint not null auto_increment, name varchar(255), department_id bigint, parent_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_template_entity (id bigint not null auto_increment, report_name varchar(255), report_name_han_yu_pin_yin varchar(255), uuid varchar(255), category_id bigint, department_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_template_info_entity (id bigint not null auto_increment, report_key varchar(255), report_section varchar(255), report_value varchar(255), report_template_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table report_template_item_entity (id bigint not null auto_increment, comments varchar(255), item_name varchar(255), item_unit varchar(255), reference_high_limit_value varchar(255), reference_low_limit_value varchar(255), report_template_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table topic_operation_entity (id bigint not null auto_increment, name varchar(255), authorization_topic_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table topic_operation_entity_authorization_assignment_list (topic_operation_entity_id bigint not null, authorization_assignment_list_id bigint not null) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table authorization_assignment_entity add constraint FKedjwiuan814a19bi4yy07tdph foreign key (authorization_id) references authorization_entity (id);
alter table authorization_assignment_entity add constraint FK8dqq1kc7jp0clkstctpnjtl2y foreign key (topic_id) references authorization_topic_entity (id);
alter table authorization_assignment_entity_allowed_operations add constraint FK5vwid8n1jmi0r5h2fxxnbvbgn foreign key (allowed_operations_id) references topic_operation_entity (id);
alter table authorization_assignment_entity_allowed_operations add constraint FKngkgigjkrhs9p2ir6bh9cuu6a foreign key (authorization_assignment_entity_id) references authorization_assignment_entity (id);
alter table report_info_entity add constraint FKapcitetv62qlykq00wmphc1o0 foreign key (report_id) references report_entity (id);
alter table report_item_entity add constraint FKp925curaqjcvb8hal0m9ick42 foreign key (report_id) references report_entity (id);
alter table report_template_category_entity add constraint FKrb14k66i30myicymaghfpxplo foreign key (department_id) references department_entity (id);
alter table report_template_category_entity add constraint FK9cjmxo9biqu4e2duj95i88lbj foreign key (parent_id) references report_template_category_entity (id);
alter table report_template_entity add constraint FK4n1wf35cfew97in891l1ktr7y foreign key (category_id) references report_template_category_entity (id);
alter table report_template_entity add constraint FKo99ncaeexhvnup2n4h5ctmfx0 foreign key (department_id) references department_entity (id);
alter table report_template_info_entity add constraint FK894ypqlpfiight4vw4kiqn0bm foreign key (report_template_id) references report_template_entity (id);
alter table report_template_item_entity add constraint FKh2lko2hwf7aeepnpsl30x71uf foreign key (report_template_id) references report_template_entity (id);
alter table topic_operation_entity add constraint FKoec3nr2ausdy7u53qubpxopo8 foreign key (authorization_topic_id) references authorization_topic_entity (id);
alter table topic_operation_entity_authorization_assignment_list add constraint FKtmjvf3170d9xr73l2i2sy705t foreign key (authorization_assignment_list_id) references authorization_assignment_entity (id);
alter table topic_operation_entity_authorization_assignment_list add constraint FK4y6aqtertcn95oyqdiba3jdbf foreign key (topic_operation_entity_id) references topic_operation_entity (id);
