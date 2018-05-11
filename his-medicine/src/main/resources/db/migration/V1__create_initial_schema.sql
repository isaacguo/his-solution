create table medicine_entity (id bigint not null auto_increment, bar_code varchar(255), dosage_per_day varchar(255), medicine_specification varchar(255), medicine_specification_unit varchar(255), name varchar(255), package_count bigint, package_unit varchar(255), price bigint, stock bigint, medicine_type_id bigint, primary key (id)) ENGINE=InnoDB;
create table medicine_type_entity (id bigint not null auto_increment, name varchar(255), primary key (id)) ENGINE=InnoDB;
create table warehouse_entity (id bigint not null auto_increment, location varchar(255), name varchar(255), primary key (id)) ENGINE=InnoDB;
alter table medicine_entity add constraint FK3qjfedbj789cco11fnx9wss0l foreign key (medicine_type_id) references medicine_type_entity (id);
