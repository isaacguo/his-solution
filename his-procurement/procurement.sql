create table contact_entity (id bigint not null auto_increment, name varchar(255), telephone varchar(255), vendor_id bigint, primary key (id)) ENGINE=InnoDB
create table currency_entity (id bigint not null auto_increment, name varchar(255), primary key (id)) ENGINE=InnoDB
create table department_permission_entity (id bigint not null auto_increment, department_id bigint, department_name varchar(255), permitted bit not null, vendor_category_id bigint, primary key (id)) ENGINE=InnoDB
create table operator_entity (id bigint not null auto_increment, primary key (id)) ENGINE=InnoDB
create table procurement_approval_entity (id bigint not null auto_increment, comments varchar(255), created_date_time tinyblob, review_result bit not null, reviewed bit not null, reviewed_date_time tinyblob, reviewer varchar(255), reviewer_full_name varchar(255), stage varchar(255), procurement_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_approval_stage_entity (id bigint not null auto_increment, stage varchar(255), previous_stage_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_configuration_entity (id bigint not null auto_increment, conf_key varchar(255), conf_value varchar(255), primary key (id)) ENGINE=InnoDB
create table procurement_entity (id bigint not null auto_increment, order_number varchar(255), status varchar(255), operator_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_log_entity (id bigint not null auto_increment, comment varchar(255), submitted_data tinyblob, procurement_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_purchase_entity (id bigint not null auto_increment, assign_to varchar(255), generated_date_time tinyblob, total_price double precision not null, procurement_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_purchase_entity_goods (procurement_purchase_entity_id bigint not null, goods_id bigint not null) ENGINE=InnoDB
create table procurement_purchase_good_entity (id bigint not null auto_increment, contact varchar(255), contact_telephone varchar(255), number double precision not null, package_specification varchar(255), package_unit varchar(255), price_per_unit double precision not null, total_price double precision not null, vendor varchar(255), procurement_purchase_id bigint, procurement_request_good_entity_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_request_good_entity (id bigint not null auto_increment, name varchar(255), number varchar(255), package_specification varchar(255), package_unit varchar(255), price_per_unit double precision not null, total_price double precision not null, request_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_requests (id bigint not null auto_increment, explanation varchar(255), requester varchar(255), requester_full_name varchar(255), submitted_data datetime, total_price double precision, procurement_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_request_vendor_info_entity (id bigint not null auto_increment, contact varchar(255), contact_telephone varchar(255), vendor varchar(255), vendor_id varchar(255), request_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_status_entity (id bigint not null auto_increment, last_status_result bit not null, status varchar(255), parent_id bigint, primary key (id)) ENGINE=InnoDB
create table procurement_type_entity (id bigint not null auto_increment, name varchar(255), primary key (id)) ENGINE=InnoDB
create table vendor_category_entity (id bigint not null auto_increment, name varchar(255), parent_id bigint, primary key (id)) ENGINE=InnoDB
create table vendor_entity (id bigint not null auto_increment, address varchar(255), description varchar(255), email varchar(255), name varchar(255), official_website_link varchar(255), postcode varchar(255), vendor_category_id bigint, primary key (id)) ENGINE=InnoDB
create table vendor_entity_contacts (vendor_entity_id bigint not null, contacts_id bigint not null) ENGINE=InnoDB
create table vendor_product_entity (id bigint not null auto_increment, currency varchar(255), order_number varchar(255), package_specification varchar(255), package_unit varchar(255), price_per_unit double precision, product_chinese_name varchar(255), product_english_name varchar(255), product_set bit not null, category_id bigint, parent_id bigint, primary key (id)) ENGINE=InnoDB
alter table procurement_purchase_entity_goods add constraint UK_1dwy8bf7kkgwe1m3u4620r93o unique (goods_id)
alter table vendor_entity_contacts add constraint UK_10dkdfv2b0dee658g4y77lwa0 unique (contacts_id)
alter table contact_entity add constraint FKr4wvr915juvwv0uogyrgyfkpq foreign key (vendor_id) references vendor_entity (id)
alter table department_permission_entity add constraint FK757m9299mpmx3qgv2jqrx9e7j foreign key (vendor_category_id) references vendor_category_entity (id)
alter table procurement_approval_entity add constraint FKop2qqfs1xn9no1pwnxork7txi foreign key (procurement_id) references procurement_entity (id)
alter table procurement_approval_stage_entity add constraint FKp61cmps4u0ybrh08tfsew6jwg foreign key (previous_stage_id) references procurement_approval_stage_entity (id)
alter table procurement_entity add constraint FK16aoiu4gphhn9dkhe2mv8iusj foreign key (operator_id) references operator_entity (id)
alter table procurement_log_entity add constraint FKre00dkxvx3i0xjen73824ici7 foreign key (procurement_id) references procurement_entity (id)
alter table procurement_purchase_entity add constraint FKb8i0w03d6h2fon9rwli60esfx foreign key (procurement_id) references procurement_entity (id)
alter table procurement_purchase_entity_goods add constraint FK8v68ac1rmn8e8nl3fisoyl8qf foreign key (goods_id) references procurement_purchase_good_entity (id)
alter table procurement_purchase_entity_goods add constraint FKdlcwgnrx49tb2au20wtic1kgf foreign key (procurement_purchase_entity_id) references procurement_purchase_entity (id)
alter table procurement_purchase_good_entity add constraint FKa397aebkk26ujnxw06e07p94e foreign key (procurement_purchase_id) references procurement_purchase_entity (id)
alter table procurement_purchase_good_entity add constraint FK5nupbngv33oooh72bxei5uuna foreign key (procurement_request_good_entity_id) references procurement_request_good_entity (id)
alter table procurement_request_good_entity add constraint FK81xfju5dl0iygqsrhjbnhxmog foreign key (request_id) references procurement_requests (id)
alter table procurement_requests add constraint FK64oci1w69fe3rbdnkecmaq2qo foreign key (procurement_id) references procurement_entity (id)
alter table procurement_request_vendor_info_entity add constraint FKg67rbl5ner1esn5q3q09np8a0 foreign key (request_id) references procurement_requests (id)
alter table procurement_status_entity add constraint FK7yhg9wpl68jbpdahnjlc3y93g foreign key (parent_id) references procurement_status_entity (id)
alter table vendor_category_entity add constraint FKjvun20pgcw9j2eypoksssswlm foreign key (parent_id) references vendor_category_entity (id)
alter table vendor_entity add constraint FKsm3bhxr77shkat5s18nfsvgw8 foreign key (vendor_category_id) references vendor_category_entity (id)
alter table vendor_entity_contacts add constraint FK5423cc8jnlnq4ik8r3hthkvxi foreign key (contacts_id) references contact_entity (id)
alter table vendor_entity_contacts add constraint FKlbdn5nquq6nyph9mjkdw40pvj foreign key (vendor_entity_id) references vendor_entity (id)
alter table vendor_product_entity add constraint FKj2h4d0je7sm885lw2jayj81bt foreign key (category_id) references vendor_category_entity (id)
alter table vendor_product_entity add constraint FKdxdbclg4rn74o6f5gtcukahvg foreign key (parent_id) references vendor_product_entity (id)
