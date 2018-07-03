create table authorization_assignment_entity (id bigint not null auto_increment, authorization_id bigint, topic_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authorization_assignment_entity_allowed_operations (authorization_assignment_entity_id bigint not null, allowed_operations_id bigint not null) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authorization_entity (id bigint not null auto_increment, uid bigint, user_account varchar(255), username varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table authorization_topic_entity (id bigint not null auto_increment, name varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table charge_category_entity (id bigint not null auto_increment, name varchar(255), parent_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table charge_entity (id bigint not null auto_increment, charge_item_id varchar(255), from_service varchar(255), member_price bigint, normal_price bigint, charge_category_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table common_configuration_entity (id bigint not null auto_increment, conf_key varchar(255), conf_value varchar(255), primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table fee_entity (id bigint not null auto_increment, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table fee_item_entity (id bigint not null auto_increment, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table topic_operation_entity (id bigint not null auto_increment, name varchar(255), authorization_topic_id bigint, primary key (id)) ENGINE=InnoDB DEFAULT CHARSET=utf8;
create table topic_operation_entity_authorization_assignment_list (topic_operation_entity_id bigint not null, authorization_assignment_list_id bigint not null) ENGINE=InnoDB DEFAULT CHARSET=utf8;
alter table authorization_assignment_entity add constraint FKedjwiuan814a19bi4yy07tdph foreign key (authorization_id) references authorization_entity (id)
alter table authorization_assignment_entity add constraint FK8dqq1kc7jp0clkstctpnjtl2y foreign key (topic_id) references authorization_topic_entity (id)
alter table authorization_assignment_entity_allowed_operations add constraint FK5vwid8n1jmi0r5h2fxxnbvbgn foreign key (allowed_operations_id) references topic_operation_entity (id)
alter table authorization_assignment_entity_allowed_operations add constraint FKngkgigjkrhs9p2ir6bh9cuu6a foreign key (authorization_assignment_entity_id) references authorization_assignment_entity (id)
alter table charge_category_entity add constraint FKjk997gmecmmwc2ek1i51qodx6 foreign key (parent_id) references charge_category_entity (id)
alter table charge_entity add constraint FKfcbbam0h8uvq1l2ebl1g1tkau foreign key (charge_category_id) references charge_category_entity (id)
alter table topic_operation_entity add constraint FKoec3nr2ausdy7u53qubpxopo8 foreign key (authorization_topic_id) references authorization_topic_entity (id)
alter table topic_operation_entity_authorization_assignment_list add constraint FKtmjvf3170d9xr73l2i2sy705t foreign key (authorization_assignment_list_id) references authorization_assignment_entity (id)
alter table topic_operation_entity_authorization_assignment_list add constraint FK4y6aqtertcn95oyqdiba3jdbf foreign key (topic_operation_entity_id) references topic_operation_entity (id)
